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
    private Point A, B, C, D, E;

    // Les cercles du sujet
    private Cercle C1, C2, C3;

    @Before public void setUp() {
        // Construire les points
        A = new Point(1, 2);
        B = new Point(2, 1);
        C = new Point(4, 1);
        D = new Point(8, 1);
        E = new Point(8, 4);

        // Construire les cercles
        C1 = new Cercle(C, D); //12
        C2 = new Cercle(C, D, Color.yellow); //13
        C3 = Cercle.creerCercle(D,E); //14
    }

    /** Vérifier si deux points ont mêmes coordonnées.
     * @param p1 le premier point
     * @param p2 le deuxième point
     */
    static void memesCoordonnees(String message, Point p1, Point p2) {
        assertEquals(message + " (x)", p1.getX(), p2.getX(), EPSILON);
        assertEquals(message + " (y)", p1.getY(), p2.getY(), EPSILON);
    }

    @Test public void testerE12(){
        memesCoordonnees("E12 : centre mauvais", new Point(6, 1), C2.getCentre());

        assertEquals("E12 : rayon mauvais", 2.0, C1.getRayon(), EPSILON );
        assertEquals("E12 : couleur fausse", Color.blue, C1.getCouleur());
    }

    @Test public void testerE13() {
        assertEquals("E13 : couleur doit etre jaune", Color.yellow, C2.getCouleur());
        assertEquals("E13 : rayon mauvais", 2.0, C2.getRayon(), EPSILON);
    }

    @Test public void testerE14() {
        memesCoordonnees("E14 : mauvais centre", D, C3.getCentre());

        assertEquals("E14 : rayon mauvais", 3.0, C3.getRayon(), EPSILON);
        assertEquals("E14 : mauvaise couleur", Color.blue, C3.getCouleur()) ;
    }
}