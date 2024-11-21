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
 
 

	//Boutons nombres
	private JLabel resultat = new JLabel("0");
	private JButton bouton1 = new JButton("1");
	private JButton bouton2 = new JButton("2");
	private JButton bouton3 = new JButton("3");
	private JButton bouton4 = new JButton("4");
	private JButton bouton5 = new JButton("5");
	private JButton bouton6 = new JButton("6");
	private JButton bouton7 = new JButton("7");
	private JButton bouton8 = new JButton("8");
	private JButton bouton9 = new JButton("9");
	private JButton bouton0 = new JButton("0");
	private JButton bouton_point = new JButton(".");
	private JButton bouton_egal = new JButton("=");

	//Boutons operateurs
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

		//numbers_container.setBackground(Color.white);
		//numbers_container.setLayout(new BorderLayout());

		this.setLayout(new BorderLayout());


		this.getContentPane().add(resultat,BorderLayout.NORTH);
		numbers_container.setLayout(new GridLayout(4, 3));
		numbers_container.add(bouton1);
		numbers_container.add(bouton2);
		numbers_container.add(bouton3);
		numbers_container.add(bouton3);
		numbers_container.add(bouton4);
		numbers_container.add(bouton5);
		numbers_container.add(bouton6);
		numbers_container.add(bouton7);
		numbers_container.add(bouton8);
		numbers_container.add(bouton9);
		numbers_container.add(bouton0);
		numbers_container.add(bouton_point);
		numbers_container.add(bouton_egal);
		this.getContentPane().add(numbers_container,BorderLayout.CENTER);

		operators_container.setLayout(new GridLayout(5, 1));
		operators_container.add(bouton_C);
		operators_container.add(bouton_plus);
		operators_container.add(bouton_moins);
		operators_container.add(bouton_fois);
		operators_container.add(bouton_divise);
		this.getContentPane().add(operators_container,BorderLayout.EAST);
  //bouton1.addActionListener(new BoutonListener());
  //bouton2.addActionListener(new BoutonListener());
  //bouton3.addActionListener(new BoutonListener());
 for(Component c:numbers_container.getComponents()) {
  JButton b = (JButton)c;
  b.addActionListener(new BoutonListener());
 }

		this.setVisible(true);
	}



	class BoutonListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		 
		 Object source = arg0.getSource();
		  if(source==bouton1) {
		   resultat.setText(resultat.getText()+"1");
		  }
		  
		  if(source==bouton2) {
     resultat.setText(resultat.getText()+"2");
    }
		  
		}
	}

}
