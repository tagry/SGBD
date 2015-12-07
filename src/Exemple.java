import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class Exemple {

    public static void main (String[] args)
    throws SQLException, ClassNotFoundException, java.io.IOException {
        
        try {

            Requete rq = new Requete ();
            System.out.println("Je suis connecté !!");
            //rechercheRecette(nomRct,categ,tri,prixMin,prixMax,difficulteMax,tempsMax)
            rq.rechercheRecette(null,"T", -1, -1, -1, -1, -1);
            menu();
            rq.rechercheEleve(1);
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
        catch (Exception e){
            System.out.println("Ca ne marche pas. Dommage !!");
        }
    }

    public int menu () {
        String title = "|----------- BDD RECETTE------------"
                    + "\n menu :";
        System.out.print(title);
        return 0;
    }
}