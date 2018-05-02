import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChangePassword {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	
	public ChangePassword(String utype,String key) {
		initialize(utype,key);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String utype,String key) {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(120, 120, 93, 14);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setBounds(120, 171, 93, 14);
		frame.getContentPane().add(lblRepeatPassword);
		
		textField = new JTextField();
		textField.setBounds(243, 117, 127, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(243, 168, 127, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(170, 229, 89, 23);
		frame.getContentPane().add(btnDone);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(textField.getText().equals(textField_1.getText()) && !textField_1.getText().equals("") ){
				String q="UPDATE "+ utype +" SET password='"+textField.getText()+"' WHERE "+ key+"='"+SignupPage.loginname.getText()+"'";
				doqueryu(q);
				if(utype.equals("Donor")) {
					UserHomePage.frame.setVisible(true);
					frame.dispose();
				}else if(utype.equals("BloodBank")) {
					BloodBankHomePage.frame.setVisible(true);
					utype.equals("Donor");
				}else {
					HospitalHomePage.frame.setVisible(true);
					frame.dispose();
				}
				
			
			}
			
			}	
		});
	}
	private static void doqueryu(String q) {
		try {
			String url = "jdbc:mysql://localhost:3306/bloodconnect";
		 	String username = "root";
		   String password = "";
		  
		   java.sql.Connection conn = DriverManager.getConnection(url,username,password);
		   Statement st=conn.createStatement();
		   //String q="Select * from login where name='"+email.getText()+"'"+" and PASSWORD='"+loginname.getText()+"'";
			int rs=st.executeUpdate(q);
//			if(rs.next()) {
//				JOptionPane.showConfirmDialog(null, "Login");
//			}else {
//				JOptionPane.showConfirmDialog(null, "Not Login");
//			}
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
