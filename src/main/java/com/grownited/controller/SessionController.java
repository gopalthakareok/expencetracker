package com.grownited.controller;

import java.time.LocalDateTime;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import com.grownited.Service.MailService;

@Controller
public class SessionController 
{
	@Autowired
	MailService serviceMail;

	// signup.jsp
	@Autowired
	UserRepository repositoryUser;

	@Autowired
	PasswordEncoder encoder;
	
	
	@GetMapping("signup")
	public String signup() 
    {
       return "Signup";
    }
	
	@GetMapping("login")
	public String login() 
    {
       return "Login";
    }
	
	@GetMapping("listuser")
	public String listuser(Model model) 
	{
		
		return "ListUser";
	}
	
	@PostMapping("saveuser")
    public String saveuser(UserEntity userEntity)	
    {
		userEntity.setRole("USER");
		userEntity.setCreatedAt(LocalDateTime.now());	
		userEntity.setActive(true);
		String encPassword = encoder.encode(userEntity.getPassword());
		userEntity.setPassword(encPassword);
		repositoryUser.save(userEntity);
		serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstname());
		
		return "redirect:login";
						
    }
	
	@GetMapping("deleteuser")
	public String deleteUser(@RequestParam Integer userId) 
	{
		repositoryUser.deleteById(userId);
		return "redirect:listuser";
	}
	
	@PostMapping("sendotp")
	public String sendOtp(String email, Model model) 
	{
		// email valid
		Optional<UserEntity> op = repositoryUser.findByEmail(email);
		if (op.isEmpty()) 
		{
			// email invalid
			model.addAttribute("error", "Email not found");
			return "ForgetPassword";
		} 
		else 
		{
		
			String otp = "";
			otp = (int) (Math.random() * 1000000) + "";// 0.25875621458541

			UserEntity user = op.get();
			user.setOtp(otp);
			repositoryUser.save(user);// update otp for user
			serviceMail.sendOtpForForgetPassword(email, user.getFirstname(), otp);
			return "ChangePassword";

		}
	}
	
	
	
	@PostMapping("authenticate")
	public String authenticate(String email, String password, HttpSession session, Model model) {
	    System.out.println("Email: " + email);
	    Optional<UserEntity> op = repositoryUser.findByEmail(email);

	    if (op.isPresent()) {
	        UserEntity dbUser = op.get();
	        System.out.println("User found: " + dbUser.getEmail());
	        System.out.println("Password in DB: " + dbUser.getPassword());
	        System.out.println("Password from input: " + password);

	        boolean ans = encoder.matches(password, dbUser.getPassword());
	        System.out.println("Password Match: " + ans);

	        if (ans) {
	            session.setAttribute("user", dbUser);
	            System.out.println("Session User: " + session.getAttribute("user"));

	            if ("USER".equals(dbUser.getRole())) {
	                return "redirect:/userdashboard";
	            } else if ("ADMIN".equals(dbUser.getRole())) {
	                return "redirect:/admindashboard";
	            } else {
	                model.addAttribute("error", "Please contact Admin with Error Code #0991");
	                return "Login";
	            }
	        }
	        
	    }
	    model.addAttribute("error", "Invalid Credentials");
	    return "Login";
	}

	
	@GetMapping("Forgetpassword")
    public String forgetpassword()	
    {
		return "Forgetpassword";
    }
	
	@GetMapping("resetpassword")
    public String changepassword(String email,String password, String otp, Model model) 
	{
		Optional<UserEntity> op = repositoryUser.findByEmail(email);
		if (op.isEmpty()) 
		{
			model.addAttribute("error", "Invalid Data");
			return "Changepassword";
		} 
		else 
		{
			UserEntity user = op.get();
			if (user.getOtp().equals(otp)) 
			{
				String encPwd = encoder.encode(password);
				user.setPassword(encPwd);
				user.setOtp("");
				repositoryUser.save(user);// update
			} 
			else 
			{

				model.addAttribute("error", "Invalid Data");
				return "Changepassword";
			}
		}
		model.addAttribute("msg", "Password updated");
		return "Login";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) 
	{
		session.invalidate();
		return "redirect:login";
	}
	
	
}
	
	
	



