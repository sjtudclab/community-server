package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *2015年6月27日 下午8:41:46
 *@author changyi yuan
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class TransactionTransfer {
	private String transactionId;
	private String merchantName;
	private String amount;
	private Date time;
	private String accountId;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
