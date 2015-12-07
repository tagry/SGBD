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
import javax.swing.table.AbstractTableModel;
import javax.swing.JCheckBox;
import java.awt.Window;
import javax.swing.JTable;

public class DialogMesRecettes extends JFrame {
	JPanel panOk;
	String title[] = {"Nom","Note Gastronomique", "Note Budget", "Note Difficulté", "M", "S"};
	ResultatMesRecettes InfoMesRecettes = new ResultatMesRecettes();
	ModelTable model = new ModelTable(InfoMesRecettes.tableau, title);
	JTable tableau = new JTable(model);
	public DialogMesRecettes()
		{
			this.setTitle("Ma JFrame");
			this.setSize(5000, 5000);
			this.setResizable(true); 	
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
			initComponent();
			this.setVisible(true);
		}

	private void initComponent(){
		JPanel panOk = new JPanel();
		JButton ok = new JButton("Revenir à la recherche");

		tableau.getColumn("M").setCellRenderer(new ButtonRenderer());
		tableau.getColumn("M").setCellEditor(new ButtonEditor(new JCheckBox()));

		tableau.getColumn("S").setCellRenderer(new ButtonRenderer());
		tableau.getColumn("S").setCellEditor(new ButtonEditor(new JCheckBox()));

		panOk.setBackground(Color.white);
		panOk.setPreferredSize(new Dimension(5000, 200));
		panOk.add(ok);
		ok.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
  
			});
		this.tableau.setRowHeight(InfoMesRecettes.nombre_ligne);
		new JScrollPane(tableau, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.getContentPane().add(ok, BorderLayout.SOUTH);
		this.getContentPane().add(new JScrollPane(tableau));
	}
}
