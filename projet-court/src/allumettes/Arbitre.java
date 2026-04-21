package allumettes;

public class Arbitre {
	//truc de confiance
	private boolean confiant = false;
	public void setConfiant(boolean confiant) {
	    this.confiant = confiant;
	}
	
    private Joueur joueur1;
    private Joueur joueur2;

    public Arbitre(Joueur j1, Joueur j2) {
        this.joueur1 = j1;
        this.joueur2 = j2;
    }

    public void arbitrer(Jeu jeu) {
        Joueur courant = this.joueur1;
        Joueur autre = this.joueur2;

        while (jeu.getNombreAllumettes() > 0) {
            try {
                jouerTour(jeu, courant);
            } catch (OperationInterditeException e) {
                System.out.println("Abandon de la partie car "
                        + courant.getNom() + " triche !");
                return;
            }

            Joueur temp = courant;
            courant = autre;
            autre = temp;
        }

        System.out.println(autre.getNom() + " perd !");
        System.out.println(courant.getNom() + " gagne !");
    }

    private void jouerTour(Jeu jeu, Joueur joueur) {
        boolean coupValide = false;
        while (!coupValide) {
            System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes());

            Jeu jeuPourJoueur;
            if (this.confiant) {
                jeuPourJoueur = jeu;
            } else {
                jeuPourJoueur = new JeuProcuration(jeu);
            }
            
            int nb = joueur.getPrise(jeuPourJoueur);

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
    }
}