package com.library.dao;

import java.util.ArrayList;
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

	// Get Issued Book By Sid
	public List<Integer> getIssuedBookBySid(int sid) {
		// Fetching all Issued Book
		List<IssuedBook> ibook = this.hibernateTemplate.loadAll(IssuedBook.class);
		List<Integer> ib2 = new ArrayList<Integer>();

		// Filtering for a Student
		for (IssuedBook ib : ibook)
			if (ib.getSid() == sid) // Verifying the sid
				ib2.add(ib.getBid()); // Adding only Book Ids

		return ib2;
	}

	// Delete Issued Book
	@Transactional
	public void deleteIssuedBook(int id) {
		this.hibernateTemplate.delete(getIssuedBook(id));
	}
	
	
}