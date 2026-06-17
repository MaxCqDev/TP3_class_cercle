package allumettes;

public class Arbitre {
    //truc de confiance
    private boolean confiant = false;

    private Joueur joueur1;
    private Joueur joueur2;
    private final Deroulement deroulement = new Deroulement();
    private static final String FICHIER_XML = "deroulement.xml";

    public Arbitre(Joueur j1, Joueur j2) {
        this.joueur1 = j1;
        this.joueur2 = j2;
    }

    public void setConfiant(boolean confiant) {
        this.confiant = confiant;
    }

    public void arbitrer(Jeu jeu) {
        Joueur courant = this.joueur1;
        Joueur autre = this.joueur2;
        int numero = 0;

        while (jeu.getNombreAllumettes() > 0) {
            try {
                int prises = jouerTour(jeu, courant);
                numero++;
                this.deroulement.ajouterCoup(numero, courant.getNom(), prises);
            } catch (OperationInterditeException e) {
                System.out.println("Abandon de la partie car "
                        + courant.getNom() + " triche !");
                this.deroulement.tricheur(courant.getNom());
                this.deroulement.ecrire(FICHIER_XML);
                return;
            }

            Joueur temp = courant;
            courant = autre;
            autre = temp;
        }

        System.out.println(autre.getNom() + " perd !");
        System.out.println(courant.getNom() + " gagne !");
        this.deroulement.gagnant(courant.getNom());
        this.deroulement.ecrire(FICHIER_XML);
    }

    private int jouerTour(Jeu jeu, Joueur joueur) {
        boolean coupValide = false;
        int nb = 0;
        while (!coupValide) {
            System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes());

            Jeu jeuPourJoueur;
            if (this.confiant) {
                jeuPourJoueur = jeu;
            } else {
                jeuPourJoueur = new JeuProcuration(jeu);
            }

            nb = joueur.getPrise(jeuPourJoueur);

            String s = (nb > 1) ? "s" : "";
            System.out.println(joueur.getNom() + " prend " + nb + " allumette" + s + ".");
            try {
                jeu.retirer(nb);
                coupValide = true;
            } catch (CoupInvalideException e) {
                System.out.println("Impossible ! Nombre invalide : "
                        + e.getCoup() + " (" + e.getProbleme() + ")");
            }
            System.out.println();
        }
        return nb;
    }
}
