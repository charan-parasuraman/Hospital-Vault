import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.mindfusion.scheduling.ItemListView;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class RegisterP extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_Age;
	private JTextField textField_Address;
	private JTextField textField_Phone_no;
	private JTextField textField_Password;
	public JComboBox comboBox;
	int y=1;
	/**
	 * @wbp.nonvisual location=-30,309
	 */
	private final JSlider slider = new JSlider();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterP frame = new RegisterP();
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
	public RegisterP() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Apps-preferences-system-login-icon.png"));
		setTitle("Registration Page");
		Connection = Hospital_ID.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 567);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(32, 11, 298, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(32, 162, 134, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBounds(32, 221, 134, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setBounds(32, 273, 134, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setBounds(32, 329, 134, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone_No.");
		lblNewLabel_6.setBounds(32, 382, 134, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(195, 142, 459, 35);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Age = new JTextField();
		textField_Age.setBounds(195, 252, 459, 35);
		contentPane.add(textField_Age);
		textField_Age.setColumns(10);
		
		textField_Address = new JTextField();
		textField_Address.setBounds(195, 308, 459, 35);
		contentPane.add(textField_Address);
		textField_Address.setColumns(10);
		
		textField_Phone_no = new JTextField();
		textField_Phone_no.setBounds(195, 361, 459, 35);
		contentPane.add(textField_Phone_no);
		textField_Phone_no.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setBounds(31, 444, 135, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_Password = new JTextField();
		textField_Password.setBounds(195, 426, 459, 35);
		contentPane.add(textField_Password);
		textField_Password.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selection=(String)comboBox.getSelectedItem();	
					String query = "Insert into Patient (Patient_name,P_gender,P_Age,P_Address,P_phoneno,Password) values (?,?,?,?,?,?)";
					
					PreparedStatement pat=Connection.prepareStatement(query);
														
//					ResultSet sellect1 = statement.executeQuery("SELECT * FROM Accounts "+" WHERE Name='Doug'");					
//					pat.setString(1,textField_ID.getText());
					pat.setString(1,textField_Name.getText());
					pat.setString(2,selection);
					pat.setString(3,textField_Age.getText());
					pat.setString(4,textField_Address.getText());
					pat.setString(5,textField_Phone_no.getText());
					pat.setString(6,textField_Password.getText());
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registration Successful ");
					Patient_page Patient_page = new Patient_page();
					Patient_page.setVisible(true);
//					Patient_page.Disps.setText(Disple.getText());
					pat.close();
					dispose();
//					String query1 = "SELECT MAX(Patient_ID) FROM Patient";
//					PreparedStatement pat1=Connection.prepareStatement(query1);
//					ResultSet rs1= pat1.executeQuery();
//					System.out.println(query1);	
//					System.out.println("\nAnswer for 1st Question");
//		            while (rs1.next()){
//		                System.out.println(rs1.getInt("Patient_ID"));
//		                }
//		            while (rs1.next()){
//		                System.out.println(rs1.getInt(1));
//		                }						
//					pat1.close();
//					rs1.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
				
				try {
					
					
					String query1 = "SELECT MAX(Patient_ID) AS Patient_ID FROM Patient";
					PreparedStatement pat1=Connection.prepareStatement(query1);
					ResultSet rs1= pat1.executeQuery();
//					System.out.println(query1);	
//					System.out.println("\nAnswer for 1st Question");
		            while (rs1.next()){
		            	int x = rs1.getInt("Patient_ID");
//		              System.out.println(rs1.getInt("Patient_ID"));
		              JOptionPane.showMessageDialog(null, "Your Patient_ID is: "+x);
		                }
//		            while (rs1.next()){
//		                System.out.println(rs1.getInt(1));
//		                }	
//		            JOptionPane.showMessageDialog(null, "Your Patient_ID is: "+x);
					pat1.close();
					rs1.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnSubmit.setBounds(195, 494, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(565, 494, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Patient_page Patient_page = new Patient_page();
				Patient_page.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(391, 494, 89, 23);
		contentPane.add(btnNewButton_2);
		
		comboBox = new JComboBox();
		comboBox.setToolTipText("Male\r\nFemale");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"","Male", "Female"}));
		comboBox.setBounds(195, 204, 459, 35);
		contentPane.add(comboBox);
		
		ItemListView itemListView = new ItemListView();
		itemListView.setBounds(379, 48, 59, -26);
		contentPane.add(itemListView);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("src\\user-group-icon.png"));
		lblNewLabel_8.setBounds(540, 11, 83, 74);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\database-arrow-up-icon.png"));
		lblNewLabel_1.setBounds(42, 77, 83, 74);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_9 = new JLabel("         Enter Your Information");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9.setBounds(227, 75, 298, 35);
		contentPane.add(lblNewLabel_9);
	}
}
