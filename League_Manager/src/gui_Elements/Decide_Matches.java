package gui_Elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Decide_Matches extends JPanel {

	private static final long serialVersionUID = -4034070376006051853L;
	private final JLabel lblNewLabel = new JLabel("Match ID: ");
	private final JTextField match_id = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("Home Team:");
	private final JTextField home_team = new JTextField();
	private final JLabel lblNewLabel_2 = new JLabel("Away Team:");
	private final JTextField away_team = new JTextField();
	private final JLabel lblNewLabel_4 = new JLabel("Kick Off:");
	private final JTextField kick_off = new JTextField();
	private final JButton process_new = new JButton("Add Entry");
	private String home, away, date;
	private int id;

	public Decide_Matches() {
		kick_off.setToolTipText("YYYY-MM-DD HH:MM:SS");
		kick_off.setForeground(Color.BLACK);
		kick_off.setBounds(126, 178, 172, 26);
		kick_off.setColumns(10);
		away_team.setBounds(126, 134, 104, 26);
		away_team.setColumns(10);
		home_team.setBounds(126, 80, 104, 26);
		home_team.setColumns(10);
		match_id.setBounds(126, 30, 48, 26);
		match_id.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setBorder(new LineBorder(Color.BLACK, 5));
		setBackground(Color.GREEN);
		setLayout(null);
		lblNewLabel.setBounds(17, 35, 68, 16);
		
		add(lblNewLabel);
		
		add(match_id);
		lblNewLabel_1.setBounds(17, 85, 91, 16);
		
		add(lblNewLabel_1);
		
		add(home_team);
		lblNewLabel_2.setBounds(17, 139, 104, 16);
		
		add(lblNewLabel_2);
		
		add(away_team);
		lblNewLabel_4.setBounds(17, 183, 120, 16);
		
		add(lblNewLabel_4);
		
		add(kick_off);
		
		process_new.setBounds(147, 254, 117, 29);
		
		add(process_new);
		
		String JdbcURL = "jdbc:mysql://127.0.0.1:3306/?user=root";
		String Username = "root";
		String password = "pranav02";
		
		process_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = Math.abs(Integer.parseInt(match_id.getText()));
				home = home_team.getText();
				away = away_team.getText();
				date = kick_off.getText();
				
				try {
					Connection con=DriverManager.getConnection(JdbcURL, Username, password);
			         
			         PreparedStatement stmt = con.prepareStatement("INSERT INTO Football_Fixtures.Fixtures VALUES (?,?,?,?);");
			         stmt.setInt(1,id);
			         stmt.setString(2, home);
			         stmt.setString(3, away);
			         stmt.setString(4, date);
			         stmt.execute();
			         
			         match_id.setText("");
			         home_team.setText("");
			         away_team.setText("");
			         kick_off.setText("");
			       
			    
			      } catch(SQLException e1) {System.out.println("Connection fails");e1.printStackTrace();}
			}
		});
		
	
	}
}
