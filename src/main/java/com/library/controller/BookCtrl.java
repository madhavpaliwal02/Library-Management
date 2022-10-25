package com.library.controller;

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
import com.library.dao.LibrarianDao;
import com.library.entities.Book;

@Controller
public class BookCtrl {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private LibrarianDao librarianDao;

	List<Book> list = null;


	// Add Book
	@RequestMapping(value = "/addBook/{lid}", method = RequestMethod.POST)
	public String addBook(@ModelAttribute Book book,@PathVariable int lid, Model m) {
		book.setDate(new Date());
		this.bookDao.addBook(book);
		m.addAttribute("lib", librarianDao.getLibrarian(lid));
		return "librarian-dashboard";
	}

	

	// Display Books Admin
	@RequestMapping("/viewBooksAdmin")
	public String viewBooksAdmin(Model m) {
		list = this.bookDao.getAllBooks();
		m.addAttribute("user", "admin");
		m.addAttribute("book", list);
		return "view-books";
	}

	// Display Books Librarian
	@RequestMapping("/viewBooksLibrarian/{lid}")
	public String viewBooksLibrarian(@PathVariable int lid, Model m) {
		list = this.bookDao.getAllBooks();
		m.addAttribute("user", "librarian");
		m.addAttribute("lid", lid);
		m.addAttribute("book", list);
		return "view-books";
	}

	// Display Books Students
	@RequestMapping("/viewBooksStudent/{studentId}")
	public String viewBooksStudent(@PathVariable int studentId , Model m) {
		list = this.bookDao.getAllBooks();
		m.addAttribute("book", list);
		m.addAttribute("studentId", studentId);
		m.addAttribute("user", "student");
		return "view-books";
	}
	
	// Update Book - Only Librarian
	
	// Delete Book Admin
	@RequestMapping("/deleteBookAdmin/{bid}")
	public String deleteBookAdmin(@PathVariable int bid, Model m) {
		bookDao.deleteBook(bid);
		return viewBooksAdmin(m);
	}
	
	// Delete Book Librarian
	@RequestMapping("/deleteBookLibrarian/{lid}/{bid}")
	public String deleteBookLibrarian(@PathVariable int lid, @PathVariable int bid, Model m) {
		bookDao.deleteBook(bid);
		return viewBooksLibrarian(lid, m);
	}
	

	
}