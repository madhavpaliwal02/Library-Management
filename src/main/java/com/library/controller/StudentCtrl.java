package com.library.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.dao.BookDao;
import com.library.dao.IssuedBookDao;
import com.library.dao.ReturnBookDao;
import com.library.dao.StudentDao;
import com.library.entities.Book;
import com.library.entities.IssuedBook;
import com.library.entities.Student;
import com.library.entities.User;

@Controller
public class StudentCtrl {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private IssuedBookDao ibDao;
	@Autowired
	private ReturnBookDao rbDao;
	@Autowired
	private BookDao bDao;
	private Date datetemp;
	private List<Student> student = null;

	private List<Book> book = null;

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
				m.addAttribute("message", "User Already Exists ! Please try with new credentials");
				return studentSignupForm(m);
			}
		}

		// If the user is new student
		stu.setDate(new Date());
		this.studentDao.addStudent(stu);
		m.addAttribute("msg", "Success Added !!!");
		return studentLogin(m);
	}

	// Get Issued Book for a student
	// Issued Book by Sid
	public List<Book> getIssuedBooksBySid(int sid) {
		// Getting all BookId from IssuedBook for a Student
		List<IssuedBook> temp = ibDao.getIssuedBookBySid(sid);

		book = new ArrayList<Book>();

		// Filtering Records for a student
		for (IssuedBook i : temp)
			book.add(bDao.getBook(i.getBid()));

		return book;
	}

	// Student Login Handling
	@RequestMapping(value = "/studentDashboard", method = RequestMethod.POST)
	public String studentDashboard(@ModelAttribute User u, Model m) {
		// Verification
		student = this.studentDao.getAllStudents();

		// If user is existing student
		for (Student s : student) {
			// After Verifying Credentials
			if (u.getEmail().equals(s.getEmail()) && u.getPassword().equals(s.getPassword())) {
				// Adding Student as attribute
				m.addAttribute("stu", s); // name has been set in Dashboard
				m.addAttribute("title", "Student : DashBoard");
				// Adding IssuedBook
				book = getIssuedBooksBySid(s.getId());
				m.addAttribute("iBook", book);
				return "student-dashboard";
			}
		}

		// If student not exists
		m.addAttribute("msg", "failed");
		m.addAttribute("message", "Invalid Credentials ! Please Try Again");
		return studentLogin(m);
	}

	// View Students - Generic
	public String viewStudents(Model m) {
		m.addAttribute("student", this.studentDao.getAllStudents());
		return "view-students";
	}

	// Admin View Students
	@RequestMapping("/viewStudentsAdmin")
	public String viewStudentsAdmin(Model m) {
		m.addAttribute("user", "admin");
		m.addAttribute("title", "Admin : View Students");
		return viewStudents(m);
	}

	// Librarian View Students
	@RequestMapping("/viewStudentsLibrarian/{lid}")
	public String viewStudentsLibrarian(@PathVariable int lid, Model m) {
		m.addAttribute("user", "librarian");
		m.addAttribute("value", "librarianDashboardBack");
		m.addAttribute("lid", lid);
		m.addAttribute("title", "Librarian : View Students");
		return viewStudents(m);
	}

	// Student DashBoard Back - for all
	@RequestMapping("/studentDashboardBack/{sid}")
	public String studentDashboardBack(@PathVariable int sid, Model m) {
		m.addAttribute("stu", studentDao.getStudent(sid));
		// Adding IssuedBook
		m.addAttribute("iBook", getIssuedBooksBySid(sid));
		return "student-dashboard";
	}

	// Student Update Form
	@RequestMapping("/updateStudentForm/{sid}")
	public String updateStudentForm(@PathVariable int sid, Model m) {
		Student stu = studentDao.getStudent(sid);
		m.addAttribute("stu", stu);
		m.addAttribute("title", "Student Update");
		datetemp = stu.getDate();
		return "update-student";
	}

	// Update Student
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute Student stu, Model m) {
		stu.setDate(datetemp);
		studentDao.addStudent(stu);
		m.addAttribute("stu", stu);
		m.addAttribute("title", "Student DashBoard");
		// Adding IssuedBook
		m.addAttribute("iBook", getIssuedBooksBySid(stu.getId()));
		return "student-dashboard";
	}

	// Delete Student Generic
	public boolean deleteStudent(int sid, Model m) {
		if (ibDao.getIssuedBookBySid(sid).size() > 0) {
			m.addAttribute("msg", "failed");
			m.addAttribute("cause", "The Record can't be deleted as they have IssuedBooks to be return");
			return false;
		} else {
			// Deleting All IssuedBook
			// ibDao.deleteIssuedBookBySid(sid);

			// Deleting All ReturnBook
			rbDao.deleteReturnBookBySid(sid);

			// Deleting Student
			studentDao.deleteStudent(sid);

			m.addAttribute("msg", "success");
			m.addAttribute("cause", "The Record is Deleted Successfully");
			return true;
		}
	}

	// Student Delete Admin
	@RequestMapping("/studentDeleteAdmin/{sid}")
	public String deleteStudentAdmin(@PathVariable int sid, Model m) {
		deleteStudent(sid, m);
		return viewStudentsAdmin(m);
	}

	// Student Delete Librarian
	@RequestMapping("/studentDeleteLibrarian/{lid}/{sid}")
	public String deleteStudentLibrarian(@PathVariable int lid, @PathVariable int sid, Model m) {
		deleteStudent(sid, m);
		return viewStudentsLibrarian(lid, m);
	}

}
