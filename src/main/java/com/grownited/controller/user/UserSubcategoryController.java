package com.grownited.controller.user;

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

import jakarta.servlet.http.HttpSession;

@Controller
public class UserSubcategoryController {
	
	@Autowired
	SubcategoryRepository reposubCategory;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@GetMapping("usernewsubcategory")
	public String userNewSubcategory(Model model,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<CategoryEntity> allCategory = repoCategory.findByUserId(user.getUserId());
		model.addAttribute("allCategory", allCategory);
		return "UserNewSubCategory";
	}
	
	@GetMapping("userlistsubcategory")
	public String userListSubcategory(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<Object[]> Subcategories = reposubCategory.getByUserId(user.getUserId());
		System.out.println(user.getUserId());
		
		model.addAttribute("subcategoryList", Subcategories);
		return "UserListSubcategory";
	}
	
	@PostMapping("usersavesubcategory")
	public String userSaveSubcategory(SubcategoryEntity entitySubcategory, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		entitySubcategory.setUserId(user.getUserId());
		reposubCategory.save(entitySubcategory);
		return "redirect:/userlistsubcategory";
	}
	
	@GetMapping("/userdeletesubcategory")
	public String UserDeleteSubcategory(Integer subCategoryId) {
		reposubCategory.deleteById(subCategoryId);//delete from account where accountID = :accountId
		return "redirect:/userlistsubcategory";
	}
	
	@GetMapping("usereditsubcategory")
	public String UserEditSubcategory(Integer subCategoryId,Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<CategoryEntity> allCategory = repoCategory.findByUserId(user.getUserId());
		model.addAttribute("allCategory", allCategory);
		Optional<SubcategoryEntity> op = reposubCategory.findById(subCategoryId);
		if (op.isEmpty()) {
			return "redirect:/userlistsubcategory";
		} else {
			model.addAttribute("subcategory",op.get());
			return "UserEditSubcategory";

		}
	}

	@PostMapping("userupdatesubcategory")
	public String UserUpdateSubcategory(SubcategoryEntity entitySubcategory) {
		
		System.out.println(entitySubcategory.getSubCategoryId());

		Optional<SubcategoryEntity> op = reposubCategory.findById(entitySubcategory.getSubCategoryId());
		
		if(op.isPresent())
		{
			SubcategoryEntity dbSubcategory = op.get(); 
			dbSubcategory.setSubCategoryName(entitySubcategory.getSubCategoryName());
			dbSubcategory.setCategoryId(entitySubcategory.getCategoryId());
			reposubCategory.save(dbSubcategory);
		}
		return "redirect:/userlistsubcategory";
	}
}
