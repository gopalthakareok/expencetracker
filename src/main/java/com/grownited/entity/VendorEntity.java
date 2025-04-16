package com.grownited.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //create table
@Table(name="vendor")// create table name set 
public class VendorEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vendorId;//primary key
	private String vendorname;
	private Integer userId;//fk
	
	
	
	public Integer getVendorId() 
	{
		return vendorId;
	}
	public void setVendorId(Integer vendorId) 
	{
		this.vendorId = vendorId;
	}
	public String getVendorname() 
	{
		return vendorname;
	}
	public void setVendorname(String vendorname) 
	{
		this.vendorname = vendorname;
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
