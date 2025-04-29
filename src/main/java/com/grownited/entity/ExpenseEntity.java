package com.grownited.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="expense")
public class ExpenseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expenseId;
	private String title;
	private Integer categoryId;//FK
	private Integer subCategoryId;//FK
	private Integer vendorId;
	private Integer accountId;
//	@Enumerated(EnumType.STRING)
	private String status;
	private Double Amount;
	@Temporal(TemporalType.DATE)
	private Date transactionDate;
	private String description;
	private Integer userId;//FK
	
	
	
	
	public Integer getExpenseId() {
		return expenseId;
	}




	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public Integer getCategoryId() {
		return categoryId;
	}




	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}




	public Integer getSubCategoryId() {
		return subCategoryId;
	}




	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}




	public Integer getVendorId() {
		return vendorId;
	}




	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}




	public Integer getAccountId() {
		return accountId;
	}




	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}



	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public Double getAmount() {
		return Amount;
	}




	public void setAmount(Double amount) {
		Amount = amount;
	}




	public Date getTransactionDate() {
		return transactionDate;
	}




	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Integer getUserId() {
		return userId;
	}




	public void setUserId(Integer userId) {
		this.userId = userId;
	}




//	public enum Status{
//		PENDING,APPROVED,REJECTED
//	}
	
}
