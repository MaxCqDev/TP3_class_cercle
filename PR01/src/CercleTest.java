import java.awt.*;
import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Classe de test de la classe Cercle.
 * @author	Maxime Criqui
 * @version	$1$
 */

public class CercleTest {

    // précision pour les comparaisons réelle
    public final static double EPSILON = 0.001;

    // Les points du sujet
    private Point P1, P2, centre, surLeCercle;

    // Les cercles du sujet
    private Cercle C1, C2, C3;

    @Before public void setUp() {
        // Construire les points
        P1 = new Point(1, 2);
        P2 = new Point(7, 10);
        centre = new Point(2, 3);
        surLeCercle = new Point(5, 7);

        // Construire les cercles
        C1 = new Cercle(P1, P2); //12
        C2 = new Cercle(P1, P2, Color.yellow); //13
        C3 = Cercle.creerCercle(centre, surLeCercle); //14
    }

    /** Vérifier si deux points ont mêmes coordonnées.
     * @param p1 le premier point
     * @param p2 le deuxième point
     */
    static void memesCoordonnees(String message, Point p1, Point p2) {
        assertEquals(message + " (x)", p1.getX(), p2.getX(), EPSILON);
        assertEquals(message + " (y)", p1.getY(), p2.getY(), EPSILON);
    }

    @Test public void testerE12() {
        memesCoordonnees("E12 : centre mauvais", new Point(4, 6), C1.getCentre());
        assertEquals("E12 : rayon mauvais", 5.0, C1.getRayon(), EPSILON);
        assertEquals("E12 : couleur doit etre bleue", Color.blue, C1.getCouleur());
    }

    @Test public void testerE13() {
        memesCoordonnees("E13 : centre mauvais", new Point(4, 6), C2.getCentre());
        assertEquals("E13 : rayon mauvais", 5.0, C2.getRayon(), EPSILON);
        assertEquals("E13 : couleur doit etre jaune", Color.yellow, C2.getCouleur());
    }

    @Test public void testerE14() {
        memesCoordonnees("E14 : centre mauvais", new Point(2, 3), C3.getCentre());
        assertEquals("E14 : rayon mauvais", 5.0, C3.getRayon(), EPSILON);
        assertEquals("E14 : couleur doit etre bleue", Color.blue, C3.getCouleur());
    }
}
