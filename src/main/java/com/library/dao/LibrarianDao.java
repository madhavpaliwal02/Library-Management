package com.library.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.library.entities.Librarian;

@Component
public class LibrarianDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	// Create Librarian
	@Transactional
	public void addLibrarian(Librarian lib) {
		this.hibernateTemplate.save(lib);
	}
	
	// Get a Librarian
	public Librarian getLibrarian(int lid) {
		return (Librarian)this.hibernateTemplate.get(Librarian.class, lid);
	}
	
	// Get all Librarians
	public List<Librarian> getAllLibrarians(){
		return (List<Librarian>)this.hibernateTemplate.loadAll(Librarian.class);
	}
	
}
