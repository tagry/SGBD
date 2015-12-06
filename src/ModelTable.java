
import javax.swing.table.AbstractTableModel;

//Classe modèle personnalisée
class ModelTable extends AbstractTableModel{
    private Object[][] data;
    private String[] title;

    //Constructeur
    public ModelTable(Object[][] data, String[] title){
		this.data = data;
		this.title = title;
    }

	//Retourne le titre de la colonne à l'indice spécifié
    public String getColumnName(int col) {
		return this.title[col];
    }

	//Retourne le nombre de colonnes
    public int getColumnCount() {
		return this.title.length;
    }

	//Retourne le nombre de lignes
    public int getRowCount() {
		return this.data.length;
    }

	//Retourne la valeur à l'emplacement spécifié
	public Object getValueAt(int row, int col) {
		return this.data[row][col];
    }

	//Définit la valeur à l'emplacement spécifié
    public void setValueAt(Object value, int row, int col) {
		//On interdit la modification sur certaines colonnes !
		if(!this.getColumnName(col).equals("Age") && !this.getColumnName(col).equals("Suppression") && !this.getColumnName(col).equals("Nom RecetteInfo"))
			this.data[row][col] = value;
    }

	//Retourne la classe de la donnée de la colonne
    public Class getColumnClass(int col){
		//On retourne le type de la cellule à la colonne demandée
		//On se moque de la ligne puisque les types de données sont les mêmes quelle que soit la ligne
		//On choisit donc la première ligne
		return this.data[0][col].getClass();
    }

	public boolean isCellEditable(int row, int col){
		if(col == 0 || col == 1)
			return true;
		else
			return false;
    }
}
