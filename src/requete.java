import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class requete {
	public void appelerRequete(String utilisateur, String motDePasse,String defRequete)
		{
			throws SQLException, ClassNotFoundException, java.io.IOException {
// Preparation de la connexion.
				OracleDataSource ods = new OracleDataSource();
				ods.setUser(utilisateur);
				ods.setPassword(motDePasse);
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

					ResultSet rset = stmt.executeQuery(defRequete);
					
					while (rset.next())
						System.out.println(rset.getString(1) + rset.getString(2));
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
}
