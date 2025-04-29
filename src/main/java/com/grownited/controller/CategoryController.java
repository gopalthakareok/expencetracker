package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.CategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	UserRepository repoUser;
	
	@GetMapping("adminnewcategory")
	public String adminNewCategory(Model model) {
		List<UserEntity> userList = repoUser.findAll();
		model.addAttribute("userList", userList);
		return "AdminNewCategory";
	}
	
	@PostMapping("adminsavecategory")
	public String adminSaveCategory(CategoryEntity entityCategory,HttpSession session) {
//		UserEntity user = (UserEntity) session.getAttribute("user");
//		Integer userId = user.getUserId(); 
//		entityCategory.setUserId(userId); 
		repoCategory.save(entityCategory);
		return "redirect:/adminlistcategory";
	}
	
	@GetMapping("adminlistcategory")
	public String adminListCategory(Model model) {
		List<CategoryEntity> categoryList = repoCategory.findAll();
		//how to send data from controller to jsp 
				//Model 
				model.addAttribute("categoryList", categoryList);
								//dataName , dataValue 
		return "AdminListCategory";
	}
	
	@GetMapping("adminviewcategory")
	public String adminViewCategory(Integer categoryId, Model model) {
		System.out.println("id===>" +categoryId);
		Optional<CategoryEntity> op = repoCategory.findById(categoryId);
		if(op.isEmpty()) {
			//not found
		}
		else {
			//data found
			CategoryEntity category = op.get();
			//send data to jsp ->
			model.addAttribute("category", category);
		}
		
		return "AdminViewCategory";
	}
	
	@GetMapping("admindeletecategory")
	public String adminDeleteCategory(Integer categoryId) {
		repoCategory.deleteById(categoryId);//delete from account where accountID = :accountId
		return "redirect:/adminlistcategory";
	}
	

}
