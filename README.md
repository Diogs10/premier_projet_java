# Projet Serveur - Administrateur - Salle (Java Console)

Ce projet Java simple permet de gérer des **salles**, des **serveurs** et des **administrateurs** via une application console.

## 📁 Structure du projet

```
ProjetServeurAdmin/
│
├── src/
│   ├── modele/
│   │   ├── Salle.java
│   │   ├── Serveur.java
│   │   └── Administrateur.java
│   │
│   └── Application.java
```

## ⚙️ Fonctionnalités de l'application

- Créer une salle
- Lister les salles
- Créer un administrateur
- Lister les administrateurs
- Rattacher un serveur à une salle
- Rattacher un serveur à un administrateur
- Lister les serveurs par administrateur
- Lister les serveurs d'une salle

## 🖥️ Exécution

### 1. Compilation

```bash
javac -d bin src/modele/*.java src/Application.java
```

### 2. Exécution

```bash
java -cp bin Application
```

## ✍️ Auteurs

- Étudiant : Diogal NDIAYE
- Encadrant : Mr SONKO
- Année : 2024-2025
