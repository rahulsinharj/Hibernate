package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity						// iss annotation ke karan ab hibernate iska obj save kar payega, iska table bana payega, iska obj fetch kar payega. 
public class Student {		// @Entity ke jagah we can also use @Entity(name="student_details")  // jisse ki ab "student_details" naam ka table banega in database, aur Entity ka naam bhi "Student" se "student_details" hojayega.
							// agar Entity ka naam Student hi rakhna hai, aur kewal table ka naam change karna hai to @Entity likh ke uske niche @Table(name="student_details") kar skete hai, for changing table name in DB, without changing Entity name.
	
	@Id
	private int sid;
	private String name;
	private String city;
	private Certificate certi;
	
	
	public Student() {
		super();
	}
	public Student(int sid, String name, String city, Certificate certi) {
		super();
		this.sid = sid;
		this.name = name;
		this.city = city;
		this.certi = certi;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Certificate getCerti() {
		return certi;
	}
	public void setCerti(Certificate certi) {
		this.certi = certi;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", city=" + city + ", certi=" + certi + "]";
	}
	

	
}
