import javax.swing.JOptionPane;

public class RecetteInfo{

	//donné
	private String numeroRecette;

	//Resultat:
	

	public	RecetteInfo(Object numeroRecette)
		{
		    this.numeroRecette = (String)numeroRecette;
			requete();
		}

	public void requete()
		{
			System.out.println("\nRequete vers Recette "+numeroRecette+" effectué");
		}

}
