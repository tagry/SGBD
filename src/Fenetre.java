import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.AbstractTableModel;

public class Fenetre extends JFrame {
    private JTable tableau;
    private JButton change = new JButton("Changer la taille");
    public Fenetre(){
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JTable");
		this.setSize(600, 140);						    
	
		Object[][] data = {
			{"Cysboy", "6boy", new Double(1.80), new Boolean(true)},
			{"BZHHydde", "BZH", new Double(1.78), new Boolean(false)},
			{"IamBow", "BoW", new Double(1.90), new Boolean(false)},
			{"FunMan", "Year", new Double(1.85), new Boolean(true)}
		};


		String title[] = {"Pseudo", "Age", "Taille","toto"};
		ModelTable model = new ModelTable(data, title);
		this.tableau = new JTable(model);      
	
		this.tableau.setRowHeight(30);
	
		this.tableau.getColumn("Age").setCellRenderer(new ButtonRenderer());
	
		this.tableau.getColumn("Age").setCellEditor(new ButtonEditor(new JCheckBox()));
	
		//On définit l'éditeur par défaut pour la cellule en lui spécifiant quel type d'affichage prendre en compte
	
		this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	
    }
    
    public static void main(String[] args){
		Fenetre fen = new Fenetre();
		fen.setVisible(true); 
    }
}
