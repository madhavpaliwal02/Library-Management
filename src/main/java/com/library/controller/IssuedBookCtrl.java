package com.library.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.dao.IssuedBookDao;
import com.library.entities.IssuedBook;

@Controller
public class IssuedBookCtrl {

	@Autowired
	private IssuedBookDao iBookDao;
	
	private IssuedBook issuedBook;

	// Issue Book by Student
	@RequestMapping("/issuedBook/{studentId}/{bookId}")
	public String issuedBook(@PathVariable int studentId, @PathVariable int bookId) {
		IssuedBook ibook = new IssuedBook(studentId, bookId);
		ibook.setDate(new Date());
		this.iBookDao.addIssuedBook(ibook);
		return "student-dashboard";
	}
	
	// Display all issue book
	@RequestMapping("/viewIssuedBooks")
	public String getAllIssuedBooks(Model m) {
		List<IssuedBook> list = this.iBookDao.getAllIssuedBook();
		m.addAttribute("ibook", list);
		return "view-issuedBooks";
	}
}
