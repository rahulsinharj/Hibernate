package com.Cascade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hql.Food;
import com.map_OneToMany.Answer;
import com.map_OneToMany.Question;

public class Cascade_Main {							// Using One To Many

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session ses = factory.openSession(); 				// factory.getCurrentSession();
		

/*		// CASCADING through Hibernate - INSERTING Entries into DB ::
 ------------------------------------------------------------------------------------------------------------------------*/
		// Creating Question :
		MyChild ch1 = new MyChild();
		ch1.setChildId(103);
		ch1.setCname("Rimi");

		MyToy t1 = new MyToy(209,"Bat", ch1);
		MyToy t2 = new MyToy(210,"Ball", ch1);
		MyToy t3 = new MyToy(211,"Baloon", ch1);
		MyToy t4 = new MyToy(212,"Gun", ch1);
		
		List<MyToy> toyList = new ArrayList<>();
		toyList.add(t1);
		toyList.add(t2);
		toyList.add(t3);
		toyList.add(t4);
		
		ch1.setToys(toyList);
		
		Transaction tx = ses.beginTransaction();
		ses.save(ch1);
		tx.commit();
		
/*
  	If we will use cascading then hame ses.save(a1); ses.save(a2); ses.save(a3); answers ko alag se save call karke ki zarurat nhi padegi.
  	So that ab -> koi bhi activity ab perform karege Main entity par to usse jitni bhi related entities hogi unpe khudse hi particular SAVE/DELETE operation perform ho jayegi    
	
	Putting inside @OneToMany(cascade = CascadeType.ALL) in MyChild class
*/
		
		
/*		// Fetching SINGLE Entries from DB ::
 ------------------------------------------------------------------------------------------------------------------------*/
	
		MyChild ch = ses.get(MyChild.class, 102);						// Fetching record for childId = 102
		System.out.println(ch.getChildId()+" -- "+ch.getCname());
			
		for(MyToy ty : ch.getToys()) {
			System.out.println(ty.getToyId()+" -- "+ty.getToy()); 
		} 
		
		System.out.println("===================================================");
		
		
/*		// Fetching MULTIPLE Entries from DB - using HQL ::
 ------------------------------------------------------------------------------------------------------------------------*/	
		
		Query q1 = ses.createQuery("from MyChild");		// "select ch from MyChild ch" , will also work same way and is more readable.								
																						// Without where clause , Query LIST will return all the columns -> for every RowEntries.
//		Query q1 = ses.createQuery("from MyChild where cname = 'Rohit' ");				// "MyChild" is the EntityName ; Also ByDefault EntityName is the Class name ; untill we specifically change it by doing  @Entity(name = "  ") in MyChild class.
		
		
/*		Query q1 = ses.createQuery("from MyChild where cname = :nam ");					// Fetching entries by Dynamically inserting cname parameter 
		q1.setParameter("nam", "Rohit");													
*/
		
//		Query q1 = ses.createQuery("from MyChild where cname like 'R%' ");				// Fetching entries which have cname starting with "R"
	
		
/*		String searchWord = "R";														// Dynamically searching alike word
		Query q1 = ses.createQuery("from MyChild where cname like :word ");				// Fetching entries by Dynamically inserting LIKE parameter for cname , here unline JPA => cname like :word%  , don't work
		q1.setParameter("word", searchWord+"%");										// ****% means starts with  
*/		
		List<MyChild> childList = q1.list();											// Since because we have written "from Food" in our query, and we have not put any specific column names to fetch, therefore it will return us a whole FOOD class OBJECT -> having all filled values of its instance variables.
		for (MyChild mych : childList) 
		{
			System.out.println(mych.getChildId() + " -- " + mych.getCname());
			
			for(MyToy toy : mych.getToys()) {
				System.out.println(toy.getToyId()+" -- "+toy.getToy()); 
			} 
			System.out.println("------------------------------------------");
		}
		
		
		
		
		ses.close();
		factory.close();
		
	}
}
