import javax.swing.JOptionPane;

public class  menu{
	public static void main(String[] args)
		{
			choixPrincipal();			
		}
	
	private static void choixPrincipal()
		{
			int continuer = 1;
			int choixRetenu = -1;
			
			String[] choixPossible = {"Info utilisateur", "Rechercher Recette", "Moyenne des prix des recette d'un éleve","Nombre de recette dispo pour une categorie","Recette trié par meilleur rapport qualité prix","Deserts les plus rapide à réaliser","Trié par plats plus commentés", "écart type le plus faible", "ajout de recette","suppression de recette","suppression d'un aliment", "suppression d'un éleve"};
			
			while(continuer==1)
			{		    
				choixRetenu = choixOuvertRetourInt(choixPossible, "Que voulez vous faire ?", "Choix requete");
				transisionChoixSecondaire(choixRetenu);
				continuer = choixFerme("Voulez vous fermer l'application ?","Fermer l'application");
				
			}
		}

	private static void transisionChoixSecondaire(int choixRetenu)
		{
			switch(choixRetenu)
			{
			case 0 :
				infoUtilisateur();
				break;
				/*
			case 1:
				rechercherRecette();
				break;

			case 2:
				moyennePrixEleve();
				break;

			case 3:
				nombreRecetteParCategorie();
				break;

			case 4:
				classerRecetteQP();//QR qualité prix
				break;

			case 5:
				classerDessertRapide();
				break;

			case 6:
				classerPlatsPlusC();//C Commentés
				break;

			case 7:
				eleveEcartTypeMin();
				break;

			case 8:
				ajoutRecette();
				break;

			case 9:
				ajoutEleve();
				break;

			case 10:
				ajoutAliment();
				break;

			case 11:
				supprimerRecette();
				break;
				
			case 12:
				supprimerEleve();
				break;

			case 13:
				supprimerAliment();
				break;*/
			}
		}

	static void infoUtilisateur()
		{
			//	requete r;
			String[] choix = {"Nom", "Numero","Les deux"};
			int choixRetenu = choixMultipleBouton(choix, "Comment identifier l'utilisateur ?","Utilisateur");

			switch(choixRetenu)
			{
			case 0:
				//	appelerRequete("Utilisateur", "Mot de passe", "Requete1");
				break;

			case 1:
				//appelerRequete("Utilisateur", "Mot de passe", "Requete2");
				break;

			case 2:
				//appelerRequete("Utilisateur", "Mot de passe", "Requete3");
				break;
			}

		}

	private static int choixMultipleBouton(String[] choix, String question, String nomFenetre)
		{
			JOptionPane jop = new JOptionPane();
			return jop.showOptionDialog(null,question,nomFenetre,JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,choix, choix[0]);
		}
	
	private static int choixOuvertRetourInt(String[] choix,String question, String nomFenetre)
		{
			JOptionPane jop = new JOptionPane();
			String nom = (String)jop.showInputDialog(null,question,nomFenetre,JOptionPane.QUESTION_MESSAGE,null, choix,choix[0]);
			return transformNomInt(choix, nom);			
		}

		private static String choixOuvertRetourString(String[] choix,String question, String nomFenetre)
		{
			JOptionPane jop = new JOptionPane();
			return (String)jop.showInputDialog(null,question,nomFenetre,JOptionPane.QUESTION_MESSAGE,null, choix,choix[0]);		
		}

	private static int choixFerme(String question, String nomFenetre)
		{
			JOptionPane jop = new JOptionPane();
			return jop.showConfirmDialog(null, question, nomFenetre, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);			
		}
	
	private static int transformNomInt(String[] tableau, String nom)
		{
			int i = 0;
			for(i = 0; i < tableau.length; i++)
			{
				if(nom == tableau[i])
					return i;
			}
			return -1;
		}
}
