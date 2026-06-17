package allumettes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Swing implements Strategie, ActionListener {

    private static final int LARGEUR_CHAMP = 3;

    private final Object verrou = new Object();
    private int choix;
    private Jeu jeu;
    private JFrame fenetre;
    private JLabel etat;
    private JButton[] boutons;
    private JTextField saisie;

    @Override
    public int getPrise(Jeu jeu, String nom) {
        this.jeu = jeu;
        this.choix = 0;
        afficher(nom);
        synchronized (this.verrou) {
            while (this.choix < 1) {
                try {
                    this.verrou.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        this.fenetre.dispose();
        return this.choix;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("tricher")) {
            tricher();
            rafraichir();
        } else {
            synchronized (this.verrou) {
                this.choix = Integer.parseInt(e.getActionCommand());
                this.verrou.notify();
            }
        }
    }

    private void afficher(String nom) {
        this.fenetre = new JFrame(nom);
        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panneau = new JPanel();
        this.etat = new JLabel();
        panneau.add(this.etat);

        this.boutons = new JButton[Jeu.PRISE_MAX];
        for (int k = 1; k <= Jeu.PRISE_MAX; k++) {
            JButton bouton = new JButton(String.valueOf(k));
            bouton.setActionCommand(String.valueOf(k));
            bouton.addActionListener(this);
            this.boutons[k - 1] = bouton;
            panneau.add(bouton);
        }

        JButton boutonTricher = new JButton("Tricher");
        boutonTricher.setActionCommand("tricher");
        boutonTricher.addActionListener(this);
        panneau.add(boutonTricher);

        this.saisie = new JTextField("2", LARGEUR_CHAMP);
        panneau.add(this.saisie);

        this.fenetre.add(panneau);
        rafraichir();
        this.fenetre.pack();
        this.fenetre.setLocationRelativeTo(null);
        this.fenetre.setVisible(true);
    }

    private void rafraichir() {
        int reste = this.jeu.getNombreAllumettes();
        this.etat.setText("Allumettes restantes : " + reste);
        for (int k = 0; k < this.boutons.length; k++) {
            this.boutons[k].setEnabled(k + 1 <= reste);
        }
    }

    private void tricher() {
        int reste = this.jeu.getNombreAllumettes();
        if (reste == 1) {
            OutilsJeu.changerNombre(this.jeu, 1);
            System.out.println("[Je triche... 1 allumette en plus]");
        } else {
            int nb = Math.min(nombreSaisi(), reste - 1);
            if (nb >= 1) {
                OutilsJeu.changerNombre(this.jeu, -nb);
                String s = (nb > 1) ? "s" : "";
                System.out.println("[Je triche... " + nb + " allumette" + s + " en moins]");
            }
        }
    }

    private int nombreSaisi() {
        try {
            return Integer.parseInt(this.saisie.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
