import javax.swing.JOptionPane;

public class ResultatEleve{

	//donné
	private String numeroEleve;

	//Resultat: [...]

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
