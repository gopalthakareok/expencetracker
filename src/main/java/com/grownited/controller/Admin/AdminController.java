package com.grownited.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController 
{

	@GetMapping("admindashboard")
	public String adminDashboard() 
	{
		return "AdminDashboard";
	}
}