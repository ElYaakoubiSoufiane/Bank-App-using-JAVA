package guis;

import guis.BankingAppGui;
import java.math.BigDecimal;

import javax.swing.*;

import db_objs.User;



public class AppLauncher {
	public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
			//new LoginGui().setVisible(true);
	          //new RegisterGui().setVisible(true); 	
		new BankingAppGui(new User(1,"ELyaakoubi","password",new BigDecimal("20.00"))).setVisible(true);
		}
	});
	
}
}
