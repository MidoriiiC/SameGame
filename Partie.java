import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
/**
 * Cette classe g&egrave;re le tableau de donn&eacute;s du jeu et le score de la Partie
 *
 * @version 30-04-2017
 * @author Mathilde Charrière
 */
public class Partie {
    /**
     *C'est la grille de caract&agrav;res contenant 'R','V' et 'B' au début et est complété avec des 'O' (o majuscules). Elle est remplie des trois premières valeurs dans le constructeur avec les fonction tabAleatoire et tabPredessiner.
     **/
    private char[][] grille= new char[10][15];
    /**
     *La variable score stocke le &laquo;score&raquo; de la Partie, et est modifiable avec la fonction updateScore.
     **/
    private int score=0;
    /**
     *Le constructeur de Partie d&eacute;termine avec son argument si le tableau priv&eacute; est remplit de mani&egrave;re al&eacute;atoire ou pr&eacute;d&eacute;finie.
     *
     * @param modeAlea est soit "on", soit "off", d&eacute;termin&eacute; dans la classe ChoixDeGrille.
     **/
    public Partie(String modeAlea){
	if(modeAlea.equals("on")){
	    grille=tabAleatoire();
	}
	else
	    grille=tabPreDessiner();
    }
    /**
     *D&eacute;cale les colonnes vers la gauche lors de pr&eacute;sence de colonnes vides de sorte qu'il n'y ai plus de s&eacute;paration dans la grille Partie.
     **/
    public void decaler(){
	int k=9;
	int v;
	int i=10;
	while(i!=0){
	    for(int x=0;x<14;x++){
		if(this.valeurDeCase(k,x)=='O'){
		    while(k!=0){
			this.grille[k][x]=this.grille[k][x+1];
			this.grille[k][x+1]='O';
			k--;
		    }
		    k=9;
		}
	    }
	    i--;
	}
    }
    /**
     *Fait remonter toutes les cases 'O' (ou vides) vers le haut dans la grille Partie.
     **/
    public void descendre(){
	int indice=15;
	while(indice!=0){
	    indice--;
	    for(int j=9;j>0;j--){
		for(int i=14;i>=0;i--){
		    if(this.valeurDeCase(j,i)=='O'){
			int k=0;
			for(k=j;(k!=0);k--){
			    this.grille[k][i]=this.grille[k-1][i];
			}
			this.grille[k][i]='O';
		    }
		}
	    }
	}
    }
     /**
     *Permet d'augmenter le score avec n, le nombre d'&eacute;l&eacute;ments pour utiliser la formule (n-2)&sup2;. 
     *
     * @param selection permet de r&eacute;cup&eacute;rer le nombre d'&eacute;l&eacute;ments qu'elle contient.
     **/
    public void upScore(Liste selection){
	this.score+=((selection.tailleTab())-2)*((selection.tailleTab())-2);
    }
    /**
     * Cette fonction permet de g&eacute;n&eacute;rer une grille al&eacute;atoirement.
     *
     * @return la grille g&eacute;n&eacute;r&eacute;e al&eacute;atoirement.
     **/
    public char[][] tabAleatoire(){
	Random valeur= new Random();
	final char[] tabRef={'R','V','B'};
	char[][] tab= new char[10][15];
	for(int i=0; i<15; i++){
	    for(int x=0; x<10; x++){
		int nombre = valeur.nextInt(3); // de 0 à 2  !!!
	        tab[x][i]=tabRef[nombre];
	    } 
	}
	return tab;
    }
    /**
     * Cette fonction permet de r&eacute;cup&eacute;rer une grille dans un fichier en apellant la fonction ouverture. 
     *
     * @return la grille t&eacute;l&eacute;charg&eacute;e.
     **/
    public char[][] tabPreDessiner(){
	char[][] grille= new char[10][15];
	JFileChooser charge= new JFileChooser();
	FileNameExtensionFilter f = new FileNameExtensionFilter("txt files","txt");
	charge.setFileFilter(f);
    
	LectureDoc bulle = new LectureDoc();
	String valeur;
	int videur;
	valeur=bulle.ouverture();
	try{
	    FileReader flux = new FileReader(valeur);
	    for(int ligne=0;ligne<10;ligne++){
		for(int col=0;col<15;col++){
		    grille[ligne][col]=((char)flux.read());
		}
		videur=flux.read();
	    }
	}catch(FileNotFoundException r){
	    System.err.println("Erreur a l'ouverture");
	}catch(IOException p){
	    System.out.println("ProposeAlea()");
	}
	    
	return grille;
    }
    /**
     * Permet de conna&icirc;tre le score actuel.
     *
     * @return le score
     **/
    public int donnerScore(){
	return this.score;
    }
    /**
     *Permet de conna&icirc;tre le caract&egrave;re de la case &aacute; la ligne x et la colonne y.
     *
     * @param x la ligne allant de 0 &agrave; 9.
     * @param y la colonne allant de 0 &agrave; 14.
     *
     * @return le caract&egrave;re de la case.
     **/
    public char valeurDeCase(int x, int y){
	return this.grille[x][y];
    }
    /**
     * Teste si la case au dessus de celle entr&eacute;e en argument ont le m&ecirc;me caract&egrave;re.
     *
     * @param box la case test&eacute;e, allant de O &agrave; 149.
     *
     * @return le num&eacute;ro de la case, sinon -1.
     **/
    public int lotusHaut(int box){  // tab de 15 sur 10
	int y=box%15;
	int x=box/15;
	if(valeurDeCase(x,y)==valeurDeCase(x-1,y))
	    return box-15;
	return -1;
    }
    /**
     * Teste si la case en dessous de celle entr&eacute;e en argument ont le m&ecirc;me caract&egrave;re.
     *
     * @param box la case test&eacute;e, allant de O &agrave; 149.
     *
     * @return le num&eacute;ro de la case, sinon -1.
     **/
    public int nenupharBas(int box){  // tab de 15 sur 10
	int y=box%15;
	int x=box/15;
	if(valeurDeCase(x,y)==valeurDeCase(x+1,y))
	    return box+15;
	return -1;
    }
    /**
     * Teste si la case &agrave; droite de celle entr&eacute;e en argument ont le m&ecirc;me caract&egrave;re.
     *
     * @param box la case test&eacute;e, allant de O &agrave; 149.
     *
     * @return le num&eacute;ro de la case, sinon -1.
     **/
    public int lysDroite(int box){  // tab de 15 sur 10
	int y=box%15;
	int x=box/15;
	if(valeurDeCase(x,y)==valeurDeCase(x,y+1))
	    return box+1;
	return -1;
    }
    /**
     * Teste si la case &agrave; gauche de celle entr&eacute;e en argument ont le m&ecirc;me caract&egrave;re.
     *
     * @param box la case test&eacute;e, allant de O &agrave; 149.
     *
     * @return le num&eacute;ro de la case, sinon -1.
     **/
    public int roseGauche(int box){  // tab de 15 sur 10
	int y=box%15;
	int x=box/15;
	if(valeurDeCase(x,y)==valeurDeCase(x,y-1))
	    return box-1;
	return -1;
    }
    /**
     * Avec le num&eacute;ro de la case cliqu&eacute;e, on cr&eacute;e une Liste, et si le groupe est de taille 2 ou plus, on supprime les cases adjacentes de m&ecirc;me couleur, on met &agrave; jour la grille, et on augmente le score en cons&eacute;quence.
     *
     * @param valeur le num&eacute;ro de la case s&eacute;l&eacute;ctionn&eacute;e par clic de la souris.
     **/
    public void boutonPouser(int valeur){
	if(valeurDeCase(valeur/15,valeur%15)!='O'){
	    Liste selection= new Liste(valeur);
	    selection.agrandirListe(selection,valeur,this);
	    for(int i=0;(i<selection.tailleTab())&&(selection.tailleTab()>=2);i++){
		valeur=selection.boxListe(i);
		this.grille[valeur/15][valeur%15]='O';
	    }
	    this.descendre();
	    this.decaler();
	    if(selection.tailleTab()>=2)
		this.upScore(selection);
	}
    }
    /**
     *Renvoie la grille de caract&egrave;res pour faire des mises a jour.
     *
     * @return la grille de caract&egrave;res de Partie.
     **/
    public char[][] getTab(){
	return this.grille;
    }
}
