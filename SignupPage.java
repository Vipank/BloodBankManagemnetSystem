

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class SignupPage {

	public static JFrame frame;
	public static JTextField email;
	public static JTextField loginname;
	private JTextField pwd1;
	private JTextField pwd2;
	private JTextField phone;
	private JTextField pincode;
	private JTextField loginpwd;
	private JTextField username;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupPage window = new SignupPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
			
	
	public SignupPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 662, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSignUp = new JLabel("         Sign UP");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSignUp.setBounds(56, 23, 139, 27);
		frame.getContentPane().add(lblSignUp);
		
		JComboBox usertype = new JComboBox();
		usertype.setModel(new DefaultComboBoxModel(new String[] {"Select", "Donor", "Hospital", "BloodBank"}));
		usertype.setBounds(445, 117, 127, 20);
		frame.getContentPane().add(usertype);
		
		JLabel lblUsername = new JLabel("Password");
		lblUsername.setBounds(56, 166, 83, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel label = new JLabel("UserName");
		label.setBounds(56, 84, 83, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Email id");
		label_1.setBounds(56, 120, 83, 14);
		frame.getContentPane().add(label_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(56, 212, 127, 14);
		frame.getContentPane().add(lblConfirmPassword);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setBounds(56, 256, 76, 27);
		frame.getContentPane().add(lblBloodGroup);
		
		email = new JTextField();
		email.setBounds(185, 117, 127, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		loginname = new JTextField();
		loginname.setColumns(10);
		loginname.setBounds(445, 81, 127, 20);
		frame.getContentPane().add(loginname);
		
		pwd1 = new JTextField();
		pwd1.setColumns(10);
		pwd1.setBounds(185, 163, 127, 20);
		frame.getContentPane().add(pwd1);
		
		pwd2 = new JTextField();
		pwd2.setColumns(10);
		pwd2.setBounds(185, 209, 127, 20);
		frame.getContentPane().add(pwd2);
		
		JComboBox Bloodgrp = new JComboBox();
		Bloodgrp.setModel(new DefaultComboBoxModel(new String[] {"Select", "A+", "B+", "A-", "B-", "AB+", "O+", "AB-", "O-"}));
		Bloodgrp.setBounds(185, 259, 127, 20);
		frame.getContentPane().add(Bloodgrp);
		
		JLabel lblPhone = new JLabel("Gender");
		lblPhone.setBounds(56, 304, 76, 27);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblNewLabel = new JLabel("Phone");
		lblNewLabel.setBounds(56, 342, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(185, 349, 127, 20);
		frame.getContentPane().add(phone);
		
		JLabel label_2 = new JLabel("Pin code");
		label_2.setBounds(56, 383, 46, 14);
		frame.getContentPane().add(label_2);
		
		pincode = new JTextField();
		pincode.setColumns(10);
		pincode.setBounds(185, 380, 127, 20);
		frame.getContentPane().add(pincode);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Select", "Male", "Female"}));
		gender.setBounds(185, 307, 127, 20);
		frame.getContentPane().add(gender);
		
		JButton signup = new JButton("Sign Up");
		signup.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				
				if(email.getText()!=null && phone.getText()!=null && username.getText()!=null && pincode.getText()!=null && pwd2.getText()!=null && pwd1.getText()!=null && Bloodgrp.getSelectedItem()!="Select" && gender.getSelectedItem()!="Select" && pwd2.getText().equals(pwd1.getText())) {
					JOptionPane.showMessageDialog(null, "User Signed up");
					String q="INSERT INTO donor (username,email,password,bloodgroup,gender,phone,pincode) VALUES ('"+username.getText()+"','"+email.getText()+"','"+pwd1.getText()+"','"+Bloodgrp.getSelectedItem()+"','"+gender.getSelectedItem()+"','"+phone.getText()+"','"+pincode.getText()+"')";
					doqueryU(q);
				}else {
					
					if(!pwd1.equals(pwd2)) {
						JOptionPane.showMessageDialog(null, "Password Did not match");
					}else {
						JOptionPane.showMessageDialog(null, "Fill Details");
					}
				}
			
			
			}
		});
		
		signup.setBounds(185, 429, 89, 23);
		frame.getContentPane().add(signup);
		
		JLabel lblNewLabel_1 = new JLabel("Already A Member");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(445, 30, 153, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("UserName");
		label_3.setBounds(355, 84, 83, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Password");
		label_4.setBounds(355, 166, 83, 14);
		frame.getContentPane().add(label_4);
		
		loginpwd = new JTextField();
		loginpwd.setColumns(10);
		loginpwd.setBounds(445, 163, 127, 20);
		frame.getContentPane().add(loginpwd);
		
		JButton signin = new JButton("Sign in");
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   if(usertype.getSelectedItem().equals("Hospital")) {
				String q="Select * from Hospital where hid='"+loginname.getText()+"'"+" and password='"+loginpwd.getText()+"'";
				int result=doquery(q);
//					String s="Login as "+usertype.getSelectedItem()+" successfully";
//					JOptionPane.showConfirmDialog(null, s);
				if(result==1) {	
				HospitalHomePage Hwindow = new HospitalHomePage(loginname.getText());
					Hwindow.frame.setVisible(true);
					frame.setVisible(false);;
				}
							
			}else if(usertype.getSelectedItem().equals("Donor")){
			String q="Select * from Donor where username='"+loginname.getText()+"'"+" and password='"+loginpwd.getText()+"'";
			int result=doquery(q);
			if(result==1) {	
				UserHomePage uwindow = new UserHomePage(loginname.getText());
					uwindow.frame.setVisible(true);
					frame.setVisible(false);;
				}
			
			}else if(usertype.getSelectedItem().equals("BloodBank")) {
				String q="Select * from BloodBank where Bid='"+loginname.getText()+"'"+" and password='"+loginpwd.getText()+"'";
				int result=doquery(q);
				if(result==1) {	
					BloodBankHomePage bwindow = new BloodBankHomePage(loginname.getText());
						bwindow.frame.setVisible(true);
						frame.setVisible(false);;
					}
					
			}
			}
			
					});
		signin.setBounds(445, 230, 89, 23);
		frame.getContentPane().add(signin);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(185, 81, 127, 20);
		frame.getContentPane().add(username);
		
		JLabel lblUsertype = new JLabel("UserType");
		lblUsertype.setBounds(355, 120, 76, 27);
		frame.getContentPane().add(lblUsertype);
		
		
	}
	private static int doqueryU(String q) {
		int rs = -1;
		try {
			String url = "jdbc:mysql://localhost:3306/bloodconnect";
		 	String username = "root";
		   String password = "";
		  
		   java.sql.Connection conn = DriverManager.getConnection(url,username,password);
		   Statement st=conn.createStatement();
		   //String q="Select * from login where name='"+email.getText()+"'"+" and PASSWORD='"+loginname.getText()+"'";
			 rs=st.executeUpdate(q);
			if(rs>=0) {
				rs=1;
			}
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	return rs;
	}
	private static int doquery(String q) {
		int rsc=-1;
		try {
			String url = "jdbc:mysql://localhost:3306/bloodconnect";
		 	String username = "root";
		   String password = "";
		  
		   java.sql.Connection conn = DriverManager.getConnection(url,username,password);
		   Statement st=conn.createStatement();
		   //String q="Select * from login where name='"+email.getText()+"'"+" and PASSWORD='"+loginname.getText()+"'";
			ResultSet rs=st.executeQuery(q);
			if(rs.next()) {
//				String season = rs.getString(1);
//				System.out.println(season);
				rsc=1;
				
			}
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return rsc;
	}

}
