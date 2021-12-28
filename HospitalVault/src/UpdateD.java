import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class UpdateD extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	public JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateD frame = new UpdateD();
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
	public JLabel Disple;
	public UpdateD() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Documents-Caduceus-icon.png"));
		setTitle("Update Symptom");
		Connection = Hospital_ID.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 200);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient_ID");
		lblNewLabel.setBounds(25, 11, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Symptoms");
		lblNewLabel_1.setBounds(178, 11, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prescription");
		lblNewLabel_2.setBounds(337, 11, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Doctor_ID");
		lblNewLabel_3.setBounds(508, 11, 64, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date");
		lblNewLabel_4.setBounds(715, 11, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(12, 76, 112, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 76, 112, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(337, 76, 112, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(715, 76, 112, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String selection=(String)comboBox.getSelectedItem();	
					String query = "Insert into Patient_History (Patient_ID,Symptoms_doc,Prescription,Doctor_ID,Appt_date) values (?,?,?,?,?)";
					PreparedStatement pat=Connection.prepareStatement(query);
					pat.setString(1,textField.getText());
					pat.setString(2,textField_1.getText());
					pat.setString(3,textField_2.getText());
					pat.setString(4,selection);
					pat.setString(5,textField_4.getText());
					pat.execute();					
//					ResultSet rs =pat.executeQuery();
					JOptionPane.showMessageDialog(null, "Data Saved");
					HistoryD HistoryD = new HistoryD();
					HistoryD.setVisible(true);
					HistoryD.Disps.setText(Disple.getText());
					dispose();
//					rs.close();
					pat.close();																				
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(269, 127, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HistoryD HistoryD = new HistoryD();
				HistoryD.setVisible(true);
				HistoryD.Disps.setText(Disple.getText());
			}
		});
		btnNewButton_1.setBounds(452, 127, 89, 23);
		contentPane.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"D101", "D102", "D103", "D104", "D105", "D106"}));
		comboBox.setBounds(508, 75, 112, 22);
		contentPane.add(comboBox);
		
		Disple = new JLabel("New label");
		Disple.setBounds(574, 11, 46, 14);
		contentPane.add(Disple);
	}
	public JLabel getDisple() {
		return Disple;
	}
}
