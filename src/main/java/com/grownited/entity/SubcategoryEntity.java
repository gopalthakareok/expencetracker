package com.grownited.entity;

import jakarta.persistence.Entity;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subcategory")
public class SubcategoryEntity
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer subcategoryId; // primary key
   private String subcategoryname;
   private Integer categoryId; // fk
   private String categoryname;
   
	public Integer getSubcategoryId() 
	{
		return subcategoryId;
	}
	public void setSubcategoryId(Integer subcategoryId) 
	{
		this.subcategoryId = subcategoryId;
	}	

	public String getSubcategoryname() 
	{
		return subcategoryname;
	}
	public void setSubcategoryname(String subcategoryname) 
	{
		this.subcategoryname = subcategoryname;
	}
	
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
