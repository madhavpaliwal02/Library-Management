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

import com.library.dao.StudentDao;
import com.library.entities.Librarian;
import com.library.entities.Student;
import com.library.entities.User;

@Controller
public class StudentCtrl {

	@Autowired
	private StudentDao studentDao;

	private List<Student> student = null;

	/** Student - Controller */

	// Common Model Attribute
	@ModelAttribute
	public void commonModel(Model m) {
		m.addAttribute("title", "Student: Home Page");
	}

	// Student Home Page
	// Student Login Form
	@RequestMapping("/studentLogin")
	public String studentLogin(Model m) {
		m.addAttribute("studentPage", "studentLoginForm");
		return "student-login";
	}

	// Student SignUp Form
	@RequestMapping("/studentSignupForm")
	public String studentSignupForm(Model m) {
		m.addAttribute("studentPage", "studentSignupForm");
		return "student-login";
	}

	// Student Signup - Registering
	@RequestMapping(value = "/studentSignup", method = RequestMethod.POST)
	public String studentSignup(@ModelAttribute Student stu, Model m) {
		student = this.studentDao.getAllStudents();

		// If the user is an existing student
		for (Student s : student) {
			if (stu.getEmail().equals(s.getEmail()) && stu.getName().equals(s.getName())) {
				m.addAttribute("msg", "failed");
				m.addAttribute("studentPage", "studentSignupForm");
				return "student-login";
			}
		}

		// If the user is new student
		stu.setDate(new Date());
		this.studentDao.addStudent(stu);
//		System.out.println(stu);
		m.addAttribute("studentPage", "studentLoginForm");
		m.addAttribute("msg", "Success");
		return "student-login";
	}

	// Student Login Handling
	@RequestMapping(value = "/studentDashboard", method = RequestMethod.POST)
	public String studentDashboard(@ModelAttribute User u, Model m) {
		// Verification
		student = this.studentDao.getAllStudents();

		// If user is existing student
		for (Student s : student) {
			if (u.getEmail().equals(s.getEmail()) && u.getPassword().equals(s.getPassword())) {
				m.addAttribute("stu", s); // name has been set in dashboard
				m.addAttribute("title", "Student DashBoard");
				return "student-dashboard";
			}
		}

		// If student not exists
		m.addAttribute("msg", "failed");
		m.addAttribute("studentPage", "studentLoginForm");
		return "student-login";
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
