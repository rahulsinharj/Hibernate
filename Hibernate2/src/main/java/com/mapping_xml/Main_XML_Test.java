package com.mapping_xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_XML_Test {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();		// If by default our hibernate.cfg.xml file in inside "src/main/java/hibernate.cfg.xml" , then we no need to specify its source location inside configure();
		Session ses = factory.openSession(); 
		
		
/*		// Inserting Entries in FRUIT Table ::
 		-----------------------------------------											*/
		Transaction tx = ses.beginTransaction();
		
		Fruit f1 = new Fruit(101,"Banana", "Yellow" , 20);
		Fruit f2 = new Fruit(102,"Guava", "Green" , 30);
		Fruit f3 = new Fruit(103,"Apple", "Red" , 40);
		Fruit f4 = new Fruit(104,"Lemon", "Orange" , 50);
		
		ses.save(f1);
		ses.save(f2);
		ses.save(f3);
		ses.save(f4);
		
        tx.commit();
	
		
	
		ses.close();
		factory.close();
       

	}

}
