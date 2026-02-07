# Redux - Projet de Programmation Objet 🎱

[![Java](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com/)
[![University](https://img.shields.io/badge/University-Paris--Saclay-red.svg)](https://www.universite-paris-saclay.fr/)

**Redux** est un jeu de réflexion développé en Java, inspiré des classiques *Oxyd* et *Enigma*. Ce projet a été réalisé en binôme dans le cadre de la Licence Informatique (L2) à l'Université Paris-Saclay.

---

## 🎨 Aperçu du Projet

### Le Lanceur
Le jeu débute par un **Lanceur** (classe `Lanceur`) qui initialise une interface graphique personnalisée :
* Une image de fond (`Launcher_bg.jpg`) avec les avatars des développeurs.
* Un bouton **Play** (`PlayButton`) qui lance le premier niveau (`lab.txt`).

### Gameplay & Niveaux
Le jeu propose une progression sur plusieurs niveaux avec un **chronomètre intégré** affiché en temps réel :

1.  **Niveau 1 (Introduction) :** Apprentissage des mécaniques et contrôle de la bille.
2.  **Niveau 2 (L'Énigme des Sorties) :** Le joueur doit trouver la case `End` réelle parmi plusieurs `FakeEnd` pour passer au labyrinthe suivant.
3.  **Niveau 3 (Labyrinthe Final) :** Un parcours complexe testant la précision des collisions.

---

## 🛠 Détails Techniques

### Moteur Physique (`Bille.java`)
La bille est gérée par des coordonnées réelles (`double x, y`) et un système de vecteurs de vitesse :
* **Vitesse Maximale :** Bridée à `0.25` pour garantir un mouvement réaliste.
* **Système de Friction :** Implémenté via la méthode `frottement()`, appliquant une décélération basée sur la constante `f`.
* **Gestion des Collisions :** La classe `Square` utilise une détection par zones (Gauche, Droite, Haut, Bas) pour calculer les points de contact. Les murs (`Mur`) inversent alors les vecteurs de vitesse via `switchVX()` et `switchVY()`.

### Architecture POO & Polymorphisme
Le projet repose sur une hiérarchie de classes héritant de la classe abstraite **Square** :
* **CaseOrdinaire** : Espace vide traversable.
* **Mur** : Bloc infranchissable provoquant un rebond.
* **End / FakeEnd** : Déclenchent soit le passage au niveau suivant, soit une simple collision.
* **Freeze** : Modifie dynamiquement la constante de frottement de la bille (`Bille.f = 0.005`) pour la ralentir fortement lorsqu'elle entre sur la case.

### Contrôles & Événements (`Events.java`)
* **Suivi de souris :** Un système de "Pause/Play" par clic :
    * **Clic gauche/droit :** Active ou désactive le mode `enjeu`.
    * **Mode Suivi :** La bille calcule l'écart entre sa position et celle du curseur pour ajuster ses vecteurs `vx` et `vy` via une accélération pondérée `a`.

---

## 🎮 Commandes
* **Souris :** Oriente la bille vers le curseur.
* **Clic :** Active / Désactive le mouvement de la bille.
* **Objectif :** Atteindre la zone verte (`End`) pour débloquer le niveau suivant.

---

## 🚀 Installation

1.  **Prérequis :** Java JDK 11 ou supérieur.
2.  **Compilation :**
    ```bash
    javac src/*.java -d bin
    ```
3.  **Exécution :**
    ```bash
    java -cp bin Lanceur
    ```

---

## 👥 Équipe
* **Manishva VIDJEACOUMAR**
* **Edam DAMMAK**

---
*Projet réalisé dans le cadre de l'UE "Introduction à la Programmation Objets" - Licence Informatique.*
