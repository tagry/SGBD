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

public class DialogNote extends JFrame {

	public DialogNote()
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
		JPanel control = new JPanel();
		JButton ok = new JButton("Ok");
		JButton annuler = new JButton("Annuler");
		control.setBackground(Color.white);
		control.setPreferredSize(new Dimension(5000, 50));
		control.add(ok);
		control.add(annuler);

		ok.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
				
			});
		
		annuler.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					dispose();	
				}
  
			});

		//panneau de données
		JPanel panDonnees = new JPanel();
		panDonnees.setLayout(new FlowLayout());
		ResultatStat Info = new ResultatStat("1");
		JLabel label= new JLabel("Données Eleve");
		panDonnees.add(label);
		
		this.getContentPane().add(control, BorderLayout.SOUTH);
		this.getContentPane().add(panDonnees,BorderLayout.CENTER);
	}
}
