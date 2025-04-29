package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.IncomeEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.IncomeRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class IncomeController {

	
	@Autowired
	IncomeRepository repoIncome;
	
	@Autowired
	AccountRepository repoAccount;
	
	@Autowired
	UserRepository repoUser;
	
	@GetMapping("adminnewincome")
	public String adminNewIncome(Model model) {
		List<AccountEntity> accountList = repoAccount.findAll();
		List<UserEntity> userList = repoUser.findAll();
		model.addAttribute("accountList", accountList);
		model.addAttribute("userList", userList);
		return "AdminNewIncome";
	}
	
	@PostMapping("adminsaveincome")
	public String adminSaveIncome(IncomeEntity entityIncome, HttpSession session) {
//		UserEntity user = (UserEntity) session.getAttribute("user");
//		Integer userId = user.getUserId(); 
//		entityIncome.setUserId(userId); 
		repoIncome.save(entityIncome);
		return "redirect:/adminlistincome";
	}
	
	@GetMapping("adminlistincome")
	public String adminListIncome(Model model) {
		List<Object[]> incomeList = repoIncome.getAll();
		model.addAttribute("incomeList", incomeList);
		return "AdminListIncome";
	}
	
	@GetMapping("adminviewincome")
	public String adminViewIncome(Integer incomeId, Model model) {
		System.out.println("id===>" +incomeId);
		Optional<IncomeEntity> op = repoIncome.findById(incomeId);
		if(op.isEmpty()) {
			//not found
		}
		else {
			//data found
			IncomeEntity income = op.get();
			//send data to jsp ->
			model.addAttribute("income", income);
		}
		
		return "AdminViewIncome";
	}
	
	@GetMapping("admindeleteincome")
	public String adminDeleteIncome(Integer incomeId) {
		repoIncome.deleteById(incomeId);//delete from account where accountID = :accountId
		return "redirect:/adminlistincome";
	}
	

}
