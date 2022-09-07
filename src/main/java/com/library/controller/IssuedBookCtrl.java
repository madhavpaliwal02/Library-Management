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

import com.library.dao.IssuedBookDao;
import com.library.entities.IssuedBook;

@Controller
public class IssuedBookCtrl {

	@Autowired
	private IssuedBookDao issuedBookDao;
	List<IssuedBook> ibook = null;

//	private IssuedBook issuedBook;

	// Issue Book by Student
	@RequestMapping("/issuedBook/{studentId}/{bookId}")
	public RedirectView issuedBook(@PathVariable int studentId, @PathVariable int bookId, HttpServletRequest request) {
		IssuedBook ibook = new IssuedBook(studentId, bookId);
		ibook.setDate(new Date());
		this.issuedBookDao.addIssuedBook(ibook);

		RedirectView rd = new RedirectView(request.getContextPath() + "/studentDashboardBack/{studentId}");
		return rd;
	}

	// Display all issue book
	@RequestMapping("/viewIssuedBooks")
	public String getAllIssuedBooks(Model m) {
		List<IssuedBook> list = this.issuedBookDao.getAllIssuedBook();
		m.addAttribute("ibook", list);
		return "view-issuedBooks";
	}

	// Get a students Issued Book
	public List<IssuedBook> getIssuedBooks(int sid) {
		// Getting all records of IssuedBook
		List<IssuedBook> temp = issuedBookDao.getAllIssuedBook();

		// Filtering Records for a student
		for (IssuedBook ib : temp) {
			if (ib.getSid() == sid)
				ibook.add(ib);
		}
		// Returning all records
		return ibook;
	}
}
