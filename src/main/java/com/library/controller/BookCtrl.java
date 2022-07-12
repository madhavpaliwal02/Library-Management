package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.dao.BookDao;
import com.library.entities.Book;

@Controller
public class BookCtrl {

	@Autowired
	private BookDao bookDao;

	
	/** Books -Controller */

	// Books add
	@RequestMapping("/addBook")
	public String addBook(@ModelAttribute Book book, Model m) {
		this.bookDao.addBook(book);
		m.addAttribute("msg", "Success");
		m.addAttribute("pageLibrarian", "");
		return "";
	}
	
	// Books List
	@RequestMapping("/viewBooks")
	public String viewBooks() {
		this.bookDao.getAllBooks();
		return "view-books";
	}

}
