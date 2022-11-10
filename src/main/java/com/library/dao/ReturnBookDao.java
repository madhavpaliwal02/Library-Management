package com.library.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.library.entities.ReturnBook;

@Component
public class ReturnBookDao {
	
	List<ReturnBook> rbook = null;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// Add Return Book
	@Transactional
	public void addReturnBook(ReturnBook rbook) {
		this.hibernateTemplate.save(rbook);
	}

	// Get a Return Book
	public ReturnBook getReturnBook(int id) {
		return this.hibernateTemplate.get(ReturnBook.class, id);
	}

	// Get all Return Book
	public List<ReturnBook> getAllReturnBook() {
		return (List<ReturnBook>) this.hibernateTemplate.loadAll(ReturnBook.class);
	}

	// Get Return Book By Sid
	public List<Integer> getReturnBookBySid(int sid) {
		// Fetching all Return Book
		rbook = getAllReturnBook();
		List<Integer> rb2 = new ArrayList<Integer>();

		// Filtering for a Student
		for (ReturnBook rb : rbook)
			if (rb.getSid() == sid) // Verifying the sid
				rb2.add(rb.getBid()); // Adding only Book Ids

		return rb2;
	}

	// Delete Return Book
	@Transactional
	public void deleteReturnBook(int id) {
		this.hibernateTemplate.delete(getReturnBook(id));
	}

	// Delete Issued Book by Bid
	@Transactional
	public void deleteReturnBookByBid(int bid) {
		// Fetching all Issued Book
		rbook = getAllReturnBook();

		// Filtering for a Student
		for (ReturnBook ib : rbook)
			if (ib.getBid() == bid) { // Verifying the sid
				deleteReturnBook(ib.getId()); // Deleting the record
			}
	}

	// Delete Issued Book by Sid
	@Transactional
	public void deleteReturnBookBySid(int sid) {
		// Fetching all Issued Book
		rbook = getAllReturnBook();

		// Filtering for a Student
		for (ReturnBook ib : rbook)
			if (ib.getSid() == sid) { // Verifying the sid
				deleteReturnBook(ib.getId()); // Deleting the record
			}
	}

}
