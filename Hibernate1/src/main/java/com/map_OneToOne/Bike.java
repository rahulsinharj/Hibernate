package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bike {

	@Id
	@Column(name = "bike_id")
	private int bikeId;
	
	@Column(name = "bike_name")
	private String bike;
	
	@ManyToOne
	private Person person;			// We can also add here @JoinColumn(name = "person_foreignKey_id")  for changing this join column name

	
	
	public Bike() {
		super();
	}

	public Bike(int bikeId, String bike, Person person) {
		super();
		this.bikeId = bikeId;
		this.bike = bike;
		this.person = person;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public String getBike() {
		return bike;
	}

	public void setBike(String bike) {
		this.bike = bike;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Bike [bikeId=" + bikeId + ", bike=" + bike + ", person=" + person + "]";
	}
	
}
