package com.library.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IssuedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String sName;
	private String bName;
	private String bAuthName;
	private String sEmail;
	private String rollNo;
	private Date date;

	public IssuedBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IssuedBook(String bName, String bAuthName, String sName, String sEmail, String rollNo, Date date) {
		super();
		this.sName = sName;
		this.bName = bName;
		this.bAuthName = bAuthName;
		this.sEmail = sEmail;
		this.rollNo = rollNo;
		this.date = date;
	}

	public IssuedBook(int id, String sName, String bName, String bAuthName, String sEmail, String rollNo, Date date) {
		super();
		this.id = id;
		this.sName = sName;
		this.bName = bName;
		this.bAuthName = bAuthName;
		this.sEmail = sEmail;
		this.rollNo = rollNo;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbAuthName() {
		return bAuthName;
	}

	public void setbAuthName(String bAuthName) {
		this.bAuthName = bAuthName;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "IssuedBook [id=" + id + ", sName=" + sName + ", bName=" + bName + ", bAuthName=" + bAuthName
				+ ", sEmail=" + sEmail + ", rollNo=" + rollNo + ", date=" + date + "]";
	}

}
