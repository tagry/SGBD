import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ResultatMesRecettes{
	//mettre dans l'ordre :
	//Nom Recette | Numero Recette | note Gastronomique | note budget | note difficulté
	Object[][] tableau = new Object[300][6];
	int nombre_ligne;//nombre de ligne que comporte la requete

	Object[] aliment = new Object[50];//requete modifier

	public ResultatMesRecettes(){
		int i = 0;
		int j = 0;

		requete();//modifie le tableau

		for(i = 0;i < nombre_ligne; i++)
		{
			this.tableau[i][4] = "Modifier";
			this.tableau[i][5] = "Supprimer";			
		}
		
	}

	public ResultatMesRecettes(String numeroRecette, String action){
		if(action == "S")
			supprimer(numeroRecette);// à faire requete
		else
		{
			modifier(numeroRecette);//mettre a jour aliment
		}
	}

	public void requete()
		{
			nombre_ligne = 50;
			int i = 0;
			int j = 0;
			for(i = 0;i < nombre_ligne; i++)
			{
				for(j = 0;j <4; j++)
				{
					this.tableau[i][j] = "11212654654";
				}
			}
		}

	public void supprimer(String numeroRecette)//à faire requete
		{

		}

	public void modifier(String numeroRecette)
		{

		}
}
