package com.grownited.controller.user;

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
import com.grownited.entity.IncomeEntity;
import com.grownited.entity.SubcategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.SubcategoryRepository;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserExpenseController {

	@Autowired
	ExpenseRepository repoExpense;
	
	@Autowired
	AccountRepository repoAccount;
	
	@Autowired
	SubcategoryRepository reposubCategory;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	VendorRepository repoVendor;
	
	@GetMapping("usernewexpense")
	public String userNewExpense(Model model,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<AccountEntity> accountList = repoAccount.findByUserId(user.getUserId());
		List<SubcategoryEntity> subcategoryList = reposubCategory.findByUserId(user.getUserId());
		List<CategoryEntity> categoryList = repoCategory.findByUserId(user.getUserId());
		List<VendorEntity> vendorList = repoVendor.findByUserId(user.getUserId());
		model.addAttribute("accountList", accountList);
		model.addAttribute("subcategoryList", subcategoryList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("vendorList", vendorList);
		return "UserNewExpense";
	}
	
	@GetMapping("userlistexpense")
	public String userListExpense(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<Object[]> expenses = repoExpense.getByUserId(user.getUserId());
		System.out.println(user.getUserId());
		
		model.addAttribute("expenses", expenses);
		return "UserListExpense";
	}
	
	@PostMapping("usersaveexpense")
	public String userSaveExpense(ExpenseEntity entityExpense, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		entityExpense.setUserId(user.getUserId());
		repoExpense.save(entityExpense);
		return "redirect:/userlistexpense";
	}
	
	@GetMapping("/userdeleteexpense")
	public String UserDeleteExpense(Integer expenseId) {
		repoExpense.deleteById(expenseId);//delete from account where accountID = :accountId
		return "redirect:/userlistexpense";
	}
	
	@GetMapping("usereditexpense")
	public String UserEditExpense(Integer expenseId,Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<AccountEntity> accountList = repoAccount.findByUserId(user.getUserId());
		List<SubcategoryEntity> subcategoryList = reposubCategory.findByUserId(user.getUserId());
		List<CategoryEntity> categoryList = repoCategory.findByUserId(user.getUserId());
		List<VendorEntity> vendorList = repoVendor.findByUserId(user.getUserId());
		model.addAttribute("accountList", accountList);
		model.addAttribute("subcategoryList", subcategoryList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("vendorList", vendorList);

		Optional<ExpenseEntity> op = repoExpense.findById(expenseId);
		if (op.isEmpty()) {
			return "redirect:/userlistexpense";
		} else {
			model.addAttribute("expense",op.get());
			return "UserEditExpense";

		}
	}

	@PostMapping("userupdateexpense")
	public String UserUpdateExpense(ExpenseEntity entityexpense) {
		
		System.out.println(entityexpense.getExpenseId());

		Optional<ExpenseEntity> op = repoExpense.findById(entityexpense.getExpenseId());
		
		if(op.isPresent())
		{
			ExpenseEntity dbExpense = op.get(); 
			dbExpense.setTitle(entityexpense.getTitle());
			dbExpense.setAmount(entityexpense.getAmount());
			dbExpense.setAccountId(entityexpense.getAccountId());
			dbExpense.setTransactionDate(entityexpense.getTransactionDate());
			dbExpense.setDescription(entityexpense.getDescription());
			dbExpense.setCategoryId(entityexpense.getCategoryId());
			dbExpense.setSubCategoryId(entityexpense.getSubCategoryId());
			dbExpense.setStatus(entityexpense.getStatus());
			dbExpense.setVendorId(entityexpense.getVendorId());

			repoExpense.save(dbExpense);
		}
		return "redirect:/userlistexpense";
	}
}
