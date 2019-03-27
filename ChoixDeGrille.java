import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.*;
/**
 * Cette classe permet de choisir le mode de jeu en tant qu'al&eacute;atoire ou pr&eacute;d&eacute;fini.
 *
 * @version 20-04-2017
 * @author Mathilde Charrière
 */
public class ChoixDeGrille extends JFrame{
/**
 * Cette fonction fait apparaitre une fen&ecirc;tre avec une question et deux options. 
 *
 *@return renvoie un String "on", pour "Al&eacute;atoire, ou "off" pour "Pr&eacute;d&eacute;fini", suivant le bouton cliqu&eacute;.
 */
    public String ChoixDeGrille(){
	
    Object[] choix = {"Aléatoire", "Prédéfini"};
    String v; 
    int reponse = JOptionPane.showOptionDialog(null,
      "Quel mode de jeu choisissez-vous ?",
      "Question",
      JOptionPane.DEFAULT_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      null,
      choix,
      null);
    if (reponse == 0)
	v ="on";
    else
      v = "off";
    return v;
  }
}
