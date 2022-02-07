package com.map_OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {

	@Id
	@Column(name = "laptop_id")
	private int laptopId;
	
	@Column(name = "laptop_name")
	private String laptop;
										// Kyuki "Person" table me already "laptop" ke foreign key hai {Kewal etna hi hota to UniDirectional Mapping reh jata}
										// But now since we have also included Foreign key of "Person" in this "Answer" table, to ab isse bhi "Person" table ka content pata lagaya ja sakta hai, So now it is BiDirectional Mapping.
	@OneToOne(mappedBy = "laptop")		// @OneToOne ke karan "Laptop table" me ek Foreign Key column ban jayega -> joki "Person table" ka Primary key hoga. 
	private Person person;				// mappedBy = "laptop" ke karan ab Laptop table me Person ka foreign key nhi banega ;  kewal bas Person table me hi "laptop" key banega.
	
	
	public Laptop() {
		super();
	}
	public Laptop(int laptopId, String laptop, Person person) {
		super();
		this.laptopId = laptopId;
		this.laptop = laptop;
		this.person = person;
	}
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptop() {
		return laptop;
	}
	public void setLaptop(String laptop) {
		this.laptop = laptop;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptop=" + laptop + ", person=" + person + "]";
	}


	

}
