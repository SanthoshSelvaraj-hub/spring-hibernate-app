package com.maven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maven.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save java object
			
			//create 3 student objects
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("Pavani","Kallempudi","pav@gmail.com");
			Student tempStudent2 = new Student("Sushma","Koneru","sush@gmail.com");
			Student tempStudent3 = new Student("Sumanth","Nacharam","boss@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			System.out.println("Saving the students...");
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
	}

}
