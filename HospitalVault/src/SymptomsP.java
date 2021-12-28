import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class SymptomsP extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	public JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SymptomsP frame = new SymptomsP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection Connection = null;
	public JLabel Dispss;
	public SymptomsP() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Patient-Tux-icon.png"));
		setTitle("Symptoms");
		Connection = Hospital_ID.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 160);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient_ID");
		lblNewLabel.setBounds(10, 11, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Symptoms");
		lblNewLabel_1.setBounds(230, 11, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Field");
		lblNewLabel_2.setBounds(459, 11, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Dashboard1P Dashboard1P = new Dashboard1P();
				Dashboard1P.lblNewLabelID.setText(Dispss.getText());
				Dashboard1P.setVisible(true);
			}
		});
		btnNewButton.setBounds(717, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Neurosurgeon", "Gynecologists", "Pediatricians", "Physiatrists", "Plastic Surgeons", "Immunologists"}));
		comboBox.setBounds(459, 70, 123, 22);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 71, 123, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String selection=(String)comboBox.getSelectedItem();	
					String query = "Insert into Patient_entry (Patient_ID,Patient_obs_symptom,Doc_spec) values (?,?,?)";
					PreparedStatement pat=Connection.prepareStatement(query);
					pat.setString(1,Dispss.getText());
					pat.setString(2,textField_1.getText());
					pat.setString(3,selection);
					pat.execute();					
					JOptionPane.showMessageDialog(null, "Data Saved");
					Dashboard1P Dashboard1P = new Dashboard1P();
					Dashboard1P.setVisible(true);
					Dashboard1P.lblNewLabelID.setText(Dispss.getText());
					dispose();
//					rs.close();
					pat.close();																				
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(717, 70, 89, 23);
		contentPane.add(btnNewButton_1);
		
		Dispss = new JLabel("New label");
		Dispss.setBounds(10, 74, 46, 14);
		contentPane.add(Dispss);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src\\People-Doctor-Male-icon.png"));
		lblNewLabel_3.setBounds(531, 0, 63, 64);
		contentPane.add(lblNewLabel_3);
	}
	public JLabel getDispss() {
		return Dispss;
	}
}
