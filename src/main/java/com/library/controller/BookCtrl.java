package com.library.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.library.dao.BookDao;
import com.library.entities.Book;

@Controller
public class BookCtrl {

	@Autowired
	private BookDao bookDao;

	List<Book> list = null;

	// Add Book Form
	@RequestMapping("/addBookForm")
	public String addBookForm(Model m) {
		m.addAttribute("librarianPage", "addBookForm");
		return "librarian-dashboard";
	}

	// Add Book
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute Book book, Model m) {
		book.setDate(new Date());
		this.bookDao.addBook(book);
		return "librarian-dashboard";
	}

	// Delete Book
	@RequestMapping("/deleteBook/{bookId}")
	public RedirectView deleteBook(@PathVariable("bookId") int id, Model m, HttpServletRequest request) {
		this.bookDao.deleteBook(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/viewBooks");
		return redirectView;
	}

	// Update Book

	// Display Books Admin
	@RequestMapping("/viewBooksAdmin")
	public String viewBooksAdmin(Model m) {
		list = this.bookDao.getAllBooks();
		m.addAttribute("book", list);
		m.addAttribute("back", "admin-dashboard");
		return "view-books";
	}

	// Display Books Librarian
	@RequestMapping("/viewBooksLibrarian")
	public String viewBooksLibrarian(Model m) {
		list = this.bookDao.getAllBooks();
		m.addAttribute("book", list);
		m.addAttribute("back", "librarian-dashboard");
		return "view-books";
	}

	// Display Books Students
	@RequestMapping("/viewBooksStudent/{studentId}")
	public String viewBooksStudent(@PathVariable int studentId , Model m) {
		list = this.bookDao.getAllBooks();
		m.addAttribute("book", list);
		m.addAttribute("studentId", studentId);
		m.addAttribute("viewBook", "viewBookStudent");
		m.addAttribute("back", "student-dashboard");
		return "view-books";
	}
	
	
}