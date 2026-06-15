package allumettes;

public class JeuToto implements Jeu{

	private int nbrAllumettes;

	//permet de changer le nombre de départ d'allumettes de la parti
	public JeuToto (int nbrAllumettes) {
		this.nbrAllumettes = nbrAllumettes;
	}

	@Override
	public int getNombreAllumettes() {
		return this.nbrAllumettes;
	}
	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
	    if (nbPrises < 1) {
	        throw new CoupInvalideException(nbPrises, "< 1");
	    }
	    if (nbPrises > this.nbrAllumettes) {
	        throw new CoupInvalideException(nbPrises, "> " + this.nbrAllumettes);
	    }
	    if (nbPrises > Jeu.PRISE_MAX) {
	        throw new CoupInvalideException(nbPrises, "> " + Jeu.PRISE_MAX);
	    }
	    this.nbrAllumettes = this.nbrAllumettes - nbPrises;
	}
	@Override
    public String toString() {
        return "Allumettes restantes = " + this.nbrAllumettes;
    }
}
