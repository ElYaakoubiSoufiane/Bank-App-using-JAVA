package db_objs;

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {

	private int userId;
	private String transactionType;
	private BigDecimal transactionAmount;
	private Date transactionDtae;

	public Transaction(int userId, String transactionType, BigDecimal transactionAmount, Date transactionDate) {

		this.userId = userId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.transactionDtae = transactionDate;
	}

	public int getUserId() {
		return userId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public Date getTransactionDtae() {
		return transactionDtae;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public void setTransactionDtae(Date transactionDtae) {
		this.transactionDtae = transactionDtae;
	}
}
