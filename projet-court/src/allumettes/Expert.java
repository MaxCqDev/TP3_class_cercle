package allumettes;

public class Expert implements Strategie {
	@Override
	public int getPrise(Jeu jeu, String nom) {
		int alluRest = jeu.getNombreAllumettes();
		int valeur = (alluRest - 1) % 4;
		
		if (valeur>3) {
			return 3;
		}
		if (valeur>0) {
			return valeur;
		}
		return 1;
	}
}
