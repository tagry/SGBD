import javax.swing.JOptionPane;

public class ResultatNote{
	
	int longueurTableau;	
	int noteG, noteB, noteD;


	public ResultatNote(int noteG, int noteB, int noteD) {
	    this.noteD = noteD;
		this.noteB= noteB;
		this.noteG = noteG;

		requete();

		
	}
	
	public void requete()
		{
		    System.out.println("\nRequete note ok\n");
		}

}
	
	
	
