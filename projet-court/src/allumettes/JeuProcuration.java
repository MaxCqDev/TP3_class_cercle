package allumettes;

public class JeuProcuration implements Jeu {

    private Jeu jeuReel;

    public JeuProcuration(Jeu jeuReel) {
        this.jeuReel = jeuReel;
    }

    @Override
    public int getNombreAllumettes() {
        return this.jeuReel.getNombreAllumettes();
    }

    @Override
    public void retirer(int nbPrises) throws CoupInvalideException {
        throw new OperationInterditeException(
                "Un joueur n'a pas le droit de retirer des allumettes.");
    }

    @Override
    public String toString() {
        return this.jeuReel.toString();
    }
}