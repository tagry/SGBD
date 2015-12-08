/**
 * Dans ce fichier sont présentes les méthodes qui interagissent avec
 * la base de donnée.
 * 
 * @author W.Soulaimana, N.Gourrin, T.Agry
 * @version 1.0  
 */

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

/**
 * 
 */

public class Requete {

	OracleDataSource ods = new OracleDataSource();
	Connection conn = null;
	
	/**
	 * Requete Constructeur
	 * Ici nous simulons la connexion d'un utilisateur.
	 * ******************************************************
	 * Pour 'connecter un autre utilisateur que W.Soulaimana'
	 * vous pouvez changer les lignes 38 et 39 afin de rentrer
	 * vos login et mot de passe de connexion a SQL*Plus sur
	 * la machine Oracle de l'école.
	 * !! Il est recommandé de faire pareil dans Exemple.java
	 * ******************************************************
	 *
	 * @param    ods	Oracle Database Source
	 */
	public Requete () throws SQLException, ClassNotFoundException, java.io.IOException{
		//-------------------------------------
		// Login et Mot de passe. A modifier.
		// ------------------------------------
        ods.setUser("wsoulaimana");
        ods.setPassword("wsoulaimana");
        
        // URL de connexion.
        ods.setURL("jdbc:oracle:thin:@localhost:1521/oracle");
        conn = ods.getConnection();
	}

