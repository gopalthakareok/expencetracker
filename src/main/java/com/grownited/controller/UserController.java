package com.grownited.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import com.grownited.service.MailService;

@Controller
public class UserController {
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	Cloudinary cloudinary;

	@Autowired
	MailService serviceMail;
	

	
	@GetMapping("adminnewuser")
	public String adminNewUser (Model model) {
		return "AdminNewUser";
	}
	
	@PostMapping("adminsaveperson")
	public String adminSavePerson(UserEntity userEntity,MultipartFile profilePic) {
		
		System.out.println(profilePic.getOriginalFilename());// file name
		// cloud->
		
//		if(profilePic.getOriginalFilename().endsWith(".png") ) {
//			
//		}else {
//			//
//			//model 
//			return "AdminNewUser";
//		}
		try {
			Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
			//System.out.println(result);
			//System.out.println(result.get("url"));
			userEntity.setProfilePicPath(result.get("url").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				LocalDate today = LocalDate.now();
				userEntity.setCreatedAt(today);
		
				String encPassword = encoder.encode(userEntity.getPassword());
				userEntity.setPassword(encPassword);
				
				userEntity.setActive(true);
				repoUser.save(userEntity);
				
				
				//send mail
				serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());
		return "redirect:/adminlistuser";
	}
		
		@GetMapping("adminlistuser")
		public String adminListUser(Model model) {
			List<UserEntity> userList = repoUser.findAll();
			model.addAttribute("userList", userList);
			return "AdminListUser";
		}
		
		
		@GetMapping("adminviewuser")
		public String adminViewUser(Integer userId, Model model) {
			System.out.println("id===>" +userId);
			Optional<UserEntity> op = repoUser.findById(userId);
			if(op.isEmpty()) {
				//not found
			}
			else {
				//data found
				UserEntity user = op.get();
				//send data to jsp ->
				model.addAttribute("user", user);
			}
			
			return "AdminViewUser";
		}
		
		@GetMapping("admindeleteuser")
		public String adminDeleteUser(Integer userId) {
			repoUser.deleteById(userId);//delete from account where accountID = :accountId
			return "redirect:/adminlistuser";
		
	}
}
