package Reg_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class sample_1 {

	private JFrame frame;
	private JTextField t1;
	private JPasswordField p1;
	JLabel ma;
	private JLabel naa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sample_1 window = new sample_1();
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
	public sample_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 917, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(347, 50, 187, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setBounds(130, 139, 230, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblPassword.setBounds(130, 233, 230, 50);
		frame.getContentPane().add(lblPassword);
		
		t1 = new JTextField();
		t1.setBounds(434, 139, 230, 50);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		 ma = new JLabel("");
		ma.setBounds(754, 122, 89, 67);
		frame.getContentPane().add(ma);
		p1 = new JPasswordField();
		p1.setBounds(434, 233, 230, 50);
		frame.getContentPane().add(p1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un=t1.getText();
				String pass=p1.getText();
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/3year","root","mysql");
					String q="select count(*) from reg where email=? and password=?";
					String q2="select marks,name from reg where email=?";
					PreparedStatement ps=con.prepareStatement(q);
					PreparedStatement ps1=con.prepareStatement(q2);
					ps.setString(1, un);
					ps.setString(2, pass);
					ps1.setString(1, un);
					ResultSet rs=ps.executeQuery();
					ResultSet rs1=ps1.executeQuery();
					rs1.next();
					rs.next();
					int maa=rs1.getInt(1);
					ma.setText("Marks:"+maa);
					naa.setText("Name : "+rs1.getString(2));
					int count =rs.getInt(1);
					if(count==0) {
						JOptionPane.showMessageDialog(btnNewButton,"Invalid Username and Password");
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton,"Login Done");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(374, 371, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		naa = new JLabel("");
		naa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		naa.setBounds(715, 224, 178, 23);
		frame.getContentPane().add(naa);
		
		
	}

}
