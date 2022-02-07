package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_OneToMany {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		
		// Creating Person :
		Person p1 = new Person();
		p1.setPersonId(104);
		p1.setName("Deepa");

		// Creating Bikes :
		Bike b1 = new Bike();
		b1.setBikeId(810);
		b1.setBike("Moto");
		b1.setPerson(p1);
	
		Bike b2 = new Bike();
		b2.setBikeId(811);
		b2.setBike("Honda");
		b2.setPerson(p1);
		
		Bike b3 = new Bike();
		b3.setBikeId(812);
		b3.setBike("Bajaj Sumo");
		b3.setPerson(p1);
		
		List<Bike> bikeList = new ArrayList<Bike>();
		bikeList.add(b1);
		bikeList.add(b2);
		bikeList.add(b3);
		
		p1.setBikes(bikeList);
		
				
		// Creating Session :
		Session ses = factory.openSession(); // factory.getCurrentSession();
		Transaction tx = ses.beginTransaction();

		ses.save(p1);
		ses.save(b1);
		ses.save(b2);
		ses.save(b3);
		
		tx.commit();
		
		// Fetching Ques and Ans from DB :
		Person per = ses.get(Person.class, 101);
		System.out.println(per.getName());
			
		for(Bike bk : per.getBikes()) {
			System.out.println(bk.getBike());
		}
		
		ses.close();
		factory.close();

		System.out.println("Fetch DONE..!!");
	}

}
