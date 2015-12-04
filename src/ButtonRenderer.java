import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Component;

public class ButtonRenderer extends JButton implements TableCellRenderer{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
	//On écrit dans le bouton ce que contient la cellule
	setText((value != null) ? value.toString() : "");
	//On retourne notre bouton
	return this;
    }
} 
