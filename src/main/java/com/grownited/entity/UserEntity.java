package com.grownited.entity;




import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //create table
@Table(name="users")// create table name set 
public class UserEntity 
{     
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer userId;// primary key 
	 private String firstname;
     private String lastname;
     @Column(unique = true)
     private String email;
     private String password;
     private String contactno;
     private String gender;
     private String otp; 
     private String role;
     private LocalDateTime createdAt;
     private Boolean active;  
     
     
     
	public String getFirstname() 
	{
		return firstname;
	}
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	
	public Integer getUserId() 
	{
		return userId;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}
	public String getLastname() 
	{
		return lastname;
	}
	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}
	public String getEmail() 
    {
		return email;
	}
	public void setEmail(String email) 
    {
		this.email = email;
	}
	public String getPassword() 
    {
		return password;
	}
	public void setPassword(String password) 
    {
		this.password = password;
	}
	public String getContactno() 
    {
		return contactno;
	}
	public void setContactno(String contactno) 
    {
		this.contactno = contactno;
	}
	public String getGender() 
    {
		return gender;
	}
	public void setGender(String gender) 
    {
		this.gender = gender;
	}
		
    
	public String getRole() 
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	public Boolean getActive() 
	{
		return active;
	}
	
	public void setActive(Boolean active) 
	{
		this.active = active;
	}
	public LocalDateTime getCreatedAt() 
	{
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) 
	{
		this.createdAt = createdAt;
	}
	
	public String getOtp() 
	{
		return otp;
	}
	public void setOtp(String otp) 
	{
		this.otp = otp;
	}
	
	
	
	
	
	
	
}
          
     
     
       
     

