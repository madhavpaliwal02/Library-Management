package com.library.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.library.dao.BookDao;
import com.library.dao.IssuedBookDao;
import com.library.dao.StudentDao;
import com.library.entities.Book;
import com.library.entities.DisplayBook;
import com.library.entities.IssuedBook;
import com.library.entities.Student;

@Controller
public class IssuedBookCtrl {

	@Autowired
	private IssuedBookDao issuedBookDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private StudentDao studentDao;

	private List<IssuedBook> ibook = null;

	private List<DisplayBook> dBook = new ArrayList<DisplayBook>();

	// Issue Book by Student
	@RequestMapping("/issuedBook/{sid}/{bid}")
	public RedirectView issuedBook(@PathVariable int sid, @PathVariable int bid, HttpServletRequest request) {
		IssuedBook ib = new IssuedBook();

		ib = new IssuedBook(sid, bid, new Date());

		this.issuedBookDao.addIssuedBook(ib);

		RedirectView rd = new RedirectView(request.getContextPath() + "/studentDashboardBack/{sid}");
		return rd;
	}

	// Display IssuedBooks - Generic
	public String viewBooks(Model m) {
		// Fetching Issued Book Records
		ibook = this.issuedBookDao.getAllIssuedBook();
		Student s = null;
		Book b = null;
		
		// Assigning to DisplayBook
		for(IssuedBook ib : ibook) {
			// Fetching Student & Book
			s = studentDao.getStudent(ib.getSid());
			b = bookDao.getBook(ib.getBid());
			
			DisplayBook db = new DisplayBook();
			
			// Assigning Student Data
			db.setsName(s.getName());
			db.setRollNo(s.getRollno());
			db.setCourse(s.getCourse());
			db.setGender(s.getGender());
			
			// Assigning Student Data
			db.setbName(b.getName());
			db.setAuthor(b.getAuthorName());
			db.setEdition(b.getEdition());
			
			db.setDate(new Date());
			
			System.out.println(db);
			
			// Adding to the list
			dBook.add(db);
		}
		System.out.println(dBook);
		
		m.addAttribute("ibook", dBook);
		return "view-issuedBooks";
	}

	// Display all issue book - Admin
	@RequestMapping("/viewIssuedBooksAdmin")
	public String viewIssuedBooksAdmin(Model m) {
		m.addAttribute("user", "admin");
		return viewBooks(m);
	}

	// Display all issue book -Librarian
	@RequestMapping("/viewIssuedBooksLibrarian/{lid}")
	public String viewIssuedBooksLibrarian(@PathVariable int lid, Model m) {
		m.addAttribute("lid", lid);
		m.addAttribute("user", "librarian");
		return viewBooks(m);
	}

	// Get a students Issued Book
	/*
	 * public List<IssuedBook> getIssuedBooks(String rollno) { // Getting all
	 * records of IssuedBook List<IssuedBook> temp =
	 * issuedBookDao.getAllIssuedBook();
	 * 
	 * // Filtering Records for a student for (IssuedBook ib : temp) { if
	 * (ib.getRollNo().equals(rollno)) ibook.add(ib); } // Returning all records
	 * return ibook; }
	 */

	// Delete Issued Book Admin
	@RequestMapping("/issuedBookDeleteAdmin/{bid}")
	public String deleteIssuedBookAdmin(@PathVariable int bid, Model m) {
		issuedBookDao.deleteIssuedBook(bid);
		return viewIssuedBooksAdmin(m);
	}

	// Delete Issued Book Librarian
	@RequestMapping("/issuedBookDeleteLibrarian/{lid}/{bid}")
	public String deleteIssuedBookLibrarian(@PathVariable int lid, @PathVariable int bid, Model m) {
		issuedBookDao.deleteIssuedBook(bid);
		return viewIssuedBooksLibrarian(lid, m);
	}

	// Return Issued Book
	@RequestMapping("/issuedBookReturn/{sid}")
	public RedirectView returnIssuedBook(@PathVariable int sid, HttpServletRequest request) {
		RedirectView view = new RedirectView(request.getContextPath() + "/studentDashboardBack/{" + sid + "}");
		return view;
	}
}
