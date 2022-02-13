package fetch.SecondLevelCache;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
		
		// Caching using normal GET
//		School sch1 = session1.get(School.class, 2);
//		System.out.println("GET call :" +sch1);
		
		// Caching using HQL :
		Query q1 = session1.createQuery("from School_Details where scid = 3");		// "School_Details" is the EntityName ; Also ByDefault EntityName is the Class name, untill we specifically change it by doing  @Entity(name = "School_Details") in School class. 
		q1.setCacheable(true);														// For 2nd level caching, since we have done "cache.use_query_cache" as true in hibernate.cfg.xml  => so here also We have to specify it in QueryObj here.
		School sh1 = (School)q1.uniqueResult();										// Here returned item is the Entity obj	
		System.out.println("CREATE QUERY call :" +sh1);
		session1.close();
	
		
/*		// Second level Caching ::
 		-----------------------------------------											*/		
		Session session2 = factory.openSession(); 
		
		// Caching using normal GET
//		School sch2 = session2.get(School.class, 2);				// Since now we have enabled Second_level_caching which is associated with SessionFactory obj level , 
//		System.out.println("GET call :" +sch2);						// therefore Hibernate won't run here in background for same id which has already been recently fetched, because Hibernate has already stored School{id=2} obj into its cache memory -> through its FactorySession Level obj. 
//		
//		// Caching using HQL  :
//		Query q2 = session2.createQuery("from School_Details where school_id = 3");
//		q2.setCacheable(true);
//		School sh2 = (School)q2.uniqueResult();
//		System.out.println("CREATE QUERY call :" +sh2);
		
		session2.close();
		
// So we can conclude that these SchoolObj which have been stored in DB with the help of "factory" obj. Therefore these Book obj will remain associated till "factory" obj lifetime only. 
// Also we have only one SessionFactory obj in an Hibernate Application. 		
		
		
		factory.close();
         
	}

}
