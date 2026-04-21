package allumettes;

public class JeuToto implements Jeu{
	
	private int NbrAllumettes;
	
	//permet de changer le nombre de départ d'allumettes de la parti
	public JeuToto (int NbrAllumettes) {
		this.NbrAllumettes = NbrAllumettes;
	}
	
	@Override
	public int getNombreAllumettes() {
		return this.NbrAllumettes;
	}
	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
	    if (nbPrises < 1) {
	        throw new CoupInvalideException(nbPrises, "< 1");
	    }
	    if (nbPrises > this.NbrAllumettes) {
	        throw new CoupInvalideException(nbPrises, "> " + this.NbrAllumettes);
	    }
	    if (nbPrises > Jeu.PRISE_MAX) {
	        throw new CoupInvalideException(nbPrises, "> " + Jeu.PRISE_MAX);
	    }
	    this.NbrAllumettes = this.NbrAllumettes - nbPrises;
	}
	@Override
    public String toString() {
        return "Allumettes restantes = " + this.NbrAllumettes;
    }
}
