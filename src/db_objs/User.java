package db_objs;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class User {
	private final int id;
	private final String useName,password;
	private BigDecimal currentBalance;
	
	public User(int id ,String userName,String password,BigDecimal currentBalance) {
	this.id=id;
	this.useName=userName;
	this.password=password;
	this.currentBalance=currentBalance;
		
	}
	public int getId() {
		return id;
	}
	public String getUserName() {
		return useName;
	}
	public String getPassword() {
		return password;
	}
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	
	public void setCurrentBalance(   BigDecimal newBalance ) {
        currentBalance = newBalance.setScale(2, RoundingMode.FLOOR);
	}
	
}
