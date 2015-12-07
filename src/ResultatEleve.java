import javax.swing.JOptionPane;

public class ResultatEleve{

    //donné
    private String numeroEleve;
    private String nomEleve;
    private String prenomEleve;
    private int nbRecette;
    private int budgetMoyen;
    private int moyenneNoteGastro;
    private int moyenneNoteBudg;
    private int moyenneNoteDiffi;

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
