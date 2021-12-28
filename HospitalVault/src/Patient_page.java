import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Patient_page extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	//int x;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_page frame = new Patient_page();
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
	
	public Patient_page() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Apps-preferences-system-login-icon.png"));
		setTitle("Patient LoginPage");
		Connection = Hospital_ID.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 391);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Patient_ID = new JLabel("Patient_ID");
		Patient_ID.setFont(new Font("Tahoma", Font.BOLD, 12));
		Patient_ID.setBounds(249, 40, 147, 32);
		contentPane.add(Patient_ID);
		
		JLabel PasswordP = new JLabel("Password");
		PasswordP.setFont(new Font("Tahoma", Font.BOLD, 12));
		PasswordP.setBounds(249, 104, 147, 32);
		contentPane.add(PasswordP);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(406, 40, 279, 35);
		contentPane.add(textFieldUN);
		textFieldUN.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(406, 104, 279, 35);
		contentPane.add(passwordField);
		
		JButton LoginP = new JButton("Login");
		LoginP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "SELECT * from Patient Where Patient_ID=? and Password=?";
					PreparedStatement pat=Connection.prepareStatement(query);
					pat.setString(1,textFieldUN.getText());
					pat.setString(2,passwordField.getText());
					
					ResultSet rs= pat.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count+1;	
					}
					if(count ==1) {
					//	JOptionPane.showMessageDialog(null, "Username and password is correct");
						dispose();
						SymptomsP SymptomsP = new SymptomsP();
						AppointmentP AppointmentP = new AppointmentP();
						
						Dashboard1P Dashboard1P = new Dashboard1P();
						Dashboard1P.setVisible(true);
						Dashboard1P.lblNewLabelID.setText(textFieldUN.getText());
						SymptomsP.Dispss.setText(textFieldUN.getText());
						AppointmentP.Displ.setText(textFieldUN.getText());
						
						
						
					}
					else if(count>1) {
						JOptionPane.showMessageDialog(null, "Duplicate and password");
					}
					else {
						JOptionPane.showMessageDialog(null, "Username and password is not correct");
					}
					rs.close();
					pat.close();					
				}catch(Exception e1) {
					
		           JOptionPane.showMessageDialog(null, e1);
		            
		        }
	
			}
		});
		LoginP.setBounds(406, 226, 89, 23);
		contentPane.add(LoginP);
		
		JButton RegisterP = new JButton("Register");
		RegisterP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegisterP RegisterP = new RegisterP();
				RegisterP.setVisible(true);
			}
		});
		RegisterP.setBounds(572, 226, 89, 23);
		contentPane.add(RegisterP);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\Apps-preferences-system-login-icon (1).png"));
		lblNewLabel.setBounds(82, 66, 141, 117);
		contentPane.add(lblNewLabel);
	}
}
