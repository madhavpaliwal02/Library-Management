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
		
		System.out.println(s + " " + b);

		RedirectView rd = new RedirectView(request.getContextPath() + "/studentDashboardBack/{sid}");
		return rd;
	}

	// Display all issue book
	@RequestMapping("/viewIssuedBooks")
	public String getAllIssuedBooks(Model m) {
		list = this.issuedBookDao.getAllIssuedBook();

		m.addAttribute("ibook", list);
		return "view-issuedBooks";
	}

	// Get a students Issued Book
	public List<IssuedBook> getIssuedBooks(int sid) {
		// Getting all records of IssuedBook
		List<IssuedBook> temp = issuedBookDao.getAllIssuedBook();

		// Filtering Records for a student
		for (IssuedBook ib : temp) {
//			if (ib.getSid() == sid)
//				list.add(ib);
		}
		// Returning all records
		return list;
	}
}
