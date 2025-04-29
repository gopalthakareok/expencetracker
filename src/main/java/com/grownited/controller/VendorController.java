package com.grownited.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class VendorController {

	@Autowired
	VendorRepository repoVendor;
	
	@Autowired
	UserRepository repoUser;
	
	@GetMapping("adminnewvendor")
	public String adminNewVandor(Model model) {
		List<UserEntity> userList = repoUser.findAll();
		model.addAttribute("userList", userList);
		return "AdminNewVendor";
	}
	
	@PostMapping("adminsavevendor")
	public String adminSaveVendor(VendorEntity entityVendor, HttpSession session) {
//		UserEntity user = (UserEntity) session.getAttribute("user");
//		Integer userId = user.getUserId(); 
//		entityVendor.setUserId(userId); 
		repoVendor.save(entityVendor);
		return "redirect:/adminlistvendor";
	}
	
	@GetMapping("adminlistvendor")
	public String adminListVendor(Model model) {
		List<VendorEntity> vendorList = repoVendor.findAll();
		model.addAttribute("vendorList", vendorList);
								 
		return "AdminListVendor";
	}
	
	@GetMapping("admindeletevendor")
	public String adminDeleteVendor(Integer vendorId) {
		repoVendor.deleteById(vendorId);//delete from account where accountID = :accountId
		return "redirect:/adminlistvendor";
	}
}
