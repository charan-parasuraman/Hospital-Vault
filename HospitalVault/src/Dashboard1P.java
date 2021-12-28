import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Dashboard1P extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int x;
	public JLabel lblNewLabelID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard1P frame = new Dashboard1P();
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
	
	public Dashboard1P() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\user-group-icon.png"));
		setTitle("Patient DashBoard");
		Connection = Hospital_ID.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 499);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("History");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					x=Integer.parseInt(lblNewLabelID.getText());
					String query = "SELECT * FROM Patient_History where Patient_ID="+x;
					PreparedStatement pat = Connection.prepareStatement(query);
					ResultSet rs=pat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(272, 96, 142, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("My Appointments");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try{
//					x=Integer.parseInt(Disp.getText());
					x=Integer.parseInt(lblNewLabelID.getText());									
					String query = "SELECT Appointment_ID,Appt_date,Doctor_ID,Patient_ID FROM Appointment where Patient_ID="+x;
					PreparedStatement pat = Connection.prepareStatement(query);
					ResultSet rs=pat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pat.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton_1.setBounds(32, 213, 142, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New Appointment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				AppointmentP AppointmentP = new AppointmentP();
				AppointmentP.Displ.setText(lblNewLabelID.getText());
				AppointmentP.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(32, 318, 142, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 130, 606, 319);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Welcome ");
		lblNewLabel.setBounds(10, 38, 63, 23);
		contentPane.add(lblNewLabel);
		
		lblNewLabelID = new JLabel("New label");
		lblNewLabelID.setBounds(99, 42, 46, 14);
		contentPane.add(lblNewLabelID);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Patient_page Patient_page= new Patient_page();
				Patient_page.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(32, 413, 142, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Enter Symptoms");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SymptomsP SymptomsP = new SymptomsP();
				SymptomsP.Dispss.setText(lblNewLabelID.getText());
				SymptomsP.setVisible(true);
				dispose();
								
			}
		});
		btnNewButton_4.setBounds(32, 127, 142, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("My Symptoms");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					x=Integer.parseInt(lblNewLabelID.getText());
					String query = "SELECT Patient_ID,Patient_obs_symptom,Doc_spec FROM Patient_entry where Patient_ID="+x;
					PreparedStatement pat = Connection.prepareStatement(query);
					ResultSet rs=pat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(554, 96, 142, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\File-History-icon.png"));
		lblNewLabel_1.setBounds(318, 42, 57, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src\\Patient-Tux-icon.png"));
		lblNewLabel_2.setBounds(574, 21, 74, 64);
		contentPane.add(lblNewLabel_2);
	}
}
