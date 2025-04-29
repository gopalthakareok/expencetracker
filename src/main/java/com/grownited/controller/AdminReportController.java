package com.grownited.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.UserEntity;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.UserRepository;

@Controller
public class AdminReportController {
	
	@Autowired 
	UserRepository repoUser;
	
	@Autowired
	ExpenseRepository repoExpense;

	@GetMapping("adminactiveuser")
	public String adminActiveUser(Model model) {
		List<UserEntity> users = repoUser.findByRoleAndActive("USER", true);
		model.addAttribute("userList",users);
		return "AdminActiveUser";
	}
	
	@GetMapping("adminexpensesreports")
	public String adminExpensesReports() {
		
		return "AdminExpensesReports";
	}
	
	@PostMapping("adminexpensereport")
    public String generateExpenseReport(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                        @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                        Model model) {

        List<Object[]> reportData = repoExpense.getExpenseDistributionByUsers(startDate, endDate);

        model.addAttribute("reportData", reportData);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "AdminExpensesReports"; // JSP page name
    }
}
