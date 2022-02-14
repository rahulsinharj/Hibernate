package com.SpringORM.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.SpringORM.entities.Student;

public class StudentDao {

	
	private HibernateTemplate hibernateTemplate;			// This obj will come from Spring IOC, who will inject values into this hibernateTemplate obj. 
	
	// Insert single Student Obj into DB
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
	}

	// Fetch single Student Obj from DB
	public Student getStudent(int StudentId) {
		Student student = this.hibernateTemplate.get(Student.class, StudentId);
		return student;
	}
	
	// Fetch ALL Students Obj from DB 
	public List<Student> getAllStudent(){
		List<Student> allStu = this.hibernateTemplate.loadAll(Student.class);
		return allStu;
	}	
	
	// DELETE single Student Obj from DB 
	@Transactional
	public void deleteStudent(int StudentId) {
		Student stu = this.hibernateTemplate.get(Student.class, StudentId);
		this.hibernateTemplate.delete(stu);
	}
	
	// UPDATE single Student Obj from DB 
	@Transactional
	public void updateStudent(Student student) 
	{
		try {
			this.hibernateTemplate.update(student);
		} 
		catch (DataAccessException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
 