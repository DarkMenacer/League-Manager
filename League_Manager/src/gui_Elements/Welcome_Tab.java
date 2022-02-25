package gui_Elements;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Welcome_Tab extends JFrame {
	
	private static final long serialVersionUID = 298612255202080827L;
	private JPanel welcome_Screen;
	private final JLabel dbms_Proj = new JLabel("Welcome to DBMS Project");
	private final JLabel welc_guidance = new JLabel("Please select appropriate option in the Main Menu to begin!");
	private final JLabel credits = new JLabel("Made by:-");
	private final JLabel lblLakshyaMaheshwari = new JLabel("Date:-        28 November 2021");
	private final JLabel lblPranavChatur = new JLabel("Pranav Chatur (20ucs138)");
	private final JLabel lblPranavGupta = new JLabel("Project made using:-");
	private final JLabel credits_3_1 = new JLabel("Java, JDBC & MySQL");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu points_table_menu = new JMenu("Points Table");
	private final JMenuItem display_points = new JMenuItem("Display");
	private final JMenu matches_menu = new JMenu("Matches");
	private Points_Table points_table_pane = new Points_Table();
	private final JMenu home_menu = new JMenu("Home");
	private final JMenuItem creator = new JMenuItem("Add Team");
	private final JMenuItem returner = new JMenuItem("Home Page");
	private Creator insert_into_pane = new Creator();
	private final JMenuItem delete_team_menu = new JMenuItem("Delete Team");
	private Deletor delete_team = new Deletor();
	private final JMenuItem add_match_menu = new JMenuItem("Add Matches");
	private Decide_Matches schedule = new Decide_Matches();
	private final JMenuItem delete_matches_menu = new JMenuItem("Delete Matches");
	private Abort_matches cancel = new Abort_matches();
	private final JMenuItem schedule_menu = new JMenuItem("Schedule");
	private Fixt_table sched = new Fixt_table();
	private final JMenu teams_menu = new JMenu("Teams");
	private final JMenuItem team_info_menu = new JMenuItem("Team Info");
	private Team_info info = new Team_info();

	public Welcome_Tab() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 359);
		menuBar.setBackground(Color.WHITE);
		menuBar.setForeground(Color.BLACK);
		
		setJMenuBar(menuBar);
		home_menu.setForeground(Color.BLACK);
		home_menu.setBackground(Color.BLACK);
		
		menuBar.add(home_menu);
		returner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				setContentPane(welcome_Screen);
				revalidate();
				getContentPane().setVisible(true);
			}
		});
		
		home_menu.add(returner);
		
		menuBar.add(teams_menu);
		teams_menu.add(creator);
		teams_menu.add(delete_team_menu);
		team_info_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				setContentPane(info);
				revalidate();
				getContentPane().setVisible(true);
			}
		});
		
		teams_menu.add(team_info_menu);
		delete_team_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				setContentPane(delete_team);
				revalidate();
				getContentPane().setVisible(true);
			}
		});
		creator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				setContentPane(insert_into_pane);
				revalidate();
				getContentPane().setVisible(true);
			}
		});
		matches_menu.setForeground(Color.BLACK);
		matches_menu.setBackground(Color.BLACK);
		
		menuBar.add(matches_menu);
		add_match_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				setContentPane(schedule);
				revalidate();
				getContentPane().setVisible(true);
			}
		});
		
		matches_menu.add(add_match_menu);
		delete_matches_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				setContentPane(cancel);
				revalidate();
				getContentPane().setVisible(true);
			}
		});
		
		matches_menu.add(delete_matches_menu);
		schedule_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				setContentPane(sched);
				revalidate();
				getContentPane().setVisible(true);
			}
		});
		
		matches_menu.add(schedule_menu);
		points_table_menu.setForeground(Color.BLACK);
		points_table_menu.setBackground(Color.BLACK);
		
		menuBar.add(points_table_menu);
		display_points.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				setContentPane(points_table_pane);
				revalidate();
				getContentPane().setVisible(true);
			}
		});
		
		points_table_menu.add(display_points);
		
		
		welcome_Screen = new JPanel();
		welcome_Screen.setBackground(Color.PINK);
		welcome_Screen.setBorder(new LineBorder(Color.BLACK, 5));
		setContentPane(welcome_Screen);
		welcome_Screen.setLayout(null);
		dbms_Proj.setBounds(45, 28, 440, 36);
		dbms_Proj.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_Screen.add(dbms_Proj);
		welc_guidance.setBounds(55, 66, 446, 16);
		welc_guidance.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_Screen.add(welc_guidance);
		credits.setBounds(17, 161, 274, 30);
		credits.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_Screen.add(credits);
		lblLakshyaMaheshwari.setBounds(102, 189, 231, 30);
		lblLakshyaMaheshwari.setHorizontalAlignment(SwingConstants.CENTER);
		
		welcome_Screen.add(lblLakshyaMaheshwari);
		lblPranavChatur.setBounds(192, 161, 171, 30);
		lblPranavChatur.setHorizontalAlignment(SwingConstants.CENTER);
		
		welcome_Screen.add(lblPranavChatur);
		lblPranavGupta.setBounds(91, 218, 187, 30);
		lblPranavGupta.setHorizontalAlignment(SwingConstants.CENTER);
		
		welcome_Screen.add(lblPranavGupta);
		credits_3_1.setBounds(234, 218, 202, 30);
		credits_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		welcome_Screen.add(credits_3_1);
	}
}
