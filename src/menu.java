import javax.swing.JOptionPane;

public class  menu{
	public static void main(String[] args) {
		int continuer = 1;
		String[] choixPossible = {"Info utilisateur", "Rechercher Recette", "Moyenne des prix des recette d'un éleve","Nombre de recette dispo pour une categorie","Recette trié par meilleur rapport qualité prix","Deserts les plus rapide à réaliser","Trié par plats plus commentés", "écart type le plus faible", "ajout de recette","suppression de recette","suppression d'un aliment", "suppression d'un éleve"};
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		JOptionPane jop3 = new JOptionPane();            



		while(continuer==1)
		{
			String nom = (String)jop.showInputDialog(null,"Que voulez vous faire ?","Choix requete",JOptionPane.QUESTION_MESSAGE,null, choixPossible,choixPossible[0]);
			int choixRetenu = transformNomInt(choixPossible, nom);
			jop2.showMessageDialog(null, "Votre choix est " + choixRetenu, "Etat civil", JOptionPane.INFORMATION_MESSAGE);

			continuer = jop3.showConfirmDialog(null, "Voulez-vous arrêter l'animation ?", "Arrêt de l'animation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
		}
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
