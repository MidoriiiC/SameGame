import javax.swing.JFileChooser;
/**
 * Cette classe permet de s&eacute;l&eacute;ctioner un fichier dans le dossier "./Fichiers" 
 *
 * @version 20-04-2017
 * @author Mathilde Charrière
 */
public class LectureDoc{
    /**
     * Cette fonction fait apparaitre une fen&ecirc;tre pour s&eacute;l&eacute;ctionner un fichier.
     *
     *@return renvoie le nom du fichier choisi.
     */
    public String ouverture(){
	JFileChooser chooser=new JFileChooser("./Fichiers");
	int result= chooser.showOpenDialog(null);
	String nom=chooser.getSelectedFile().getAbsolutePath();
	return nom;
    }
}
