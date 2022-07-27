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

	// Librarian Home Page
	@RequestMapping("/librarianHome")
	public String librarianHome(Model m) {
		m.addAttribute("title", "Librarian : Home Page");
		m.addAttribute("librarianPage", "librarianLoginForm");
		return "librarian-home";
	}

	// Librarian Login Form
	@RequestMapping("/librarianLoginForm")
	public String librarianLoginForm(Model m) {
		m.addAttribute("title", "Librarian : Home Page");
		m.addAttribute("librarianPage", "librarianLoginForm");
		return "librarian-home";
	}

	// Librarian SignUp Form
	@RequestMapping("/librarianSignupForm")
	public String librarianSignupForm(Model m) {
		m.addAttribute("title", "Librarian : Home Page");
		m.addAttribute("librarianPage", "librarianSignupForm");
		return "librarian-home";
	}

	// Librarian Signup Added
	@RequestMapping(value = "/signupLibrarian", method = RequestMethod.POST)
	public String signupLibrarian(@ModelAttribute Librarian lib, Model m) {
		lib.setDate(new Date());
		this.librarianDao.addLibrarian(lib);
		m.addAttribute("msg", "Success");
		m.addAttribute("title", "Librarian : DashBoard");
		m.addAttribute("librarianPage", "librarianLoginForm");
		return "librarian-home";
	}

	// Librarian Login Handling
	@RequestMapping(value = "/loginLibrarian", method = RequestMethod.POST)
	public String loginLibrarian(@ModelAttribute Librarian lib, Model m) {
		m.addAttribute("title", "Librarian DashBoard");
		return "librarian-dashboard";
	}
	
	// Librarian student view back
	@RequestMapping("/viewStudentsLibrarianBack")
	public String viewStudentsBack() {
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
