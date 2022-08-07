package com.library.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.dao.LibrarianDao;
import com.library.entities.Librarian;

@Controller
public class LibrarianCtrl {

	@Autowired
	private LibrarianDao librarianDao;

	/** Librarian - Controller */
	
	@ModelAttribute
	public void commonModel(Model m) {
		m.addAttribute("title", "Librarian : Home Page");
	}


	// Librarian Home Page
	// Librarian Login Form
	@RequestMapping("/librarianLogin")
	public String librarianLogin(Model m) {
		m.addAttribute("librarianPage", "librarianLogin");
		return "librarian-login";
	}

	// Librarian SignUp Form
	@RequestMapping("/librarianSignupForm")
	public String librarianSignupForm(Model m) {
		m.addAttribute("librarianPage", "librarianSignupForm");
		return "librarian-login";
	}
	
	// Librarian Signup Added
	@RequestMapping(value = "/librarianSignup", method = RequestMethod.POST)
	public String librarianSignup(@ModelAttribute Librarian lib, Model m) {
		lib.setDate(new Date());
		this.librarianDao.addLibrarian(lib);
		m.addAttribute("msg", "Success");
		m.addAttribute("librarianPage", "librarianLoginForm");
		return "librarian-home";
	}

	// Librarian Login Handling
	@RequestMapping(value = "/librarianDashboard", method = RequestMethod.POST)
	public String librarianDashboard(@ModelAttribute Librarian lib, Model m) {
		m.addAttribute("title", "Librarian DashBoard");
		return "librarian-dashboard";
	}
	
	// Librarian student view back - used in BookCtrl
	@RequestMapping("/librarianDashboardBack")
	public String librarianDashboardBack() {
		return "librarian-dashboard";
	}

	// Librarian List
	@RequestMapping("/viewLibrarians")
	public String viewLibrarians(Model m) {
		List<Librarian> list = this.librarianDao.getAllLibrarians();
		m.addAttribute("librarian", list);

		return "view-librarians";
	}
	


}
