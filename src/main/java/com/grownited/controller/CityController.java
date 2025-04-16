package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;


@Controller
public class CityController 
{
	@Autowired
	CityRepository repositoryCity;
	
	@Autowired
	StateRepository repositoryState;

	
	@GetMapping("newcity")
	public String newstate(Model model)
	{
		List<StateEntity> stateList =repositoryState.findAll();
		model.addAttribute("stateList",stateList);
		return "NewCity";
	}
	
	@PostMapping("savecity")
	public String savecity(CityEntity entityCity) 
	{
		repositoryCity.save(entityCity);
		return "redirect:listcity";
	}
	
	@GetMapping("listcity")
	public String listcity(Model model) 
	{
		List<Object[]> cityList = repositoryCity.getAllCities();
		model.addAttribute("cityList", cityList);
		return "ListCity";
	}
	
	@GetMapping("viewcity")
	public String viewcity(Model model,Integer cityId) 
	{
		Optional<CityEntity> city = repositoryCity.findById(cityId);
		model.addAttribute("subcategory", city.get());
		return "ViewCity";
	}
	
	@GetMapping("editcity")
	public String editcity(Integer cityId,Model model) 
	{
		Optional<CityEntity>op = repositoryCity.findById(cityId);
		if(op.isEmpty()) 
		{
			return "redirect:/listcity";
		}
		else 
		{
			model.addAttribute("city",op.get());
		    return "EditCity";
	    }
	}
	
	@PostMapping("updatecity")
	public String updatecity(CityEntity cityentity)
	{
		System.out.println(cityentity.getCityId());
		System.out.println(cityentity.getCityname());
		Optional<CityEntity>op = repositoryCity.findById(cityentity.getCityId());
		System.out.println(op.isPresent());
		
		if (op.isPresent())
		{
			CityEntity dbCity= op.get();
			dbCity.setCityname(cityentity.getCityname());
			repositoryCity.save(dbCity);
			System.out.println(dbCity.getCityname());
				
		}
		return "redirect:/listcity";
		
	}

	@GetMapping("deletecity")
	public String deleteCity(@RequestParam Integer cityId) 
	{
		repositoryCity.deleteById(cityId);
		return "redirect:listcity";
	}
	
	
}
