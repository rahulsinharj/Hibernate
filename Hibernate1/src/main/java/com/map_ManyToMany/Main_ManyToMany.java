package com.map_ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_ManyToMany {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		
		Emp e1 = new Emp();
		e1.setEid(1001);
		e1.setName("Rahul");
		
		Emp e2 = new Emp();
		e2.setEid(1002);
		e2.setName("Shubham");
		
		Project p1 = new Project();
		p1.setPid(8001);
		p1.setProjectName("Ecommerce Web Project");
		
		Project p2 = new Project();
		p2.setPid(8002);
		p2.setProjectName("Library Management Project");
		
		List<Emp> eList = new ArrayList<Emp>();
		eList.add(e1);  
		eList.add(e2);
		List<Project> pList = new ArrayList<Project>();
		pList.add(p1);  
		pList.add(p2);
		
		e1.setProjects(pList);
		p2.setEmps(eList);
		
		
		// Creating Session :
		Session ses = factory.openSession(); // factory.getCurrentSession();
		Transaction tx = ses.beginTransaction();

		
		ses.save(e1);
		ses.save(e2);
		ses.save(p1);
		ses.save(p2);
		tx.commit();
		
		ses.close();
		factory.close();

		System.out.println("ManyToMany DONE..!!");
	}

}
