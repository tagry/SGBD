-----------------------------\ Projet SGBD Recettes /----------------------------------
---
--- Auteurs : W.Soulaimana, N.Gourrin, T.Agry
---------------------------------------------------------------------------------------

***************************************************************************************
Tout d'abord nous tenons à vous présenter nos excuses pour le désagrément qu'engendrent
notre retard concernant le rendu du projet.
***************************************************************************************

Ceci est une version du projet dans laquel il y a:
    - Une Base De Donnée générée sous Oracle
    - Une Interface Graphique (java.swing)
    - Un Programme d'Exemple
    - divers fichiers ayant servi au developpement

Compte tenu du problème que l'on a rencontré, nous n'avons pas reussi à
fusionner la partie du programme qui gère les requêtes SQL et communique
avec la BDD avec la partie interface graphique.
Nous détaillerons ces problème lors de la soutenance.

Dans cette version la base de donnée est quand même opérationnelle c'est 
pour cela que nous avons décidé de recréer une mini interface dans le 
Terminal afin de pouvoir la tester.


---------------------------------------------------------------------------------------
--- I - LA BASE DE DONNEES
---------------------------------------------------------------------------------------

La BDD a été implémentée sous Oracle. Ce qui implique que pour la lancer il est
nécessaire d'avoir accès à la machine Oracle de l'école pour la consulter.

--- Création de la base

Pour créer la base de donnée:

    - Se connecter à Oracle (la machine Oracle de l'école)
    - Se rendre à la racine du projet
    
    - Configurer Oracle : 
        Au choix :  faire   'source src/script.bash'
                    ou      faire manuellement la configuration des variables
                            contenues dans src/script.bash  

    - Créer et Préremplir la base :
        Au choix :  faire   'sqlplus <login>/<mdp> @all'
                    ou      lancer SQL*Plus et faire            '@all'      //plus sûr

La BDD doit normalement etre créé. Vous pouvez des lors la consulter avec SQL*Plus


---------------------------------------------------------------------------------------
--- II - L'INTERFACE GRAPHIQUE
---------------------------------------------------------------------------------------

Depuis l'interface, pour l'instant, on n'a pas accès à la base de donnée. Cependant,
il est possible d'ouvrir l'interface et d'en avoir un apercu. Les données affichées 
sont totalement arbitraire et n'ont pas de réelle valeur. Ce qui compte c'est la
disposition et les actions des différents boutons.

--- Création de l'interface

Pour compiler et executer l'interface graphique:

    - Quitter oracle si ce n'est pas encore fait
    - Se rendre à la racine du projet
    - Compiler et exécuter l'interface avec la commande :   'make prog'

Pour seulement compiler l'interface :

    - lancer la commande :  'make compilProg'

Une fois compilée l'interface peut aussi se lancer à la racine avec :
    - 'make prog'
    ou
    - 'java -cp ./build/ FenetrePrincipale

A ce stade vous pouvez voir l'interface et parcourir les différentes fenêtre qui
y sont présentées.


---------------------------------------------------------------------------------------
--- III - INTERFACE MINIMALE : EXEMPLE ET REQUETE
---------------------------------------------------------------------------------------

Dans les fichier src/Exemple.java et src/Requête.java nous avons développé une 
interface minimale dans le terminal afin de pouvoir interagir avec la base de donnée
même si nous n'avons pas réussi à le faire via l'interface graphique java.swing.

Techniquement les requêtes sont toutes définies dans la classe src/Requete.java
et le code dans src/Exemple.java implémente la mini interface.

--- Prérequis

Modifier les fichier src/Requete.java et src/Exemple.java comme décrit dans leur
préambules. C'est à dire changer les paramètres de connexion.

--- Compilation et Utilisation de l'interface et des requetes

Pour compiler et exécuter l'interface minimale :

    - Se rendre dans Oracle et configurer la machine comme en _section_I_
    - Se rendre à la racine du projet
    - Compiler et exécuter l'interface avec :
        'make expl'

Pour seulement la compiler :
    - 'make cmplEx'

Une fois compilée cette interface peut se lancer en faisant 
    - 'make expl'
    ou
    - 'java -cp ./build Exemple.java'

Dès lors vous avez accès à une interface qui permet de communiquer avec la base de donnée.
Vous pouvez ajouter, consulter, rechercher,etc des données dans la base.