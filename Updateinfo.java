import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Updateinfo {

	public static JFrame frame;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField lblNewPhone;
	public static JTextField lblConfirmPhone;
	
	public Updateinfo() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewPhone = new JLabel("New Phone/New Pincode");
		lblNewPhone.setBounds(19, 74, 149, 14);
		frame.getContentPane().add(lblNewPhone);
		
		JLabel lblConfirmPhone = new JLabel("confirm Phone/Confirm Pincode");
		lblConfirmPhone.setBounds(19, 131, 149, 14);
		frame.getContentPane().add(lblConfirmPhone);
		
		textField = new JTextField();
		textField.setBounds(210, 71, 110, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(210, 128, 110, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(150, 185, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(textField.getText().equals(textField_1.getText()) && !textField.getText().equals("")) {
				if(UserHomePage.updateselection.getSelectedItem().equals("Phone")) {
					String q="UPDATE Donor SET phone='"+textField.getText()+"' WHERE  username='"+SignupPage.loginname.getText()+"'";
					doqueryU(q);
	
				}else {
					String q="UPDATE Donor SET pincode='"+textField.getText()+"' WHERE  username='"+SignupPage.loginname.getText()+"'";
					doqueryU(q);
				}
			}
			UserHomePage.frame.setVisible(true);
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
