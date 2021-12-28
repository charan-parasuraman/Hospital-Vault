import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Hospital_ID {
	Connection Conn=null;
	public static Connection dbConnector(){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn= DriverManager.getConnection("jdbc:sqlite:src\\Java_Project"); 
	//		JOptionPane.showMessageDialog(null, "Connection Succesful");
			return conn;
		}catch(SQLException | ClassNotFoundException e) {
			
           JOptionPane.showMessageDialog(null, e);
            return null;
        }
	}

}
