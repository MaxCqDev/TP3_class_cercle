import java.awt.*;


public class Cercle implements Mesurable2D {
    private Point centre;
    private double rayon;
    private Color couleur;

    public final static double PI = Math.PI;

    public Cercle(Point centre, double rayon){
        assert centre != null;
        assert rayon > 0;

        this.centre= new Point (centre.getX() , centre.getY());
        this.rayon=rayon;
        this.couleur = Color.blue;
    }
    public Cercle(Point point1, Point point2){
        assert point1 != null;
        assert point2 != null;
        assert point1 != point2;
        assert point1.distance(point2) /2 > 0;

        double centrex = (point1.getX() + point2.getX() ) /2;
        double centrey = (point1.getY()+point2.getY())/2;
        this.centre = new Point(centrex, centrey);

        this.rayon = point1.distance(point2) /2;
        this.couleur = Color.blue;
    }
    public Cercle(Point p1, Point p2 , Color c){
        assert p1 != null;
        assert p2 != null;
        assert p1 != p2;
        assert c != null;
        assert p1.distance(p2) /2 > 0;

        double centrex = (p1.getX() + p2.getX() ) /2;
        double centrey = (p1.getY()+p2.getY())/2;
        this.centre = new Point(centrex, centrey);
        this.rayon = p1.distance(p2) /2;
        this.couleur = c;
    }

    public void setRayon(double rayon){
        assert rayon > 0;
        this.rayon = rayon;
    }
    public void setDiametre(double dia){
        assert dia > 0;
        this.rayon = dia / 2 ;
    }

    public Point getCentre(){
        return new Point(this.centre.getX(), this.centre.getY());
    }
    public double getRayon(){
        return this.rayon;
    }
    public double getDiametre(){
        return this.rayon * 2;
    }
    public Color getCouleur(){
        return this.couleur;
    }

    public boolean contient(Point point){
        assert point !=null;
        double distance = this.centre.distance(point);
        return distance <= this.rayon;
    }

    public void translater(double dx, double dy) {
        this.centre.translater(dx, dy);
    }

    public void setCouleur(Color couleur){
        assert couleur != null;
        this.couleur = couleur;
    }

    public double aire(){
        return PI * (this.rayon * this.rayon);
    }

    public double perimetre(){return 2*PI * this.rayon;}

    public static Cercle creerCercle(Point point1, Point point2){
        assert point1 != null;
        assert point2 != null;
        assert point1.distance(point2) > 0;

        double rayon = point1.distance(point2) ;
        return new Cercle(point1, rayon);
    }

    public String toString(){
        return "C" + this.rayon + "@(" + this.centre.getX() + ", " + this.centre.getY() + ")";
    }

}


