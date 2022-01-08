package gui_Elements;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Team_info extends JPanel {

	private static final long serialVersionUID = -5783053974062881150L;
	private final JLabel lblNewLabel = new JLabel("Enter Team Name:");
	private final JTextField textField = new JTextField();
	private final JButton process_query = new JButton("Find Info");
	private final JTextArea basis = new JTextArea();
	private final JTextArea reply = new JTextArea();
	private String team;
	private final JButton btnNewButton = new JButton("X");

	public Team_info() {
		textField.setBounds(160, 15, 130, 26);
		textField.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setBorder(new LineBorder(Color.BLACK, 5));
		setBackground(Color.PINK);
		setLayout(null);
		lblNewLabel.setBounds(40, 20, 136, 16);
		
		add(lblNewLabel);
		
		basis.setText("ID:\n\nMatches Played:\n\nPoints:\n\nHome Stadium:\n\nCapacity:\n\nUpcoming Home Match:\n\n\nUpcoming Away Match:");
		
		String JdbcURL = "jdbc:mysql://127.0.0.1:3306/?user=root";
		String Username = "root";
		String password = "pranav02";
		
		add(textField);
		process_query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				team=textField.getText();
				Connection con = null;
			      try {
			         con=DriverManager.getConnection(JdbcURL, Username, password);
			         
			         PreparedStatement stmt = con.prepareStatement("SELECT * FROM Football_Fixtures.Points_Table NATURAL JOIN Football_Fixtures.Home_Ground_info WHERE Team_name = ?;");
			         stmt.setString(1, team);
			         ResultSet rs = stmt.executeQuery();
			         
			         PreparedStatement stmt1 = con.prepareStatement("SELECT * FROM Football_Fixtures.Fixtures WHERE Home_Team = ? ORDER BY Kick_Off LIMIT 1;");
			         stmt1.setString(1, team);
			         ResultSet rs1 = stmt1.executeQuery();
			         
			         PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM Football_Fixtures.Fixtures WHERE Away_Team = ? ORDER BY Kick_Off LIMIT 1;");
			         stmt2.setString(1, team);
			         ResultSet rs2 = stmt2.executeQuery();
			         
			         while(rs.next()) {
			        	 reply.append(rs.getInt("Team_ID") + "\n\n");
			        	 reply.append(rs.getInt("Matches_Played") + "\n\n");
			        	 reply.append(rs.getInt("Points") + "\n\n");
			        	 reply.append(rs.getString("Stadium_Name") + "\n\n");
			        	 reply.append(rs.getInt("Capacity") + "\n\n");
			         }
			        while(rs1.next()) {reply.append(rs1.getString("Away_Team")+ " \nKick Off: " + rs1.getString("Kick_Off")+"\n\n" );}
			        while(rs2.next()) {reply.append(rs2.getString("Home_Team")+ " \nKick Off: " + rs2.getString("Kick_Off") );}
			         
			        
			      } catch(SQLException e1) {System.out.println("Connection fails");e1.printStackTrace();}
			}
		});
		process_query.setBounds(299, 15, 117, 29);
		
		add(process_query);
		basis.setEditable(false);
		basis.setBounds(50, 48, 168, 247);
		
		add(basis);
		reply.setEditable(false);
		reply.setBounds(230, 48, 214, 247);
		
		add(reply);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reply.setText("");
			}
		});
		btnNewButton.setBounds(416, 15, 53, 29);
		
		add(btnNewButton);
	}
}
