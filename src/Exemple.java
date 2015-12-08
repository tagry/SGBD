/**
 * Cette classe émule de facon assez sommaire le comportement du programme 
 * que l'on souhaitait implémenter.
 * Ayant rencontré des problème lors du passage de l'interface graphique
 * sous Oracle, on a décidé de recréer un comportement similaire sur un 
 * terminal.
 * 
 * @author W.Soulaimana, N.Gourrin, T.Agry
 * @version 1.0  
 */

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import java.util.Scanner;

public class Exemple {
    
    /**
     * ******************************************************
     * Pour 'connecter un autre utilisateur que W.Soulaimana'
     * vous pouvez changer les lignes 35, 36 et 37
     * afin de rentrer vos nom et prenom et ainsi 
     * simuler votre connexion.
     * !! Il est recommandé de faire pareil dans Requete.java
     * ******************************************************
     */
    public static void main (String[] args)
    throws SQLException, ClassNotFoundException, java.io.IOException {
        
        try {
            System.out.println("Connecting to database...");

            Requete rq = new Requete();
            //nom prénom et numero sont à modifier selon l'utilisateur
            String nomEleveConnecte = "SOULAIMANA";
            String prenomEleveConnecte = "WARDI";
            int numeroEleveConnecte = 1;

            System.out.print("Connecté : "+prenomEleveConnecte+" "+nomEleveConnecte
                +"\n-----------------------------------");

            Scanner sc;
            


            int m=10;
            int el;
            boolean q = true;

            String nomRecette, categorie, tmp, nomAlim,unite,nomEleve, prenomEleve;
            int tri, prixMin, prixMax, difficulteMax, tempsMax, t;

            int difficulte,budget,preparation,cuisson,nbPersonnes;

            while (q){ 
                try{   
                    String title = 
                       "\n---         BDD RECETTE         ---\n"
                        +"---   MENU : Choisir un item    ---\n"
                        +"-----------------------------------\n"
                        +"1: rechercher recettes\n"
                        +"2: rechercher détailée élève\n"
                        +"-----------------------------------\n"
                        +"3: afficher toutes les recettes\n"
                        +"4: afficher tous les élèves\n"
                        +"5: afficher tous les aliments\n"
                        +"-----------------------------------\n"
                        +"6: ajouter une recette\n"
                        +"7: ajouter un aliment\n"
                        +"8: ajouter un élève\n"
                        +"-----------------------------------\n"
                        +"9: afficher statistiques BDD\n"
                        +"-----------------------------------\n"
                        +"0: QUITTER\n"
                        +"-----------------------------------\n";
                           
                    System.out.print(title);
                    //Requete rq = new Requete ();
                    //System.out.println("Je suis connecté !!");
                    
                    sc = new Scanner(System.in);
                    m = sc.nextInt();
    
                    switch(m){
                        case 1: 
                            System.out.println("Recherche recette :");
                            System.out.println("Renseignez les champs suivants :");
                            System.out.println("nomRecette, categorie, tri, prixMin, prixMax, difficulteMax, tempsMax\n"
                                              +"---------------------------------------------------------------------");

                            System.out.print("\nnomRecette [tapez '-1' pour ignorer] : ");
                            tmp = sc.next();
                            if (tmp.equals("-1"))
                                nomRecette = null;
                            else 
                                nomRecette = tmp;

                            System.out.print("\ncategorie [E Entree, P Plat, D Dessert, T Toute] : ");
                            categorie = sc.next();

                            System.out.print("\ntri [0 Prix croiss. 1 Prix déc. 2 Durée croiss. 3 Durée déc.\n"
                            +"     4 Note crois. 5 Note déc. -1 pour ignorer] : ");
                            tri = sc.nextInt();
                            
                            System.out.print("\nprixMin ['-1' pour ignorer] : ");
                            prixMin = sc.nextInt();

                            System.out.print("\nprixMax ['-1' pour ignorer] : ");
                            prixMax = sc.nextInt();

                            System.out.print("\ndifficulteMax ['-1' pour ignorer] : ");
                            difficulteMax = sc.nextInt();

                            System.out.print("\ntempsMax ['-1' pour ignorer] : ");
                            tempsMax = sc.nextInt();

                            System.out.format("rechercheRecette(nom "+nomRecette+", categ " +categorie +", tri %d, pmin %d, pmax %d, diffMax %d, tmpsMax %d)\n",
                                tri,prixMin, prixMax, difficulteMax, tempsMax);

                            rq.rechercheRecette (nomRecette, categorie, tri, 
                                prixMin, prixMax, difficulteMax, tempsMax);

                            System.out.println("Appuyez sur une touche pour continuer ...");
                            System.in.read();
                            break;

                        case 2:
                            System.out.println("Recherche detail élève :");
                            System.out.println("Entrez le numéro de l'élève :");
                            el = sc.nextInt();
                            rq.rechercheEleve(el);
                            System.out.println("Appuyez sur une touche pour continuer ...");
                            System.in.read();
                            break;

                        case 3: 
                            System.out.println("Recettes disponibles :");
                            rq.afficheRecette();
                            System.out.println("Appuyez sur une touche pour continuer ...");
                            System.in.read();
                            break;

                        case 4:
                            System.out.println("Elèves inscrits :");
                            rq.afficheEleve(); 
                            System.out.println("Appuyez sur une touche pour continuer ...");
                            System.in.read();
                            break;

                        case 5:
                            System.out.println("Aliments disponibles :"); 
                            rq.afficheAliment();
                            System.out.println("Appuyez sur une touche pour continuer ...");
                            System.in.read();
                            break;
                        case 6:
                            System.out.println("Ajouter une recette :");
                            System.out.println("Renseignez les champs suivants :");
                            System.out.println("nomRecette,categorie, difficulte, budget, tmpsPreparation, tmpsCuisson, nbPersonnes\n"
                                              +"-----------------------------------------------------------------------------------");

                            System.out.print("\nNOM de votre recette : ");
                            nomRecette = sc.next();

                            System.out.print("\nCATEGORIE de votre recette [E Entree, P Plat, D Dessert]: ");
                            categorie = sc.next();

                            System.out.print("\nDIFFICULTE de votre recette [0 .. 10] : ");
                            difficulte = sc.nextInt();

                            System.out.print("\nBUDGET de votre recette [en €] : ");
                            budget = sc.nextInt();

                            System.out.print("\nTEMPS de PREPARATION : ");
                            preparation = sc.nextInt();

                            System.out.print("\nTEMPS de CUISSON : ");
                            cuisson = sc.nextInt();

                            System.out.print("\nPOUR COMBIEN DE PERSONNES: ");
                            nbPersonnes = sc.nextInt();

                            System.out.format("\najoutRecette(nom "+nomRecette+", categ " +categorie +", diff %d, budget %d, prep %d, cuiss %d, nbpers %d)\n",
                                difficulte, budget, preparation, cuisson, nbPersonnes);
                            System.out.println("Tapez '1' pour confirmer l'ajout ou une autre touche pour annuler : ");
                            if (sc.nextInt() == 1){
                                rq.ajoutRecette(numeroEleveConnecte, nomRecette, categorie, difficulte, budget, preparation, cuisson, nbPersonnes);
                                System.out.println("Ajout confirmé ");
                            }
                            else
                                System.out.println("Abandon de l'ajout...");

                            System.out.println("Appuyez sur une touche pour continuer ...");
                            System.in.read();
                            break;

                        case 7:
                            System.out.println("Ajouter un aliment :"); 
                            System.out.println("Renseignez les champs suivants :");
                            System.out.println("nomAlim, unité\n"
                                              +"-----------------------------------------------------------------------------------");

                            System.out.print("\nNOM de votre aliment : ");
                            nomAlim = sc.next();

                            System.out.print("\nUNITE de mesure [Gramme, Unite, Sachet, ...] : ");
                            unite = sc.next();

                            System.out.format("\najoutAliment(nom "+nomAlim+", unité " + unite);
                            System.out.println("\nTapez '1' pour confirmer l'ajout ou une autre touche pour annuler : ");
                            if (sc.nextInt() == 1){
                                rq.ajoutAliment (nomAlim, unite);
                                System.out.println("Ajout confirmé ");
                            }
                            else
                                System.out.println("Abandon de l'ajout...");

                            System.out.println("Appuyez sur une touche pour continuer ...");
                            System.in.read();
                            break;
                        case 8:
                            System.out.println("Ajouter un élève :"); 
                            System.out.println("Renseignez les champs suivants :");
                            System.out.println("nomEleve, prenomEleve\n"
                                              +"-----------------------------------------------------------------------------------");

                            System.out.print("\nNOM de l'élève : ");
                            nomEleve = sc.next();

                            System.out.print("\nPRENOM de l'élève : ");
                            prenomEleve = sc.next();

                            System.out.format("\najoutEleve(nom "+nomEleve+", prenom "+prenomEleve);
                            System.out.println("\nTapez '1' pour confirmer l'ajout ou une autre touche pour annuler : ");
                            if (sc.nextInt() == 1){
                                rq.ajoutEleve (nomEleve,prenomEleve);
                                System.out.println("Ajout confirmé ");
                            }
                            else
                                System.out.println("Abandon de l'ajout...");

                            System.out.println("Appuyez sur une touche pour continuer ...");
                            System.in.read();
                            break;
                        case 9:
                            System.out.println("Afficher Statistiques :");
                            System.out.format("Il ya actuelement dans la Base De Donnees :\n" 
                                +"%d \tRecettes publiées\n"
                                +"%d \tAliments\n"
                                +"%d \tEleves\n",
                                rq.getNbRct(),rq.getNbAlim(),rq.getNbEleve()); 

                            System.out.println("Appuyez sur une touche pour continuer ...");
                            System.in.read();
                            break;
                        
                        case 0:
                            System.out.println("Confirmez 'quitter' en appyant sur 0\n"
                                +"ou annulez en appuyant sur une autre touche :");
                            if ((m = sc.nextInt()) == 0){
                                System.out.println("Fin");
                                q = false;
                            }
                             
                            break;
                        
                        default:
                            System.out.println("Choisissez un item correct ...");
                            break;
                    }

                }
                catch (Exception e){
                    System.out.println("Erreur de syntaxe ou de type. Veuillez recommencer !!");
                }
                //rechercheRecette(nomRct,categ,tri,prixMin,prixMax,difficulteMax,tempsMax)
                //rq.rechercheRecette(null,"T", -1, -1, -1, -1, -1);
                
                //rq.rechercheEleve(1);
                //rq.rechercheEleve(2);

                //Statistiques
                //rq.statistique();
                //rq.nbRecette();
                //rq.dessertRapide();
                //rq.rapportQP();

                //Mise a jour des donnees
                //rq.rechercheRecette(null,"D", -1, -1, -1, -1, -1);
                //rq.ajoutAliment("BATATA","UNITE");
                //rq.ajoutRecette(1, "MATABA","E", 5, 4, 20, 40, 4);
                //rq.rechercheRecette(null,"T", 3, -1, -1, -1, -1);
                
                /*rq.utilisateur("SOULAIMANA");
                rq.utilisateur("GOURRIN");
                rq.utilisateur(3);
                rq.recette("CREPE");*/
            }
        } 
        catch (SQLException e){
            System.out.println("Requete invalide. Désolé");
        }
        
    }

}