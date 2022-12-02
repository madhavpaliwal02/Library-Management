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
	private IssuedBookDao ibDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private StudentDao studentDao;

	private List<IssuedBook> ibook = null;

	private List<DisplayBook> dBook;

	// Get Issued Book for a student
	// Issued Book by Sid
	public List<Book> getIssuedBooksBySid(int sid) {
		// Getting all BookId from IssuedBook for a Student
		List<IssuedBook> temp = ibDao.getIssuedBookBySid(sid);

		List<Book> book = new ArrayList<Book>();

		// Filtering Records for a student
		for (IssuedBook i : temp)
			book.add(bookDao.getBook(i.getBid()));

		return book;
	}

	// Issue Book by Student
	@RequestMapping("/issuedBook/{sid}/{bid}")
	public String issuedBook(@PathVariable int sid, @PathVariable int bid, Model m, HttpServletRequest request) {
		// Check for existing issued records
		List<IssuedBook> ibs = ibDao.getIssuedBookBySid(sid);
		m.addAttribute("stu", studentDao.getStudent(sid));

		for (IssuedBook i : ibs) {
			if (i.getBid() == bid) {
				m.addAttribute("msg", "failed");
				m.addAttribute("message", "Book Already Issued By You !");
				m.addAttribute("iBook", getIssuedBooksBySid(sid));
				return "student-dashboard";
			}
		}

		// Creating a new IssuedBook Entry
		this.ibDao.addIssuedBook(new IssuedBook(sid, bid, new Date()));

		m.addAttribute("msg", "Book Issued Successfully");
		m.addAttribute("iBook", getIssuedBooksBySid(sid));

		return "student-dashboard";
	}

	// Display IssuedBooks - Generic
	public String viewBooks(Model m) {
		// Fetching Issued Book Records
		ibook = this.ibDao.getAllIssuedBook();
		dBook = new ArrayList<DisplayBook>();
//		System.out.println(ibook);
		Student s = null;
		Book b = null;
		int i=1;

		// Assigning to DisplayBook
		for (IssuedBook ib : ibook) {
			// Fetching Student & Book
			s = studentDao.getStudent(ib.getSid());
			b = bookDao.getBook(ib.getBid());

			// Creating a new object
			DisplayBook db = new DisplayBook();

			// Setting S.No
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

			// Assigning Issued Book Date
			db.setDate(ib.getDate());

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
		m.addAttribute("title", "Admin : View IssuedBooks");
		return viewBooks(m);
	}

	// Display all issue book -Librarian
	@RequestMapping("/viewIssuedBooksLibrarian/{lid}")
	public String viewIssuedBooksLibrarian(@PathVariable int lid, Model m) {
		m.addAttribute("lid", lid);
		m.addAttribute("user", "librarian");
		m.addAttribute("title", "Librarian : View IssuedBooks");
		return viewBooks(m);
	}

	// Delete Issued Book Admin
	@RequestMapping("/issuedBookDeleteAdmin/{bid}/{sid}")
	public String deleteIssuedBookAdmin(@PathVariable int bid, @PathVariable int sid, Model m) {
		ibDao.deleteIssuedBook(bid, sid);
		return viewIssuedBooksAdmin(m);
	}

}
