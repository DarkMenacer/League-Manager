package gui_Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Points_Table extends JPanel {
	private static final long serialVersionUID = 3406952088321236405L;
	private final JTextArea col1 = new JTextArea();
	private final JTextArea col4 = new JTextArea();
	private final JTextArea col2 = new JTextArea();
	private final JTextArea col3 = new JTextArea();
	private final JLabel lblNewLabel = new JLabel("ID");
	private final JLabel lblNewLabel_1 = new JLabel("Team Name");
	private final JLabel lblNewLabel_2 = new JLabel("Matches Played");
	private final JLabel lblNewLabel_3 = new JLabel("Points");
	private final JLabel lblNewLabel_4 = new JLabel("Points Table");
	private final JButton refresh = new JButton("Refresh");

	public Points_Table() {
		
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
		col4.setBounds(350, 59, 94, 235);
		add(col4);
		col2.setEditable(false);
		col2.setBounds(62, 59, 160, 235);
		add(col2);
		col3.setEditable(false);
		col3.setBounds(234, 59, 104, 235);
		add(col3);
		
		String JdbcURL = "jdbc:mysql://127.0.0.1:3306/?user=root";
		String Username = "root";
		String password = "pranav02";
		
		Connection con = null;
	      try {
	         con=DriverManager.getConnection(JdbcURL, Username, password);
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM Football_Fixtures.Points_Table ORDER BY Points DESC;");
	         
	         while(rs.next()) {
	        	 col1.append(rs.getInt("Team_ID") + ")\n");
	        	 col2.append(rs.getString("Team_Name")+"\n");
	        	 col3.append(rs.getInt("Matches_Played")+"\n");
	        	 col4.append(rs.getInt("Points")+"\n");
	         }
	      } catch(SQLException e) {System.out.println("Connection fails");e.printStackTrace();}
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 36, 24, 16);
		
		
		add(lblNewLabel);
		lblNewLabel_1.setBounds(62, 36, 104, 16);
		
		add(lblNewLabel_1);
		lblNewLabel_2.setBounds(234, 36, 104, 16);
		
		add(lblNewLabel_2);
		lblNewLabel_3.setBounds(350, 36, 61, 16);
		
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
			         ResultSet rs = stmt.executeQuery("SELECT * FROM Football_Fixtures.Points_Table ORDER BY Points DESC;");
			         
			         while(rs.next()) {
			        	 col1.append(rs.getInt("Team_ID") + ")\n");
			        	 col2.append(rs.getString("Team_Name")+"\n");
			        	 col3.append(rs.getInt("Matches_Played")+"\n");
			        	 col4.append(rs.getInt("Points")+"\n");
			         }
			      } catch(SQLException e1) {System.out.println("Connection fails");e1.printStackTrace();}
			}
		});
		refresh.setBounds(327, 3, 117, 29);
		
		add(refresh);
	}
}
