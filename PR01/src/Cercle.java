import java.awt.Color;

/** Cercle modélise un cercle géométrique défini par son centre, son rayon
 * et sa couleur.  Un cercle est un Mesurable2D : on peut obtenir son
 * périmètre et son aire.
 *
 * @author  Maxime Criqui
 */
public class Cercle implements Mesurable2D {

    /** Centre du cercle. */
    private Point centre;

    /** Rayon du cercle. */
    private double rayon;

    /** Couleur du cercle. */
    private Color couleur;

    /** Valeur de PI. */
    public static final double PI = Math.PI;

    /** Construire un cercle à partir de son centre et de son rayon.
     * Sa couleur est le bleu.
     * @param centre le centre du cercle
     * @param rayon le rayon du cercle
     */
    public Cercle(Point centre, double rayon) {
        assert centre != null;
        assert rayon > 0;

        this.centre = new Point(centre.getX(), centre.getY());
        this.rayon = rayon;
        this.couleur = Color.blue;
    }

    /** Construire un cercle à partir de deux points diamétralement opposés.
     * Sa couleur est le bleu.
     * @param point1 le premier point
     * @param point2 le deuxième point
     */
    public Cercle(Point point1, Point point2) {
        this(point1, point2, Color.blue);
    }

    /** Construire un cercle à partir de deux points diamétralement opposés
     * et de sa couleur.
     * @param p1 le premier point
     * @param p2 le deuxième point
     * @param c la couleur du cercle
     */
    public Cercle(Point p1, Point p2, Color c) {
        assert p1 != null;
        assert p2 != null;
        assert p1 != p2;
        assert c != null;
        assert p1.distance(p2) / 2 > 0;

        double centrex = (p1.getX() + p2.getX()) / 2;
        double centrey = (p1.getY() + p2.getY()) / 2;
        this.centre = new Point(centrex, centrey);
        this.rayon = p1.distance(p2) / 2;
        this.couleur = c;
    }

    /** Changer le rayon du cercle.
     * @param rayon le nouveau rayon
     */
    public void setRayon(double rayon) {
        assert rayon > 0;
        this.rayon = rayon;
    }

    /** Changer le diamètre du cercle.
     * @param dia le nouveau diamètre
     */
    public void setDiametre(double dia) {
        assert dia > 0;
        this.rayon = dia / 2;
    }

    /** Obtenir le centre du cercle.
     * @return le centre du cercle
     */
    public Point getCentre() {
        return new Point(this.centre.getX(), this.centre.getY());
    }

    /** Obtenir le rayon du cercle.
     * @return le rayon du cercle
     */
    public double getRayon() {
        return this.rayon;
    }

    /** Obtenir le diamètre du cercle.
     * @return le diamètre du cercle
     */
    public double getDiametre() {
        return this.rayon * 2;
    }

    /** Obtenir la couleur du cercle.
     * @return la couleur du cercle
     */
    public Color getCouleur() {
        return this.couleur;
    }

    /** Savoir si un point est à l'intérieur du cercle.
     * @param point le point à tester
     * @return vrai si le point est dans le cercle
     */
    public boolean contient(Point point) {
        assert point != null;
        double distance = this.centre.distance(point);
        return distance <= this.rayon;
    }

    /** Translater le cercle.
     * @param dx déplacement suivant l'axe des X
     * @param dy déplacement suivant l'axe des Y
     */
    public void translater(double dx, double dy) {
        this.centre.translater(dx, dy);
    }

    /** Changer la couleur du cercle.
     * @param couleur la nouvelle couleur
     */
    public void setCouleur(Color couleur) {
        assert couleur != null;
        this.couleur = couleur;
    }

    /** Obtenir l'aire du cercle.
     * @return l'aire du cercle
     */
    public double aire() {
        return PI * (this.rayon * this.rayon);
    }

    /** Obtenir le périmètre du cercle.
     * @return le périmètre du cercle
     */
    public double perimetre() {
        return 2 * PI * this.rayon;
    }

    /** Créer un cercle à partir de son centre et d'un point du cercle.
     * @param point1 le centre du cercle
     * @param point2 un point de la circonférence
     * @return le cercle créé
     */
    public static Cercle creerCercle(Point point1, Point point2) {
        assert point1 != null;
        assert point2 != null;
        assert point1.distance(point2) > 0;

        double rayon = point1.distance(point2);
        return new Cercle(point1, rayon);
    }

    /** Représenter le cercle sous forme de chaîne de caractères.
     * @return la représentation du cercle
     */
    public String toString() {
        return "C" + this.rayon + "@" + this.centre;
    }

}
