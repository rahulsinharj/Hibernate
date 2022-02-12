package com.SqlQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQL_Queries {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session ses = factory.openSession(); // factory.getCurrentSession();
		
		
/*		// SELECTING entries through HQL Syntax::
 		-----------------------------------------											*/
//		String query1 = "select * from student where course = 'Java Programming'";
		String query1 = "select * from student where course = :x";							// Putting dynamic entries through :x
		
		NativeQuery nq = ses.createSQLQuery(query1); 
		nq.setParameter("x", "Java Programming");
		List<Object[]> sList = nq.list();
		
		for(Object[] stu : sList) {
//			System.out.println(Arrays.toString(stu));						// Showing all index values of returned Student Array 
			System.out.println(stu[0] +" -- "+stu[4] +" -- "+stu[3]);		// Showing only some specific index values of returned Student Array 
		}
		
		ses.close();
		factory.close();

	}

}
