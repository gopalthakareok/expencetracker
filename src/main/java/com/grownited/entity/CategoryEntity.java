package com.grownited.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //create table
@Table(name="category")// create expense name set 
public class CategoryEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;// primary key
	private String categoryname;
	
	
	
	public Integer getCategoryId() 
	{
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) 
	{
		this.categoryId = categoryId;
	}
	
	
	public String getCategoryname() 
	{
		return categoryname;
	}

	public void setCategoryname(String categoryname) 
	{
		this.categoryname = categoryname;
	}

	

	
	
	
	
	
}
