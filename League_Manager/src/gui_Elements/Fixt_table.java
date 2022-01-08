package gui_Elements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Fixt_table extends JPanel {
	private static final long serialVersionUID = 3406952088321236405L;
	private final JTextArea col1 = new JTextArea();
	private final JTextArea col4 = new JTextArea();
	private final JTextArea col2 = new JTextArea();
	private final JTextArea col3 = new JTextArea();
	private final JLabel lblNewLabel = new JLabel("ID");
	private final JLabel lblNewLabel_1 = new JLabel("Home Team");
	private final JLabel lblNewLabel_2 = new JLabel("Away Team");
	private final JLabel lblNewLabel_3 = new JLabel("Date - Time");
	private final JLabel lblNewLabel_4 = new JLabel("Schedule");
	private final JButton refresh = new JButton("Refresh");

	public Fixt_table() {
		
		initGUI();
	}
	private void initGUI() {
		setBorder(new LineBorder(Color.BLACK, 5));
		setBackground(Color.PINK);
		setLayout(null);
		col1.setEditable(false);
		col1.setBounds(6, 59, 44, 235);
		add(col1);
		col4.setEditable(false);
		col4.setBounds(294, 59, 150, 235);
		add(col4);
		col2.setEditable(false);
		col2.setBounds(62, 59, 104, 235);
		add(col2);
		col3.setEditable(false);
		col3.setBounds(178, 59, 104, 235);
		add(col3);
		
		String JdbcURL = "jdbc:mysql://127.0.0.1:3306/?user=root";
		String Username = "root";
		String password = "pranav02";
		
		Connection con = null;
	      try {
	         con=DriverManager.getConnection(JdbcURL, Username, password);
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM Football_Fixtures.Fixtures ORDER BY Kick_Off ASC;");
	         
	         while(rs.next()) {
	        	 col1.append(rs.getInt("Match_ID") + ")\n");
	        	 col2.append(rs.getString("Home_Team")+"\n");
	        	 col3.append(rs.getString("Away_Team")+"\n");
	        	 col4.append(rs.getString("Kick_Off")+"\n");
	         }
	      } catch(SQLException e) {System.out.println("Connection fails");e.printStackTrace();}
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 36, 24, 16);
		
		
		add(lblNewLabel);
		lblNewLabel_1.setBounds(62, 36, 104, 16);
		
		add(lblNewLabel_1);
		lblNewLabel_2.setBounds(178, 36, 104, 16);
		
		add(lblNewLabel_2);
		lblNewLabel_3.setBounds(294, 36, 117, 16);
		
		add(lblNewLabel_3);
		lblNewLabel_4.setBounds(173, 8, 129, 16);
		
		add(lblNewLabel_4);
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col1.setText("");
				col2.setText("");
				col3.setText("");
				col4.setText("");
				 try {
			         Connection con=DriverManager.getConnection(JdbcURL, Username, password);
			         Statement stmt = con.createStatement();
			         ResultSet rs = stmt.executeQuery("SELECT * FROM Football_Fixtures.Fixtures ORDER BY Kick_Off ASC;");
			         
			         while(rs.next()) {
			        	 col1.append(rs.getInt("Match_ID") + ")\n");
			        	 col2.append(rs.getString("Home_Team")+"\n");
			        	 col3.append(rs.getString("Away_Team")+"\n");
			        	 col4.append(rs.getString("Kick_Off")+"\n");
			         }
			      } catch(SQLException e1) {System.out.println("Connection fails");e1.printStackTrace();}
			}
		});
		refresh.setBounds(327, 3, 117, 29);
		
		add(refresh);
	}

}
