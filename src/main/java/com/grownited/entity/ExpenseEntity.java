package com.grownited.entity;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //create table
@Table(name="expense")// create expense name set 
public class ExpenseEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expenseId; //pk
	private String exptitle;
	private Integer categoryId;//fk
	private Integer subcategoryId;//fk
	private Integer vendorId;//fk
	private Integer accountId;//fk
	private Integer amount;
	private LocalDate transactiondate;
	private String description;
	private Integer userId; // fk
	
	public Integer getExpenseId() 
	{
		return expenseId;
	}
	public void setExpenseId(Integer expenseId) 
	{
		this.expenseId = expenseId;
	}
	
	public String getExptitle() 
	{
		return exptitle;
	}
	public void setExptitle(String exptitle) 
	{
		this.exptitle = exptitle;
	}
		
	public Integer getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) 
	{
		this.categoryId = categoryId;
	}
	
	public Integer getSubcategoryId() 
	{
		return subcategoryId;
	}
	public void setSubcategoryId(Integer subcategoryId) 
	{
		this.subcategoryId = subcategoryId;
	}
	
	public Integer getVendorId() 
	{
		return vendorId;
	}
	public void setVendorId(Integer vendorId) 
	{
		this.vendorId = vendorId;
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
			
	public LocalDate getTransactiondate() 
	{
		return transactiondate;
	}
	public void setTransactiondate(LocalDate transactiondate) 
	{
		this.transactiondate = transactiondate;
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
	
	
	
	
    
}