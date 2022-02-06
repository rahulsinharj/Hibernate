package com.myHibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hibernate Project started..!!" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
               
     // Creating Student obj
        Student s1 = new Student();
        s1.setSid(101);
        s1.setName("Rahul");
        s1.setCity("Delhi");
        System.out.println(s1);
        
     // Creating Address obj  
        Address adr1 = new Address();
        adr1.setStreet("BigRd");
        adr1.setCity("Mumbai");
        adr1.setOpen(true);
        adr1.setAddedDate(new Date());
        adr1.setX(55.25);
        
     // Reading file
        FileInputStream fis = new FileInputStream("src/main/java/rj pic.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        adr1.setImage(data); 
        
        Session session = factory.openSession();		 // factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(s1);
        session.save(adr1);
        
        tx.commit();			//  session.getTransaction().commit();  // alternate way
        session.close();
            
        System.out.println("Transaction DONE..!!");
        
    }
}
