package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    	EntityManager em = emf.createEntityManager();
    	
    	Teacher te = new Teacher(507, "Devika mam" , "Chemistry");
    	
    	// SAVING entities into DB
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	em.persist(te);
    	tx.commit();
    	
    	// FETCHING entities from DB
    	Teacher t = em.find(Teacher.class, 507);
    	System.out.println(t);
    	
    	
    	
    }
}
