package com.library.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.dao.LibrarianDao;
import com.library.entities.Librarian;
import com.library.entities.User;

@Controller
public class LibrarianCtrl {

	@Autowired
	private LibrarianDao librarianDao;

	private List<Librarian> list;

	/** Librarian - Controller */

	// Common Model Attribute
	@ModelAttribute
	public void commonModel(Model m) {
		m.addAttribute("title", "Librarian : Home Page");
	}

	// Librarian Home Page
	// Librarian Login Form
	@RequestMapping("/librarianLogin")
	public String librarianLogin(Model m) {
		m.addAttribute("librarianPage", "librarianLoginForm");
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
		return "librarian-login";
	}

	// Librarian Login Handling
	@RequestMapping(value = "/librarianDashboard", method = RequestMethod.POST)
	public String librarianDashboard(@ModelAttribute User u, Model m) {
		// Verification
		List<Librarian> lib = this.librarianDao.getAllLibrarians();
		for (Librarian l : lib) {
			// For True Condition
			if (u.getEmail().equals(l.getEmail()) && u.getPassword().equals(l.getPassword())) {
				// Adding Librarian as Attribute
				m.addAttribute("lib", l);
				m.addAttribute("title", "Librarian DashBoard");
				return "librarian-dashboard";
			}

		}

		m.addAttribute("msg", "Invalid Credentials");
		m.addAttribute("librarianPage", "librarianLoginForm");
		return "librarian-login";
	}

	// Librarian Dashboard back - for all
	@RequestMapping("/librarianDashboardBack/{lid}")
	public String librarianDashboardBack(@PathVariable int lid, Model m) {
		m.addAttribute("lib", librarianDao.getLibrarian(lid));
		return "librarian-dashboard";
	}

	// Librarian List
	@RequestMapping("/viewLibrarians")
	public String viewLibrarians(Model m) {
		list = this.librarianDao.getAllLibrarians();
		m.addAttribute("librarian", list);

		return "view-librarians";
	}

	// Librarian Update Form
	@RequestMapping("/updateLibrarian/{libId}")
	public String updateLibrarian(@PathVariable int libId, Model m) {
		Librarian lib = librarianDao.getLibrarian(libId);
		m.addAttribute("librarian", lib);
		return "update-librarian";
	}

	// Delete Librarian
	@RequestMapping("/deleteLibrarian/{libId}")
	public String deleteLibrarian(@PathVariable int libId, Model m) {
		librarianDao.deleteLibrarian(libId);
		return viewLibrarians(m);
	}

}
