import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FenetrePrincipal extends JFrame {
	private JButton bouton = new JButton("Appel à la ZDialog");

	public FenetrePrincipal(){      
		this.setTitle("Ma JFrame");
		this.setSize(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);      
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(bouton);
		bouton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					menuPrincipal zd = new menuPrincipal(null, "Coucou les ZérOs", true);
						menuPrincipalInfoRecette InfoRecette = zd.showmenuPrincipal(); 
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null, InfoRecette.toString(), "Informations personnage", JOptionPane.INFORMATION_MESSAGE);
				}         
			});      
		this.setVisible(true);      
	}
   
	public static void main(String[] main){
		FenetrePrincipal fen = new FenetrePrincipal();
	}   
}
