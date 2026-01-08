public class Cellule {
    private int element;
    Cellule suivante;

    public Cellule(int element, Cellule suivante){
        this.element = element;
        this.suivante = suivante;
    }

    public int getElement(){
        return this.element;
    }

    public Cellule getSuivante(){
        return this.suivante;
    }
}
