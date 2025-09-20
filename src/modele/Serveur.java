package modele;

public class Serveur {
    private String nom;
    private Salle salle;
    private Administrateur administrateur;

    public Serveur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Salle getSalle() {
        return salle;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
        salle.ajouterServeur(this);
    }

    public void setAdministrateur(Administrateur admin) {
        this.administrateur = admin;
        admin.ajouterServeur(this);
    }

    @Override
    public String toString() {
        return "Serveur: " + nom +
               (salle != null ? ", Salle: " + salle.getNom() : "") +
               (administrateur != null ? ", Admin: " + administrateur.getNom() : "");
    }
}