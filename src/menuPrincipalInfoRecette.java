import javax.swing.JOptionPane;

public class menuPrincipalInfoRecette{
	String nomR = null, nomE = null, categorie = "T";
	int prixMin = -1, prixMax = -1, difficulter = -1,tempsMax = -1, trie = -1;
	Object[][] tableau = new Object[5000][13];
	int longueurTableau;

	
	boolean changer;

	public menuPrincipalInfoRecette(){
		int i = 0;
		int j = 0;
	    longueurTableau = requete();
		
	}

	public menuPrincipalInfoRecette(String nomR, String nomE, String categorie, String trie, String prixMin,String prixMax,String difficulter,String tempsMax){
		this.nomR = getNom(nomR);
		this.nomE = getNom(nomE);
		this.categorie = getCategorie(categorie);
		this.trie = getTrie(trie);
		this.prixMin = getPrixMin(prixMin);
		this.prixMax = getPrixMax(prixMax);
		this.difficulter = getDifficulter(difficulter);
		this.tempsMax = getTempsMax(tempsMax);

		if(controlErreur())
		{
			longueurTableau = requete();
			changer = true;
		}
		else
		{
			changer = false;
		}
		
	}
	
	public int requete()
		{
			int i = 0;
			int j = 0;

			for(i = 0; i < 50; i++)
			{
				for(j = 0; j < 13; j++)
				{
					tableau[i][j] = i;
				}
			}

			return 50;
			
		}

	
public boolean controlErreur()
{
	JOptionPane messageErreur = new JOptionPane();
			
	if(this.categorie == null || this.trie == -1){
		messageErreur.showMessageDialog(null, "Rentrez les champs Categorie et Trie SVP !","Erreur", JOptionPane.INFORMATION_MESSAGE);
		return false;
	}
	else
	{
		return true;
	}
}


	public String getNom(String s)
		{
			if(s.length() == 0)
				return null;
			else
				return s;
		}
	
public String getCategorie(String s)
{
	String s2;
			
	switch(s.length())
	{
	case 6://"Entrée":
		s2 = "E";
		break;

	case 4://"Plat":
	    if(s.equals("Plat"))
		s2 = "P";
	    else
		s2 = "T";//tout
		break;

	case 7://"Dessert":
		s2 = "D";
		break;

	default:
		s2 = null;
		break;
	}

	return s2;
}

public int getTrie(String s)
{
	int i = -1;
			
	switch(s.length())
	{
	case 14://"Prix Croissant":
		i = 0;
		break;
				
	case 16://"Prix Décroissant":
	    if(s.equals("Prix Décroissant"))
		i = 1;
	    else//durée croissante
		i = 2;
	    break;
				
	case 18://"Durée Décroissante":
		i = 3;
		break;
				
	case 23://"Le plus de commentaires":
		i = 4;
		break;
				
	case 24://"Le moins de commentaires":
		i = 5;
		break;

	default:
		i = -1;
		break;
	}

	return i;
}
	
    public int getDifficulter(String s)
    {
	int i = 0;
			
	if(s.equals("1/5"))
	    i = 1;
	else if(s.equals("2/5"))
	    i = 2;
	
	else if(s.equals("3/5"))
	    i = 3;
	 
	else if(s.equals("4/5"))
	    i = 4;
	
	else if(s.equals("5/5"))
	    i = 5;
	else
	    i = -1;
	return i;
    }
	
public int getPrixMin(String s)
{
	int i = 0;
	try {
		i = Integer.parseInt(s);
	} catch (NumberFormatException e){
		i = -1;
	}
			
	return i;
}

public int getPrixMax(String s)
{
	int i = 0;
	try {
		i = Integer.parseInt(s);
	} catch (NumberFormatException e){
		i = -1;
	}
			
	return i;
}

public int getTempsMax(String s)
{
	int i = 0;
	try {
		i = Integer.parseInt(s);
	} catch (NumberFormatException e){
		i = -1;
	}
			
	return i;
}


}
