package com.FirstLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/* 	# With the help of CACHING IN HIBERNATE - it can enhance the performance of Application.
	# Cache is use to reduce the number of database queries 										*/

//Second level caching is byDafault enabled & it is available at SESSION obj level and hence associated with SESSION object. 

public class FirstLevelCache_Main 		
{
    public static void main( String[] args )
    {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();		// If by default our hibernate.cfg.xml file in inside "src/main/java/hibernate.cfg.xml" , then we no need to specify its source location inside configure();
		Session ses = factory.openSession(); 
		
		
/*		// Inserting Entries in Book Table ::
 		-----------------------------------------											*/
//		Transaction tx = ses.beginTransaction();
//		
//		Book b1 = new Book("Data Structures Book" , 200);
//		Book b2 = new Book("Prod companies Book" , 250);
//		Book b3 = new Book("Revenue Book" , 370);
//        
//		ses.save(b1);
//		ses.save(b2);
//		ses.save(b3);
//		
//        tx.commit();
	
		
/*		// FETCHING stored Entries from Book Table ::
 		---------------------------------------------										*/		
		Book book1 = ses.get(Book.class, 3);
		System.out.println(book1);
		
		System.out.println("Working something.......");
		
		Book book2 = ses.get(Book.class, 3);					// Hibernate won't run here in background for same id which has already been recently fetched, because Hibernate has already stored Book{id=3} obj into its cache memory -> through its Session Level obj.  
		System.out.println(book2);
		
		System.out.println(ses.contains(book2));				// Checking stored book2 obj in sessionObj
		
// So we can conclude that these BookObj which have been stored in DB with the help of "ses" obj. Therefore these Book obj will remain associated till "ses" obj lifetime only, and not for session2		
		
		
		ses.close();
		factory.close();
         
		
    }
}
