/**
 * Cette classe Liste permet de cr&eacute;er les groupes, c'est un m&eacute;canisme important dans le jeu.
 *
 * @version 30-04-2017
 * @author Mathilde Charrière
 */
public class Liste {
    /**
     * ce tableau de int stocke la valeur des cases qui sont de la m&ecirc;me couleur que tableau[0]. Il est &eacute;tendu avec la fonction agrandirListe.
     **/
    private int[] tableau=new int[1];
    /**
     * Renvoie le contenu de la case demand&eacute;e si il existe.
     *
     * @param v le num&eacute;ro fournit sert lors de boucles. Pour le nombre v donn&eacute;, la fonction renvoie le int correspondant.
     * @return le contenu de la case
     **/
    public int boxListe(int v){
	return this.tableau[v];
    }
    /**
     * Ce constructeur est la base de la Liste, le premier argument de son tableau est &laquo;a&raquo;.
     *
     * @param a est le num&eacute;ro du bouton s&eacute;lectionn&eacute;.
     */
    public Liste(int a) {
	this.tableau[0]=a;
    }
    /**
     *Renvoie la taille de la Liste.
     *
     *@return la longueur du tableau de Liste.
     **/
    public int tailleTab(){
	return this.tableau.length;
    }
    /**
     *Permet de savoir si l'argument v est d&eacute;j&agrave; dans la Liste, pour &eacute;viter les doublons.
     *
     * @param v est le int test&eacute; sur le contenu du tableau de la Liste.
     *
     * @return retourne 1 si v n'est pas dans la Liste, sinon 0.
     **/
    public int pasDansListe(int v){ 
	for(int y=0;y<this.tableau.length;y++){ 
	    if(v==this.tableau[y]){
		return 0;
	    }
	}
	return 1;
    }
    /**
     * Cette fonction agrandit de 1 la taille du tableau sans perdre ses donn&eacute;es.
     **/
    public void extendListe(){
	int[] etendu= new int[this.tableau.length+1];
	for (int z=0; z<this.tableau.length;z++)
	    etendu[z]=boxListe(z);
	this.tableau=etendu;
    }
    /**
     * Localise les cases en contact (in)directs avec l'argument n, survol&eacute;es ou cliqu&eacute;es, et les ajoute dans la Liste.
     *
     * @param a Permet de r&eacute;cup&eacute;rer les donn&eacute;es pour &eacute;tendre la Liste.
     * @param n est la case de base, stock&eacute;e le premier dans le tableau.
     * @param p permet de r&eacute;cup&eacute;rer des donn&eacute;es.
     **/
    public void agrandirListe(Liste a, int n, Partie p){ // marche impec!!! :D
	int indice=1;
	int test;
	Liste older=new Liste(n);
	while(indice==1){
	    for(int t=0;t<a.tailleTab()||indice==1;t++){
		older=a;
		if(a.tableau[t]>14){
		    test=p.lotusHaut(this.tableau[t]);
		    if((test!=-1)&&(pasDansListe(test)==1)){
			a.extendListe();
			a.tableau[a.tailleTab()-1]=test;
		    }
		}
		if(a.tableau[t]<134){
		    test=p.nenupharBas(this.tableau[t]);
		    if((test!=-1)&&(pasDansListe(test)==1)){
			a.extendListe();
			this.tableau[a.tailleTab()-1]=test;
		    }
		}
		if(a.tableau[t]%15!=14){
		    test=p.lysDroite(this.tableau[t]);
		    if((test!=-1)&&(pasDansListe(test)==1)){
			a.extendListe();
			this.tableau[a.tailleTab()-1]=test;
		    }
		}
		if(a.tableau[t]%15!=0){
		    test=p.roseGauche(this.tableau[t]);
		    if((test!=-1)&&(pasDansListe(test)==1)){
			a.extendListe();
			this.tableau[a.tailleTab()-1]=test;
		    }
		}
		if(a.tailleTab()==older.tailleTab()){
		    indice=0;
		}
	    }
	}
    }
}
