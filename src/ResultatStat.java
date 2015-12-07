import javax.swing.JOptionPane;
import java.awt.FlowLayout;

public class ResultatStat{

	//donné
    private int nbRecetteTotal;
    private int nbRecetteCatégorie;
    private int nbEleve;
    private int nbAliment;


	//Resultat: [...]

	public	ResultatStat()
		{
		    this.numeroEleve = (String)numeroEleve;
			requete();
		}

	public void requete()
		{
			System.out.println("\nRequete vers Eleve " +numeroEleve +" effectué");
		}

}
