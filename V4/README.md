# jpaGestionEnsup

Gestion Ensup en projet Maven multi-modules avec JPA et Hibernate.
Ajout de Log4j2.

## Prérequis

- JDK 8
- Maven 3.6.3
- Un serveur MySQL
- Apache Tomcat 9 configuré sur le port 8080
- Le serveur web et le serveur de base de données doivent être lancés

## Installation

1. Cloner le dépôt
2. Créer une base de données en la nommant **jpagestionensup**
3. A la racine du projet V4, ouvrir un invite de commande et taper l'instruction `mvn clean package` pour compiler le projet
4. Une fois compilé, copier le fichier **V4\web\target\web.war** dans le dossier **webapps** du serveur Tomcat
5. Lancer le serveur Tomcat pour déployer le projet sur le serveur
6. Ouvrir un navigateur et entrer `http://127.0.0.1:8080/web` dans la barre d'URL pour accéder à l'application
