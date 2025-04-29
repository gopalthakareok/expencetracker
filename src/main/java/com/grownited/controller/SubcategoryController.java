package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.entity.SubcategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.SubcategoryRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;




@Controller
public class SubcategoryController {
	
	@Autowired
	SubcategoryRepository reposubCategory;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	UserRepository repoUser;
	
	@GetMapping("adminnewsubcategory")
	public String adminNewSubcategory(Model model) {
		List<CategoryEntity> allCategory = repoCategory.findAll();
		List<UserEntity> userList = repoUser.findAll();
		model.addAttribute("userList", userList);
		model.addAttribute("allCategory", allCategory);
		return "AdminNewSubCategory";
	}
	
	@PostMapping("adminsavesubcategory")
	public String adminSavesubCategory(SubcategoryEntity entitySubcategory, HttpSession session) {
//		UserEntity user= (UserEntity) session.getAttribute("user");
//		Integer userId=user.getUserId();
//		entitySubcategory.setUserId(userId);
		reposubCategory.save(entitySubcategory);
		return "redirect:/adminlistsubcategory";
	}
	
	@GetMapping("adminlistsubcategory")
	public String adminListSubcategory(Model model) {
		List<Object[]> subCategoryList = reposubCategory.getAll();
		model.addAttribute("allsubCategory", subCategoryList);
								 
		return "AdminListSubCategory";
	}
	@GetMapping("adminviewsubcategory")
	public String adminViewSubcategory(Integer subCategoryId, Model model) {
		System.out.println("id===>" +subCategoryId);
		Optional<SubcategoryEntity> op = reposubCategory.findById(subCategoryId);
		if(op.isEmpty()) {
			//not found
		}
		else {
			//data found
			SubcategoryEntity subcategory = op.get();
			//send data to jsp ->
			model.addAttribute("subcategory", subcategory);
		}
		
		return "AdminViewSubcategory";
	}
	
	@GetMapping("admindeletesubcategory")
	public String adminDeleteSubcategory(Integer subCategoryId) {
		reposubCategory.deleteById(subCategoryId);//delete from account where accountID = :accountId
		return "redirect:/adminlistsubcategory";
	}

}
