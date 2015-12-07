import javax.swing.JOptionPane;
import java.awt.FlowLayout;

public class ResultatStat{

	//donné
	private String numeroEleve;

	//Resultat: [...]

	public	ResultatStat(Object numeroEleve)
		{
		    this.numeroEleve = (String)numeroEleve;
			requete();
		}

	public void requete()
		{
			System.out.println("\nRequete vers Eleve " +numeroEleve +" effectué");
		}

}
