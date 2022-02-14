package com.mapping_xml;

public class Fruit {

	private int id;
	private String name;
	private String color;
	private int rate;
	
	public Fruit() {
		super();
	}
	public Fruit(String name, String color, int rate) {
		super();
		this.name = name;
		this.color = color;
		this.rate = rate;
	}
	public Fruit(int id, String name, String color, int rate) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.rate = rate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", color=" + color + ", rate=" + rate + "]";
	}
	
}
