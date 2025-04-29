package com.grownited.controller.user;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.IncomeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserDashboardController {
	
	@Autowired
	ExpenseRepository repoExpense;
	
	@Autowired
	IncomeRepository repoIncome;

	@GetMapping("userdashboard")
	public String dashboard(HttpSession session, Model model) {
		
		LocalDate today = LocalDate.now();
//		int month = today.getMonthValue();
		int year = today.getYear();
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		
		Integer thisMonthExpenseOfUser = repoExpense.getCurrentMonthExpenseByUser(userId);
		Integer thisYearExpenseOfUser = repoExpense.getYearlyExpense(userId,year);
		Integer thisMonthIncomeOfUser = repoIncome.getMonthlyIncome(userId);
		Integer thisYearIncomeOfUser = repoIncome.getYearlyIncome(userId,year);
		
		Integer monthWiseExpenseOfUser [] = new Integer[12];
		for(int month=1;month<=12;month++) {
			monthWiseExpenseOfUser [month-1] = repoExpense.getCurrentMonthExpense(month,year,userId);
		}
		
		
		model.addAttribute("thisMonthExpenseOfUser",thisMonthExpenseOfUser);
		model.addAttribute("thisYearExpenseOfUser",thisYearExpenseOfUser);
		model.addAttribute("thisMonthIncomeOfUser",thisMonthIncomeOfUser);
		model.addAttribute("thisYearIncomeOfUser",thisYearIncomeOfUser);
		model.addAttribute("monthWiseExpenseOfUser",monthWiseExpenseOfUser);

		
		
		
		return "UserDashboard";
		
	}
}
