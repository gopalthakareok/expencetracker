package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;



@Controller
public class VendorController 
{
	@Autowired
	VendorRepository repositoryVendor;
	
	@GetMapping("newvendor")
	public String newVendor() 
	{
		return "NewVendor";
	}
	
	@PostMapping("savevendor")
	public String saveVendor(VendorEntity entityvendor,HttpSession session) 
	{
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
		entityvendor.setUserId(userId);
		System.out.println(entityvendor.getUserId());
		repositoryVendor.save(entityvendor);
		return "redirect:userlistvendor";
	}
	
	@GetMapping("listvendor")
	public String listVendor(Model model) 
	{
		List<VendorEntity> vendorList = repositoryVendor.findAll();
		model.addAttribute("vendorList", vendorList);
		return "ListVendor";
	}
	
	@GetMapping("userlistvendor")
	public String userlistVendor(Model model,HttpSession session) 
	{
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		List<VendorEntity> uservendorList = repositoryVendor.findByVendorId(userId);
		model.addAttribute("uservendorList", uservendorList);
		return "UserListVendor";
	}
	
	@GetMapping("viewvendor")
	public String viewVendor(Model model,Integer vendorId) 
	{
		Optional<VendorEntity> vendor = repositoryVendor.findById(vendorId);
		model.addAttribute("vendor", vendor.get());
		return "ViewVendor";
	}
	
	@GetMapping("editvendor")
	public String editvendor(Integer vendorId,Model model) 
	{
		Optional<VendorEntity>op = repositoryVendor.findById(vendorId);
		if(op.isEmpty()) 
		{
			return "redirect:/userlistvendor";
		}
		else 
		{
			model.addAttribute("vendor",op.get());
		    return "EditVendor";
	    }
	}
	
	@PostMapping("updatevendor")
	public String updatevendor(VendorEntity vendorentity)
	{
		System.out.println(vendorentity.getVendorId());
		System.out.println(vendorentity.getVendorname());
		Optional<VendorEntity>op = repositoryVendor.findById(vendorentity.getVendorId());
		System.out.println(op.isPresent());
		
		if (op.isPresent())
		{
			VendorEntity dbVendor= op.get();
			dbVendor.setVendorname(vendorentity.getVendorname());
			repositoryVendor.save(dbVendor);
			System.out.println(dbVendor.getVendorname());
				
		}
		return "redirect:/userlistvendor";
		
	}
	
	@GetMapping("deletevendor")
	public String deleteVendor(@RequestParam Integer vendorId) 
	{
		repositoryVendor.deleteById(vendorId);
		return "redirect:userlistvendor";
	}	
}