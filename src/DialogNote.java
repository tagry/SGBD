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

	private JLabel noteGLabel,noteBLabel,noteDLabel ;
	
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
		JPanel parametre = new JPanel();

		JPanel panNoteG = new JPanel();
		JComboBox CnoteG = new JComboBox();
		CnoteG.addItem(0);
		CnoteG.addItem(1);
		CnoteG.addItem(2);
		CnoteG.addItem(3);
		CnoteG.addItem(4);
		CnoteG.addItem(5);
		noteGLabel = new JLabel("Note Gastronomique");
		panNoteG.add(noteGLabel);
		panNoteG.add(CnoteG);

		JPanel panNoteB = new JPanel();
		JComboBox CnoteB = new JComboBox();
		CnoteB.addItem(0);
		CnoteB.addItem(1);
		CnoteB.addItem(2);
		CnoteB.addItem(3);
		CnoteB.addItem(4);
		CnoteB.addItem(5);
		noteGLabel = new JLabel("Note Respect du Budjet");
		panNoteB.add(noteBLabel);
		panNoteB.add(CnoteB);

		JPanel panNoteD = new JPanel();
		JComboBox CnoteD = new JComboBox();
		CnoteD.addItem(0);
		CnoteD.addItem(1);
		CnoteD.addItem(2);
		CnoteD.addItem(3);
		CnoteD.addItem(4);
		CnoteD.addItem(5);
		noteGLabel = new JLabel("Note Respect de la Difficulté");
		panNoteD.add(CnoteD);

		parametre.add(panNoteG);
		parametre.add(panNoteB);
		parametre.add(panNoteD);

		
		JPanel control = new JPanel();
		JButton ok = new JButton("Ok");
		JButton annuler = new JButton("Annuler");
		control.setBackground(Color.white);
		control.setPreferredSize(new Dimension(5000, 50));
		control.add(ok);
		control.add(annuler);

		ok.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					ResultatNote Info = new ResultatNote(1,2,3);
					dispose();
				}
				
			});
		
		annuler.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					dispose();	
				}
  
			});

		this.getContentPane().add(control, BorderLayout.SOUTH);
		this.getContentPane().add(parametre,BorderLayout.CENTER);
	}
}
