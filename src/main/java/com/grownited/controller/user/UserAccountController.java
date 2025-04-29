package com.grownited.controller.user;

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

import jakarta.servlet.http.HttpSession;

@Controller
public class UserAccountController {

	@Autowired
	AccountRepository repoAccount;
	
	
	
	  @GetMapping("usernewaccount")
	  public String userNewAccount() {
	  return"UserNewAccount"; 
	  }
	
	@GetMapping("userlistaccount")
	public String userListAccount(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<AccountEntity> accounts = repoAccount.findByUserId(user.getUserId());
		model.addAttribute("accountList", accounts);
		return "UserListAccount";
	}
	
	@PostMapping("usersaveaccount")
	public String userSaveAccount(AccountEntity entityAccount, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		entityAccount.setUserId(user.getUserId());
		repoAccount.save(entityAccount);
		return "redirect:/userlistaccount";
	}
	
	@GetMapping("/userdeleteaccount")
	public String UserDeleteAccount(Integer accountId) {
		repoAccount.deleteById(accountId);//delete from account where accountID = :accountId
		return "redirect:/userlistaccount";

	}
	

	@GetMapping("usereditaccount")
	public String UserEditAccount(Integer accountId,Model model) {
		Optional<AccountEntity> op = repoAccount.findById(accountId);
		if (op.isEmpty()) {
			return "redirect:/userlistaccount";
		} else {
			model.addAttribute("account",op.get());
			return "UserEditAccount";

		}
	}
	//save -> entity -> no id present -> insert 
	//save -> entity -> id present -> not present in db -> insert 
	//save -> entity -> id present -> present in db -> update  

	@PostMapping("userupdateaccount")
	public String UserUpdateAccount(AccountEntity entityAccount) {
		
		System.out.println(entityAccount.getAccountId());

		Optional<AccountEntity> op = repoAccount.findById(entityAccount.getAccountId());
		
		if(op.isPresent())
		{
			AccountEntity dbAccount = op.get(); 
			dbAccount.setTitle(entityAccount.getTitle());
			dbAccount.setAmount(entityAccount.getAmount());
			dbAccount.setDescription(entityAccount.getDescription());
			repoAccount.save(dbAccount);
		}
		return "redirect:/userlistaccount";
	}
	

}
