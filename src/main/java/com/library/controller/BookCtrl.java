package com.library.controller;

import java.util.ArrayList;
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

import com.library.dao.BookDao;
import com.library.dao.LibrarianDao;
import com.library.entities.Book;

@Controller
public class BookCtrl {

	@Autowired
	private BookDao bookDao;
	@Autowired
	private LibrarianDao libDao;

	List<Book> book = null;

	// Add Book
	@RequestMapping(value = "/addBook/{lid}", method = RequestMethod.POST)
	public String addBook(@ModelAttribute Book book, @PathVariable int lid, Model m, HttpServletRequest request) {
		this.book = bookDao.getAllBooks();
		m.addAttribute("lib", libDao.getLibrarian(lid));

		// If the book exists
		if (this.book != null) {
			for (Book b : this.book) {
				// Condition for failed
				if (book.getName().equals(b.getName()) && book.getAuthorName().equals(b.getAuthorName())
						&& book.getEdition().equals(b.getEdition()) && b.getCount() > 0) {
					m.addAttribute("msg", "failed");
					m.addAttribute("message", "Book Already Exists ! Please try with new credentials");
					return "librarian-dashboard";
				}
			}
		}

		// If book doesn't exist
		book.setDate(new Date());
		this.bookDao.addBook(book);
		m.addAttribute("msg", "Success Added !!!");
		return "librarian-dashboard";
	}

	// Display Books - Generic
	public String viewBooks(Model m) {
		List<Book> b2 = this.bookDao.getAllBooks();
		book = new ArrayList<Book>();
		for (Book b : b2) {
			if (b.getCount() > 0) {
				book.add(b);
			}
		}

		m.addAttribute("book", book);
		return "view-books";
	}

	// Display Books Admin
	@RequestMapping("/viewBooksAdmin")
	public String viewBooksAdmin(Model m) {
		m.addAttribute("user", "admin");
		return viewBooks(m);
	}

	// Display Books Librarian
	@RequestMapping("/viewBooksLibrarian/{lid}")
	public String viewBooksLibrarian(@PathVariable int lid, Model m) {
		m.addAttribute("user", "librarian");
		m.addAttribute("lid", lid);
		return viewBooks(m);
	}

	// Display Books Students
	@RequestMapping("/viewBooksStudent/{sid}")
	public String viewBooksStudent(@PathVariable int sid, Model m) {
		m.addAttribute("user", "student");
		m.addAttribute("sid", sid);
		return viewBooks(m);
	}

	// Update Book - Only Librarian

	// Delete Book Admin
	@RequestMapping("/bookDeleteAdmin/{bid}")
	public String deleteBookAdmin(@PathVariable int bid, Model m) {
		bookDao.deleteBook(bid);
		return viewBooksAdmin(m);
	}

	// Delete Book Librarian
	@RequestMapping("/bookDeleteLibrarian/{lid}/{bid}")
	public String deleteBookLibrarian(@PathVariable int lid, @PathVariable int bid, Model m) {
		bookDao.deleteBook(bid);
		return viewBooksLibrarian(lid, m);
	}

}