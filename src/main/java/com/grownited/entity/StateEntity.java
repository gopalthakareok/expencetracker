package com.grownited.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "state")
public class StateEntity 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer stateId;//pk
   @Column(unique = true)
   private String statename;
   
   
	public Integer getStateId() 
	{
		return stateId;
	}
	public void setStateId(Integer stateId) 
	{
		this.stateId = stateId;
	}
	public String getStatename() 
	{
		return statename;
	}
	public void setStatename(String statename) 
	{
		this.statename = statename;
	}
   
}
