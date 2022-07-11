package com.library.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.library.dao.*;
import com.library.entities.*;

@Controller
public class HomeCtrl {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private LibrarianDao librarianDao;
	@Autowired
	private BookDao bookDao;
	
	
	/** Home Page */

	// Home Page
	@RequestMapping("/home")
	public String homePage(Model m) {
		m.addAttribute("title", "Home Page");
		return "home";
	}

	
	
	/** Admin - Controller */

	// Admin Home Page
	@RequestMapping("/admin")
	public String adminHome(Model m) {
		m.addAttribute("title", "Admin : Login Page");
		return "admin-home";
	}

	// Admin DashBoard
	@RequestMapping("/loginAdmin")
	public String adminLogin(Model m) {
		m.addAttribute("title", "Admin : DashBoard");
		return "admin-dashboard";
	}

	
	
	
	/** Librarian - Controller */

	// Librarian Home Page
	@RequestMapping("/librarian")
	public String librarianHome(Model m) {
		m.addAttribute("title", "Librarian : Home Page");
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

		// librarian Dao
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

	// Librarian List
	@RequestMapping("viewLibrarians")
	public String viewLibrarians(Model m) {
		
		List<Librarian> list = this.librarianDao.getAllLibrarians();
		m.addAttribute("librarian", list);
		
		return "view-librarians";
	}
	
	
	
	/** Student - Controller */

	// Student Home Page
	@RequestMapping("/student")
	public String studentHome(Model m) {
		m.addAttribute("title", "Student: Home Page ");
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
		return "student-home";
	}

	// Student Signup Added
	@RequestMapping(value = "/signupStudent", method = RequestMethod.POST)
	public String signupStudent(@ModelAttribute Student stu, Model m) {
		stu.setDate(new Date());
		this.studentDao.addStudent(stu);
		System.out.println(stu);
		m.addAttribute("studentPage", "studentLoginForm");
		m.addAttribute("msg", "Success");

		return "student-home";
	}

	// Student Login Handling
	@RequestMapping(value = "/loginStudent", method = RequestMethod.POST)
	public String loginStudent(@ModelAttribute Student stu, Model m) {

		m.addAttribute("title", "Student DashBoard");
		return "student-dashboard";
	}

	// Students List
	@RequestMapping("/viewStudents")
	public String viewStudents(Model m) {
		List<Student> list = this.studentDao.getAllStudents();
		m.addAttribute("student",list);
		return "view-students";
	}
	
	// Student Delete
	@RequestMapping("/deleteStudent")
	public RedirectView deleteStudent(Model m) {
		RedirectView redView = new RedirectView();
		return redView;
	}
	
	/** Books -Controller */
	
	@RequestMapping("/viewBooks")
	public String viewBooks() {
		
		
		return "view-books";
	}
	
	
}
