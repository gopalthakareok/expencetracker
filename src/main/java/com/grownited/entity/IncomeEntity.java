package com.grownited.entity;


import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "income") // Create 'income' table
public class IncomeEntity 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer incomeId;
    private String title;
    private Integer accountId;//fk
    private Integer amount;
    private LocalDate transactiondate;
    private String description;
    private Integer userId; // fk
    
	public Integer getIncomeId() 
	{
		return incomeId;
	}
	public void setIncomeId(Integer incomeId)
	{
		this.incomeId = incomeId;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
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
	
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public Integer getUserId() 
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	

	public LocalDate getTransactiondate() 
	{
		return transactiondate;
	}
	public void setTransactiondate(LocalDate transactiondate) 
	{
		this.transactiondate = transactiondate;
	}
	
	
	
	
	
	
    
    

}