package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {

	/** Home Page */

	// Home Page
	@RequestMapping("/home")
	public String homePage(Model m) {
		m.addAttribute("title", "Home Page");
		return "home";
	}

}
