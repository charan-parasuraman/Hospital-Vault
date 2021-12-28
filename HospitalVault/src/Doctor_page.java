import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Doctor_page  extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	int x =1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_page frame = new Doctor_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	Connection Connection = null;
	private JLabel Doctor_ID;
	private JTextField textFieldUN;
	private JLabel PasswordD;
	private JPasswordField passwordField;
	private JButton LoginD;
	private JLabel lblNewLabel;
	public Doctor_page() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Hospital-red-icon.png"));
		setTitle("Doctor Login Page");
		Connection = Hospital_ID.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 436);
		contentPane  = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		
		Doctor_ID = new JLabel("Doctor_ID");
		Doctor_ID.setFont(new Font("Tahoma", Font.BOLD, 13));
		
	//	textFieldUN = new JTextField();
		textFieldUN = new JTextField(x);
		textFieldUN.setColumns(10);
		
		
		PasswordD = new JLabel("Password");
		PasswordD.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		passwordField = new JPasswordField();
		
		LoginD = new JButton("Login");
		LoginD.setFont(new Font("Tahoma", Font.BOLD, 11));
		LoginD.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "SELECT * from Doctor Where Doctor_ID=? and password=?";
					PreparedStatement pat=Connection.prepareStatement(query);					
					pat.setString(1,textFieldUN.getText());
					pat.setString(2,passwordField.getText());					
					ResultSet rs= pat.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count+1;
						
						
					}
					if(count ==1) {
						JOptionPane.showMessageDialog(null, "Username and password is correct  ");
						dispose();
						DashboardD DashboardD = new DashboardD();
						UpdateD UpdateD = new UpdateD();
						HistoryD HistoryD= new HistoryD();
						AppointmentD AppointmentD = new AppointmentD();
						DashboardD.setVisible(true);
						DashboardD.setLocationRelativeTo(null);
						DashboardD.Disp.setText(textFieldUN.getText());
						HistoryD.Disps.setText(textFieldUN.getText());
						UpdateD.Disple.setText(textFieldUN.getText());
						AppointmentD.Displey.setText(textFieldUN.getText());
						
												
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
	
//				
			}
		});
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\Hospital-red-icon.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(112)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Doctor_ID, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(PasswordD, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
							.addGap(44)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(textFieldUN, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
					.addGap(78))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(376, Short.MAX_VALUE)
					.addComponent(LoginD, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(144))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(Doctor_ID)
								.addComponent(textFieldUN, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addGap(85)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(PasswordD)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(45)
							.addComponent(LoginD))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
