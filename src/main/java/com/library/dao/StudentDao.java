package com.library.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.library.entities.Student;

@Component
public class StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// Add Student
	@Transactional
	public void addStudent(Student stu) {
		this.hibernateTemplate.save(stu);
	}
	
	// Get a student
	public Student getStudent(int sid) {
		return (Student) this.hibernateTemplate.get(Student.class, sid);
	}

	// Get all students
	public List<Student> getAllStudents() {
		return (List<Student>) this.hibernateTemplate.loadAll(Student.class);
	}

	// delete a student
	@Transactional
	public void deleteStudent(int sid) {
		this.hibernateTemplate.delete(getStudent(sid));
	}
}
