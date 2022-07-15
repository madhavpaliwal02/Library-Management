package com.library.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IssuedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int sid;
	private int bid;

	public IssuedBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IssuedBook(int sid, int bid) {
		super();
		this.sid = sid;
		this.bid = bid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "IssuedBook [id=" + id + ", sid=" + sid + ", bid=" + bid + "]";
	}

}
