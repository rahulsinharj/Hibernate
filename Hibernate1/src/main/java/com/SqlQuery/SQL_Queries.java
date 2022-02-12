package com.SqlQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SQL_Queries {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session ses = factory.openSession(); // factory.getCurrentSession();
		
		
/*		// SELECTING nonDynamic entries through HQL Syntax::
 		-------------------------------------------------									*/
		
		
		
		
		ses.close();
		factory.close();

	}

}
