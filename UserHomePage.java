import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javafx.scene.control.ComboBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class UserHomePage {

	public static JFrame frame;
	public static JTextField txtVipan;
	public static  JTextField textField;
	public static JComboBox updateselection;

	
	
		
	public UserHomePage(String uname) {
		initialize(uname);
	}

	private void initialize(String uname) {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtVipan = new JTextField();
		txtVipan.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtVipan.setBounds(41, 34, 146, 29);
		frame.getContentPane().add(txtVipan);
		txtVipan.setColumns(10);
		txtVipan.setText(uname);
		txtVipan.setEditable(false);
		
		
		JLabel lblNewLabel = new JLabel("Donor Status");
		lblNewLabel.setBounds(41, 113, 86, 29);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(137, 116, 116, 21);
		frame.getContentPane().add(textField);
		textField.setText("Active");
		
		updateselection = new JComboBox();
		updateselection.setModel(new DefaultComboBoxModel(new String[] {"Select", "Phone", "Pincode"}));
		updateselection.setBounds(430, 116, 139, 23);
		frame.getContentPane().add(updateselection);
		
		JButton btnNewButton = new JButton("Update Info");
		btnNewButton.setBounds(430, 190, 109, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(updateselection.getSelectedItem().equals("Select")) {
				JOptionPane.showMessageDialog(null, "Choose Option");
			}else {
				if(updateselection.getSelectedItem().equals("Phone")) {
					Updateinfo uwindow=new Updateinfo();
					uwindow.frame.setVisible(true);
					frame.setVisible(false);
				}else {
					Updateinfo uwindow=new Updateinfo();
					uwindow.frame.setVisible(true);
					frame.setVisible(false);
				}
			}
			
			
			
			}	
		});
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(41, 227, 139, 23);
		frame.getContentPane().add(btnChangePassword);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ChangePassword Pwindow=new ChangePassword("Donor","username");
			Pwindow.frame.setVisible(true);
			frame.setVisible(false);
			
			
			}	
		});
		
		
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setBounds(222, 227, 139, 23);
		frame.getContentPane().add(btnDeleteAccount);
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			SignupPage.frame.setVisible(true);
			String q="DELETE from donor where username='"+ SignupPage.loginname.getText()+"'";
			int result=doqueryU(q);
			if(result!=0) {
				JOptionPane.showMessageDialog(null, "User Account Deleted");
			}
			}	
		});
		
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(222, 306, 109, 23);
		frame.getContentPane().add(btnSignOut);
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			SignupPage.frame.setVisible(true);
			
			}	
		});
		
		JLabel lblBloodConnect = new JLabel("Blood Connect ++");
		lblBloodConnect.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBloodConnect.setBounds(340, -17, 277, 120);
		frame.getContentPane().add(lblBloodConnect);
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
