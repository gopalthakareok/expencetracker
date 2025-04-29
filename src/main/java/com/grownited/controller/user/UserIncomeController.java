package com.grownited.controller.user;

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
public class UserIncomeController {

	@Autowired
	IncomeRepository repoIncome;
	
	@Autowired
	AccountRepository repoAccount;
	
	@Autowired
	UserRepository repoUser;
	
	@GetMapping("usernewincome")
	public String userNewIncome(Model model,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<AccountEntity> accountList = repoAccount.findByUserId(user.getUserId());
		model.addAttribute("accountList", accountList);
		return "UserNewIncome";
	}
	
	@GetMapping("userlistincome")
	public String userListIncome(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<Object[]> incomes = repoIncome.getByUserId(user.getUserId());
		System.out.println(user.getUserId());
		
		model.addAttribute("incomes", incomes);
		return "UserListIncome";
	}
	
	@PostMapping("usersaveincome")
	public String userSaveIncome(IncomeEntity entityIncome, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		entityIncome.setUserId(user.getUserId());
		repoIncome.save(entityIncome);
		return "redirect:/userlistincome";
	}
	
	@GetMapping("/userdeleteincome")
	public String UserDeleteIncome(Integer incomeId) {
		repoIncome.deleteById(incomeId);//delete from account where accountID = :accountId
		return "redirect:/userlistincome";
	}
	
	@GetMapping("usereditincome")
	public String UserEditIncome(Integer incomeId,Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<AccountEntity> accountList = repoAccount.findByUserId(user.getUserId());
		model.addAttribute("accountList", accountList);

		Optional<IncomeEntity> op = repoIncome.findById(incomeId);
		if (op.isEmpty()) {
			return "redirect:/userlistincome";
		} else {
			model.addAttribute("income",op.get());
			return "UserEditIncome";

		}
	}

	@PostMapping("userupdateincome")
	public String UserUpdateIncome(IncomeEntity entityincome) {
		
		System.out.println(entityincome.getIncomeId());

		Optional<IncomeEntity> op = repoIncome.findById(entityincome.getIncomeId());
		
		if(op.isPresent())
		{
			IncomeEntity dbIncome = op.get(); 
			dbIncome.setTitle(entityincome.getTitle());
			dbIncome.setAmount(entityincome.getAmount());
			dbIncome.setAccountId(entityincome.getAccountId());
			dbIncome.setTransactionDate(entityincome.getTransactionDate());
			dbIncome.setDescription(entityincome.getDescription());
			repoIncome.save(dbIncome);
		}
		return "redirect:/userlistincome";
	}
}
