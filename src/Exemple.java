import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class Exemple {
    public static void main(String[] args)
    throws SQLException, ClassNotFoundException, java.io.IOException {
// Preparation de la connexion.
        OracleDataSource ods = new OracleDataSource();
        ods.setUser("wsoulaimana");
        ods.setPassword("wsoulaimana");
// URL de connexion, on remarque que le pilote utilise est "thin".
        ods.setURL("jdbc:oracle:thin:@localhost:1521/oracle");

        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;
        try {
            conn = ods.getConnection();
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
// Execution de la requete.

            ResultSet rset = stmt.executeQuery(
                    "select NOM_RECETTE, CATEGORIE "
                +   "from RECETTE");

            ResultSet rset2 = stmt2.executeQuery(
                    "select NOM_ELEVE "
                +   "from ELEVE");

            while (rset.next())
                System.out.println(rset.getString(1) + rset.getString(2));

            while (rset2.next())
                System.out.println(rset2.getString(1));
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