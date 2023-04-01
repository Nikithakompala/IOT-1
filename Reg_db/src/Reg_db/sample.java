package Reg_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class sample {

	private JFrame frame;
	private JTextField e1;
	private JPasswordField p;
	private JTextField n;
	private JTextField m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sample window = new sample();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(30, 151, 115, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Set password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblPassword.setBounds(36, 229, 183, 28);
		frame.getContentPane().add(lblPassword);
		
		e1 = new JTextField();
		e1.setBounds(218, 156, 170, 28);
		frame.getContentPane().add(e1);
		e1.setColumns(10);
		
		p = new JPasswordField();
		p.setBounds(218, 234, 170, 29);
		frame.getContentPane().add(p);
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblName.setBounds(431, 151, 115, 28);
		frame.getContentPane().add(lblName);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblMarks.setBounds(431, 229, 115, 28);
		frame.getContentPane().add(lblMarks);
		
		n = new JTextField();
		n.setColumns(10);
		n.setBounds(564, 151, 170, 28);
		frame.getContentPane().add(n);
		
		m = new JTextField();
		m.setColumns(10);
		m.setBounds(564, 229, 170, 28);
		frame.getContentPane().add(m);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblRegistration.setBounds(306, 34, 183, 28);
		frame.getContentPane().add(lblRegistration);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Email=e1.getText();
				String Password=p.getText();
				String Name=n.getText();
				String Marks=m.getText();
				
				try {
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/3year","root","mysql");
					String w="Insert into reg values('"+Email+"','"+Password+"','"+Name+"','"+Marks+"')";
					java.sql.Statement sta=con.createStatement();
					sta.executeUpdate(w);
					con.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton.setBounds(334, 340, 135, 28);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
