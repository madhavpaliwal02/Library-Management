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
	
	// Get issued book By Roll No
	public List<IssuedBook> getIssuedBookByRollNo(String rollNo){
		List<IssuedBook> ibook = this.hibernateTemplate.loadAll(IssuedBook.class);
		List<IssuedBook> ib2 = new ArrayList<IssuedBook>();
		
		for(IssuedBook ib : ibook) 
			if(rollNo.equals(ib.getRollNo())) {
				ib2.add(ib);
				System.out.println(ib);
			}
				
		return ib2;
	}

	// Delete Issued Book
	@Transactional
	public void deleteIssuedBook(int id) {
		this.hibernateTemplate.delete(getIssuedBook(id));
	}
}