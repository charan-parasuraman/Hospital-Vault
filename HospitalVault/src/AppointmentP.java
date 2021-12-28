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

public class AppointmentP extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentP frame = new AppointmentP();
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
	public JLabel Displ;
	public AppointmentP() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Actions-appointment-new-icon.png"));
		setTitle("Appointment Date");
		Connection = Hospital_ID.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 169);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Next Appointment Date");
		lblNewLabel.setBounds(42, 11, 130, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor_ID");
		lblNewLabel_1.setBounds(320, 11, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Patient_ID");
		lblNewLabel_2.setBounds(599, 11, 113, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dashboard1P Dashboard1P = new Dashboard1P();
				Dashboard1P.setVisible(true);
				Dashboard1P.lblNewLabelID.setText(Displ.getText());
				dispose();
			}
		});
		btnNewButton.setBounds(754, 7, 89, 23);
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
					pat.setString(3,Displ.getText());
					pat.execute();					
//					ResultSet rs =pat.executeQuery();
					JOptionPane.showMessageDialog(null, "Data Saved");
					Dashboard1P Dashboard1P = new Dashboard1P();
					Dashboard1P.lblNewLabelID.setText(Displ.getText());
					Dashboard1P.setVisible(true);
					dispose();
					pat.close();																				
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(754, 70, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(42, 71, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"D101", "D102", "D103", "D104", "D105", "D106"}));
		comboBox.setBounds(320, 70, 130, 22);
		contentPane.add(comboBox);
		
		Displ = new JLabel("New label");
		Displ.setBounds(599, 74, 46, 14);
		contentPane.add(Displ);
	}
	public JLabel getDispl() {
		return Displ;
	}
}
