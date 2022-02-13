package com.SecondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//Second level caching is NOT byDafault enabled & it is available at SessionFactory obj level and hence associated with FACTORY object. 

public class SecondLevelCache_Main {	

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();		// If by default our hibernate.cfg.xml file in inside "src/main/java/hibernate.cfg.xml" , then we no need to specify its source location inside configure();
		Session session1 = factory.openSession(); 
				
/*		// Inserting Entries in Book Table ::
 		-----------------------------------------											*/
//		Transaction tx = ses.beginTransaction();
//		
//		School sc1 = new School("Dav Public School" , "Patna");
//		School sc2 = new School("HPS School" , "Noida");
//		School sc3 = new School("Vidya Public School" , "Delhi");
//		School sc4 = new School("Gaya Public School" , "Gaya");
//		
//		session1.save(sc1);
//		session1.save(sc2);
//		session1.save(sc3);
//		session1.save(sc4);
//		tx.commit();
		
		School sch1 = session1.get(School.class, 2);
		System.out.println(sch1);
	
		session1.close();
	
		
/*		// Second level Caching ::
 		-----------------------------------------											*/		
		Session session2 = factory.openSession(); 
		
		School sch2 = session2.get(School.class, 2);		// Since now we have enabled Second_level_caching which is associated with SessionFactory obj level , 
		System.out.println(sch2);							// therefore Hibernate won't run here in background for same id which has already been recently fetched, because Hibernate has already stored School{id=2} obj into its cache memory -> through its FactorySession Level obj. 
		
		session2.close();
		
// So we can conclude that these SchoolObj which have been stored in DB with the help of "factory" obj. Therefore these Book obj will remain associated till "factory" obj lifetime only. 
// Also we have only one SessionFactory obj in an Hibernate Application. 		
		
		
		factory.close();
         
	}

}
