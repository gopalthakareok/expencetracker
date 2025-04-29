package com.grownited.controller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.CategoryEntity;
import com.grownited.entity.SubcategoryEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.SubcategoryRepository;
import com.grownited.repository.VendorRepository;

@RestController
public class AjaxController {
	
	@Autowired
	AccountRepository repoAccount;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	SubcategoryRepository repoSubcategory;
	
	@Autowired
	VendorRepository repoVendor;
	
	
	@GetMapping("/getallaccountbyuserid/{userId}")
	public List<AccountEntity> getAllAccountByuserId(@PathVariable Integer userId) {
		System.out.println(userId);
		
		List<AccountEntity> allAccount  =  repoAccount.findByUserId(userId);
			
		
		return allAccount;
	}
	
	@GetMapping("/getallcategorybyuserid/{userId}")
	public List<CategoryEntity> getAllCategoryByuserId(@PathVariable Integer userId) {
		System.out.println(userId);
		
		List<CategoryEntity> allCategory  =  repoCategory.findByUserId(userId);
			
		
		return allCategory;
	}
	
	@GetMapping("/getallsubcategorybyuserid/{userId}")
	public List<SubcategoryEntity> getAllSubCategoryByuserId(@PathVariable Integer userId) {
		System.out.println(userId);
		
		List<SubcategoryEntity> allSubCategory  =  repoSubcategory.findByUserId(userId);
			
		
		return allSubCategory;
	}
	
	@GetMapping("/getallvendorbyuserid/{userId}")
	public List<VendorEntity> getAllVendorByuserId(@PathVariable Integer userId) {
		System.out.println(userId);
		
		List<VendorEntity> allVendor  =  repoVendor.findByUserId(userId);
			
		
		return allVendor;
	}

}
