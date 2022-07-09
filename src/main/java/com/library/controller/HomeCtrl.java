package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.entities.Student;

@Controller
public class HomeCtrl {

	// Home Page
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}

	/** Student - Controller */

	// Student Home Page
	@RequestMapping("/student")
	public String studentHome() {
		return "student-home";
	}

	// Student Login Form
	@RequestMapping("/studentLoginForm")
	public String studentLoginForm(Model m) {
		m.addAttribute("studentPage", "studentLoginForm");
		return "student-home";
	}

	// Student SignUp Form
	@RequestMapping("/studentSignupForm")
	public String studentLSignupForm(Model m) {
		m.addAttribute("studentPage", "studentSignupForm");
//		m.addAttribute("msg", "Success");
		return "student-home";
	}

	// Student Signup Database
	@RequestMapping(value = "/signupStudent", method = RequestMethod.POST)
	public String signupStudent(@ModelAttribute Student stu, Model m) {
		m.addAttribute("studentPage", "studentLoginForm");
		m.addAttribute("msg", "Success");
		System.out.println(stu);
		return "student-home";
	}

}
