package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import fetch.FirstLevelCache.Book;

public class CriteriaExample {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();		// If by default our hibernate.cfg.xml file in inside "src/main/java/hibernate.cfg.xml" , then we no need to specify its source location inside configure();
		Session ses = factory.openSession(); 
	
/*		// FETCHING Records through CRITERIA Api - without manually writing any SQL query ::
 		------------------------------------------------------------------------------------					*/
		
		Criteria c = ses.createCriteria(Book.class);
		c.add(Restrictions.ge("price", 250));					// Restricting the criteria to retrieve records which has "price" of Book Entity >= 250 
		c.add(Restrictions.like("bookName", "Java%"));			// "bookName" starting with "Java"  	// like() is caseSensitive	; and ilike() is caseInSensitive	
																
		List<Book> bookList = c.list();
		
		for(Book b : bookList) {
			System.out.println(b);
		}
		

		ses.close();
		factory.close();
       

	}

}


