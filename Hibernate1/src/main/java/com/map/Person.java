package com.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@Column(name = "person_id")
	private int personId;
	
	@Column(name = "person_name")
	private String name;
										// Jo bhi Foreign key column creation ka kaam tha wo "Person" class ke bikes wale instance se chhinke kewal "Bike" class ke person ke de diya gaya hai.
	@OneToMany(mappedBy = "person")		// Matlab ab, jo bhi join colum banega -> wo banega "Bike" class ke Table ke "person" field me 	
	private List<Bike> bikes;			// One Person can have many bikes.
	
	
	public Person() {
		super();
	}
	public Person(int personId, String name, List<Bike> bikes) {
		super();
		this.personId = personId;
		this.name = name;
		this.bikes = bikes;
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
	public List<Bike> getBikes() {
		return bikes;
	}
	public void setBikes(List<Bike> bikes) {
		this.bikes = bikes;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", bikes=" + bikes + "]";
	}
	
	
}
