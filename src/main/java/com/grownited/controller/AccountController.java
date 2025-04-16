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
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController 
{
	@Autowired
	AccountRepository repositoryAccount ;
	
	@Autowired
	UserRepository repositoryUser;
	
	@GetMapping("newaccount")
	public String newaccount(Model model)
	{
		
		return "NewAccount";
	}
	
	@PostMapping("saveaccount")
	public String saveaccount(AccountEntity entityAccount, HttpSession session) 
	{
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
		entityAccount.setUserId(userId);
		System.out.println(entityAccount.getUserId());
		repositoryAccount.save(entityAccount);
		return "redirect:userlistaccount";
	}
	
	
	
	@GetMapping("listaccount")
	public String listaccount(Model model) 
	{
		List<Object[]> accountList = repositoryAccount.getAllAccounts();
		model.addAttribute("accountList", accountList);
		return "ListAccount";
	}
	
	@GetMapping("userlistaccount")
	public String userlistaccount(Model model,HttpSession session) 
	{
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		List<Object[]> useraccountList = repositoryAccount.getAccountByUserId(userId);
		model.addAttribute("useraccountList", useraccountList);
		return "UserListAccount";
	}
	
	@GetMapping("viewaccount")
	public String viewaccount(Model model,Integer accountId) 
	{
		Optional<AccountEntity> account = repositoryAccount.findById(accountId);
		model.addAttribute("account", account.get());
		return "ViewAccount";
	}
	
	@GetMapping("editaccount")
	public String editaccount(Integer accountId,Model model) 
	{
		Optional<AccountEntity>op = repositoryAccount.findById(accountId);
		if(op.isEmpty()) 
		{
			return "redirect:/userlistaccount";
		}
		else 
		{
			model.addAttribute("account",op.get());
		    return "EditAccount";
	    }
	}
	
	@PostMapping("updateaccount")
	public String updateaccount(AccountEntity accountentity)
	{
		System.out.println(accountentity.getAccountId());
		System.out.println(accountentity.getAcctitle());
		Optional<AccountEntity>op = repositoryAccount.findById(accountentity.getAccountId());
		System.out.println(op.isPresent());
		
		if (op.isPresent())
		{
			AccountEntity dbAccount= op.get();
			dbAccount.setAcctitle(accountentity.getAcctitle());
			repositoryAccount.save(dbAccount);
			System.out.println(dbAccount.getAcctitle());
				
		}
		return "redirect:/userlistaccount";
		
	}
	
	@GetMapping("deleteaccount")
	public String deleteaccount(@RequestParam Integer accountId) 
	{
		repositoryAccount.deleteById(accountId);
		return "redirect:userlistaccount";	
    }
	
}