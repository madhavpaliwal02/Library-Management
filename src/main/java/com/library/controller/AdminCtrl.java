package com.library.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminCtrl {

	/** Admin - Controller */

	// Admin Home Page
	@RequestMapping("/adminHome")
	public String adminHome(Model m) {
		m.addAttribute("title", "Admin : Login Page");
		return "admin-home";
	}

	// Admin DashBoard
	@RequestMapping("/adminLogin")
	public String adminLogin(Model m) {
		m.addAttribute("title", "Admin : DashBoard");
		return "admin-dashboard";
	}
	
	
}
