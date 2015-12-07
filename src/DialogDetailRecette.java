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
import java.awt.FlowLayout;

public class DialogDetailRecette extends JFrame {
	private JPanel panOk;
	public DialogDetailRecette(RecetteInfo infoRecette)
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
		panOk.setBackground(Color.white);
		panOk.setPreferredSize(new Dimension(5000, 50));
		panOk.add(ok);

				//panneau de données
		JPanel panDonnees = new JPanel();
		panDonnees.setLayout(new FlowLayout());
		RecetteInfo Info = new RecetteInfo("1");
		JLabel label= new JLabel("Données");
		panDonnees.add(label);

		JButton note = new JButton("Noter le recette");
		panOk.add(note);

		note.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					DialogNote Dnote = new DialogNote();
				}
				
			});
		
		ok.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					dispose();	
				}
  
			});

		
		
		this.getContentPane().add(panOk, BorderLayout.SOUTH);
		this.getContentPane().add(panDonnees,BorderLayout.CENTER);
	}
}
