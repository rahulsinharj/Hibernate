package com.Cascade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map_OneToMany.Answer;
import com.map_OneToMany.Question;

public class Cascade_Main {							// Using One To Many

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session ses = factory.openSession(); 				// factory.getCurrentSession();
		

/*		// CASCADING through Hibernate ::
 		-----------------------------------------											*/
		// Creating Question :
		MyChild ch1 = new MyChild();
		ch1.setChildId(201);
		ch1.setName("Rano");

		MyToy t1 = new MyToy(6010,"Bat", ch1);
		MyToy t2 = new MyToy(6011,"Ball", ch1);
		MyToy t3 = new MyToy(6012,"Hat", ch1);
		MyToy t4 = new MyToy(6013,"Gun", ch1);
		
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
  	If we will use cascading then hame ses.save(a1); ses.save(a2); ses.save(a3); answers ko alag se save call karke kei xarurat nhi padegi.
  	So that ab -> koi bhi activity ab perform karege Main entity par to usse jitni bhi related entities hogi unpe khudse hi particular SAVE/DELETE operation perform ho jayegi    
	
	Putting inside @OneToMany(cascade = CascadeType.ALL) in MyChild class
*/
		
		ses.close();
		factory.close();
		
	}

}
