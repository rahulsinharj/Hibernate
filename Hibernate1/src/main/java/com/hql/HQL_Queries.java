package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.myHibernate.Student;

public class HQL_Queries {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session ses = factory.openSession(); // factory.getCurrentSession();

/*		// SELECTING nonDynamic entries through HQL Syntax ::
 		-----------------------------------------------------								*/
//		String query = "from Student where city = 'Bhopal' ";
//		Query q = ses.createQuery(query);


/*		// SELECTING Dynamic entries through HQL Syntax ::
 		--------------------------------------------------									*/
		String query = "from Student where city = :x and name = :n";
//			String query = "from Student as s where s.city = :x and s.name = :n";			// Using ALIAS
		Query q1 = ses.createQuery(query);
		q1.setParameter("x", "Bhopal");
		q1.setParameter("n", "Shiv");

		// fetching single object : // q.uniqueResult();

		// fetching multiple objects <List> :
		List<Student> stuList = q1.list();
		for (Student s : stuList) {
			System.out.println(s.getSid() + " -- " + s.getName() + " -- " + s.getCity());
		}

		
/*		// DELETING entries through HQL Syntax ::
		-----------------------------------------											*/	
		Transaction tx = ses.beginTransaction();
		Query q2 = ses.createQuery("delete from Student where city = :c");
		q2.setParameter("c", "Mumbai");
		int updResult = q2.executeUpdate();
		System.out.println("Deleted entries " + updResult);
		tx.commit();


/*		// UPDATING entries through HQL Syntax ::
		-----------------------------------------											*/
		Transaction tx3 = ses.beginTransaction();
		Query q3 = ses.createQuery("update Student set name = :n where sid= :id");
		q3.setParameter("n", "Shruti");
		q3.setParameter("id", 103);
		int delResult = q3.executeUpdate();
		System.out.println("Updated entries " + delResult);
		tx.commit();

		
/*		// SELECTING/EXECUTING Join entries through HQL Syntax ::
		---------------------------------------------------------							*/	
		Query q4 = ses.createQuery("select q.questionId, q.question, a.answer from Question as q INNER JOIN q.answers as a");
		List<Object[]> list4 = q4.getResultList();
		for (Object[] e : list4) {
			System.out.println(Arrays.toString(e));
		}

		ses.close();
		factory.close();
	}

}
