package com.grownited.controller.user;

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

import jakarta.servlet.http.HttpSession;

@Controller
public class UserCategoryController {

	@Autowired
	CategoryRepository repoCategory;
	
	
	
	 @GetMapping("usernewcategory") 
	 public String userNewAccount() {
	  return"UserNewCategory"; 
	  }
	 	
	@GetMapping("userlistcategory")
	public String userListCategory(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<CategoryEntity> categories = repoCategory.findByUserId(user.getUserId());
		model.addAttribute("categoryList", categories);
		return "UserListCategory";
	}
	
	@PostMapping("usersavecategory")
	public String userSaveCategoryt(CategoryEntity entityCategory, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		entityCategory.setUserId(user.getUserId());
		repoCategory.save(entityCategory);
		return "redirect:/userlistcategory";
	}
	
	@GetMapping("/userdeletecategory")
	public String UserDeleteCategory(Integer categoryId) {
		repoCategory.deleteById(categoryId);//delete from account where accountID = :accountId
		return "redirect:/userlistcategory";
	}
	
	@GetMapping("usereditcategory")
	public String UserEditCategory(Integer categoryId,Model model) {
		Optional<CategoryEntity> op = repoCategory.findById(categoryId);
		if (op.isEmpty()) {
			return "redirect:/userlistcategory";
		} else {
			model.addAttribute("category",op.get());
			return "UserEditCategory";

		}
	}

	@PostMapping("userupdatecategory")
	public String UserUpdateCategory(CategoryEntity entityCategory) {
		
		System.out.println(entityCategory.getCategoryId());

		Optional<CategoryEntity> op = repoCategory.findById(entityCategory.getCategoryId());
		
		if(op.isPresent())
		{
			CategoryEntity dbCategory = op.get(); 
			dbCategory.setCategoryName(entityCategory.getCategoryName());
			repoCategory.save(dbCategory);
		}
		return "redirect:/userlistcategory";
	}
	
}
