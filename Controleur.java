import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
/**
 * Cette classe permet de capter les int&eacute;ractions sur les boutons Colori
 *
 * @version 20-04-2017
 * @author Mathilde Charrière
 */
public class Controleur implements ActionListener, MouseListener {
    /**
     *Non utilis&eacute;e ici.
     **/
    private Fenetre fond;
    /**
     *Non utilis&eacute;e ici.
     **/
    private Partie etat;
    /**
     *Non utilis&eacute;e ici.
     **/
    private char[][] tab= new char[10][15];
    /**
     * Ce constructeur associe ses arguments &agrave; ses attributs.
     *
     * @param a Permet de r&eacute;cup&eacute;rer les donn&eacute;es de la Partie a.
     * @param b Permet de pouvoir par la suite de mettre &agrave; jour la Fen&ecirc;tre b.
     **/
    public Controleur(Partie a, Fenetre b){
	this.fond=b;
	this.etat=a;
	this.tab=a.getTab();
    }
    /**
     *Met &agrave; jour les attributs du controleur avec ceux de la Partie a.
     *
     * @param a Permet de r&eacute;cup&eacute;rer les donn&eacute;es de la Partie a.
     **/
    public void mettreAJour(Partie a){
        this.etat=a;
	this.tab=a.getTab();
    }
    /**
     *Non utilis&eacute;e ici.
     **/
    public void mouseClicked(MouseEvent e){}
    /**
     * Ne marche pas... Est cens&eacute; d&eacute;t&eacute;cter un objet survol&eacute;, mais ne r&eacute;agit pas... voir si modif marche...
     **/
    @Override
    public void mouseEntered(MouseEvent e){
	int x=e.getX(); // pas de réaction
	int y=e.getY(); // pas de réaction
        Object nouveau= e.getSource();
	//if ((Colori)nouveau==test){
	//System.out.println((Colori)nouveau.nomCase()/*getToolTipText()*/);
	//Liste v =new Liste(Integer.parseInt(nouveau.nomCase()));
	//v.agrandirListe(Integer.parseInt(nouveau.nomCase()),this.etat);
	//modif ici!! mettre fond.png  !!!!
	//if(v.tailleTab()>1){
	//...blanchirLeFond();
	//...colorerLeFond(v);
	//}
    }
    /**
     * R&eacute;agit lorsque l'objet n'est plus survol&eacute;.
     *
     * @param e MouseEvent e.
     **/
    @Override
    public void mouseExited(MouseEvent e){}
    /**
     *Non utilis&eacute;e ici.
     **/
    public void mousePressed(MouseEvent e){}
    /**
     *Non utilis&eacute;e ici.
     **/
    public void mouseReleased(MouseEvent e){}
    /**
     * Lorsqu'un bouton est cliqu&eacute;, actionPerformed s'active et appelle la fonction boutonPouser, et red&eacute;ssine la fen&ecirc;tre avec les nouvelles donn&eacute;es.
     *
     * @param e ActionEvent e.
     **/
    @Override
    public void actionPerformed(ActionEvent e){
	String txt=e.getActionCommand();
	int valeur=Integer.parseInt(txt);
	this.etat.boutonPouser(valeur);
	mettreAJour(this.etat);
	this.fond.score.setText("Score:"+etat.donnerScore());
	this.fond.repaint();
    }
}
