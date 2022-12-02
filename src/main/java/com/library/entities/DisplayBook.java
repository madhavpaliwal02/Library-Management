package com.library.entities;

import java.util.Date;

public class DisplayBook {

	private int id;
	private Date date;

	// Student Data
	private int sid;
	private String sName;
	private String rollNo;
	private String course;
	private String gender;

	// Book Data
	private int bid;
	private String bName;
	private String author;
	private String edition;

	public DisplayBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisplayBook(int id, Date date, String sName, String rollNo, String course, String gender, String bName,
			String author, String edition) {
		super();
		this.id = id;
		this.date = date;
		this.sName = sName;
		this.rollNo = rollNo;
		this.course = course;
		this.gender = gender;
		this.bName = bName;
		this.author = author;
		this.edition = edition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
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
		return "DisplayBook [id=" + id + ", date=" + date + ", sid=" + sid + ", sName=" + sName + ", rollNo=" + rollNo
				+ ", course=" + course + ", gender=" + gender + ", bid=" + bid + ", bName=" + bName + ", author="
				+ author + ", edition=" + edition + "]";
	}

}
