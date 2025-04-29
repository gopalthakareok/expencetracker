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

import jakarta.servlet.http.HttpSession;

@Controller

public class SessionController {
	
	@Autowired
	MailService serviceMail;
	
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	Cloudinary cloudinary;
  
	@GetMapping(value= {"signup","/"})
	public String signup() {
		return "Signup"; //jsp name
	}

	@GetMapping("login")
	public String login(String email, String password) {
		return "Login"; //jsp name	
	}
	
	@PostMapping("saveuser")
	public String saveUser(UserEntity userEntity,MultipartFile profilePic) {
		
		System.out.println(profilePic.getOriginalFilename());// file name
		// cloud->
		
		if(profilePic.getOriginalFilename().endsWith(".png") || profilePic.getOriginalFilename().endsWith(".jpg") || profilePic.getOriginalFilename().endsWith(".jpeg") ) {
			
		}else {
			//
			//model 
			return "Signup";
		}
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
				
				userEntity.setRole("USER");
				userEntity.setActive(true);
				repoUser.save(userEntity);
				
				//send mail
				serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());
		return "Login";
	}
	
	
	// open forgetpassword jsp
	@GetMapping("/forgetpassword")
	public String forgetpasssword() {
		return "Forgetpassword"; //jsp name	
	}
	
	// submit on forgetpassword ->
	@PostMapping("sendOtp")
	public String sendOtp(String email, Model model) {
		//email valid
		Optional<UserEntity> op = repoUser.findByEmail(email);
		if(op.isEmpty()) {
			//email invalid
			model.addAttribute("error","Email not found");
			return "Forgetpassword";
		}else {
			// email valid
		    // send mail otp
			// opt generate
		    // send mail otp
			String otp = "";
			otp=(int)(Math.random()*1000000)+"";// 0.25875621458541
			UserEntity user = op.get();
			user.setOtp(otp);
			repoUser.save(user);
			serviceMail.sendOtpForForgetPassword(email, user.getFirstName(), otp);
			return "ChangePassword"; //jsp name	

		}
	}
	
	@PostMapping("updatepassword")
	public String updatePassword(String email, String password, String otp, Model model) {
		Optional<UserEntity> op = repoUser.findByEmail(email);
		if (op.isEmpty()) {
			model.addAttribute("error", "Invalid Data");
			return "ChangePassword";
		} else {
			UserEntity user = op.get();
			if (user.getOtp().equals(otp)) {
				String encPwd = encoder.encode(password);
				user.setPassword(encPwd);
				user.setOtp("");
				repoUser.save(user);// update
			} else {

				model.addAttribute("error", "Invalid Data");
				return "ChangePassword";
			}
		}
		model.addAttribute("msg", "Password updated");
		return "Login";
	}
	
	@PostMapping("authenticate")
	public String authenticate(String email, String password, Model model, HttpSession session) {// sakira@yopmail.com
																									// sakira
		System.out.println(email);
		System.out.println(password);

		// users -> email,password
		Optional<UserEntity> op = repoUser.findByEmail(email);
		// select * from users where email = :email and password = :password
		if (op.isPresent()) {
			// true
			// email
			UserEntity dbUser = op.get();
			boolean ans = encoder.matches(password, dbUser.getPassword());

			if (ans == true) {
				session.setAttribute("user", dbUser); // session -> user set
				System.out.println(dbUser.getUserId());
				if (dbUser.getRole().equals("ADMIN")) {

					return "redirect:/admindashboard";
				} else if (dbUser.getRole().equals("USER")) {

					return "redirect:/userdashboard";
				} else {
					model.addAttribute("error", "Please contact Admin with Error Code #0991");
					return "Login";
				}

			}
		}
		model.addAttribute("error", "Invalid Credentials");
		return "Login";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";// login url
	}

	
//	@GetMapping("listuser")
//	public String listUser(Model model) {
//		List<UserEntity> userList = repoUser.findAll();
//		model.addAttribute("userList", userList);
//		return "ListUser";
//	}
//	
//	
//	@GetMapping("viewuser")
//	public String ViewUser(Integer userId, Model model) {
//		System.out.println("id===>" +userId);
//		Optional<UserEntity> op = repoUser.findById(userId);
//		if(op.isEmpty()) {
//			//not found
//		}
//		else {
//			//data found
//			UserEntity user = op.get();
//			//send data to jsp ->
//			model.addAttribute("user", user);
//		}
//		
//		return "ViewUser";
//	}
//	
//	@GetMapping("deleteuser")
//	public String deleteUser(Integer userId) {
//		repoUser.deleteById(userId);//delete from account where accountID = :accountId
//		return "redirect:/listuser";
//	}

}
