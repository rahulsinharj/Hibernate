package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchMain {

	public static void main(String[] args) {
		
		// get, load
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();	
        // No require of transaction open/close since we are not saving any transaction into db.
        
        Student stu = (Student)session.get(Student.class, 102);
        System.out.println(stu);
        
        Address ad = session.load(Address.class, 3);
        System.out.println(ad);
        System.out.println(ad.getStreet() +" : "+ad.getCity() );
        
        session.close();
        factory.close();
        System.out.println("Fetch DONE..!!");
	}

}
 