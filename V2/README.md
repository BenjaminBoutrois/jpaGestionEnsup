# jpaGestionEnsup

Gestion Ensup avec JPA et Hibernate.

## Prérequis
- JDK 8
- Maven 3.6.3
- Un serveur MySQL

## Installation

1. Cloner le dépôt
2. Modifier le fichier `jpaGestionEnsup/V1/src/main/resources/META-INF/persistence.xml` pour qu'il corresponde à la base de données souhaitée
3. A la racine du projet V1, ouvrir un invite de commande et taper l'instruction `mvn clean package` pour compiler le projet
4. Toujours à la racine du projet V1, ouvrir un invite de commande et taper l'instruction `java -jar target\jpaGestionEnsup-0.0.1-SNAPSHOT.jar` pour lancer le projet
