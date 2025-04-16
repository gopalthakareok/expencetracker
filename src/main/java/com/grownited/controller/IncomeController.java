package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.IncomeEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.IncomeRepository;


import jakarta.servlet.http.HttpSession;

@Controller
public class IncomeController 
{
	@Autowired
	IncomeRepository repositoryIncome;
	
	@Autowired
	AccountRepository repositoryAccount;
	
	
	@GetMapping("newincome")
	public String income(Model model,HttpSession session)
	{
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		List<Object[]> accountList = repositoryAccount.getAccountByUserId(userId);
		System.out.println(accountList);
		model.addAttribute("accountList",accountList);
		return "NewIncome";
		
	}
	
	@PostMapping("saveincome")
	public String saveincome(IncomeEntity entityIncome, HttpSession session) 
	{
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		entityIncome.setUserId(userId);
		System.out.println(entityIncome.getUserId());
		repositoryIncome.save(entityIncome);
		return "redirect:userlistincome";
				
	}	
		
	
	@GetMapping("listincome")
	public String listincome(Model model) 
	{
		List<Object[]> incomeList = repositoryIncome.getAllIncomes();
		model.addAttribute("incomeList", incomeList);
		return "ListIncome";
	}
	
	@GetMapping("userlistincome")
	public String userlistincome(Model model,HttpSession session) 
	{
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		List<Object[]> userincomeList = repositoryIncome.getIncomeByUserId(userId);
		model.addAttribute("userincomeList", userincomeList);
		return "UserListIncome";
	}
	
	@GetMapping("viewincome")
	public String viewincome(Model model,Integer incomeId) 
	{
		Optional<IncomeEntity> income = repositoryIncome.findById(incomeId);
		model.addAttribute("income", income.get());
		return "ViewIncome";
	}
	
	@GetMapping("editincome")
	public String editincome(Integer incomeId,Model model) 
	{
		Optional<IncomeEntity>op = repositoryIncome.findById(incomeId);
		if(op.isEmpty()) 
		{
			return "redirect:/listincome";
		}
		else 
		{
			model.addAttribute("income",op.get());
		    return "EditIncome";
	    }
	}
	
	@PostMapping("updateincome")
	public String updateincome(IncomeEntity incomeentity)
	{
		System.out.println(incomeentity.getIncomeId());
		System.out.println(incomeentity.getTitle());
		Optional<IncomeEntity>op = repositoryIncome.findById(incomeentity.getIncomeId());
		System.out.println(op.isPresent());
		
		if (op.isPresent())
		{
			IncomeEntity dbIncome= op.get();
			dbIncome.setTitle(incomeentity.getTitle());
			repositoryIncome.save(dbIncome);
			System.out.println(dbIncome.getTitle());
				
		}
		return "redirect:/listincome";
		
	}

	@GetMapping("deleteincome")
	public String deleteincome(@RequestParam Integer incomeId) 
	{
		repositoryIncome.deleteById(incomeId);
		return "redirect:listincome";
	}
	
	
}