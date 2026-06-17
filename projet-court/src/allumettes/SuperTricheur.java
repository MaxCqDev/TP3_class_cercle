package allumettes;

public class SuperTricheur implements Strategie {

    private static final int RESTE_VOULU = 2;

    //getPrise() -> interface Strategie
    @Override
    public int getPrise(Jeu jeu, String nom) {
        System.out.println("[Je triche...]");
        Jeu vraiJeu = OutilsJeu.vraiJeu(jeu);
        viderJusquA(vraiJeu, RESTE_VOULU);
        System.out.println("[Allumettes restantes : " + vraiJeu.getNombreAllumettes() + "]");
        return 1;
    }

    private void viderJusquA(Jeu jeu, int cible) {
        while (jeu.getNombreAllumettes() > cible) {
            int aRetirer = Math.min(Jeu.PRISE_MAX, jeu.getNombreAllumettes() - cible);
            try {
                jeu.retirer(aRetirer);
            } catch (CoupInvalideException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
