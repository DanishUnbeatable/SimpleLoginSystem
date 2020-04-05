package bs;
import java.sql.Connection;

import java.sql.DriverManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

public class MainPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField nametxt;
	private JTextField usertxt;
	private JPanel panel;
	private JPasswordField passtxt;
	private JFrame Frame;
	Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	public MainPage() {
		initialize();
		conn=Sqliteconnection.Connectiondb();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JPasswordField passwordField;
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(200, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Simple Login System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(356, 47, 437, 62);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCreateAccount.setBackground(new Color(30, 144, 255));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
			}
		});
		btnCreateAccount.setBounds(129, 243, 271, 55);
		frame.getContentPane().add(btnCreateAccount);
		
		textField = new JTextField();
		textField.setBounds(663, 273, 225, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(567, 273, 84, 22);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(567, 327, 80, 22);
		frame.getContentPane().add(lblNewLabel_1);
		//code for login 
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				PreparedStatement p=null;
				ResultSet rs=null;
				String username=textField.getText();
				String password=String.valueOf(passwordField.getPassword());
				
				String que="SELECT * FROM user WHERE Username=? AND Password=?";
				try {
					p=Sqliteconnection.Connectiondb().prepareStatement(que);
					p.setString(1,username);
					p.setString(2,password);	
					rs=p.executeQuery();
					
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Sucessfull");
						Home ho=new Home();
						ho.setVisible(true);
						
						
					}
					else
					{

						JOptionPane.showMessageDialog(null, "Authentication failed");
					
					}
				} catch (SQLException es) {
					// TODO Auto-generated catch block
					Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,es);
				}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1);

				}
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(696, 368, 155, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblAlreadyUser = new JLabel("Already User");
		lblAlreadyUser.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAlreadyUser.setBounds(674, 183, 188, 45);
		frame.getContentPane().add(lblAlreadyUser);
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewUser.setBounds(196, 180, 147, 50);
		frame.getContentPane().add(lblNewUser);
		
		panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(30, 144, 255)));
		//make variables global
		panel.setVisible(false);
		panel.setBounds(36, 311, 497, 217);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		nametxt = new JTextField();
		//make your textfield field variables global so that you can use it within application by default they are global here
		nametxt.setBounds(147, 33, 179, 22);
		panel.add(nametxt);
		nametxt.setColumns(10);
		
		usertxt = new JTextField();
		usertxt.setBounds(147, 68, 179, 22);
		panel.add(usertxt);
		usertxt.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(26, 35, 56, 16);
		panel.add(lblName);
		
		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername_1.setBounds(26, 70, 75, 16);
		panel.add(lblUsername_1);
		
		JLabel lblChoosePassword = new JLabel("Choose Password");
		lblChoosePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChoosePassword.setBounds(26, 105, 116, 16);
		panel.add(lblChoosePassword);
		//code for register
		JButton create_account = new JButton("Create Account");
		create_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name=nametxt.getText();
					String username=usertxt.getText();
					String password=String.valueOf(passtxt.getPassword());
					if(name.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Enter Your Name");;

					}
					else if(username.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Enter Your UserName");;

					}
					else if(password.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Enter Your Password");;

					}
					
					
					PreparedStatement ps;
					String query="INSERT INTO `user`(`Name`, `Username`, `Password`) VALUES (?,?,?)";
					try {
					ps=Sqliteconnection.Connectiondb().prepareStatement(query);
					ps.setString(1, name);
					ps.setString(2, username);
					ps.setString(3, password);
					
					if(ps.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "New User Added");
					}
					
				}catch(SQLException es)
					{
					Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,es);
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);;
				}
				
				
				
				
				
				
			}
		});
		create_account.setBackground(new Color(30, 144, 255));
		create_account.setFont(new Font("Tahoma", Font.BOLD, 15));
		create_account.setBounds(147, 150, 179, 31);
		panel.add(create_account);
		
		passtxt = new JPasswordField();
		passtxt.setBounds(147, 103, 179, 22);
		panel.add(passtxt);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(663, 327, 225, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame = new JFrame();
				if(JOptionPane.showConfirmDialog(Frame,"Confirm if you want to exit","Simple Login System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
				
			}
		});
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(873, 503, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
	//initialize table
		//createTableNew();
	}
}
