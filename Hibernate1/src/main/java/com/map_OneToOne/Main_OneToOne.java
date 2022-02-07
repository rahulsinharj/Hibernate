package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_OneToOne {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		
		// Creating Question :
		Question q1 = new Question();
		q1.setQuestionId(201);
		q1.setQuestion("What is Java ?");

		// Creating Answer :
		Answer a1 = new Answer();
		a1.setAnswerId(901);
		a1.setAnswer("Java is programming Language");
		a1.setQuestion(q1);
		q1.setAnswer(a1);

		
		// Creating Question 2 :
		Question q2 = new Question();
		q2.setQuestionId(202);
		q2.setQuestion("What is HTML ?");

		// Creating Answer 2 :
		Answer a2 = new Answer();
		a2.setAnswerId(902);
		a2.setAnswer("HTML is a web markup language");
		a2.setQuestion(q2);
		q2.setAnswer(a2);

		
	
		// Creating Session :
		Session session = factory.openSession(); // factory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(q1);
		session.save(a1);
		session.save(q2);
		session.save(a2);
		tx.commit();
		
		// Fetching Ques and Ans from DB :
		Question newQ = (Question)session.get(Question.class, 201);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());
		
		
		session.close();
		factory.close();

	}

}
