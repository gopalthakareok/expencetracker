package com.grownited.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.CategoryEntity;
import com.grownited.entity.ExpenseEntity;
import com.grownited.entity.SubcategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.SubcategoryRepository;

import jakarta.servlet.http.HttpSession;




@Controller
public class ExpenseController 
{
	@Autowired
	ExpenseRepository repositoryExpense;
	
	@Autowired
	CategoryRepository repositoryCategory;
	
	@Autowired
	SubcategoryRepository repositorySubcategory;
	
	@Autowired
	AccountRepository repositoryAccount;
	
	@GetMapping("newexpense")
	public String newexpense(Model model)
	{
		List<CategoryEntity> categoryList = repositoryCategory.findAll();
		model.addAttribute("categoryList",categoryList);
		
		List<SubcategoryEntity> subcategoryList = repositorySubcategory.findAll();
		model.addAttribute("subcategoryList",subcategoryList);
		
		List<AccountEntity> accountList = repositoryAccount.findAll();
		model.addAttribute("accountList",accountList);
		return "NewExpense";
	}
	
	@PostMapping("saveexpense")
	public String saveexpense(ExpenseEntity entityExpense,  HttpSession session) 
	{
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		entityExpense.setUserId(userId);
		
		repositoryExpense.save(entityExpense);
		return "redirect:userlistexpense";
	}
	
	@GetMapping("listexpense")
	public String userlistexpense(Model model) 
	{
		List<Object[]> expenseList = repositoryExpense.getAllExpenses();
		model.addAttribute("expenseList", expenseList);
		return "ListExpense";
	}
	
	@GetMapping("userlistexpense")
	public String userlistExpense(Model model,HttpSession session) 
	{
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		List<Object[]> userexpenseList = repositoryExpense.getExpenseByUserId(userId);
		System.out.println(userexpenseList);
		model.addAttribute("userexpenseList", userexpenseList);
		return "UserListExpense";
	}
	
	@GetMapping("viewexpense")
	public String viewexpense(Model model,Integer expenseId) 
	{
		Optional<ExpenseEntity> expense = repositoryExpense.findById(expenseId);
		model.addAttribute("expense", expense.get());
		return "ViewExpense";
	}
	
	@GetMapping("editexpense")
	public String editexpense(Integer expenseId,Model model) 
	{
		Optional<ExpenseEntity>op = repositoryExpense.findById(expenseId);
		if(op.isEmpty()) 
		{
			return "redirect:/listexpense";
		}
		else 
		{
			model.addAttribute("expense",op.get());
		    return "EditExpense";
	    }
	}
	
	
	@PostMapping("updateexpense")
	public String updateexpense(ExpenseEntity expenseentity)
	{
		System.out.println(expenseentity.getExpenseId());
		System.out.println(expenseentity.getExptitle());
		Optional<ExpenseEntity>op = repositoryExpense.findById(expenseentity.getExpenseId());
		System.out.println(op.isPresent());
		
		if (op.isPresent())
		{
			ExpenseEntity dbExpense = op.get();
			dbExpense.setExptitle(expenseentity.getExptitle());
			repositoryExpense.save(dbExpense);
			System.out.println(dbExpense.getExptitle());
				
		}
		return "redirect:/userlistexpense";
		
	}
	
	@GetMapping("deleteexpense")
	public String deleteexpense(@RequestParam Integer expenseId) 
	{
		repositoryExpense.deleteById(expenseId);
		return "redirect:userlistexpense";
	}
}