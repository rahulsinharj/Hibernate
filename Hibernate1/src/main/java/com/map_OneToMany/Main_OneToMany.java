package com.map_OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_OneToMany {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		
		// Creating Question :
		Question ques1 = new Question();
		ques1.setQuestionId(101); 
		ques1.setQuestion("What are feachers of Java ?");
		
		// Creating Answer's :
		Answer a1 = new Answer();
		a1.setAnswerId(9001);
		a1.setAnswer("Java is a programming language.");
		a1.setQuestion(ques1);
		
		Answer a2 = new Answer();
		a2.setAnswerId(9002);
		a2.setAnswer("Java is used to develop mobile apps, web apps and desktop apps.");
		a2.setQuestion(ques1);
		
		Answer a3 = new Answer();
		a3.setAnswerId(9003);
		a3.setAnswer("Java has an important feature of write once, run anywhere.");
		a3.setQuestion(ques1);
		
		List<Answer> answers1 = new ArrayList<Answer>();
		answers1.add(a1);
		answers1.add(a2);
		answers1.add(a3);
		ques1.setAnswers(answers1);
		
		// Creating Session :
		Session ses = factory.openSession(); // factory.getCurrentSession();
		Transaction tx = ses.beginTransaction();

		ses.save(ques1);
		ses.save(a1);
		ses.save(a2);
		ses.save(a3);
		
		tx.commit();
		
		// Fetching Ques and Ans from DB :
		Question qu = ses.get(Question.class, 101);
		System.out.println(qu.getQuestion());
			
		for(Answer ans : qu.getAnswers()) {
			System.out.println(ans.getAnswer());
		}
		
		ses.close();
		factory.close();

		System.out.println("Fetch DONE..!!");
	}

}
