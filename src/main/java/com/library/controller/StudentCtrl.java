package com.library.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.library.dao.StudentDao;
import com.library.entities.Student;

@Controller
public class StudentCtrl {

	@Autowired
	private StudentDao studentDao;
	

	/** Student - Controller */

	// Student Home Page
	@RequestMapping("/studentHome")
	public String studentHome(Model m) {
		m.addAttribute("title", "Student: Home Page");
		m.addAttribute("studentPage", "studentLoginForm");
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
		// Verification 
		
		m.addAttribute("title", "Student DashBoard");
		return "student-dashboard";
	}

	
	// Admin View Students
	@RequestMapping("/viewStudentsAdmin")
	public String viewStudentsAdmin(Model m) {
		m.addAttribute("user", "admin");
		m.addAttribute("student", this.studentDao.getAllStudents());
		return "view-students";
	}
	
	// Librarian View Students
	@RequestMapping("/viewStudentsLibrarian")
	public String viewStudentsLibrarian(Model m) {
		m.addAttribute("user", "librarian");
		m.addAttribute("value", "librarianDashboardBack");
		m.addAttribute("student", this.studentDao.getAllStudents());
		return "view-students";
	}
	
	// Student Login Handling
		@RequestMapping("/studentDashboardBack")
		public String studentDashboardBack() {
			return "student-dashboard";
		}


	// Student Delete
	@RequestMapping("/deleteStudent")
	public RedirectView deleteStudent(Model m) {
		RedirectView redView = new RedirectView();
		return redView;
	}
	

}
