package com.SqlQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hql.Food;

public class SQL_Queries {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session ses = factory.openSession(); // factory.getCurrentSession();
		
		
/*		// SELECTING STUDENT entries through SQL Query Syntax:: {without receiving into a proper class entity}
 		-------------------------------------------------------								*/
//		String query1 = "select * from student where course = 'Java Programming'";
		String query1 = "select * from student where course = :x";							// Putting dynamic entries through :x
		
		NativeQuery nQuery = ses.createSQLQuery(query1); 
		nQuery.setParameter("x", "Java Programming");
		
		List<Object[]> sList = nQuery.list();
		
		for(Object[] stu : sList) {
//			System.out.println(Arrays.toString(stu));						// Showing all index values of returned Student Array 
			System.out.println(stu[0] +" -- "+stu[4] +" -- "+stu[3]);		// Showing only some specific index values of returned Student Array 
		}

		
/*		// SELECTING FOOD entries through SQL Query Syntax:: {receiving into a FOOD class entity}
 		----------------------------------------------------								*/
//		NativeQuery sqlQuery = ses.createSQLQuery("select fid,foodName,food_rate from Food_Details"); // put names of all columns of RowEntries
		NativeQuery sqlQuery = ses.createSQLQuery("select * from Food_Details");
		sqlQuery.addEntity(Food.class);						// With this we are telling hibernate that we have to receive RowEntries{containing all ENTIRE Columns} in the form of a FOOD object.
		
		List<Food> foodList = sqlQuery.list(); 
		
		for(Food f : foodList) {
			System.out.println(f);
		}
		
		
		ses.close();
		factory.close();
		
	}

}
