package com.library.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int count;
	private String name;
	private String authorName;
	private String description;
	private String edition;
	private Date date;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int count, String name, String authorName, String description, String edition, Date date) {
		super();
		this.count = count;
		this.name = name;
		this.authorName = authorName;
		this.description = description;
		this.edition = edition;
		this.date = date;
	}

	public Book(int id, int count, String name, String authorName, String description, String edition, Date date) {
		super();
		this.id = id;
		this.count = count;
		this.name = name;
		this.authorName = authorName;
		this.description = description;
		this.edition = edition;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", count=" + count + ", name=" + name + ", authorName=" + authorName
				+ ", description=" + description + ", edition=" + edition + ", date=" + date + "]";
	}

}
