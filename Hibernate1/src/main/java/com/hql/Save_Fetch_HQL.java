package com.hql;

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
		Transaction tx = ses.beginTransaction();
		Food f1 = new Food(101,"Samosa",50);		ses.save(f1);
		Food f2 = new Food(102,"Jalebi",50);		ses.save(f2);	
		Food f3 = new Food(103,"Pepsi",20);			ses.save(f3);
		Food f4 = new Food(104,"Coke",35);			ses.save(f4);
		Food f5 = new Food(105,"Paneer",50);		ses.save(f5);	
		
		tx.commit();
		
/*		// SELECTING Dynamic entries through HQL Syntax ::
 		--------------------------------------------------									*/
		String query = "from Food where food_rate = 50";	// "Food" is the EntityName ; Also ByDefault EntityName is the Class name ; untill we specifically change it by doing  @Entity(name = "Food_Details") in Food class, in that case put "Food_Details"   
															// And, after where condition for putting the where parameter -> either we can write varible name "rate" or, Entity's changed Column name {@Column(name = "food_rate")}	 in Food class
		Query q1 = ses.createQuery(query);

		List<Food> foodList = q1.list();
		for (Food f : foodList) {
			System.out.println(f.getFid() + " -- " + f.getFoodName() + " -- " + f.getRate());
		}

		
		
		ses.close();
		factory.close();
        
    }
}
