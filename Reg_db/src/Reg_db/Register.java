package Reg_db;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Register {

	private JFrame frame;
	private JTextField n;
	private JTextField em;
	private JPasswordField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 762, 643);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 31));
		lblNewLabel.setBounds(214, 11, 291, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(71, 117, 79, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(71, 188, 79, 27);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(71, 262, 125, 27);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(71, 321, 125, 27);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Programming language");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_4.setBounds(71, 385, 277, 27);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		n = new JTextField();
		n.setBounds(339, 122, 227, 27);
		frame.getContentPane().add(n);
		n.setColumns(10);
		
		em = new JTextField();
		em.setColumns(10);
		em.setBounds(339, 188, 227, 27);
		frame.getContentPane().add(em);
		
		p = new JPasswordField();
		p.setBounds(339, 262, 227, 27);
		frame.getContentPane().add(p);
		JComboBox<?> c1 = new JComboBox<Object>();
		c1.setBounds(376, 385, 130, 22);
		frame.getContentPane().add(c1);
		
		JRadioButton r1 = new JRadioButton("Male\r\n");
		r1.setBounds(337, 328, 111, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Female");
		r2.setBounds(455, 328, 111, 23);
		frame.getContentPane().add(r2);
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=n.getText();
				String Password=p.getText();
				String email=em.getText();
				String pro=(String)c1.getSelectedItem();
				
				String Gender;
				if (r1.isSelected()) {
					Gender="Female";
				}
				else if(r2.isSelected()) {
					Gender="Male";
				}
				else {
					Gender="Invalid";
				}
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/3year","root","mysql");
					String q="Insert into student values('"+Name+"','"+email+"','"+Password+"','"+Gender+"','"+pro+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(294, 512, 130, 31);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		
		
		
		
	}
}
