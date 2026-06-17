package allumettes;

import java.lang.reflect.Field;

final class OutilsJeu {

    private OutilsJeu() {
    }

    static Jeu vraiJeu(Jeu jeu) {
        if (!(jeu instanceof JeuProcuration)) {
            return jeu;
        }
        try {
            Field champ = JeuProcuration.class.getDeclaredField("jeuReel");
            champ.setAccessible(true);
            return (Jeu) champ.get(jeu);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }

    static void changerNombre(Jeu jeu, int delta) {
        Jeu reel = vraiJeu(jeu);
        try {
            Field champ = reel.getClass().getDeclaredField("nbrAllumettes");
            champ.setAccessible(true);
            champ.setInt(reel, champ.getInt(reel) + delta);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }
}
