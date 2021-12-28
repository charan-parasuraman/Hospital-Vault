import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class HistoryD extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JTable table;
	public JComboBox comboBoxSellect;
	String x;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryD frame = new HistoryD();
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
	public JLabel Disps;
	public HistoryD() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\stethoscope-icon.png"));
		setTitle("Data History");
		Connection = Hospital_ID.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 470);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton _history = new JButton("All History");
		_history.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try{
					x=(Disps.getText());
					String query = "SELECT * FROM Patient_History";
					PreparedStatement pat = Connection.prepareStatement(query);
					ResultSet rs=pat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		_history.setBounds(28, 105, 131, 23);
		contentPane.add(_history);
		
		JButton btnNewButton_update = new JButton("Update");
		btnNewButton_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdateD UpdateD = new UpdateD();
				UpdateD.setVisible(true);
				UpdateD.Disple.setText(Disps.getText());
				
				}
		});
		btnNewButton_update.setBounds(28, 229, 131, 23);
		contentPane.add(btnNewButton_update);
		
		JButton btnNewButton_2 = new JButton("My Appointment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				DashboardD DashboardD =new DashboardD();
				DashboardD.Disp.setText(Disps.getText());
				DashboardD.setVisible(true);
				dispose();
				}
		});
		btnNewButton_2.setBounds(28, 341, 131, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New Appointment");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AppointmentD AppointmentD = new AppointmentD();
				AppointmentD.setVisible(true);
				AppointmentD.Displey.setText(Disps.getText());
			}
		});
		btnNewButton_3.setBounds(28, 284, 131, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Doctor_page Doctor_page = new Doctor_page();
				Doctor_page.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(28, 397, 131, 23);
		contentPane.add(btnNewButton_4);
		
		Disps = new JLabel("New label");
		Disps.setBounds(108, 33, 89, 14);
		contentPane.add(Disps);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
								
				try{
//					x=Integer.parseInt(Disp.getText());
					x=(Disps.getText());
					String selection=(String)comboBoxSellect.getSelectedItem();				
					String query = "SELECT * FROM Patient_History where "+selection+"=?";
					PreparedStatement pat = Connection.prepareStatement(query);
					pat.setString(1,textField.getText());
					ResultSet rs=pat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pat.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		textField.setBounds(460, 30, 167, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBoxSellect = new JComboBox();
		comboBoxSellect.setModel(new DefaultComboBoxModel(new String[] {"Patient_ID", "Doctor_ID"}));
		comboBoxSellect.setBounds(247, 29, 134, 22);
		contentPane.add(comboBoxSellect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 105, 582, 315);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(28, 33, 70, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Patient Symptomps");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
//					x=Integer.parseInt(Disp.getText());
					x=(Disps.getText());
					String selection=(String)comboBoxSellect.getSelectedItem();				
					String query = "SELECT * FROM Patient_entry where "+selection+"=?";
					PreparedStatement pat = Connection.prepareStatement(query);
					pat.setString(1,textField.getText());
					ResultSet rs=pat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pat.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(28, 168, 131, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\global-icon.png"));
		lblNewLabel_1.setBounds(660, 11, 91, 72);
		contentPane.add(lblNewLabel_1);
		
	
	}
	public JLabel getDisps() {
		return Disps;
	}
}
