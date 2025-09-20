import modele.Salle;
import modele.Serveur;
import modele.Administrateur;

import java.util.*;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Salle> salles = new ArrayList<>();
    private static final List<Administrateur> administrateurs = new ArrayList<>();
    private static final List<Serveur> serveurs = new ArrayList<>();

    public static void main(String[] args) {
        int choix;
        do {
            afficherMenu();
            choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1 -> creerSalle();
                case 2 -> listerSalles();
                case 3 -> creerAdministrateur();
                case 4 -> listerAdministrateurs();
                case 5 -> rattacherServeurSalle();
                case 6 -> rattacherServeurAdministrateur();
                case 7 -> listerServeursParAdministrateur();
                case 8 -> listerServeursParSalle();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void afficherMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Créer une salle");
        System.out.println("2. Lister les salles");
        System.out.println("3. Créer un administrateur");
        System.out.println("4. Lister les administrateurs");
        System.out.println("5. Rattacher un serveur à une salle");
        System.out.println("6. Rattacher un serveur à un administrateur");
        System.out.println("7. Lister les serveurs par administrateur");
        System.out.println("8. Lister les serveurs d'une salle");
        System.out.println("0. Quitter");
        System.out.print("Choix : ");
    }

    private static void creerSalle() {
        System.out.print("Nom de la salle : ");
        String nom = scanner.nextLine();
        salles.add(new Salle(nom));
        System.out.println("Salle créée !");
    }

    private static void listerSalles() {
        if (salles.isEmpty()) {
            System.out.println("Aucune salle enregistrée.");
        } else {
            salles.forEach(System.out::println);
        }
    }

    private static void creerAdministrateur() {
        System.out.print("Nom de l'administrateur : ");
        String nom = scanner.nextLine();
        administrateurs.add(new Administrateur(nom));
        System.out.println("Administrateur créé !");
    }

    private static void listerAdministrateurs() {
        if (administrateurs.isEmpty()) {
            System.out.println("Aucun administrateur.");
        } else {
            administrateurs.forEach(System.out::println);
        }
    }

    private static void rattacherServeurSalle() {
        System.out.print("Nom du serveur à créer : ");
        String nom = scanner.nextLine();
        System.out.println("Choisir une salle :");
        for (int i = 0; i < salles.size(); i++) {
            System.out.println(i + ". " + salles.get(i).getNom());
        }
        int choixSalle = Integer.parseInt(scanner.nextLine());
        Serveur serveur = new Serveur(nom);
        serveur.setSalle(salles.get(choixSalle));
        serveurs.add(serveur);
        System.out.println("Serveur créé et attaché à la salle !");
    }

    private static void rattacherServeurAdministrateur() {
        if (serveurs.isEmpty()) {
            System.out.println("Aucun serveur disponible.");
            return;
        }
        System.out.println("Choisir un serveur :");
        for (int i = 0; i < serveurs.size(); i++) {
            System.out.println(i + ". " + serveurs.get(i).getNom());
        }
        int choixServeur = Integer.parseInt(scanner.nextLine());

        System.out.println("Choisir un administrateur :");
        for (int i = 0; i < administrateurs.size(); i++) {
            System.out.println(i + ". " + administrateurs.get(i).getNom());
        }
        int choixAdmin = Integer.parseInt(scanner.nextLine());

        serveurs.get(choixServeur).setAdministrateur(administrateurs.get(choixAdmin));
        System.out.println("Serveur assigné à l'administrateur !");
    }

    private static void listerServeursParAdministrateur() {
        for (Administrateur admin : administrateurs) {
            System.out.println("\n" + admin.getNom() + " gère :");
            for (Serveur srv : admin.getServeursGeres()) {
                System.out.println("  - " + srv.getNom());
            }
        }
    }

    private static void listerServeursParSalle() {
        System.out.println("Choisir une salle :");
        for (int i = 0; i < salles.size(); i++) {
            System.out.println(i + ". " + salles.get(i).getNom());
        }
        int choix = Integer.parseInt(scanner.nextLine());
        Salle salle = salles.get(choix);
        System.out.println("Serveurs dans la salle " + salle.getNom() + " :");
        for (Serveur srv : salle.getServeurs()) {
            System.out.println("  - " + srv.getNom());
        }
    }
}