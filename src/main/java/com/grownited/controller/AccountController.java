package com.grownited.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AccountController {
	
	@Autowired
	AccountRepository repoAccount;
	
	@Autowired
	UserRepository repoUser;

	@GetMapping("adminnewaccount")
	public String adminNewAccount(Model model) {
		List<UserEntity> userList = repoUser.findAll();
		model.addAttribute("userList", userList);
		return "AdminNewAccount";
	}
	
	@PostMapping("adminsaveaccount")
	public String adminSaveAccount(AccountEntity entityAccount, HttpSession session) {
//		UserEntity user = (UserEntity) session.getAttribute("user");
//		Integer userId = user.getUserId(); 
//		entityAccount.setUserId(userId); 
		repoAccount.save(entityAccount);
		return "redirect:/adminlistaccount";
	}
	
	@GetMapping("adminlistaccount")
	public String adminListAccount(Model model) {
		List<AccountEntity> accountList = repoAccount.findAll();
		//how to send data from controller to jsp 
				//Model 
				model.addAttribute("accountList", accountList);
								//dataName , dataValue 
		return "AdminListAccount";
	}
	
	@GetMapping("adminviewaccount")
	public String adminViewAccount(Integer accountId, Model model) {
		System.out.println("id===>" + accountId);
		Optional<AccountEntity> op = repoAccount.findById(accountId);
		if(op.isEmpty()) {
			//not found
		}
		else {
			//data found
			AccountEntity account = op.get();
			//send data to jsp ->
			model.addAttribute("account",account);
		}
		
		return "AdminViewAccount";
	}
	
	@GetMapping("admindeleteaccount")
	public String adminDeleteAccount(Integer accountId) {
		repoAccount.deleteById(accountId);//delete from account where accountID = :accountId
		return "redirect:/adminlistaccount";
	}
	
	
	
}
