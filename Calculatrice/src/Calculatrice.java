import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Calculatrice extends JFrame {

    private double operande1 = 0.0;
    private double operande2 = 0.0;
    private boolean cleanRes = false;
    private boolean opClicked = false;
    private Operateur op = null;

    // Label pour l'affichage
    private JLabel resultat = new JLabel("0");

    // Boutons
    private Bouton[] boutons = new Bouton[17];

    // Conteneur des boutons de nombre, point(.) et égal(=)
    private JPanel numbers_container = new JPanel();

    // Conteneur des opérateur et du bouton d'initialisation (C)
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

	// Initialisation des autres boutons
	boutons[10] = new Bouton(".", TypeBouton.AUTRE);
	boutons[11] = new Bouton("=", TypeBouton.AUTRE);
	boutons[12] = new Bouton("C", TypeBouton.AUTRE);
	boutons[13] = new Bouton("+", TypeBouton.OPERATEUR);
	boutons[14] = new Bouton("-", TypeBouton.OPERATEUR);
	boutons[15] = new Bouton("*", TypeBouton.OPERATEUR);
	boutons[16] = new Bouton("/", TypeBouton.OPERATEUR);

	// Définition du Layout de la fênetre
	this.setLayout(new BorderLayout());

	// Ajout du label d'affichage
	this.getContentPane().add(resultat, BorderLayout.NORTH);

	// Définition du Layout du conteneur des nombres
	numbers_container.setLayout(new GridLayout(4, 3));

	// Ajout des boutons des nombre au Layout
	// chiffres des 1 à 9
	for (int i = 1; i < 10; i++) {
	    numbers_container.add(boutons[i]);
	}

	// Bouton zéro
	numbers_container.add(boutons[0]);

	// Bouton point
	numbers_container.add(boutons[10]);

	// Bouton égal (=)
	numbers_container.add(boutons[11]);

	// Ajout du conteneur des nombres au Layout de la fênetre
	this.getContentPane().add(numbers_container, BorderLayout.CENTER);

	// Définition du Layout du conteneur des opérateurs
	operators_container.setLayout(new GridLayout(5, 1));

	// Ajout des opérateurs dans leur conteneur
	for (int i = 12; i < 17; i++) {
	    operators_container.add(boutons[i]);
	}

	// Ajout du conteneur des opérateurs au Layout de la fênetre
	this.getContentPane().add(operators_container, BorderLayout.EAST);

	// Rendre la fenêtre visible
	this.setVisible(true);
    }

    class BoutonListener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
	    String s = resultat.getText();
	    if (cleanRes == true) {
		s = "";
	    }

	    Bouton source = (Bouton) arg0.getSource();
	    String textBouton = source.getText();

	    if ((source.getType() == TypeBouton.CHIFFRE)) {
		if (s.equals("0")) {
		    s = "";
		}
		resultat.setText(s + textBouton);
		cleanRes = false;

		if (opClicked) {
		    operande2 = Double.parseDouble(resultat.getText());
		} else {
		    operande1 = Double.parseDouble(resultat.getText());
		}
	    }

	    if (source.getType() == TypeBouton.OPERATEUR) {

		if (opClicked == false) {

		    opClicked = true;

		    cleanRes = true;

		    op = getOp(textBouton);
		} else {

		    double resTemp = calculer(operande1, operande2, op);
		    resultat.setText("" + resTemp);
		    operande1 = resTemp;
		    operande2 = 0;
		    op = getOp(textBouton);
		    cleanRes = true;
		    opClicked=false;
		}

	    }

	    if (source.getType() == TypeBouton.AUTRE) {
		switch (textBouton) {
		case "=":
		    double resTemp = calculer(operande1, operande2, op);
		    resultat.setText("" + resTemp);
		    operande1 = resTemp;
		    operande2 = 0;
		    cleanRes = true;
		    opClicked=false;
		    break;

		case "C":
		    resultat.setText("0");
		    operande1 = 0;
		    operande2 = 0;
		    op = null;
		    opClicked = false;
		    break;

		case ".":
		    if (s.equals("")) {
			resultat.setText("0.");
			cleanRes=false;
		    } else {
			if (!s.contains(".")) {
			    resultat.setText(s + ".");
			}
		    }

		}
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

    double calculer(double opd1, double opd2, Operateur operateur) {
	double res = 0;

	switch (operateur) {
	case PLUS:
	    res = opd1 + opd2;
	    break;

	case MOINS:
	    res = opd1 - opd2;
	    break;

	case DIVISE:
	    res = opd1 / opd2;
	    break;

	case FOIS:
	    res = opd1 * opd2;
	    break;

	}

	return res;
    }

    public Operateur getOp(String s) {

	switch (s) {

	case "+":
	    return Operateur.PLUS;
	case "*":
	    return Operateur.FOIS;

	case "-":
	    return Operateur.MOINS;
	case "/":
	    return Operateur.DIVISE;
	default:
	    return null;
	}
    }

}
