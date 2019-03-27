import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.*;
    
public class Fenetre extends JFrame{
    /**
     *ce tableau permet d'avoir la copie de celui de Partie, stocke les caract&egrave;res 'R', 'V', 'B' et 'O'.
     **/
    private char[][] tab=new char[10][15];
    /**
     *Ce JLabel permet d'afficher le score sur la fen&ecirc;tre.
     **/
    public JLabel score;
    /**
     * Affiche notre fen&ecirc;tre de jeu et tous ses boutons, qui sont "&eacute;cout&eacute;s" par le controleur.
     *
     * @param a permet de copier les données dans Fen&ecirc;tre.
     **/
    public Fenetre(Partie a) { // ajouter un tab de Colori??
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 470);
	this.setLocation(100,100);
	this.tab=a.getTab();
	JPanel panneau = new JPanel();
        this.add(panneau, BorderLayout.NORTH);
	Controleur ctrl= new Controleur(a,this); // tab 
	GridLayout gestionnaire = new GridLayout(10, 15);
	panneau.setLayout(gestionnaire);
        score=new JLabel("Score:"+a.donnerScore());
	this.add(score, BorderLayout.NORTH);
	for(int i=0; i<10; i++){
	    for(int j=0; j<15; j++){
		Colori color= new Colori(""+(i*15+j),this.tab,i,j);
	    panneau.add(color);
	    color.addActionListener(ctrl);
	    }
	}
	this.add(panneau);
    }
}
