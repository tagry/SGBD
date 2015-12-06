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

public class FenetrePrincipal extends JFrame {
    
    private menuPrincipalInfoRecette InfoRecette = new menuPrincipalInfoRecette();
	String title[] = {"Nom Recette", "Numero Recette", "Nom Créateur", "Prenom Créateur", "Numero Créateur","Budget", "Difficulé", "Temps de Préparation", "Temps de Cuisson","Note Gastronomique", "Note Budget", "Note Difficulté" };
	ModelTable model = new ModelTable(InfoRecette.tableau, title);
	JTable tableau = new JTable(model);
    private boolean sendData;
    private JLabel nomLabel, prixMinLabel, prixMaxLabel, tempsMaxLabel;
    private ArrayList<JRadioButton> nomArray;
    private JComboBox categorie, trie, difficulter;
    private JTextField nom,prixMin,prixMax, tempsMax;
    private JButton rechercherRecette;

    
public FenetrePrincipal(){      
	this.setTitle("Ma JFrame");
	this.setSize(5000, 5000);
	this.setResizable(true); 	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);      
	this.initComponent();
}    
    

private void initComponent(){
	JPanel panRecette = new JPanel();

	//parametrage tableau
	tableau.getTableHeader().setReorderingAllowed(false) ;
	this.tableau.getColumn("Nom Recette").setCellRenderer(new ButtonRenderer());
	this.tableau.getColumn("Nom Recette").setCellEditor(new ButtonEditor(new JCheckBox()));
	
	panRecette.setPreferredSize(new Dimension(250, 600));
	panRecette.setBackground(Color.white);

		
		
	//nom:
	JPanel panNom = new JPanel();
	nom = new JTextField();
	panNom.setPreferredSize(new Dimension(250,30));
	nom.setPreferredSize(new Dimension(150, 25));
	nomLabel = new JLabel("Nom :");
	panNom.setBackground(Color.white);
	panNom.add(nomLabel);
	panNom.add(nom);

	//categorie:
	JPanel panCategorie = new JPanel();
	panCategorie.setBackground(Color.white);
	panCategorie.setPreferredSize(new Dimension(250, 100));
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
	panTrie.setPreferredSize(new Dimension(250, 100));
	trie = new JComboBox();
	trie.addItem("Trier");
	trie.addItem("Prix Croissant");
	trie.addItem("Prix Décroissant");
	trie.addItem("Durée Croissante");
	trie.addItem("Durée Décroissante");
	trie.addItem("Le plus de commentaires");
	trie.addItem("Le moins de commentaires");
	panTrie.add(trie);

	//Prix min
	JPanel panPrixMin = new JPanel();
	prixMin = new JTextField();
	panPrixMin.setPreferredSize(new Dimension(250,50));
	prixMin.setPreferredSize(new Dimension(150, 25));
	prixMinLabel = new JLabel("PrixMin :");
	panPrixMin.setBackground(Color.white);
	panPrixMin.add(prixMinLabel);
	panPrixMin.add(prixMin);
		
	//Prix max
	JPanel panPrixMax = new JPanel();
	prixMax = new JTextField();
	panPrixMax.setPreferredSize(new Dimension(250,50));
	prixMax.setPreferredSize(new Dimension(150, 25));
	prixMaxLabel = new JLabel("PrixMax :");
	panPrixMax.setBackground(Color.white);
	panPrixMax.add(prixMaxLabel);
	panPrixMax.add(prixMax);

	//difficulter
	JPanel panDifficulter = new JPanel();
	difficulter = new JComboBox();
	panDifficulter.setPreferredSize(new Dimension(250,100));
	panDifficulter.setBackground(Color.white);
	difficulter.addItem("Difficulté");
	difficulter.addItem("1/5");
	difficulter.addItem("2/5");
	difficulter.addItem("3/5");
	difficulter.addItem("4/5");
	difficulter.addItem("5/5");
	panDifficulter.add(difficulter);

	//Tempsmax
	JPanel panTempsMax = new JPanel();
	tempsMax = new JTextField();
	panTempsMax.setPreferredSize(new Dimension(250,50));
	tempsMax.setPreferredSize(new Dimension(150, 25));
	tempsMaxLabel = new JLabel("TempsMax :");
	panTempsMax.setBackground(Color.white);
	panTempsMax.add(tempsMaxLabel);
	panTempsMax.add(tempsMax);
		
	//control (detail à enlever)
	JPanel control = new JPanel();
	rechercherRecette = new JButton("Rechercher");

	rechercherRecette.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {        
				InfoRecette = new menuPrincipalInfoRecette(nom.getText(), (String)categorie.getSelectedItem(),(String)trie.getSelectedItem(), prixMin.getText(), prixMax.getText(), (String)difficulter.getSelectedItem(), tempsMax.getText());
				model = new ModelTable(InfoRecette.tableau, title);

				tableau.setModel(model);
				tableau.getTableHeader().setReorderingAllowed(false) ;
				tableau.getColumn("Nom Recette").setCellRenderer(new ButtonRenderer());
				tableau.getColumn("Nom Recette").setCellEditor(new ButtonEditor(new JCheckBox()));
				
			}
  
		});

	control.add(rechercherRecette);


	panRecette.add(panNom);
	panRecette.add(panCategorie);
	panRecette.add(panTrie);
	panRecette.add(panDifficulter);
	panRecette.add(panPrixMin);
	panRecette.add(panPrixMax);
	panRecette.add(panTempsMax);
	panRecette.add(control);

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
	fen.setVisible(true);
}   
}
