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

public class menuPrincipal extends JDialog{


	private menuPrincipalInfoRecette InfoRecette = new menuPrincipalInfoRecette();
	private boolean sendData;
	private JLabel nomLabel, nomCLabel, dureeCLabal, prixCLabel, note1CLabel, note2CLabel, note3CLabel;
	private ArrayList<JRadioButton> nomArray;
	private JComboBox categorie, trie;
	private JTextField nom;
	private JButton rechercherRecette, detail;
	private JSplitPane splitRecetteResult;
	
	public menuPrincipal(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
   		this.setSize(1100, 650);
   		this.setLocationRelativeTo(null);
   		this.setResizable(true); 	
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
		this.setVisible(true);
	}

	private void initComponent(){
		JPanel panRecette = new JPanel();
		
		JPanel panResultR = new JPanel();
//		panRecette.setLayout(null);
//		panRecette.setBounds(0,0,200,600);
		panRecette.setSize(new Dimension(200, 600));
		splitRecetteResult = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panRecette, panResultR);
		splitRecetteResult.setDividerLocation(200);
		panRecette.setBackground(Color.blue);
		panResultR.setBackground(Color.green);

		
		
		//nom:
		JPanel panNom = new JPanel();
		nom = new JTextField();
		panNom.setPreferredSize(new Dimension(200,30));
		nom.setPreferredSize(new Dimension(150, 25));
		nomLabel = new JLabel("Nom :");
		panNom.setBackground(Color.white);
		panNom.add(nomLabel);
		panNom.add(nom);

		//categorie:
		JPanel panCategorie = new JPanel();
		panCategorie.setBackground(Color.white);
		panCategorie.setPreferredSize(new Dimension(200, 100));
		categorie = new JComboBox();
		categorie.addItem("Categorie");
		categorie.addItem("Entrée");
		categorie.addItem("Plat");
		categorie.addItem("Dessert");
		categorie.addItem("Tout");
		panCategorie.add(categorie);

		//trie:
		JPanel panTrie = new JPanel();
		panTrie.setBackground(Color.white);
		panTrie.setPreferredSize(new Dimension(200, 100));
		trie = new JComboBox();
		trie.addItem("Trie");
		trie.addItem("Prix Croissant");
		trie.addItem("Prix Décroissant");
		trie.addItem("Durée Croissant");
		trie.addItem("Durée Décroissant");
		panTrie.add(trie);

		JPanel control = new JPanel();
		rechercherRecette = new JButton("Rechercher");
		detail = new JButton("Détail");

		rechercherRecette.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {        
					InfoRecette = new menuPrincipalInfoRecette(nom.getText(), (String)categorie.getSelectedItem(),(String)trie.getSelectedItem());
				}
  
			});

		detail.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					setVisible(false);
				}
			});

		control.add(rechercherRecette);
		control.add(detail);


		panRecette.add(panNom);
		panRecette.add(panCategorie);
		panRecette.add(panTrie);
		panRecette.add(control);
		this.getContentPane().add(splitRecetteResult, BorderLayout.CENTER);

	   
	}

	public menuPrincipalInfoRecette showmenuPrincipal(){
		
		return this.InfoRecette;
	}
}

