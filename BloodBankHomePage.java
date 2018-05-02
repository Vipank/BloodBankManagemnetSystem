import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class BloodBankHomePage {

	public static JFrame frame;
	public static JTextField textField;
	private JTextField textField_1;

	
		
	public BloodBankHomePage(String uname) {
		initialize(uname);
	}

	
	private void initialize(String uname) {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Blood Connect ++");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(272, 21, 252, 97);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(26, 53, 112, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(uname);
		textField.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Blood Group");
		lblNewLabel_1.setBounds(26, 164, 81, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Any", "A+", "B+", "A-", "B-", "AB+", "O+", "AB-", "O-"}));
		comboBox.setBounds(117, 164, 105, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Find User");
		btnNewButton.setBounds(261, 164, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBloodAvailability = new JButton("Blood Availability");
		btnBloodAvailability.setBounds(26, 253, 128, 23);
		frame.getContentPane().add(btnBloodAvailability);
		btnBloodAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q="SELECT bloodbank .Bid , bloodavailability .A_Pos , bloodavailability .A_Neg , bloodavailability .B_Pos ,bloodavailability .B_Neg ,bloodavailability .AB_Pos ,bloodavailability .AB_Neg , bloodavailability .O_Pos ,bloodavailability .O_Neg FROM bloodbank JOIN bloodavailability ON bloodbank .Bid =bloodavailability .id and bloodbank .Bid ='"+SignupPage.loginname.getText()+"'";                         
				try {	
				String url = "jdbc:mysql://localhost:3306/bloodconnect";
				 	String username = "root";
				   String password = "";
				   java.sql.Connection conn = DriverManager.getConnection(url,username,password);
				   Statement st=conn.createStatement();
					ResultSet rs=st.executeQuery(q);
					while (rs.next()) {
			           System.out.println(rs.getObject(1).toString()+" "+rs.getObject(2).toString()+" "+rs.getObject(3).toString()+rs.getObject(4).toString()+" "+rs.getObject(5).toString()+" "+rs.getObject(6).toString()+rs.getObject(7).toString()+" "+rs.getObject(8).toString()+" "+rs.getObject(9).toString());
				 }
					conn.close();
				}catch(Exception ex) {
					System.out.println(e);
				}	
			
			
			}	
		});

		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(377, 310, 128, 23);
		frame.getContentPane().add(btnSignOut);
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			SignupPage.frame.setVisible(true);
			
			}	
		});
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "A_Pos", "B_Pos", "A_Neg", "B_Neg", "AB_Pos", "O_Pos", "AB_Neg", "O_Neg"}));
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(175, 254, 105, 20);
		frame.getContentPane().add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 254, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton update = new JButton("Update ");
		update.setBounds(396, 253, 128, 23);
		frame.getContentPane().add(update);
		update.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!comboBox_1.getSelectedItem().equals("Select")) {
				if(!textField_1.getText().equals("")) {
					String q="UPDATE bloodavailability JOIN BloodBank SET "+comboBox_1.getSelectedItem()+" = '"+textField_1.getText()+"' WHERE BloodBank .Bid =bloodavailability .id and bloodavailability .id = '"+SignupPage.loginname.getText()+"'";
					doqueryU(q);
					JOptionPane.showMessageDialog(null, "Updated");
				}else {
					JOptionPane.showMessageDialog(null, "Please Enter Quantity");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Select Blood Group");
			}
			
			
			
			}	
		});
	
		
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(206, 310, 144, 23);
		frame.getContentPane().add(btnChangePassword);
		
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ChangePassword Pwindow=new ChangePassword("BloodBank","Bid");
			Pwindow.frame.setVisible(true);
			frame.setVisible(false);
			
			
			}	
		});
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
