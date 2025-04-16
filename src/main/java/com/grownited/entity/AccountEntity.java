package com.grownited.entity;

import jakarta.persistence.Entity;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //create table
@Table(name="account")// create expense name set 
public class AccountEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId; //primary key
	private String acctitle;
	private Integer userId;// fk
	private Integer amount;
	
	
	public Integer getAccountId() 
	{
		return accountId;
	}
	public void setAccountId(Integer accountId) 
	{
		this.accountId = accountId;
	}
	
	public Integer getAmount() 
	{
		return amount;
	}
	public void setAmount(Integer amount) 
	{
		this.amount = amount;
	}
	
	public Integer getUserId() 
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public String getAcctitle() 
	{
		return acctitle;
	}
	public void setAcctitle(String acctitle) 
	{
		this.acctitle = acctitle;
	}
	
	
	
}
