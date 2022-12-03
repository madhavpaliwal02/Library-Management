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
import com.library.dao.ReturnBookDao;
import com.library.dao.StudentDao;
import com.library.entities.Book;
import com.library.entities.DisplayBook;
import com.library.entities.ReturnBook;
import com.library.entities.Student;

@Controller
public class ReturnBookCtrl {

	@Autowired
	private ReturnBookDao returnBookDao;
	@Autowired
	private IssuedBookDao issuedBookDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private StudentDao studentDao;

	private List<ReturnBook> rbook = null;

	private List<DisplayBook> dBook;

	// Return Book by Student
	@RequestMapping("/returnBook/{sid}/{bid}")
	public RedirectView returnBook(@PathVariable int sid, @PathVariable int bid, HttpServletRequest request) {
		RedirectView rd = new RedirectView(request.getContextPath() + "/studentDashboardBack/{sid}");
		/*
		 * // Fetching all existing records rbook =
		 * this.returnBookDao.getAllReturnBook(); System.out.println(rbook); // Checking
		 * for dublicity for (ReturnBook rb : rbook) { if (rb.getSid() == sid &&
		 * rb.getBid() == bid) { return rd; } }
		 */

		// Record Added in return Book
		ReturnBook ib = new ReturnBook(sid, bid, new Date());
		this.returnBookDao.addReturnBook(ib);

		// Count changes in Book
		Book b = bookDao.getBook(bid);
		int count = b.getCount() + 1;
		b.setCount(count);

		// Delete record from returned book by student id
		issuedBookDao.deleteIssuedBook(bid, sid);
		return rd;
	}

	// Display ReturnBooks - Generic
	public String viewBooks(Model m) {
		// Fetching Return Book Records
		rbook = this.returnBookDao.getAllReturnBook();
		dBook = new ArrayList<DisplayBook>();
		Student s = null;
		Book b = null;
		int i = 1;

		// Assigning to DisplayBook
		for (ReturnBook rb : rbook) {
			// Fetching Student & Book
			s = studentDao.getStudent(rb.getSid());
			b = bookDao.getBook(rb.getBid());

			DisplayBook db = new DisplayBook();

			// Assigning S.No
			db.setId(i++);

			// Assigning Student Data
			db.setSid(s.getId());
			db.setsName(s.getName());
			db.setRollNo(s.getRollno());
			db.setCourse(s.getCourse());
			db.setGender(s.getGender());

			// Assigning Book Data
			db.setBid(b.getId());
			db.setbName(b.getName());
			db.setAuthor(b.getAuthorName());
			db.setEdition(b.getEdition());

			db.setDate(rb.getDate());

			System.out.println(db);

			// Adding to the list
			dBook.add(db);
		}
		System.out.println(dBook);

		m.addAttribute("rbook", dBook);
		return "view-returnBooks";
	}

	// Display all return book - Admin
	@RequestMapping("/viewReturnBooksAdmin")
	public String viewReturnBooksAdmin(Model m) {
		m.addAttribute("user", "admin");
		m.addAttribute("title", "Admin : View ReturnBooks");
		return viewBooks(m);
	}

	// Display all return book -Librarian
	@RequestMapping("/viewReturnBooksLibrarian/{lid}")
	public String viewReturnBooksLibrarian(@PathVariable int lid, Model m) {
		m.addAttribute("lid", lid);
		m.addAttribute("user", "librarian");
		m.addAttribute("title", "Librarian : View ReturnBooks");
		return viewBooks(m);
	}

	// Delete Return Book Admin
	@RequestMapping("/returnBookDeleteAdmin/{bid}/{sid}")
	public String deleteReturnBookAdmin(@PathVariable int bid, @PathVariable int sid, Model m) {
		returnBookDao.deleteReturnBook(bid, sid);
		m.addAttribute("msg", "The record is Successfully Deleted !!!");
		return viewReturnBooksAdmin(m);
	}

}
