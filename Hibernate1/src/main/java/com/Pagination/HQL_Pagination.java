package com.Pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.myHibernate.Student;

public class HQL_Pagination {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session ses = factory.openSession(); // factory.getCurrentSession();

/*		// Implementing PAGINATION using Hibernate ::
 		-------------------------------------------------									*/
		Query q = ses.createQuery("from Student");
		
		q.setFirstResult(7);		// firstly we can start with 0 , but currently we are starting with 8th element{7th index element , because indexing here also starts with 0} 
		q.setMaxResults(20);		// Per page search kewal 20 entries hi dega. 	
		List<Student> stuList = q.list();
		for(Student s : stuList) {
			System.out.println(s.getSid()+" "+s.getName()+" "+s.getCity());
		}
		
		
		ses.close();
		factory.close();
	}

}
