package gui_Elements;

import java.awt.Color;
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
import javax.swing.border.LineBorder;

public class Abort_matches extends JPanel {

	private static final long serialVersionUID = 5759816820939273931L;
	private final JLabel prompt = new JLabel("Enter Match ID: ");
	private final JTextField match_id = new JTextField();
	private final JButton delete_but = new JButton("DELETE");
	private int del_id;

	public Abort_matches() {
		match_id.setBounds(182, 104, 130, 26);
		match_id.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setBorder(new LineBorder(Color.BLACK, 5));
		
		String JdbcURL = "jdbc:mysql://127.0.0.1:3306/?user=root";
		String Username = "root";
		String password = "pranav02";
		
		setBackground(Color.RED);
		setLayout(null);
		prompt.setBounds(77, 109, 135, 16);
		
		add(prompt);
		
		add(match_id);
		delete_but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				del_id = Math.abs(Integer.parseInt(match_id.getText()));
				try {
					Connection con=DriverManager.getConnection(JdbcURL, Username, password);
			         PreparedStatement stmt1 = con.prepareStatement("DELETE FROM Football_Fixtures.Fixtures WHERE Match_ID = (?);");
			         stmt1.setInt(1,del_id);
			         stmt1.execute();
			       
			         match_id.setText("");
			       
			      } catch(SQLException e1) {System.out.println("Connection fails");e1.printStackTrace();}
			}
		});
		
		
		delete_but.setBounds(127, 137, 117, 29);
		
		add(delete_but);
	}

}
