package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddMain {

	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();		 // factory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    
	    Student stu1 = new Student();
	    stu1.setSid(108);
	    stu1.setName("Priya");
	    stu1.setCity("Noida");
	    
	    Certificate cert1 = new Certificate();
	    cert1.setCourse("CProgramming");
	    cert1.setDuration("4Months");
	    stu1.setCerti(cert1);
	    
	    
	    Student stu2 = new Student();
	    stu2.setSid(109);
	    stu2.setName("Dinesh Kumar");
	    stu2.setCity("Bhopal");
	    
	    Certificate cert2 = new Certificate();
	    cert2.setCourse("PythonProgramming");
	    cert2.setDuration("1Months");
	    stu2.setCerti(cert2);
	   
	    // Saving Objects
	    session.save(stu1);
	    session.save(stu2);
	    tx.commit();			//  session.getTransaction().commit();  // alternate way
	    session.close();
	     

	}

}
