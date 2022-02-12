package com.Cascade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MyToy {

	@Id
	@Column(name = "toy_id")
	private int toyId;
	
	private String toy;
	
	@ManyToOne
	private MyChild mychild;
	
	
	public MyToy() {
		super();
	}
	public MyToy(int toyId, String toy, MyChild mychild) {
		super();
		this.toyId = toyId;
		this.toy = toy;
		this.mychild = mychild;
	}
	public int getToyId() {
		return toyId;
	}
	public void setToyId(int toyId) {
		this.toyId = toyId;
	}
	public String getToy() {
		return toy;
	}
	public void setToy(String toy) {
		this.toy = toy;
	}
	public MyChild getMychild() {
		return mychild;
	}
	public void setMychild(MyChild mychild) {
		this.mychild = mychild;
	}
	@Override
	public String toString() {
		return "MyToy [toyId=" + toyId + ", toy=" + toy + ", mychild=" + mychild + "]";
	}

	
	
}
