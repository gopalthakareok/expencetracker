package com.grownited.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.UserEntity;
import com.grownited.repository.ExpenseRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserReportController {
	
	@Autowired
	ExpenseRepository repoExpense;

	@GetMapping("userexpensereports")
	public String adminActiveUser(Model model,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<Object[]> expenses = repoExpense.getByUserId(user.getUserId());
		
		model.addAttribute("expenses", expenses);

		return "UserExpenseReports";
	}
	
	@GetMapping("usermonthlyexpensecategory")
	public String adminExpensesReports() {
		
		return "UserMonthlyExpenseCategory";
	}
	
	@PostMapping("usermonthlyexpensecategories")
	public String monthlyExpenseCategories(Model model,HttpSession session,@RequestParam("month")Integer month,@RequestParam("year")Integer year) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<Object[]> categorywiseexpenses = repoExpense.getMonthlyExpenseByCategory(user.getUserId(),month,year);
		model.addAttribute("categorywiseexpenses",categorywiseexpenses);
		model.addAttribute("month",month);
		model.addAttribute("year",year);

		return "UserMonthlyExpenseCategory";
	}
}
