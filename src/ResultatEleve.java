import javax.swing.JOptionPane;

public class ResultatEleve{

    //donné
    String numeroEleve;
    String nomEleve;
    String prenomEleve;
    int nbRecette;
    int budgetMoyen;
    int moyenneNoteGastro;
    int moyenneNoteBudg;
    int moyenneNoteDiffi;

	public	ResultatEleve(Object numeroEleve)
		{
		    this.numeroEleve = (String)numeroEleve;
			requete();
		}

	public void requete()
		{
			System.out.println("\nRequete vers Eleve " +numeroEleve +" effectué");
		}

}
