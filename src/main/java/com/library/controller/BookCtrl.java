package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.dao.BookDao;

@Controller
public class BookCtrl {

	@Autowired
	private BookDao bookDao;

	
	/** Books -Controller */

	// Books List
	@RequestMapping("/viewBooks")
	public String viewBooks() {

		return "view-books";
	}

}
