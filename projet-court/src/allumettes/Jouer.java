package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {
	
	private static final int NB_ALLUMETTES_INITIAL = 13;

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
	    try {
	        verifierNombreArguments(args);

	        boolean confiant = false;
	        int offset = 0;
	        if (args.length == 3) {
	            if (!args[0].equals("-confiant")) {
	                throw new ConfigurationException("Option inconnue : " + args[0]);
	            }
	            confiant = true;
	            offset = 1;
	        }

	        Joueur j1 = creerJoueur(args[offset]);
	        Joueur j2 = creerJoueur(args[offset + 1]);

	        Arbitre arbitre = new Arbitre(j1, j2);
	        arbitre.setConfiant(confiant);
	        Jeu jeu = new JeuToto(NB_ALLUMETTES_INITIAL);
	        arbitre.arbitrer(jeu);

	    } catch (ConfigurationException e) {
	        System.out.println();
	        System.out.println("Erreur : " + e.getMessage());
	        afficherUsage();
	        System.exit(1);
	    }
	}
	

    private static Joueur creerJoueur(String description) {
        String[] parts = description.split("@");
        if (parts.length != 2) {
            throw new ConfigurationException(
                    "Joueur mal décrit (attendu nom@strategie) : " + description);
        }
        String nom = parts[0];
        String nomStrategie = parts[1];
        Strategie strategie = creerStrategie(nomStrategie);
        return new Joueur(nom, strategie);
    }

    private static Strategie creerStrategie(String nomStrategie) {
        switch (nomStrategie) {
            case "rapide":
                return new Rapide();
            case "naif":
            	return new Naif();
            	
            case "tricheur":
            	return new Tricheur();
            	
            case "expert":
            	return new Expert();
            	
            case "humain":
            	return new Humain();
            	
            default:
                throw new ConfigurationException(
                        "Stratégie inconnue : " + nomStrategie);
        }
    }
    
    
    
    
    
    /////////////////////////////////////////////////////////

    
    
    
    
    
	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

}
