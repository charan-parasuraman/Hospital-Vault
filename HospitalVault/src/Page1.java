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
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class Page1  {

	private JFrame frmWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 window = new Page1();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection Connection = null;
	public Page1() {
		initialize();
		Connection = Hospital_ID.dbConnector();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setForeground(SystemColor.inactiveCaptionText);
		frmWelcome.setFont(new Font("Dialog", Font.BOLD, 12));
		frmWelcome.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\global-icon.png"));
		frmWelcome.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frmWelcome.getContentPane().setForeground(SystemColor.activeCaption);
		frmWelcome.getContentPane().setBackground(SystemColor.activeCaption);
		frmWelcome.setTitle("HealthVault");
		frmWelcome.setBounds(100, 100, 699, 447);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton Patient = new JButton("Patient");
		Patient.setBackground(SystemColor.inactiveCaptionBorder);
		Patient.setFont(new Font("Tahoma", Font.BOLD, 11));
		Patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWelcome.dispose();
				Patient_page Patient_page = new Patient_page();
				Patient_page.setVisible(true);
			}
		});
		
		JButton Doctor = new JButton("Doctor");
		Doctor.setBackground(SystemColor.inactiveCaptionBorder);
		Doctor.setFont(new Font("Tahoma", Font.BOLD, 11));
		Doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWelcome.dispose();
				Doctor_page Doctor_page = new Doctor_page();
				Doctor_page.setVisible(true);
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\People-Doctor-Male-icon.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\user-group-icon.png"));
		GroupLayout groupLayout = new GroupLayout(frmWelcome.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(242)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(Patient, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Doctor, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(Doctor)
							.addGap(154)
							.addComponent(Patient))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(109)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		frmWelcome.getContentPane().setLayout(groupLayout);
	}
}
