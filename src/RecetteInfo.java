import javax.swing.JOptionPane;

public class RecetteInfo{

    //donné
    String numeroRecette;
    String nomRecette;
    int moyenneNoteGastro;
    int moyenneNoteBudget;
    int moyenneNoteDifficulte;
    int tempsPreparation;
    int tempsCuisson;
        	

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
