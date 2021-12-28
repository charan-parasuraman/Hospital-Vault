import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AppointmentD extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	public JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentD frame = new AppointmentD();
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
	private JLabel lblNewLabel_1;
	public JLabel Displey;
	public AppointmentD() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Actions-appointment-new-icon.png"));
		setTitle("Appointment Date");
		Connection = Hospital_ID.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 158);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Next Appointment Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(32, 11, 182, 23);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Doctor_ID");
		lblNewLabel_1.setBounds(276, 11, 72, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Patient_ID");
		lblNewLabel_2.setBounds(548, 11, 129, 23);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(32, 65, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(548, 65, 129, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HistoryD HistoryD = new HistoryD();
				HistoryD.setVisible(true);
				HistoryD.Disps.setText(Displey.getText());
				dispose();
			}
		});
		btnNewButton.setBounds(742, 7, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String selection=(String)comboBox.getSelectedItem();	
					String query = "Insert into Appointment (Appt_date,Doctor_ID,Patient_ID) values (?,?,?)";
					PreparedStatement pat=Connection.prepareStatement(query);
					pat.setString(1,textField.getText());
					pat.setString(2,selection);
					pat.setString(3,textField_2.getText());
					pat.execute();					
					JOptionPane.showMessageDialog(null, "Data Saved");
					HistoryD HistoryD = new HistoryD();
					HistoryD.setVisible(true);
					HistoryD.Disps.setText(Displey.getText());
					dispose();
					pat.close();																				
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(742, 64, 89, 23);
		contentPane.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"D101", "D102", "D103", "D104", "D105", "D106"}));
		comboBox.setBounds(276, 64, 129, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src\\Patient-Tux-icon.png"));
		lblNewLabel_3.setBounds(631, 11, 59, 43);
		contentPane.add(lblNewLabel_3);
		
		Displey = new JLabel("New label");
		Displey.setBounds(359, 11, 46, 23);
		contentPane.add(Displey);
	}
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}
	public JLabel getDispley() {
		return Displey;
	}
}
