public class menuPrincipalInfoRecette{
	private String nom, categorie, trie;

	public menuPrincipalInfoRecette(){}

	public menuPrincipalInfoRecette(String nom, String categorie, String trie){
		this.nom = nom;
		this.categorie = categorie;
		this.trie = trie;
	}

	public String toString(){
		String str;
		if(this.nom == null || this.categorie == "Categorie" || this.trie == "Trie"){
			str = "Rentrez TOUT les champs SVP !";
		}

		else{
			str = "ok";
		}
		
		return str;
	}
}
