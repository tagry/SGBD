import javax.swing.JTable;

public static class Table extends JTable{
 
	public Table(){
		super(new Modele());	// avec cette initialisation l'instance fait partie des listener de TableModelEvent
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getTableHeader().setResizingAllowed(false); 
	}
 
	/* 
	 * Declenché lors d'un changement de valeurs dans le modele 
	 */
	public void tableChanged(TableModelEvent e) {
		super.tableChanged(e);
		TableColumnModel modelecolonne=getColumnModel();
		TableModel modele=getModel();
		int total=modelecolonne.getColumnCount();
		for(int i=0;i<total;i++){
			int taille=0;
			int total2=modele.getRowCount();
			for(int j=0;j<total2;j++){
				// Partie determinant la taille de la cellule de ligne j et de colonne i
				int taille2=modele.getValueAt(j,i).toString().length()*7;	// determination arbitraire
				if(taille2>taille){
					taille=taille2;
				}
			}
			modelecolonne.getColumn(i).setPreferredWidth(taille);
		}
	}
 
}
