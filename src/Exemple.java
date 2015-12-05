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
        Statement stmt = null;
        Statement stmt2 = null;
        
        try {

            Requete rq = new Requete (ods);
            rq.utilisateur("SOULAIMANA");
            rq.utilisateur(3);
            rq.recette("CREPE");

        }

        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}