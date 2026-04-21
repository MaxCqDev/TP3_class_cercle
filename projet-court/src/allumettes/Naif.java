package allumettes;
import java.util.Random;

public class Naif implements Strategie {
	
    private Random random = new Random();

    @Override
    public int getPrise(Jeu jeu, String nom) {
        return random.nextInt(Jeu.PRISE_MAX) + 1;
    }
}
