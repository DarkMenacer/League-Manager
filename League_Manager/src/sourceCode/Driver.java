package sourceCode;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import gui_Elements.Welcome_Tab;

public class Driver {

	public static void main(String[] args) {
		
		String JdbcURL = "jdbc:mysql://127.0.0.1:3306/?user=root";
		String Username = "root";
		String password = "pranav02";
		String use_db = "USE Football_Fixtures;"; 
		Connection con = null;
	      try {
	    	  //Connecting to DB
	         System.out.println("Connecting to database..............."+JdbcURL);
	         con=DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	         
	         //Using DB Football_Fixtures
	         Statement stmt = con.createStatement();
	         stmt.execute(use_db);
	         System.out.println("Database Football_Fixtures is selected");
	         
	         
	      } catch(SQLException e) {System.out.println("Connection fails");e.printStackTrace();}
		
	      
	     //Initialise GUI 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome_Tab frame = new Welcome_Tab();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

}
