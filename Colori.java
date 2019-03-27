import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Cette classe Colori permet de cr&eacute;er des boutons personalis&eacute;s.
 *
 * @version 30-04-2017
 * @author Mathilde Charrière
 */
public class Colori extends JButton{
    //Toolkit ne veux pas marcher :/
    /**
     * Stocke l'image correspondant au 'R'.
     **/
    private Image rouge;
    /**
     * Stocke l'image correspondant au 'B'.
     **/
    private Image bleu;
    /**
     * Stocke l'image correspondant au 'V'.
     **/
    private Image vert;
    /**
     * Stocke la ligne du bouton, allant de 0 &agrave; 9.
     **/
    private int ligne;
    /**
     * Stocke la colonne du bouton, allant de 0 &agrave; 14.
     **/
    private int col;
    /**
     * Stocke le nom du bouton, corrspond &agrave; son num&eacute;ro, allant de 0 &agrave; 149.
     **/
    private String name;
    /**
     *Stocke l'image de fond, inutilis&eacute;e.
     **/
    private Image fond;
    //private Image blanc;
    /**
     *Tableau correspondant au m&ecirc;me que celui de Partie et Fen&ecirc;tre.
     **/
    private char[][] tab=new char[10][15];
    /**
     * Ce constructeur cr&eacute;e un bouton avec plusieurs param&egrave;tres comme sa couleur.
     * @param nom son num&eacute;ro donn&eacute; en tant que String.
     * @param grille la grille de jeu.
     * @param i sa ligne.
     * @param j sa colonne.
     **/
    public Colori(String nom,char[][] grille,int i,int j) {
	this.ligne=i;
	this.col=j;
	this.tab=grille;
	this.name=nom;
	this.setActionCommand(nom);
	this.setBorder(BorderFactory.createEmptyBorder());
	this.setContentAreaFilled(false);
        try{this.rouge=ImageIO.read(new File("./images/R.png"));}catch(IOException e) { e.printStackTrace();}
	try{this.bleu=ImageIO.read(new File("./images/B.png"));}catch (IOException e) {e.printStackTrace();}
	try{this.vert=ImageIO.read(new File("./images/V.png"));}catch (IOException e) {e.printStackTrace();}
    }
    /**
     *Retourne le num&eacute;ro de la case du bouton.
     *
     * @return son num&eacute;ro.
     **/
    public String nomCase(){
	return this.name;
    }
    /**
     * Dessine le bouton selon sa couleur.
     *
     * @param g Graphics g.
     **/
    public void paintComponent(Graphics g){
	if(this.isOpaque()) {
            g.setColor(this.getBackground());
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	Graphics2D g2d = (Graphics2D)g;
	GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
	g2d.setPaint(gp);
	if (this.tab[this.ligne][this.col] == 'B')
	   g2d.drawImage(this.bleu, 0, 0, this.getWidth(), this.getHeight(), this);
	if (this.tab[this.ligne][this.col] == 'R')
	   g2d.drawImage(this.rouge, 0, 0, this.getWidth(), this.getHeight(), this);
	if (this.tab[this.ligne][this.col] == 'V')
	   g2d.drawImage(this.vert, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
