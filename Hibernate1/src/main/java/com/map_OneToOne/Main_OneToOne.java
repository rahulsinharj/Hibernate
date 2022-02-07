package com.map_OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map_OneToMany.Answer;
import com.map_OneToMany.Question;

public class Main_OneToOne {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Creating Person 1 ::
		Person per1 = new Person();
		per1.setPersonId(201);
		per1.setName("Rahul");

		// Creating Laptop 1 ::
		Laptop lap1 = new Laptop();
		lap1.setLaptopId(8001);
		lap1.setLaptop("Lenovo01");
		lap1.setPerson(per1);

		per1.setLaptop(lap1);

		// Creating Person 2 ::
		Person per2 = new Person();
		per2.setPersonId(202);
		per2.setName("Vikash");

		// Creating Laptop 2 ::
		Laptop lap2 = new Laptop();
		lap2.setLaptopId(8002);
		lap2.setLaptop("Dell01");
		lap2.setPerson(per2);

		
		per2.setLaptop(lap2);

		// Creating Session :
		Session session = factory.openSession(); // factory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(per1);
		session.save(lap1);
		session.save(per2);
		session.save(lap2);
		tx.commit();

		// Fetching Ques and Ans from DB :
		Person person = (Person) session.get(Person.class, 201);
		System.out.println(person.getName());
		System.out.println(person.getLaptop().getLaptop());

		session.close();
		factory.close();

	}

}
