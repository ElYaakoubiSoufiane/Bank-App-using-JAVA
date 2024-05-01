package guis;
import javax.swing.*;
import db_objs.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BankingAppGui extends BaseFrame implements ActionListener{

	private JTextField currentBalanceField;
	public JTextField getCurrentBalanceField() {
		return currentBalanceField;
	}
	public BankingAppGui(User user) {
		super("S-BANK APP",user);
	}
	

	@Override
	protected void addGuiComponents() {
		
		
		
		
		String welcomeMessage="<html>"+"<body style='text-align:center'"+"<b>Hello Mr/MMe "+user.getUserName()+"<b><br>"+
								"what would you like to do today?</body><html>";
		
		JLabel welcomeMessageLabel=new JLabel(welcomeMessage);
		welcomeMessageLabel.setBounds(0,20,getWidth()-10,40);
		welcomeMessageLabel.setFont(new Font("Dialog",Font.PLAIN,16));
		welcomeMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(welcomeMessageLabel);

		JLabel currentBalanceLabel=new JLabel("Current Balance");
		currentBalanceLabel.setBounds(0,80,getWidth()-10,30);
		currentBalanceLabel.setFont(new Font("Dialog",Font.BOLD,22));
		currentBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(currentBalanceLabel);
		
		currentBalanceField=new JTextField("$"+user.getCurrentBalance());
		currentBalanceField.setBounds(15,120,getWidth()-50,40);
		currentBalanceField.setFont(new Font("Dialog",Font.BOLD,28));
		currentBalanceField.setHorizontalAlignment(SwingConstants.RIGHT);
		currentBalanceField.setEditable(false);
		add(currentBalanceField);	
		JButton depositButton =new JButton("Deposit");
		depositButton.setBounds(20,170,getWidth()-70,40);
		depositButton.setFont(new Font("Dialog",Font.BOLD,28));
		depositButton.setHorizontalAlignment(SwingConstants.CENTER);
		depositButton.setBackground(Color.yellow);
		depositButton.addActionListener(this);
		add(depositButton);
		JButton withdrawButton =new JButton("Withdraw");
		withdrawButton.setBounds(20,215,getWidth()-70,40);
		withdrawButton.setFont(new Font("Dialog",Font.BOLD,28));
		withdrawButton.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawButton.setBackground(Color.yellow);
		withdrawButton.addActionListener(this);

		add(withdrawButton);
		JButton postTransactionButton =new JButton("Post Transaction");
		postTransactionButton.setBounds(20,260,getWidth()-70,40);
		postTransactionButton.setFont(new Font("Dialog",Font.BOLD,28));
		postTransactionButton.setHorizontalAlignment(SwingConstants.CENTER);
		postTransactionButton.setBackground(Color.yellow);
		postTransactionButton.addActionListener(this);

		add(postTransactionButton);
		JButton transactionButton =new JButton("Transfer");
		transactionButton.setBounds(20,305,getWidth()-70,40);
		transactionButton.setFont(new Font("Dialog",Font.BOLD,28));
		transactionButton.setHorizontalAlignment(SwingConstants.CENTER);
		transactionButton.setBackground(Color.yellow);
		transactionButton.addActionListener(this);

		add(transactionButton);
		
		JButton logoutButton=new JButton("Logout");
		logoutButton.setBounds(80,405,getWidth()-200,40);
		logoutButton.setFont(new Font("Dialog",Font.BOLD,28));
		logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
		logoutButton.setBackground(Color.DARK_GRAY);
		logoutButton.setForeground(Color.white);
		logoutButton.addActionListener(this);

		add(logoutButton);
		
		
	}
	
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		String buttonPressed =e.getActionCommand();
		if (buttonPressed.equalsIgnoreCase("Logout")) {
			new LoginGui().setVisible(true);
			this.dispose();
			return;
		}
		
		BankingAppDialog bankingAppDialog=new BankingAppDialog(this,user);
		bankingAppDialog.setTitle(buttonPressed);
		
		
		if(buttonPressed.equalsIgnoreCase("Deposit")||buttonPressed.equalsIgnoreCase("Withdraw")||buttonPressed.equalsIgnoreCase("Transfer")) {
			
			bankingAppDialog.addCurrentBalanceAndAmount();
			
			bankingAppDialog.addActionButton(buttonPressed);
			bankingAppDialog.setVisible(true);
			
			if(buttonPressed.equalsIgnoreCase("Transfer")) {
                bankingAppDialog.addUserField();

			}
		 }else if(buttonPressed.equalsIgnoreCase("Past Transaction")){
            bankingAppDialog.addPastTransactionComponents();
        }
        bankingAppDialog.setVisible(true);

		
	}
}
