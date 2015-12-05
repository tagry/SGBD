import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class Requete {
	OracleDataSource ods;
	Connection conn;
	

	//Constructeur
	Requete (OracleDataSource ods) {
		this.ods = ods;
		try{
			this.conn = ods.getConnection();
		} catch (Exception e) {
			this.conn = null;
		}
	}

	// To correct
	public void utilisateur (String nomEleve) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
				"select * from ELEVE where NOM_ELEVE = ?");	//FAKE >=
			stmt.setString(1, nomEleve); 
			ResultSet rset = stmt.executeQuery();
			print(rset);
       	}
       	catch (Exception e) {
       		System.out.println(e.toString());
       	}
	}

	public void utilisateur (int numEleve) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
				"select * from ELEVE where NUMERO_ELEVE = ?");
			stmt.setInt(1, numEleve); 
			ResultSet rset = stmt.executeQuery();
			print(rset);
       	}
       	catch (Exception e) {
       		System.out.println(e.toString());
       	}
	}

	public void recette (String nomRct) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
				"select * from RECETTE where NOM_RECETTE = ?");
			stmt.setString(1, nomRct); 
			ResultSet rset = stmt.executeQuery();
			print(rset);
       	}
       	catch (Exception e) {
       		System.out.println(e.toString());
       	}
	}

	public void print (ResultSet rset) {
		try {
			int nbC = rset.getMetaData().getColumnCount();
			while (rset.next()){
	            for (int i = 1; i <= nbC; i++) {
	            	if (i > 1) System.out.print(", ");
	            	System.out.print(rset.getMetaData().getColumnName(i) + " " + rset.getString(i));
	        	}
	        	System.out.println(" ");
	    	}
        	System.out.println(" ");
    	}
    	catch (Exception e) {
       		System.out.println(e.toString());
    	}
	}

}
