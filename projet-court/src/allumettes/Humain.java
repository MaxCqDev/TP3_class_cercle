package allumettes;
import java.util.Scanner;

public class Humain implements Strategie {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public int getPrise(Jeu jeu, String nom) {
        while (true) {
            System.out.print(nom + ", combien d'allumettes ? ");
            String entree = SCANNER.next();

            if (entree.equals("triche")) {
                tricher(jeu);
            } else {
                try {
                    return Integer.parseInt(entree);
                } catch (NumberFormatException e) {
                    System.out.println("Vous devez donner un entier.");
                }
            }
        }
    }

    private void tricher(Jeu jeu) {
        try {
            jeu.retirer(1);
            System.out.println("[Une allumette en moins, plus que "
                    + jeu.getNombreAllumettes() + ". Chut !]");
        } catch (CoupInvalideException e) {
        	//?
        }
    }
}