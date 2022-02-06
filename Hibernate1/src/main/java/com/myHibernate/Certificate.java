package com.hibernate;

import javax.persistence.Embeddable;

@Embeddable						// iss Embeddable ke karan iss certficate ka new table nhi banega -> uske jagah iss Certificate class ke jo 2 instance variable hai unke liye DB me Student table ke andar hi 2 new columns add ho jayega.		
public class Certificate {

	private String course;
	private String duration;
	
	
	public Certificate() {
		super();
	}
	public Certificate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Certificate [course=" + course + ", duration=" + duration + "]";
	}
	
	
}
