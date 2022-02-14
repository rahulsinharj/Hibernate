package com.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Id
	private int tid;
	private String tname;
	private String tech;
	
	public Teacher() {
		super();
	}
	public Teacher(int tid, String tname, String tech) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tech = tech;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tech=" + tech + "]";
	}
	
	
}
