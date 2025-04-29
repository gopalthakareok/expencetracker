package com.grownited.controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserVendorController {
	@Autowired
	VendorRepository repoVendor;
	
	
	
	 @GetMapping("usernewvendor") 
	 public String userNewAccount() {
	 return"UserNewVendor"; 
	 }
	 
	
	
	@GetMapping("userlistvendor")
	public String userListVendor(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<VendorEntity> vendors = repoVendor.findByUserId(user.getUserId());
		model.addAttribute("vendorList", vendors);
		return "UserListVendor";
	}
	
	@PostMapping("usersavevendor")
	public String userSaveVendor(VendorEntity entityVendor, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		entityVendor.setUserId(user.getUserId());
		repoVendor.save(entityVendor);
		return "redirect:/userlistvendor";
	}
	
	@GetMapping("/userdeletevendor")
	public String UserDeleteVendor(Integer vendorId) {
		repoVendor.deleteById(vendorId);//delete from account where accountID = :accountId
		return "redirect:/userlistvendor";
	}
	
	@GetMapping("usereditvendor")
	public String UserEditVendor(Integer vendorId,Model model) {
		Optional<VendorEntity> op = repoVendor.findById(vendorId);
		if (op.isEmpty()) {
			return "redirect:/userlistvendor";
		} else {
			model.addAttribute("vendor",op.get());
			return "UserEditVendor";

		}
	}

	@PostMapping("userupdatevendor")
	public String UserUpdateVendor(VendorEntity entityVendor) {
		
		System.out.println(entityVendor.getVendorId());

		Optional<VendorEntity> op = repoVendor.findById(entityVendor.getVendorId());
		
		if(op.isPresent())
		{
			VendorEntity dbVendor = op.get(); 
			dbVendor.setVendorName(entityVendor.getVendorName());
			repoVendor.save(dbVendor);
		}
		return "redirect:/userlistvendor";
	}
	
}
