package com.grownited.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="city")
public class CityEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId; //pk
	private String cityname;
	private Integer stateId;// fk
	private Integer statename;
	
	public Integer getCityId() 
    {
		return cityId;
	}
	public void setCityId(Integer cityId) 
    {
		this.cityId = cityId;
	}
	public String getCityname() 
    {
		return cityname;
	}
	public void setCityname(String cityname) 
    {
		this.cityname = cityname;
	}
	public Integer getStateId() 
    {
		return stateId;
	}
	public void setStateId(Integer stateId) 
    {
		this.stateId = stateId;
	}
	public Integer getStatename() 
	{
		return statename;
	}
	public void setStatename(Integer statename) 
	{
		this.statename = statename;
	}
	
	
	

}
