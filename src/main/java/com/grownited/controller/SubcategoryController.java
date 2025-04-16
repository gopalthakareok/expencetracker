package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.grownited.entity.CategoryEntity;
import com.grownited.entity.SubcategoryEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.SubcategoryRepository;



@Controller
public class SubcategoryController 
{
	@Autowired
	SubcategoryRepository repositorySubcategory ;
	
	@Autowired
	CategoryRepository repositoryCategory ;
	
	
	@GetMapping("newsubcategory")
	public String newsubcategory(Model model)
	{
		List<CategoryEntity> categoryList = repositoryCategory.findAll();
		model.addAttribute("categoryList", categoryList);
		return "NewSubcategory";
	}
	
	@PostMapping("savesubcategory")
	public String savesubcategory(SubcategoryEntity entitySubcategory) 
	{
		
		repositorySubcategory.save(entitySubcategory);
		return "redirect:listsubcategory";
	}
	
	@GetMapping("viewsubcategory")
	public String viewsubcategory(Model model,Integer subcategoryId) 
	{
		Optional<SubcategoryEntity> subcategory = repositorySubcategory.findById(subcategoryId);
		model.addAttribute("subcategory", subcategory.get());
		return "ViewSubcategory";
	}
	

	@GetMapping("listsubcategory")
	public String listSubcategory(Model model) 
	{
		List<Object[]> subcategoryList = repositorySubcategory.getAllSubcategories();
		model.addAttribute("subcategoryList", subcategoryList);
		return "ListSubcategory";
	}
	
	
	@GetMapping("editsubcategory")
	public String editsubcategory(Integer subcategoryId,Model model) 
	{
		Optional<SubcategoryEntity>op = repositorySubcategory.findById(subcategoryId);
		if(op.isEmpty()) 
		{
			return "redirect:/listsubcategory";
		}
		else 
		{
			model.addAttribute("subcategory",op.get());
		    return "EditSubcategory";
	    }
	}
	
	@PostMapping("updatesubcategory")
	public String updatesubcategory(SubcategoryEntity subcategoryentity)
	{
		System.out.println(subcategoryentity.getSubcategoryId());
		System.out.println(subcategoryentity.getSubcategoryname());
		Optional<SubcategoryEntity>op = repositorySubcategory.findById(subcategoryentity.getSubcategoryId());
		System.out.println(op.isPresent());
		
		if (op.isPresent())
		{
			SubcategoryEntity dbSubcategory= op.get();
			dbSubcategory.setSubcategoryname(subcategoryentity.getSubcategoryname());
			repositorySubcategory.save(dbSubcategory);
			System.out.println(dbSubcategory.getSubcategoryname());
				
		}
		return "redirect:/listsubcategory";
		
	}

	@GetMapping("deletesubcategory")
	public String deleteSubcategory(@RequestParam Integer subcategoryId) 
	{
		repositorySubcategory.deleteById(subcategoryId);
		return "redirect:listsubcategory";
	}
}
