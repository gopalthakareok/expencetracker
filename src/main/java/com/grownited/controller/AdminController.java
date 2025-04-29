package com.grownited.controller;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.IncomeRepository;
import com.grownited.repository.UserRepository;

@Controller
public class AdminController {
	
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	IncomeRepository repoIncome;
	
	@Autowired
	ExpenseRepository repoExpense;

	@GetMapping("admindashboard")
		public String adminDashboard(Model model) {
		
		
		
		Long totalUsers = repoUser.count();
		Integer totalUser = repoUser.findByRole("USER").size();
		
		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();
		
		Integer thisMonthUserCount = repoUser.countThisMonthUser(month);
		Integer thismonthTransaction = repoIncome.countThisMonthTransaction(month)+repoExpense.countThisMonthTransaction(month);
		Integer thisMonthExpense = repoExpense.sumThisMonthExpense(month);
		
		Integer monthWiseExpense [] = new Integer[12];
		for(int i=1;i<=12;i++) {
			monthWiseExpense [i-1] = repoExpense.sumThisMonthExpense(i);
		}
		
		
		model.addAttribute("totalUser",totalUser);
		model.addAttribute("thisMonthUserCount",thisMonthUserCount);
		model.addAttribute("thismonthTransaction",thismonthTransaction);
		model.addAttribute("thisMonthExpense",thisMonthExpense);
		model.addAttribute("monthWiseExpense",monthWiseExpense);
		
		return "AdminDashboard";
	}
}
