package com.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.myHibernate.Certificate;
import com.myHibernate.Student;

// Hibernate Object State Persistent Life Cycle.

public class States_LifeCycle {

	public static void main(String[] args) {
		
	/* Types of states for Hibernate Obj :
	    1. Transient
	    2. Persistent
	    3. Detached
	    4. Removed   
	*/
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		
	    // Creating student Object
		Student student = new Student();
		student.setSid(106);
		student.setName("Shivam1");
		student.setCity("Bhopal");
		student.setCerti(new Certificate("Java Programming course", "4months"));
		
		// student obj : is now in Transient state - because neither this obj is associated with database not with session obj.
		
	    Session ses = factory.openSession();		 // factory.getCurrentSession();
	    Transaction tx = ses.beginTransaction();

    	ses.save(student);
    	student.setName("Shivam2");
    	tx.commit();
		// student obj : is now in Persistent state - because this obj is now associated with session obj as well database.

//    	ses.remove(student);	// student obj : is now in Removed state 
    	
    	
    	ses.close();
		student.setName("Shivam3");
    	// student obj : is now in Detached state - because this obj is now only associated with database, and got unAssociated with session obj.
    	// yaha pe ab koi values update karege iss student obj ki to wo session ke through DB me hi japayega
    	
    	
    	
    	
		factory.close();
	}
}
