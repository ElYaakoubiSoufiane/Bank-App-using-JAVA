package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import db_objs.MyJDBC;

public class RegisterGui extends BaseFrame {

	public RegisterGui() {
		super("S-BANK Register");
		
	}
	
	@Override 
	protected void addGuiComponents() {

		JLabel bankingAppLabel=new JLabel("S-BANK Application");
		bankingAppLabel.setBounds(0,20,super.getWidth(),40);
		bankingAppLabel.setFont(new Font ("Dialog",Font.BOLD,32));
		bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(bankingAppLabel);
		
		JLabel userNameLabel=new JLabel("UserName");
		userNameLabel.setBounds(20,120,getWidth()-30,24);
		userNameLabel.setFont(new Font ("Dialog",Font.PLAIN,20));
		add(userNameLabel);
		
		LineBorder lineBorder =new LineBorder(Color.black, 1, true);
		JTextField  userNameField=new JTextField();
		userNameField.setBounds(20,160,getWidth()-50,40);
		userNameField.setFont(new Font("Dialog",Font.PLAIN,28));
		userNameField.setBorder(lineBorder );
		add(userNameField);
		
		JLabel passwordLabel=new JLabel("Password");
		passwordLabel.setBounds(20,210,getWidth()-30,24);
		passwordLabel.setFont(new Font ("Dialog",Font.PLAIN,20));
		add(passwordLabel);
		
		JPasswordField  passwordField=new JPasswordField();
		passwordField.setBounds(20,250,getWidth()-50,40);
		passwordField.setFont(new Font("Dialog",Font.PLAIN,28));
		passwordField.setBorder(lineBorder );
		add(passwordField);
		
		
		JLabel rePasswordLabel=new JLabel("Confirm Password");
		rePasswordLabel.setBounds(20,300,getWidth()-30,24);
		rePasswordLabel.setFont(new Font ("Dialog",Font.PLAIN,20));
		add(rePasswordLabel);
		
		JPasswordField  rePasswordField=new JPasswordField();
		rePasswordField.setBounds(20,340,getWidth()-50,40);
		rePasswordField.setFont(new Font("Dialog",Font.PLAIN,28));
		rePasswordField.setBorder(lineBorder );
		add(rePasswordField);
		
		JButton  registerButton=new JButton("Register");
		registerButton.setBounds(100,430,getWidth()-200,40);
		registerButton.setFont(new Font("Dialog",Font.BOLD,28));
		registerButton.setBorder(lineBorder );
		registerButton.setHorizontalAlignment(SwingConstants.CENTER);
		add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName=userNameField.getText();
				String password=String.valueOf(passwordField.getPassword());
				String rePassword=String.valueOf(rePasswordField.getPassword());
				
			       if(validateUserInput(userName, password, rePassword)){
	                    // attempt to register the user to the database
	                    if(MyJDBC.register(userName, password)){
	                        // register success
	                        // dispose of this gui
	                        RegisterGui.this.dispose();

	                        // launch the login gui
	                        LoginGui loginGui = new LoginGui();
	                        loginGui.setVisible(true);

	                        // create a result dialog
	                        JOptionPane.showMessageDialog(loginGui, "Registered Account Successfully!");
	                    }else{
	                        // register failed
	                        JOptionPane.showMessageDialog(RegisterGui.this, "Error: Username already taken");
	                    }
	                }else{
	                    // invalid user input
	                    JOptionPane.showMessageDialog(RegisterGui.this,
	                            "Error: Username must be at least 6 characters\n" +
	                            "and/or Password must match");
	                }
			}

			
		});
		
		JLabel LoginLabel=new JLabel("<html>You Have an account?  <a  href=\"#\">Login Here</a></html>");
		LoginLabel.setBounds(7,480,getWidth()-10,24);
		LoginLabel.setFont(new Font ("Dialog",Font.PLAIN,20));
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);

		add(LoginLabel);
		
		LoginLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterGui.this.dispose();
				
				new LoginGui().setVisible(true);
			}
			
		});
			
	}
	private boolean validateUserInput (String username,String password,String rePassword ) {
		
		if (username.length()==0 || password.length()==0||rePassword.length()==0)return false;
		
		if (username.length()<6)return false;
		if(!password.equals(rePassword))return false;
		return true;
	}
	
	
}
