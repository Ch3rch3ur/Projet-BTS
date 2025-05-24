# 🌐 Supervision logicielle – Projet Eau Pluviale (CIEL IR – Option A)

## 🎓 Projet BTS Systèmes Numériques – Option A : Informatique et Réseaux  
📍 Lycée Modeste Leroy, Évreux – Session 2025

---

## 📘 Contexte

Ce dépôt couvre la partie **Informatique et Réseaux (CIEL IR – Option A)** du projet de supervision d’une cuve d’eau pluviale.

Le rôle de l’équipe IR est de concevoir un **système logiciel complet** permettant de :
- Récupérer les données mesurées par la partie ER (Option B)
- Les stocker dans une base de données
- Les afficher en **temps réel via une IHM Web**
- Et aussi via une **application Android dédiée**

---

## 🎯 Objectifs

- 🔄 Récupérer les données envoyées via le réseau local (Wi-Fi)
- 🗃️ Enregistrer les valeurs dans une base de données
- 🌐 Créer une **interface Web** (IHM)
- 📱 Développer une **application Android** connectée à l’API REST
- 🌍 Assurer la synchronisation entre les interfaces et les données du système

---

## 🧱 Architecture logicielle

![Serveur de déploiment](https://github.com/user-attachments/assets/3195d6d1-e2f0-4bf0-81d1-80e0dc42cf35)


     << Partie ER (ESP32) envoie les données ici via POST REST >>
---

## 🛠️ Technologies utilisées

| Élément              | Outils / Langages                         |
|----------------------|-------------------------------------------|
| Backend              | Java (Servlets)                           |
| API                  | REST (GET, POST), JSON                    |
| Frontend Web         | HTML/CSS/JS (responsive, AJAX)            |
| App Android          | Java (Android Studio)                     |
| Base de données      | MySQL                                     |
| Communication        | TCP/IP (réseau local)                     |

---

## 📂 Structure du dépôt recommandée

- 📂 Common : Régler entité et méthode spécifique (getby spécifique)
- 📂 Couche Métier : API Restful et régles de fonctionnement
- 📂 Couche Physique : Base de Données et Test Unitaire 
- 📂 ServeurAvecClientWebPF : IHM (module du site web)

---

## 🧪 Fonctionnalités clés

| Fonction                     | Web | Android |
|------------------------------|-----|---------|
| Consultation des mesures     | ✅   | ✅     |
| Historique des données       | ✅   | ✅     |
| Affichage des alertes        | ✅   | ✅     |
| Requête en temps réel (API)  | ✅   | ✅     |

---

## 🧪 Fonctionnalités développées

- 📶 Récupération en temps réel des mesures envoyées par l’ER :
  - Niveau d’eau
  - Température (Pompe et Cuve)
  - Pression
  - Consommation du surpresseur sur la ville et la pluie
  - Débit
- 🗃️ Enregistrement en base de données (intervalle régulier)
- 🌍 Interface Web consultable depuis smartphone/PC
- 📊 Visualisation des données
- 🚨 Affichage des alertes système (niveau bas, surpression, etc.)

---

## 👥 Taches des étudiants

| Étudiant             | Tâches réaliser                                                 |
|----------------------|-----------------------------------------------------------------|
| GODARD Joris         | Mise en œuvre de la BDD (MySQL)                                 |
|                      | Réalisation couche metier (regles fonctionnement)               |  
|                      | Réalisation couche ORM (JPA, avec Lib de la section)            |
|                      | Test unitaire, scénario de peuplement de la base                |
| BULLIARD Chloé       | Réalisation Serveur RESTFul mappage service métier distant      |
|                      | Réalisation client RESTFul en Java pour le client lourd         |
|                      | Réalisation client RESTFul en Python sur la P.O                 |
| TSOULI Ahmed         | IHM web générale de gestion en J2EE / JSF /PrimeFaces           |
| BOUFFANDEAU Romain   | Réalisation application type client mobile Android en JAVA      |
|                      | Gestion des alertes                                             |
|                      | Utilisation client REST Java (en collaboration avec le restful) | 

---

## 👥 Encadrement & Équipe IR

- Étudiant.e.s IR : [GODARD Joris, BULLIARD Chloé, BOUFFANDEAU Romain, TSOULI Ahmed]
- Référents pédagogiques :
  - M. GOUBIN Thomas
  - M. DENISART Xavier
  - M. ALONSO Stéphane

---

## 🧠 Notes supplémentaires

 L'application Android n'apparaît pas dans ce dépot.
 Le projet est fonctionnelle.

---

> 🔧 *Partie IR – Option A du projet global de supervision de l’eau pluviale – BTS SN Session 2025*

