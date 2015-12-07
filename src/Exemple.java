import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class Exemple {

    

    public static OracleDataSource initConnexion () throws SQLException, ClassNotFoundException, java.io.IOException {
        OracleDataSource ods = new OracleDataSource(); 

        // Preparation de la connexion.
        
        ods.setUser("wsoulaimana");
        ods.setPassword("wsoulaimana");
        
        // URL de connexion.
        ods.setURL("jdbc:oracle:thin:@localhost:1521/oracle");
	return ods;
    }




    public static void main(String[] args)
    throws SQLException, ClassNotFoundException, java.io.IOException {

        // Lancement de la connexion
        OracleDataSource ods = initConnexion();

        Connection conn = null;
        
        try {

            Requete rq = new Requete (ods);

            //rechercheRecette(nomRct,categ,tri,prixMin,prixMax,difficulteMax,tempsMax)
            //rq.rechercheRecette(null,"T", -1, -1, -1, -1, -1);
            
            //rechercheEleve(numEleve)
            //rq.rechercheEleve(2);

            //Statistiques
            //rq.statistique();
            //rq.nbRecette();
            //rq.dessertRapide();
            //rq.rapportQP();

            //Mise a jour des donnees
            rq.rechercheRecette(null,"D", -1, -1, -1, -1, -1);
            rq.ajoutAliment("BATATA","UNITE");
            //rq.ajoutRecette(1, "MATABA","E", 5, 4, 20, 40, 4);
            rq.rechercheRecette(null,"T", 3, -1, -1, -1, -1);
            
            /*rq.utilisateur("SOULAIMANA");
            rq.utilisateur("GOURRIN");
            rq.utilisateur(3);
            rq.recette("CREPE");*/

        }

        finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}