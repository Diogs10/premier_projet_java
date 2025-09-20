package modele;

import java.util.ArrayList;
import java.util.List;

public class Administrateur {
    private String nom;
    private List<Serveur> serveursGeres;

    public Administrateur(String nom) {
        this.nom = nom;
        this.serveursGeres = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Serveur> getServeursGeres() {
        return serveursGeres;
    }

    public void ajouterServeur(Serveur serveur) {
        serveursGeres.add(serveur);
    }

    @Override
    public String toString() {
        return "Administrateur: " + nom + " (" + serveursGeres.size() + " serveurs gérés)";
    }
}