	/**
	 * rechercheRecette
	 * 	Donne les différentes recettes correspondant au critères de recherche.
	 *
	 * @param      nomRecette     nom de la recette
	 * @param      categorie      categorie de la recette
	 * @param      tri            ordre d'affichage des resultats
	 * 		0 Prix croissant, 1 Prix decroissant, 2 Durée croissante, 
	 * 		3 Durée decroissante, 4 Note gastronomique croissante, 
	 * 		5 Note gastronomique decroissante, 6 rappoert QP,
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
			+"TEMPS_DE_PREPARATION + TEMPS_DE_CUISSON as TEMPS "
			//+"NOTE_GASTRONOMIQUE, NOTE_BUDGET, NOTE_DIFFICULTE "

			//+"NUMERO_NOTE, R.NUMERO_RECETTE, N.NUMERO_RECETTE "//COM

			+"from ELEVE E, RECETTE R "//, NOTE N "
			
			+"where E.NUMERO_ELEVE = R.NUMERO_CREATEUR "
//			+"and R.NUMERO_RECETTE = N.NUMERO_RECETTE ";

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
			case 2: query += "order by TEMPS asc "; break;
			case 3: query += "order by TEMPS desc "; break;
			case 4: query += "order by NOTE_GASTRONOMIQUE asc"; break;
			case 5: query += "order by NOTE_GASTRONOMIQUE desc "; break;
			default: query += "order by NOM_RECETTE "; break;
		}

		try {
			//System.out.println(query);
			PreparedStatement stmt = conn.prepareStatement(query);

			// Affectation des paramètres
			if (nomRecette != null) stmt.setString(1,"%"+nomRecette.toUpperCase()+"%");
			else stmt.setString(1,"%");

			if (categorie.toUpperCase().equals("T")) stmt.setString(2, "%");
			else stmt.setString(2, categorie.toUpperCase());

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
	 * 	Donne des details sur un élève en le retrouvant par son numéro d'élève.
	 *
	 * @param    numEleve  entier correspondant au numero de l'eleve recherché
	 * 
	 * @return   tableau contenant
	 * 	Nom élève, Prénom élève, 
	 * 	Nombre de recette de l'élève, Moyenne des prix de ses recettes.
	 */
	public void rechercheEleve (int numEleve) {
		int i = nbRecetteEleve(numEleve);
		String query;
		if (i > 0){
			query = 
				"select NUMERO_ELEVE, NOM_ELEVE, PRENOM_ELEVE, count(NOM_ELEVE) NOMBRE_DE_RECETTE, "
				+"avg(BUDGET) MOYENNE_BUDGET "
				+"from ELEVE E, RECETTE R "
				+"where E.NUMERO_ELEVE = R.NUMERO_CREATEUR "
				+"and E.NUMERO_ELEVE = ? "
				+"group by NUMERO_ELEVE, NOM_ELEVE, PRENOM_ELEVE ";
		}
		else{	
			query =
				"select NUMERO_ELEVE, NOM_ELEVE, PRENOM_ELEVE "
				+"from ELEVE "
				+"where NUMERO_ELEVE = ? ";
		}

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			// Affectation des paramètres
			stmt.setInt(1, numEleve);

			ResultSet rset = stmt.executeQuery();
			print(rset);
			if (i<=0)
				System.out.println("Cet élève n'a pas encore publié de recette\n");
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public int nbRecetteEleve (int numEleve) {
		String query = 
			"select count(*) "
			+"from ELEVE E, RECETTE R "
			+"where E.NUMERO_ELEVE = R.NUMERO_CREATEUR "
			+"and E.NUMERO_ELEVE = ? ";

			//uery += "group by NUMERO_ELEVE ";

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			// Affectation des paramètres
			stmt.setInt(1, numEleve);

			ResultSet rset = stmt.executeQuery();
			//print(rset);
			rset.next();
			return rset.getInt(1);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}

	public void afficheRecette() {
		rechercheRecette(null,"T", -1, -1, -1, -1, -1);
	}

	public void afficheEleve () {
		String query = 
			"select * "
			+"from ELEVE E ";

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			ResultSet rset = stmt.executeQuery();
			print(rset);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void afficheAliment () {
		String query = 
			"select * "
			+"from ALIMENT ";

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			ResultSet rset = stmt.executeQuery();
			print(rset);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}


	/**
	 * statistique
	 * 	lance les différentes requêtes d'ordre statistiques: 
	 * 	nbRecette()
	 * 	dessertRapide()
	 */
	public void statistique () {
		nbRecette();
		//rapportQP();
	}

	/**
	 * nbRecette	
	 * 	Donne le nombre de recette total dans la BDD pour chaque catégorie.
	 */
	public void nbRecette () {
		try {
			PreparedStatement stmt = conn.prepareStatement(
				"select CATEGORIE, count(CATEGORIE) from RECETTE group by CATEGORIE ");
			ResultSet rset = stmt.executeQuery();
			print(rset);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}


	public void ajoutRecette (int numCreateur, String nomRecette,
		String categorie, int difficulte, int budget,
		int preparation, int cuisson, int nbPersonne) {

		int nbRct = getNbRct();

		String query = 
			"insert into RECETTE values "
			+"(?, ?, ?, ?, ?, ?, ?, ?, ?) "; 

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setInt(1, nbRct+1);
			stmt.setInt(2, numCreateur);
			stmt.setString(3, nomRecette.toUpperCase());
			stmt.setString(4, categorie.toUpperCase());
			stmt.setInt(5, budget);
			stmt.setInt(6, difficulte);
			stmt.setInt(7, preparation);
			stmt.setInt(8, cuisson);
			stmt.setInt(9, nbPersonne);

			ResultSet rset = stmt.executeQuery();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}


	}

	public void ajoutAliment (String nomAlim, String unite) {
		int nbAlim = getNbAlim();

		String query = 
			"insert into ALIMENT values "
			+"(?, ?, ?) "; 

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setInt(1, nbAlim+1);
			stmt.setString(2, nomAlim.toUpperCase());
			stmt.setString(3, unite.toUpperCase());

			ResultSet rset = stmt.executeQuery();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void ajoutEleve (String nomEleve, String prenomEleve) {
		int nbEleve = getNbEleve();

		String query = 
			"insert into ELEVE values "
			+"(?, ?, ?) "; 

		try {
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setInt(1, nbEleve+1);
			stmt.setString(2, nomEleve.toUpperCase());
			stmt.setString(3, prenomEleve.toUpperCase());

			ResultSet rset = stmt.executeQuery();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}


	public int getNbRct () {
		try {
			PreparedStatement stmtNb = conn.prepareStatement(
				"select count(*) from RECETTE");
			ResultSet rset = stmtNb.executeQuery();
			rset.next();
			return rset.getInt(1);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}

	public int getNbAlim () {
		try {
			PreparedStatement stmtNb = conn.prepareStatement(
				"select count(*) from ALIMENT");
			ResultSet rset = stmtNb.executeQuery();
			rset.next();

			return rset.getInt(1);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}

	public int getNbEleve () {
		try {
			PreparedStatement stmtNb = conn.prepareStatement(
				"select count(*) from ELEVE");
			ResultSet rset = stmtNb.executeQuery();
			rset.next();
			return rset.getInt(1);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return 0;
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
	            	System.out.print(" " + rset.getString(i));
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
