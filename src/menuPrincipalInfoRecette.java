import javax.swing.JOptionPane;

public class menuPrincipalInfoRecette{
	private String nom, categorie;
	private int prixMin, prixMax, difficulter,tempsMax, trie;
	Object[][] tableau = new Object[5000][13];

	public menuPrincipalInfoRecette(){
		int i = 0;
		int j = 0;
		for(i = 0;i < 50; i++)
		{
			for(j = 0;j <13; j++)
			{
				this.tableau[i][j] = "1";
			}
		}
		
	}

	public menuPrincipalInfoRecette(String nom, String categorie, String trie, String prixMin,String prixMax,String difficulter,String tempsMax){
		this.nom = nom;
		this.categorie = getCategorie(categorie);
		this.trie = getTrie(trie);
		this.prixMin = getPrixMin(prixMin);
		this.prixMax = getPrixMax(prixMax);
		this.difficulter = getDifficulter(difficulter);
		this.tempsMax = getTempsMax(tempsMax);

		if(controlErreur())
		{
			requete();
		}
		
	}
	
	public void requete()
		{
			//Les données du tableau
			int i = 0;
			int j = 0;
			for(i = 0;i < 50; i++)
			{
				for(j = 0;j <13; j++)
				{
					this.tableau[i][j] = "0";
				}
			}
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
	
public String getCategorie(String s)
{
	String s2;
			
	switch(s)
	{
	case "Entrée":
		s2 = "E";
		break;

	case "Plat":
		s2 = "P";
		break;

	case "Dessert":
		s2 = "D";
		break;

	case "Tout":
		s2 = "T";
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
			
	switch(s)
	{
	case "Prix Croissant":
		i = 0;
		break;
				
	case "Prix Décroissant":
		i = 1;
		break;
				
	case "Durée Croissante":
		i = 2;
		break;
				
	case "Durée Décroissante":
		i = 3;
		break;
				
	case "Le plus de commentaires":
		i = 4;
		break;
				
	case "Le moins de commentaires":
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
			
	switch(s)
	{
	case "1/5":
		i = 1;
		break;
				
	case "2/5":
		i = 2;
		break;
				
	case "3/5":
		i = 3;
		break;
				
	case "4/5":
		i = 4;
		break;
				
	case "5/5":
		i = 5;
		break;
				
	default:
		i = -1;
		break;		   
	}

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
