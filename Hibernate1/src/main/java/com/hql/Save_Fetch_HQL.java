package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Save_Fetch_HQL {
	
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session ses = factory.openSession(); // factory.getCurrentSession();

/*		// INSERTING Dynamic entries ::
 		--------------------------------------------------									*/
//		Transaction tx = ses.beginTransaction();
//		Food f1 = new Food(101,"Samosa",50);		ses.save(f1);
//		Food f2 = new Food(102,"Jalebi",50);		ses.save(f2);	
//		Food f3 = new Food(103,"Pepsi",20);			ses.save(f3);
//		Food f4 = new Food(104,"Coke",35);			ses.save(f4);
//		Food f5 = new Food(105,"Paneer",50);		ses.save(f5);
//		Food f6 = new Food(106,"Pizza",20);			ses.save(f6);
//		
//		tx.commit();
		
		
/*		// FETCHING Dynamic entries through HQL Syntax ::
 		--------------------------------------------------									*/
//		Query q1 = ses.createQuery("from Food");								// Without where clause , Query LIST will return all the columns -> for every RowEntries.

//		Query q1 = ses.createQuery("from Food where rate = :r");				// "Food" is the EntityName ; Also ByDefault EntityName is the Class name ; untill we specifically change it by doing  @Entity(name = "Food_Details") in Food class, in that case put "Food_Details"   
//		q1.setParameter("r", 50);												// But when we only change  @Table(name = "School_Details") ,  and no change in @Entity name, then in that case again our class name will be Entity Name, that we have to put here ClassName in HQL query 
																				// And, after where condition for putting the where parameter -> either here we can write variable name "rate" or, Entity's Column changed name {@Column(name = "food_rate")} of Food class.
//		Query q1 = ses.createQuery("from Food where foodName = :fdname ");
//		q1.setParameter("fdname", "Samosa");
		
//		Query q1 = ses.createQuery("from Food where foodName like 'P%' ");		// FoodNames starting with "P"
		
		Query q1 = ses.createQuery("from Food where foodName like :fdname ");	// FoodNames starting with "P" -  inserting DYNAMICALLY
		q1.setParameter("fdname", "P"+"%");
		
		List<Food> foodList = q1.list();										// Since because we have written "from Food" in our query, and we have not put any specific column names to fetch, therefore it will return us a whole FOOD class OBJECT -> having all filled values of its instance variables.
		for (Food f : foodList) {
			System.out.println(f.getFid() + " -- " + f.getFoodName() + " -- " + f.getRate());
		}

		
/*		// FETCHING some specific columns from table ::
 		--------------------------------------------------									*/
		Query q2 = ses.createQuery("select fid,foodName,rate from Food");		// It will not return LIST of Food objects, now it will return LIST of Object[] arrays.
		List<Object[]> fList = q2.list();
		
		for(Object[] fd : fList) {
			System.out.println(Arrays.toString(fd));
//			System.out.println(fd[0] +" -- "+fd[1] +" -- "+fd[2]);		// Showing only some specific index values of returned Food Array 
		}
		
		
		
		ses.close();
		factory.close();
        
    }
}
