/**
 * @version 24-03-2017
 * @author Mathilde Charrière
 */
public class Jeu {
    /**
     * lance le jeu du SameGame.
     *
     * @param args la liste des arguments de la ligne de commande (inutilis&eacute;e ici)
     */
    public static void main(String[] args) {
	ChoixDeGrille choix=new ChoixDeGrille();
	String mode=choix.ChoixDeGrille();
	Partie jeu = new Partie(mode);
	Fenetre affichage =new Fenetre(jeu);
	affichage.setVisible(true);
    }
}
