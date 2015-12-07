import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class Requete {
	OracleDataSource ods;
	Connection conn;
	

	/**
	 * Requete Constructeur
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
	 * 	Donne les différentes recettes correspondant au critères de recherche.
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
	 * 	Donne des details sur un élève en le retrouvant par son numéro d'élève.
	 *
	 * @param    numEleve  entier correspondant au numero de l'eleve recherché
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
		dessertRapide();
		rapportQP();
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

	/**
	 * dessertRapide
	 * 	Classe les desserts du plus rapide au plus long a réaliser.
	 */
	public void dessertRapide () {
		try {
			PreparedStatement stmt = conn.prepareStatement(
				"select * from RECETTE order by TEMPS_DE_PREPARATION + TEMPS_DE_CUISSON");
			ResultSet rset = stmt.executeQuery();
			print(rset);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * rapportQP
	 * 	Classe les recette par leur rapport qualité/prix.
	 * 	Le rapport est calculé ainsi:
	 * 		r = moyenne note(gastronomique + budget + difficulté) / prix
	 */
	public void rapportQP () {
		String query =
			"select NOM_RECETTE, CATEGORIE, BUDGET, "
			+"avg(NOTE_GASTRONOMIQUE + NOTE_DIFFICULTE + NOTE_BUDGET) NOTE "
			+"from RECETTE R, NOTE N "
			+"where N.NUMERO_RECETTE = R.NUMERO_RECETTE";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
				
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
