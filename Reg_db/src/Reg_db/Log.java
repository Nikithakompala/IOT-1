package Reg_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;

public class Log {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log window = new Log();
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
	public Log() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 844, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Roll No");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(152, 53, 104, 47);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(373, 56, 203, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel maa = new JLabel("");
		maa.setFont(new Font("Tahoma", Font.BOLD, 23));
		maa.setBounds(283, 252, 96, 31);
		frame.getContentPane().add(maa);
		
		JLabel naaa = new JLabel("");
		naaa.setFont(new Font("Tahoma", Font.BOLD, 23));
		naaa.setBounds(283, 338, 96, 31);
		frame.getContentPane().add(naaa);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roll=textField.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud_data","root","mysql");
					String q="select Marks from data where Roll_No=?";
					String q1="select Name from data where Roll_No=?";
					PreparedStatement ps=con.prepareStatement(q);
					PreparedStatement ps1=con.prepareStatement(q1);
					ps.setString(1, roll);
					ps1.setString(1, roll);
					ResultSet rs=ps.executeQuery();
					
					rs.next();
					maa.setText("Marks:"+rs.getInt(1));
					ResultSet rs1=ps.executeQuery();
					rs1.next();
					naaa.setText(rs1.getString(1));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(295, 134, 125, 31);
		frame.getContentPane().add(btnNewButton);
		
		JInternalFrame internalFrame = new JInternalFrame("Fuck your");
		internalFrame.setBounds(111, 191, 527, 242);
		frame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setBounds(24, 0, 158, 112);
		internalFrame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel lblNewLabel_1_1 = new JLabel("Marks :");
		lblNewLabel_1_1.setBounds(24, 98, 96, 31);
		internalFrame.getContentPane().add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		internalFrame.setVisible(true);
		
		
	}
}
