package modele;

import java.util.ArrayList;
import java.util.List;

public class Salle {
    private String nom;
    private List<Serveur> serveurs;

    public Salle(String nom) {
        this.nom = nom;
        this.serveurs = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Serveur> getServeurs() {
        return serveurs;
    }

    public void ajouterServeur(Serveur serveur) {
        serveurs.add(serveur);
    }

    @Override
    public String toString() {
        return "Salle: " + nom + " (" + serveurs.size() + " serveurs)";
    }
}