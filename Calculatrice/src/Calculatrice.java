import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Calculatrice extends JFrame {

 // Boutons nombres
 private JLabel resultat = new JLabel("0");
 private Bouton[] boutons = new Bouton[17];
 /*
  * private Bouton bouton1 = new Bouton("1",TypeBouton.CHIFFRE); private JButton
  * bouton2 = new JButton("2"); private JButton bouton3 = new JButton("3");
  * private JButton bouton4 = new JButton("4"); private JButton bouton5 = new
  * JButton("5"); private JButton bouton6 = new JButton("6"); private JButton
  * bouton7 = new JButton("7"); private JButton bouton8 = new JButton("8");
  * private JButton bouton9 = new JButton("9"); private JButton bouton0 = new
  * JButton("0"); private JButton bouton_point = new JButton("."); private
  * JButton bouton_egal = new JButton("=");
  */

 // Boutons opérateurs
 private JButton bouton_C = new JButton("C");
 private JButton bouton_plus = new JButton("+");
 private JButton bouton_moins = new JButton("-");
 private JButton bouton_fois = new JButton("*");
 private JButton bouton_divise = new JButton("/");

 private JPanel numbers_container = new JPanel();
 private JPanel operators_container = new JPanel();

 public Calculatrice() {
  this.setTitle("Calculatrice");
  this.setSize(300, 300);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setLocationRelativeTo(null);

  // Initialisation des boutons de nombres
  for (int i = 0; i < 10; i++) {
   boutons[i] = new Bouton(Integer.toString(i), TypeBouton.CHIFFRE);
  }
  boutons[10] = new Bouton(".", TypeBouton.AUTRE);
  boutons[11] = new Bouton("=", TypeBouton.AUTRE);
  boutons[12] = new Bouton("C", TypeBouton.AUTRE);
  boutons[13] = new Bouton("+", TypeBouton.OPERATEUR);
  boutons[14] = new Bouton("-", TypeBouton.OPERATEUR);
  boutons[15] = new Bouton("*", TypeBouton.OPERATEUR);
  boutons[16] = new Bouton("/", TypeBouton.OPERATEUR);

  this.setLayout(new BorderLayout());

  this.getContentPane().add(resultat, BorderLayout.NORTH);
  numbers_container.setLayout(new GridLayout(4, 3));

  for (int i = 1; i < 10; i++) {
   numbers_container.add(boutons[i]);
  }
  numbers_container.add(boutons[0]);

  numbers_container.add(boutons[10]);
  numbers_container.add(boutons[11]);

  this.getContentPane().add(numbers_container, BorderLayout.CENTER);

  operators_container.setLayout(new GridLayout(5, 1));
  for (int i = 12; i < 17; i++) {
   operators_container.add(boutons[i]);
  }

  this.getContentPane().add(operators_container, BorderLayout.EAST);

  /*
   * for(Component c:numbers_container.getComponents()) { JButton b =
   * (JButton)c; b.addActionListener(new BoutonListener()); }
   */

  this.setVisible(true);
 }

 class BoutonListener implements ActionListener {
  public void actionPerformed(ActionEvent arg0) {
   String s = resultat.getText();
   if(s.equals("0")) {
    s="";
   }

   Bouton source = (Bouton) arg0.getSource();

   if (source.getType() == TypeBouton.CHIFFRE) {
    resultat.setText(s + source.getText());
   }

  }
 }

 class Bouton extends JButton {
  private String text = "";
  private TypeBouton type = TypeBouton.AUTRE;

  public Bouton(String s, TypeBouton type) {
   this.text = s;
   this.type = type;
   this.addActionListener(new BoutonListener());
  }

  public String getText() {
   return this.text;
  }

  public TypeBouton getType() {
   return this.type;
  }

 }

}
