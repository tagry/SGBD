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

public class DialogAdd extends JFrame {
	JPanel panOk;
	int nombreRecette = 0;
	String title[] = {"Ingredient", "Quantité", "Supprimer"};
	Object[][] table = new Object[500][3];
	ModelTable model = new ModelTable(table, title);

	String titleEtape[] = {"Numero étape", "Description", "Sup"};
	Object[][] tableEtape = new Object[500][3];
	ModelTable modelEtape = new ModelTable(tableEtape, titleEtape);
	

	JTable tableauEtape = new JTable(modelEtape);
	JTable tableau = new JTable(model);
	public DialogAdd()
		{
			this.setTitle("Ma JFrame");
			this.setSize(5000, 5000);
			this.setResizable(true); 	
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
			int i = 0;
			int j = 0;
				
			for(i = 0; i < 1; i++)
			{
				for(j = 0; j < 3; j++)
				{
					if(j == 2)
						table[i][j] = "Supprimer";
					else
						table[i][j] =" ";
				}
			}

			for(i = 0; i < 1; i++)
			{
				for(j = 0; j < 3; j++)
				{
					if(j == 2)
						tableEtape[i][j] = "Supprimer";
					else
						tableEtape[i][j] =" ";
				}
			}
						
			initComponent();
			this.setVisible(true);
		}

	private void initComponent(){
		JPanel panOk = new JPanel();
		JButton ok = new JButton("Revenir à la recherche");
		panOk.setBackground(Color.white);
		panOk.setPreferredSize(new Dimension(5000, 50));
		JButton addI = new JButton("Ajouter Ingrédient");

		JPanel panDescription = new JPanel();
		JTextField desc = new JTextField();
		panDescription.setPreferredSize(new Dimension(300,30));
		desc.setPreferredSize(new Dimension(150, 25));
		JLabel descriptionLabel = new JLabel("Description");
		panDescription.setBackground(Color.white);
		panDescription.add(descriptionLabel);
		panDescription.add(desc);
		
		JButton EtapeAdd = new JButton("Ajouter une Etape");

		tableau.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
		tableau.getColumn("Supprimer").setCellEditor(new ButtonEditor(new JCheckBox()));

		tableauEtape.getColumn("Sup").setCellRenderer(new ButtonRenderer());
		tableauEtape.getColumn("Sup").setCellEditor(new ButtonEditor(new JCheckBox()));
		
		panOk.add(ok);
	  
		panOk.add(addI);

		panOk.add(EtapeAdd);
		


		ok.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
  
			});


	
		System.out.println("\nok\n");
		//tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.getContentPane().add(panOk, BorderLayout.SOUTH);
		this.getContentPane().add(new JScrollPane(tableau), BorderLayout.WEST);
		this.getContentPane().add(new JScrollPane(tableauEtape), BorderLayout.CENTER);
			this.getContentPane().add(panDescription, BorderLayout.EAST);
	}
}
