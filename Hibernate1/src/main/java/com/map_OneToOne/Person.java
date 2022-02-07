package com.map_OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	@Column(name = "person_id")
	private int personId;
	
	@Column(name = "person_name")
	private String name;
	
	@OneToOne							// @OneToOne ke karan "Person table" me "lap_id" ka ek Foreign Key column ban jayega -> joki "Laptop table" ka Primary key hoga.
	@JoinColumn(name = "lap_id")		// isse Foreign key ka name change kar skate hai DB me
	private Laptop laptop;
	
	
	public Person() {
		super();
	}
	public Person(int personId, String name, Laptop laptop) {
		super();
		this.personId = personId;
		this.name = name;
		this.laptop = laptop;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", laptop=" + laptop + "]";
	} 
	
	
	
}
