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
import com.grownited.repository.CategoryRepository;


@Controller
public class CategoryController 
{
	@Autowired
	CategoryRepository repositoryCategory;
	
	@GetMapping("newcategory")
	public String newcategory()
	{
		return "NewCategory";
	}
	
	@PostMapping("savecategory")
	public String savecity(CategoryEntity entityCategory ) 
	{
		
		repositoryCategory.save(entityCategory);
		return "redirect:listcategory";
	}
	
	@GetMapping("listcategory")
	public String listCategory(Model model) 
	{
		List<CategoryEntity> categoryList = repositoryCategory.findAll();
		model.addAttribute("categoryList", categoryList);
		return "ListCategory";
	}
	
	@GetMapping("viewcategory")
	public String viewcategory(Model model,Integer categoryId) 
	{
		Optional<CategoryEntity> category = repositoryCategory.findById(categoryId);
		model.addAttribute("category", category.get());
		return "ViewCategory";
	}
	
	@GetMapping("editcategory")
	public String editcategory(Integer categoryId,Model model) 
	{
		Optional<CategoryEntity>op = repositoryCategory.findById(categoryId);
		if(op.isEmpty()) 
		{
			return "redirect:/listcategory";
		}
		else 
		{
			model.addAttribute("category",op.get());
		    return "EditCategory";
	    }
	}
	
	@PostMapping("updatecategory")
	public String updatecategory(CategoryEntity categoryentity)
	{
		System.out.println(categoryentity.getCategoryId());
		System.out.println(categoryentity.getCategoryname());
		Optional<CategoryEntity>op = repositoryCategory.findById(categoryentity.getCategoryId());
		System.out.println(op.isPresent());
		
		if (op.isPresent())
		{
			CategoryEntity dbCategory = op.get();
			dbCategory.setCategoryname(categoryentity.getCategoryname());
			repositoryCategory.save(dbCategory);
			System.out.println(dbCategory.getCategoryname());
				
		}
		return "redirect:/liststate";
		
	}

	
	@GetMapping("deletecategory")
	public String deleteCategory(@RequestParam Integer categoryId) 
	{
		repositoryCategory.deleteById(categoryId);
		return "redirect:listcategory";
	}
}