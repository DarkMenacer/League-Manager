package gui_Elements;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Creator extends JPanel {
	private static final long serialVersionUID = -4034070376006051853L;
	private final JLabel lblNewLabel = new JLabel("Team ID: ");
	private final JTextField team_id = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("Team Name:");
	private final JTextField team_name = new JTextField();
	private final JLabel lblNewLabel_2 = new JLabel("Matches Played:");
	private final JTextField matches_played = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("Matches Won:");
	private final JTextField matches_won = new JTextField();
	private final JLabel lblNewLabel_4 = new JLabel("Home Stadium:");
	private final JTextField stadium = new JTextField();
	private final JLabel lblNewLabel_5 = new JLabel("Capacity: ");
	private final JTextField capacity = new JTextField();
	private final JButton process_new = new JButton("Add Entry");
	private String teamname,stadname;
	private int id, no_match, won_match,size;

	public Creator() {
		capacity.setBounds(126, 216, 78, 26);
		capacity.setColumns(10);
		stadium.setBounds(126, 178, 130, 26);
		stadium.setColumns(10);
		matches_won.setBounds(339, 136, 72, 26);
		matches_won.setColumns(10);
		matches_played.setBounds(126, 136, 59, 26);
		matches_played.setColumns(10);
		team_name.setBounds(126, 80, 151, 26);
		team_name.setColumns(10);
		team_id.setBounds(126, 30, 48, 26);
		team_id.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setBackground(Color.GREEN);
		setLayout(null);
		lblNewLabel.setBounds(17, 35, 68, 16);
		
		add(lblNewLabel);
		
		add(team_id);
		lblNewLabel_1.setBounds(17, 85, 91, 16);
		
		add(lblNewLabel_1);
		
		add(team_name);
		lblNewLabel_2.setBounds(17, 141, 104, 16);
		
		add(lblNewLabel_2);
		
		add(matches_played);
		lblNewLabel_3.setBounds(222, 141, 91, 16);
		
		add(lblNewLabel_3);
		
		add(matches_won);
		lblNewLabel_4.setBounds(17, 183, 120, 16);
		
		add(lblNewLabel_4);
		
		add(stadium);
		lblNewLabel_5.setBounds(17, 221, 78, 16);
		
		add(lblNewLabel_5);
		
		add(capacity);
		
		process_new.setBounds(147, 254, 117, 29);
		
		add(process_new);
		
		String JdbcURL = "jdbc:mysql://127.0.0.1:3306/?user=root";
		String Username = "root";
		String password = "pranav02";
		
		process_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = Math.abs(Integer.parseInt(team_id.getText()));
				teamname = team_name.getText();
				no_match = Math.abs(Integer.parseInt(matches_played.getText()));
				won_match = Math.abs(Integer.parseInt(matches_won.getText()));
				stadname = stadium.getText();
				size = Math.abs(Integer.parseInt(capacity.getText()));
				
				try {
					Connection con=DriverManager.getConnection(JdbcURL, Username, password);
			         
			         PreparedStatement stmt = con.prepareStatement("INSERT INTO Football_Fixtures.Points_Table VALUES (?,?,?,?);");
			         stmt.setInt(1,id);
			         stmt.setString(2, teamname);
			         stmt.setInt(3, no_match);
			         stmt.setInt(4, won_match*3);
			         stmt.execute();
			         
			         PreparedStatement stmt1 = con.prepareStatement("INSERT INTO Football_Fixtures.Home_Ground_info VALUES(?,?,?);");
			         stmt1.setInt(2,size);
			         stmt1.setString(1, stadname);
			         stmt1.setInt(3, id);
			         stmt1.execute();
			         
			         team_id.setText("");
			         team_name.setText("");
			         matches_played.setText("");
			         matches_won.setText("");
			         stadium.setText("");
			         capacity.setText("");
			       
			    
			      } catch(SQLException e1) {System.out.println("Connection fails");e1.printStackTrace();}
			}
		});
		
	
	}
}
