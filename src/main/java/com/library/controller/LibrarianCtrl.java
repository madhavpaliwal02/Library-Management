package com.library.controller;

import java.text.ParseException;
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

	private List<Librarian> librarian;
	
	private Date datetemp;

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
		librarian = librarianDao.getAllLibrarians();

		// If the user is an existing librarian
		for (Librarian l : librarian) {
			if (l.getEmail().equals(lib.getEmail()) && l.getName().equals(lib.getName())) {
				m.addAttribute("msg", "failed");
				m.addAttribute("message", "User Already Exists ! Please try with new credentials");
				return librarianSignupForm(m);
			}
		}
		lib.setDate(new Date());
		this.librarianDao.addLibrarian(lib);
		m.addAttribute("msg", "Success Added !!!");
		return librarianLogin(m);
	}

	// Librarian Login Handling
	@RequestMapping(value = "/librarianDashboard", method = RequestMethod.POST)
	public String librarianDashboard(@ModelAttribute User u, Model m) {
		// Verification
		librarian = this.librarianDao.getAllLibrarians();

		// If user is existing Librarian
		for (Librarian l : librarian) {
			// For True Condition
			if (u.getEmail().equals(l.getEmail()) && u.getPassword().equals(l.getPassword())) {
				// Adding Librarian as Attribute
				m.addAttribute("lib", l);
				m.addAttribute("title", "Librarian : DashBoard");
				return "librarian-dashboard";
			}
		}
		// If librarian not exist
		m.addAttribute("msg", "failed");
		m.addAttribute("message", "Invalid Credentials ! Please Try Again");
//		m.addAttribute("title", "Librarian : ");
		return librarianLogin(m);
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
		librarian = this.librarianDao.getAllLibrarians();
		m.addAttribute("librarian", librarian);
		m.addAttribute("title","Admin : View Librarians");
		return "view-librarians";
	}

	// Librarian Update Form
	@RequestMapping("/updateLibrarianForm/{lid}")
	public String updateLibrarianForm(@PathVariable int lid, Model m) {
		Librarian lib = librarianDao.getLibrarian(lid);
		m.addAttribute("librarian", lib);
		m.addAttribute("title", "Librarian Update");
		datetemp =  lib.getDate();
		return "update-librarian";
	}

	// Update Librarian
	@RequestMapping(value = "/updateLibrarian", method = RequestMethod.POST)
	public String updateLibrarian(@ModelAttribute Librarian lib, Model m) throws ParseException {
		lib.setDate(datetemp);
		librarianDao.addLibrarian(lib);
		m.addAttribute("lib", lib);
		m.addAttribute("title", "Librarian DashBoard");
		return "librarian-dashboard";
	}

	// Delete Librarian
	@RequestMapping("/deleteLibrarian/{lid}")
	public String deleteLibrarian(@PathVariable int lid, Model m) {
		librarianDao.deleteLibrarian(lid);
		return viewLibrarians(m);
	}

}
