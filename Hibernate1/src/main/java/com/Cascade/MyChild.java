package com.Cascade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MyChild {

	@Id
	@Column(name = "child_id")
	private int childId;
	
	@Column(name = "child_name")
	private String cname;
	
	@OneToMany(mappedBy = "mychild" , cascade = CascadeType.ALL)
	private List<MyToy> toys;

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<MyToy> getToys() {
		return toys;
	}
	public void setToys(List<MyToy> toys) {
		this.toys = toys;
	}

	@Override
	public String toString() {
		return "MyChild [childId=" + childId + ", cname=" + cname + ", toys=" + toys + "]";
	}

	
	
}
