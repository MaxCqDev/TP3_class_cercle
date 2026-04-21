package allumettes;

public class Joueur {
	private String nom;
	private Strategie strategie;

	public Joueur(String nom, Strategie strategie) {
		this.nom = nom;
		this.strategie = strategie;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getPrise(Jeu jeu) {
		return this.strategie.getPrise(jeu, this.nom);
	}
	
	//test changer strategie en cours de parti
	public void setStrategie(Strategie toto) {
		this.strategie = toto;
	}
	
}
