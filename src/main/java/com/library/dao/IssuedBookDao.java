package com.library.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.library.entities.IssuedBook;

@Component
public class IssuedBookDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	// Add Issued Book
	@Transactional
	public void addIssuedBook(IssuedBook ibook) {
		this.hibernateTemplate.save(ibook);
	}
	
	// Get a Issued Book
	public IssuedBook getIssuedBook(int id) {
		return this.hibernateTemplate.get(IssuedBook.class, id);
	}
	
	// Get all Issued Book
	public List<IssuedBook> getAllIssuedBook() {
		return (List<IssuedBook>) this.hibernateTemplate.loadAll(IssuedBook.class);
	}
}
