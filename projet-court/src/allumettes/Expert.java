package allumettes;

public class Expert implements Strategie {
	@Override
	public int getPrise(Jeu jeu, String nom) {
		int alluRest = jeu.getNombreAllumettes();
		int valeur = (alluRest - 1) % (Jeu.PRISE_MAX + 1);//present dans l'interface

		if (valeur > Jeu.PRISE_MAX) {
		    return Jeu.PRISE_MAX;
		}
		if (valeur>0) {
			return valeur;
		}
		return 1;
	}
}
