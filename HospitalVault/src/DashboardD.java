import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DashboardD extends JFrame {

	public JPanel contentPane;
	public JTable table;
	String x;
	String y;
	public JComboBox comboBoxSellect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardD frame = new DashboardD();
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
	Connection conn = null;
	public JButton AppoinmentsD;
	public JLabel lblNewLabel;
	public JLabel Disp;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	public DashboardD() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Documents-Caduceus-icon.png"));
		setTitle("Doctor Dashboard");
		Connection = Hospital_ID.dbConnector();
//		conn = Doctor_page.main(null);
//		conn = Doctor_page actionPerformed(ActionEvent);
//		Connection = Doctor_page.Doctor_page();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 437);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		HistoryD HistoryD = new HistoryD();
		HistoryD.Disps.setText(x);
		
		AppoinmentsD = new JButton("My Appointments");
		AppoinmentsD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					x=(Disp.getText());				
					String query = "SELECT * FROM Appointment where Doctor_ID='"+x+"'";
					PreparedStatement pat = Connection.prepareStatement(query);
					ResultSet rs=pat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					HistoryD HistoryD = new HistoryD();
					HistoryD.Disps.setText(x);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}

			private int interest(int parseInt) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		AppoinmentsD.setBounds(10, 92, 135, 23);
		contentPane.add(AppoinmentsD);
		
		JButton btnNewButton_History = new JButton("History");
		btnNewButton_History.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HistoryD HistoryD = new HistoryD();
				HistoryD.Disps.setText(x);
				HistoryD.setVisible(true);
			}
		});
		btnNewButton_History.setBounds(10, 196, 135, 23);
		contentPane.add(btnNewButton_History);
		
		JButton btnNewButton_out = new JButton("Logout");
		btnNewButton_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HistoryD HistoryD= new HistoryD();
				HistoryD.Disps.setText(x);
				Doctor_page Doctor_page = new Doctor_page();
				Doctor_page.setVisible(true);
			}
		});
		btnNewButton_out.setBounds(10, 304, 135, 23);
		contentPane.add(btnNewButton_out);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(155, 61, 521, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(10, 11, 64, 44);
		contentPane.add(lblNewLabel);
		
		y= "New label";
		Disp = new JLabel(y);
		Disp.setBounds(83, 26, 79, 14);
		contentPane.add(Disp);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
//					x=Integer.parseInt(Disp.getText());
					x=(Disp.getText());
					String selection=(String)comboBoxSellect.getSelectedItem();				
					String query = "SELECT * FROM Appointment where "+selection+"=?" +"AND Doctor_ID='"+x+"'";
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
		textField.setBounds(519, 19, 157, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBoxSellect = new JComboBox();
		comboBoxSellect.setModel(new DefaultComboBoxModel(new String[] {"Patient_ID", "Appointment_ID"}));
		comboBoxSellect.setBounds(306, 22, 138, 28);
		contentPane.add(comboBoxSellect);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\search-icon.png"));
		lblNewLabel_1.setBounds(454, 11, 55, 39);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src\\Actions-appointment-new-icon.png"));
		lblNewLabel_2.setBounds(91, 126, 54, 44);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src\\File-History-icon.png"));
		lblNewLabel_3.setBounds(90, 230, 55, 44);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("src\\Apps-Dialog-Logout-icon.png"));
		lblNewLabel_4.setBounds(90, 338, 55, 39);
		contentPane.add(lblNewLabel_4);
		
	}
	public JButton getAppoinmentsD() {
		return AppoinmentsD;
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public JLabel getDisp() {
		return Disp;
	}
}
