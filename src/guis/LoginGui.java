package guis;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import db_objs.MyJDBC;
import db_objs.User;

public class LoginGui extends BaseFrame {

	public LoginGui() {
		super("S-Bank App Login");
		// TODO Auto-generated constructor stub
	}

	
	@Override 
	protected void addGuiComponents() {
		
		JLabel bankingAppLabel=new JLabel("S-Bank Application");
		bankingAppLabel.setBounds(0,20,super.getWidth(),40);
		bankingAppLabel.setFont(new Font ("Dialog",Font.BOLD,32));
		bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(bankingAppLabel);
		
		JLabel userNameLabel=new JLabel("userName");
		userNameLabel.setBounds(20,120,getWidth()-30,24);
		userNameLabel.setFont(new Font ("Dialog",Font.PLAIN,20));
		add(userNameLabel);
		
		LineBorder lineBorder =new LineBorder(Color.black, 1, true);
		JTextField  userNameField=new JTextField();
		userNameField.setBounds(20,160,getWidth()-50,40);
		userNameField.setFont(new Font("Dialog",Font.PLAIN,28));
		userNameField.setBorder(lineBorder );
		add(userNameField);
		
		JLabel passwordLabel=new JLabel("password");
		passwordLabel.setBounds(20,210,getWidth()-30,24);
		passwordLabel.setFont(new Font ("Dialog",Font.PLAIN,20));
		add(passwordLabel);
		
		JPasswordField  passwordField=new JPasswordField();
		passwordField.setBounds(20,250,getWidth()-50,40);
		passwordField.setFont(new Font("Dialog",Font.PLAIN,28));
		passwordField.setBorder(lineBorder );
		add(passwordField);
		
		JButton  loginButton=new JButton("Login");
		loginButton.setBounds(100,360,getWidth()-200,40);
		loginButton.setFont(new Font("Dialog",Font.BOLD,28));
		loginButton.setBorder(lineBorder );
		loginButton.setHorizontalAlignment(SwingConstants.CENTER);
		loginButton.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				
				//get userName
				String  username=userNameField.getText();
				
				//get password
				String password =String.valueOf(passwordField.getPassword());
			
			
			
			//validatelogin
				User user=MyJDBC.validateLogin(username, password);
				
				if(user!=null) {
					
					LoginGui.this.dispose();
					
					
					//launch bank app gui
					
					BankingAppGui bankingAppGui=new BankingAppGui(user);
					bankingAppGui.setVisible(true);
					
					JOptionPane.showMessageDialog(bankingAppGui, "Login successfully");
				}else {
					JOptionPane.showMessageDialog(LoginGui.this,"Login Failed....");
					
				}
			}
			
		});
		add(loginButton);
		
		JLabel RegisterLabel=new JLabel("<html>New Here?<a  href=\"#\" > Regiter Here</a></html>");
		RegisterLabel.setBounds(100,410,getWidth()-90,24);
		RegisterLabel.setFont(new Font ("Dialog",Font.PLAIN,20));
		add(RegisterLabel);
		
		
		RegisterLabel.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseClicked(MouseEvent e) {
				LoginGui.this.dispose();
				
				new RegisterGui().setVisible(true);
			}
		});
		
		add(RegisterLabel);
	
	
	}

	
}
