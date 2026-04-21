package allumettes;

public class Tricheur implements Strategie {

    private static final int RESTE_VOULU = 2;

    @Override
    public int getPrise(Jeu jeu, String nom) {
        System.out.println("[Je triche...]");
        viderJusquA(jeu, RESTE_VOULU);
        System.out.println("[Allumettes restantes : " + jeu.getNombreAllumettes() + "]");
        return 1;
    }

    private void viderJusquA(Jeu jeu, int cible) {
        while (jeu.getNombreAllumettes() > cible) {
            int aRetirer = Math.min(Jeu.PRISE_MAX, jeu.getNombreAllumettes() - cible);
            try {
                jeu.retirer(aRetirer);
            } catch (CoupInvalideException e) {
                //?
            }
        }
    }
}