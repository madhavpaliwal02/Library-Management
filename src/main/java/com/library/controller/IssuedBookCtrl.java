package com.library.controller;

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

	List<IssuedBook> list = null;

	// Issue Book by Student
	@RequestMapping("/issuedBook/{sid}/{bid}")
	public RedirectView issuedBook(@PathVariable int sid, @PathVariable int bid, HttpServletRequest request) {
		IssuedBook ibook = new IssuedBook();

		Book b = bookDao.getBook(bid);
		Student s = studentDao.getStudent(sid);

//		ibook = new IssuedBook(b.getName(), b.getAuthorName(), s.getName(), s.getEmail(), s.getRollno(), new Date());

		ibook.setbName(b.getName());
		ibook.setbAuthName(b.getAuthorName());
		ibook.setsName(s.getName());
		ibook.setsEmail(s.getEmail());
		ibook.setRollNo(s.getRollno());
		ibook.setDate(new Date());

		this.issuedBookDao.addIssuedBook(ibook);

		RedirectView rd = new RedirectView(request.getContextPath() + "/studentDashboardBack/{sid}");
		return rd;
	}

	// Display all issue book - Admin
	@RequestMapping("/viewIssuedBooksAdmin")
	public String viewIssuedBooksAdmin(Model m) {
		list = this.issuedBookDao.getAllIssuedBook();

		m.addAttribute("ibook", list);
		m.addAttribute("user", "admin");
		return "view-issuedBooks";
	}

	// Display all issue book -Librarian
	@RequestMapping("/viewIssuedBooksLibrarian/{lid}")
	public String viewIssuedBooksLibrarian(@PathVariable int lid, Model m) {
		list = this.issuedBookDao.getAllIssuedBook();
		m.addAttribute("lid", lid);
		m.addAttribute("ibook", list);
		m.addAttribute("user", "librarian");
		return "view-issuedBooks";
	}

	// Get a students Issued Book
	public List<IssuedBook> getIssuedBooks(String rollno) {
		// Getting all records of IssuedBook
		List<IssuedBook> temp = issuedBookDao.getAllIssuedBook();

		// Filtering Records for a student
		for (IssuedBook ib : temp) {
			if (ib.getRollNo().equals(rollno))
				list.add(ib);
		}
		// Returning all records
		return list;
	}

	// Delete Issued Book Admin
	@RequestMapping("/deleteIssueBookAdmin/{bid}")
	public String deleteIssuedBookAdmin(@PathVariable int bid, Model m) {
		issuedBookDao.deleteIssuedBook(bid);
		return viewIssuedBooksAdmin(m);
	}

	// Delete Issued Book Librarian
	@RequestMapping("/deleteIssueBookLibrarian/{bid}")
	public String deleteIssuedBookLibrarian(@PathVariable int bid, Model m) {
		issuedBookDao.deleteIssuedBook(bid);
//		return viewIssuedBooksLibrarian(m);
		return "";
	}
}
