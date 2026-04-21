package allumettes;

public class Rapide implements Strategie{
	@Override
	public int getPrise(Jeu jeu, String nom) {
		int reste = jeu.getNombreAllumettes();
		int max = Jeu.PRISE_MAX;
        if (reste >= max) {
        	return max;
        } else {
        	return reste;
        }
	}
}
