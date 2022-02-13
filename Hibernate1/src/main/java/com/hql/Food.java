package com.hql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Food {

	@Id
	private int fid;
	private String foodName;
	
	@Column(name = "food_rate")
	private int rate;
	
	public Food() {
		super();
	}
	public Food(int fid, String foodName, int rate) {
		super();
		this.fid = fid;
		this.foodName = foodName;
		this.rate = rate;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Food [fid=" + fid + ", foodName=" + foodName + ", rate=" + rate + "]";
	}
	
}