package com.library.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.library.entities.Book;

@Component
public class BookDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	// Add Book
	@Transactional
	public void addBook(Book book) {
		this.hibernateTemplate.save(book);
	}
	
	// Get a Book
	public Book getBook(int bid) {
		return (Book)this.hibernateTemplate.get(Book.class, bid);
	}
	
	// Get All Books
	public List<Book> getAllBooks() {
		return (List<Book>) this.hibernateTemplate.loadAll(Book.class);
	}
	
	// Delete a Book
	@Transactional
	public void deleteBook(int bid) {
		this.hibernateTemplate.delete(getBook(bid));
	}
}
