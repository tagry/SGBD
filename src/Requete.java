import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class Requete {
	OracleDataSource ods;
	Connection conn;
	

	/**
	 * Constructeur
	 *
	 * @param    ods	Oracle Database Source
	 */
	Requete (OracleDataSource ods) {
		this.ods = ods;
		try{
			this.conn = ods.getConnection();
		} catch (Exception e) {
			this.conn = null;
		}
	}


	/**
	 * rechercheRecette
	 *
	 * @param    nom	nom de la recette
	 * @param categorie 
	 * @param tri
	 * 	0 Prix croissant, 1 Prix decroissant, 2 Durée croissante, 3 Durée decroissante
	 *	4 du Plus commenté, 5 du Moin commenté, -1 Non renseigné (alphabétique par défaut)
	 * @param prixMin	-1 si Non renseigné
	 * @param prixMAx	-1 si Non renseigné
	 * @param difficulteMax	-1 si Non renseigné
	 * @param tempsMax 	
	 * 	temps préparation + cuisson
	 * 	-1 si Non renseigné
	 *
	 * @return 
	 * 	
	 */
	/**
	 * rechercheRecette
	 *
	 * @param      nomRecette     nom de la recette
	 * @param      categorie      categorie de la recette
	 * @param      tri            ordre d'affichage des resultats
	 * 		0 Prix croissant, 1 Prix decroissant, 2 Durée croissante, 
	 * 		3 Durée decroissante, 4 Note gastronomique croissante, 
	 * 		5 Note gastronomique decroissante
	 * 		-1 Non renseigné (alphabétique par défaut)
	 * @param      prixMin	      -1 si Non renseigné
	 * @param      prixMax        -1 si Non renseigné
	 * @param      difficulteMax  -1 si Non renseigné
	 * @param      tempsMax       = temps de préparation + temps de cuisson
	 * 							  ou -1 si Non renseigné
	 * 							  
	 * @return   tableau contenant 
	 *	Nom recette, Nom créateur, N° créateur, Catégorie, Budget, Difficulté
	 * 	Temps (préparation+cuisson), 
	 * 	Note (qualité, respect budget, respect difficulté) 
	 */
	public void rechercheRecette (String nomRecette, String categorie, int tri, int prixMin, 
		int prixMax, int difficulteMax, int tempsMax) {

		String query = 
			"select NOM_RECETTE, NOM_ELEVE NOM_CREATEUR, NUMERO_CREATEUR, "
			+"CATEGORIE, BUDGET, DIFFICULTE, "
			+"TEMPS_DE_PREPARATION + TEMPS_DE_CUISSON as TEMPS, "
			+" NOTE_GASTRONOMIQUE, NOTE_BUDGET, NOTE_DIFFICULTE "

			+"from ELEVE E, RECETTE R, NOTE N "
			
			+"where E.NUMERO_ELEVE = R.NUMERO_CREATEUR "
			+"and R.NUMERO_RECETTE = N.NUMERO_RECETTE "

			// positionnement des paramètres
			+"and R.NOM_RECETTE like ? "
			+"and CATEGORIE like ? "
			+"and BUDGET between ? and ? "
			+"and DIFFICULTE <= ? "
			+"and TEMPS_DE_CUISSON + TEMPS_DE_PREPARATION <= ? ";

		// prise  en compte du tri
		switch (tri) {
			case 0: query += "order by BUDGET asc "; break;
			case 1: query += "order by BUDGET desc "; break;
			case 2: query += "order by DIFFICULTE asc "; break;
			case 3: query += "order by DIFFICULTE desc "; break;
			case 4: query += "order by NOTE_GASTRONOMIQUE asc"; break;
			case 5: query += "order by NOTE_GASTRONOMIQUE desc "; break;
			default: query += "order by NOM_RECETTE "; break;
		}

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			// Affectation des paramètres
			if (nomRecette != null) stmt.setString(1,"%"+nomRecette.toUpperCase()+"%");
			else stmt.setString(1,"%");

			if (categorie != "T") stmt.setString(2, categorie);
			else stmt.setString(2, "%");

			if (prixMin > -1) stmt.setInt(3, prixMin);
			else stmt.setInt(3,0);

			if (prixMax > -1) stmt.setInt(4, prixMax);
			else stmt.setInt(4,1000);

			if (difficulteMax > -1) stmt.setInt(5, difficulteMax);
			else stmt.setInt(5,10);

			if (tempsMax > -1) stmt.setInt(6, tempsMax);
			else stmt.setInt(6,2000);

			ResultSet rset = stmt.executeQuery();
			print(rset);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * rechercheEleve
	 *
	 * @param      numEleve  entier correspondant au numero de l'eleve recherché
	 * 
	 * @return   tableau contenant
	 * 	Nom élève, Prénom élève, 
	 * 	Nombre de recette de l'élève, Moyenne des prix de ses recettes.
	 */
	public void rechercheEleve (int numEleve) {
		String query = 
			"select NOM_ELEVE, PRENOM_ELEVE, count(*) NOMBRE_DE_RECETTE, "
			+"avg(BUDGET) MOYENNE_BUDGET "
			+"from ELEVE E, RECETTE R "
			+"where E.NUMERO_ELEVE = R.NUMERO_CREATEUR "
			+"and E.NUMERO_ELEVE = ? ";

			query += "group by NOM_ELEVE, PRENOM_ELEVE ";

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			// Affectation des paramètres
			stmt.setInt(1, numEleve);

			System.out.println(query);
			ResultSet rset = stmt.executeQuery();
			print(rset);
		}
		catch (Exception e) {
			System.out.println(query);
			System.out.println(e.toString());
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
			for (int i = 1; i <= nbC; i++) {
	            	if (i > 1) System.out.print(", ");
	            	System.out.print(rset.getMetaData().getColumnName(i)+" ");
	        	}
	        System.out.println(" ");
			while (rset.next()){
	            for (int i = 1; i <= nbC; i++) {
	            	if (i > 1) System.out.print(", ");
	            	System.out.print(/*rset.getMetaData().getColumnName(i) +*/ " " + rset.getString(i));
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
