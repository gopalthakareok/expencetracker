package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.CategoryEntity;
import com.grownited.entity.ExpenseEntity;
import com.grownited.entity.SubcategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.SubcategoryRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseRepository repoExpense;
	
	@Autowired
	AccountRepository repoAccount;

	@Autowired
	UserRepository repoUser;
	
	@Autowired
	SubcategoryRepository reposubCategory;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	VendorRepository repoVendor;
	
	
	
	@GetMapping("adminnewexpense")
	public String adminNewExpense(Model model) {
		List<AccountEntity> accountList = repoAccount.findAll();
		List<UserEntity> userList = repoUser.findAll();
		List<SubcategoryEntity> subcategoryList = reposubCategory.findAll();
		List<CategoryEntity> categoryList = repoCategory.findAll();
		List<VendorEntity> vendorList = repoVendor.findAll();
		model.addAttribute("accountList", accountList);
		model.addAttribute("userList", userList);
		model.addAttribute("subcategoryList", subcategoryList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("vendorList", vendorList);
		return "AdminNewExpense";
	}
	
	@PostMapping("adminsaveexpense")
	public String adminSaveExpense(ExpenseEntity entityExpense, HttpSession session) {
//		UserEntity user = (UserEntity) session.getAttribute("user");
//		Integer userId = user.getUserId(); 
//		entityExpense.setUserId(userId); 
		repoExpense.save(entityExpense);
		return "redirect:/adminlistexpense";
	}
	
	@GetMapping("adminlistexpense")
	public String adminListExpense(Model model) {
		List<Object[]> expenseList = repoExpense.getAll();
		model.addAttribute("expenseList", expenseList);
		return "AdminListExpense";
	}
	
	@GetMapping("adminviewexpense")
	public String adminViewExpense(Integer expenseId, Model model) {
		System.out.println("id===>" +expenseId);
		Optional<ExpenseEntity> op = repoExpense.findById(expenseId);
		if(op.isEmpty()) {
			//not found
		}
		else {
			//data found
			ExpenseEntity expense = op.get();
			//send data to jsp ->
			model.addAttribute("expense", expense);
		}
		
		return "AdminViewExpense";
	}
	
	@GetMapping("admindeleteexpense")
	public String admindeleteExpense(Integer expenseId) {
		repoExpense.deleteById(expenseId);//delete from account where accountID = :accountId
		return "redirect:/adminlistexpense";
	}

}
