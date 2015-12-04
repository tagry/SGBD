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


public class FenetrePrincipal extends JFrame {
    
    private menuPrincipalInfoRecette InfoRecette = new menuPrincipalInfoRecette();
    private boolean sendData;
    private JLabel nomLabel, nomCLabel, dureeCLabal, prixCLabel, note1CLabel, note2CLabel, note3CLabel;
    private ArrayList<JRadioButton> nomArray;
    private JComboBox categorie, trie;
    private JTextField nom;
    private JButton rechercherRecette, detail;
    private JSplitPane splitRecetteResult;
    
    
    public FenetrePrincipal(){      
	this.setTitle("Ma JFrame");
	this.setSize(1100, 650);
	this.setResizable(true); 	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);      
	this.initComponent();
	this.setVisible(true);

    }    
    

    private void initComponent(){
	JPanel panRecette = new JPanel();
		
	//	JPanel panResultR = new JPanel();
	//		panRecette.setLayout(null);
	//		panRecette.setBounds(0,0,200,600);
	panRecette.setPreferredSize(new Dimension(200, 600));
	//panResultR.setSize(new Dimension(900,600));
	//splitRecetteResult = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panRecette, panResultR);
	panRecette.setBackground(Color.white);
	//panResultR.setBackground(Color.white);

		
		
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
	trie.addItem("Trier");
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
		    System.exit(0);
		}
	    });

	control.add(rechercherRecette);
	control.add(detail);


	panRecette.add(panNom);
	panRecette.add(panCategorie);
	panRecette.add(panTrie);
	panRecette.add(control);

	//Les données du tableau
	Object[][] data = {
	    {"Cysboy", "28 ans", "1.80 m"},
	    {"BZHHydde", "28 ans", "1.80 m"},
	    {"IamBow", "24 ans", "1.90 m"},
	    {"FunMan", "32 ans", "1.85 m"}
	};
	//Les titres des colonnes
	String title[] = {"Pseudo", "Age", "Taille"};
	JTable tableau = new JTable(data, title);
	//Nous ajoutons notre tableau à notre contentPane dans un scroll
	//Sinon les titres des colonnes ne s'afficheront pas !


	this.getContentPane().add(panRecette, BorderLayout.WEST);
	this.getContentPane().add(new JScrollPane(tableau));
	   
    }

    public menuPrincipalInfoRecette showmenuPrincipal(){
		
	return this.InfoRecette;
    }


    public static void main(String[] main){
	FenetrePrincipal fen = new FenetrePrincipal();
    }   
}
