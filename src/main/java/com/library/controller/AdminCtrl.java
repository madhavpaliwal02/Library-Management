package com.library.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.entities.User;

@Controller
public class AdminCtrl {

	/** Admin - Controller */

	// Admin Home Page
	@RequestMapping("/adminLogin")
	public String adminLogin(Model m) {
		m.addAttribute("title", "Admin : Login Page");
		m.addAttribute("msg", "");
		return "admin-login";
	}

	// Admin DashBoard
	@RequestMapping(value = "/adminDashboard", method = RequestMethod.POST)
	public String adminDashboard(@ModelAttribute User u, Model m) {
		// Verification 
//		if(! (u.getEmail().equals("admin@gmail.com") && u.getPassword().equals("admin@123"))) {
//			m.addAttribute("msg", "Invalid Credentials");
//			return "admin-login";
//		}
		m.addAttribute("title", "Admin : DashBoard");
		return "admin-dashboard";
	}
	
	@RequestMapping("/adminDashboardBack")
	public String adminDashboardBack() {
		return "admin-dashboard";
	}
	
	
}
