package com.maven.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maven.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
										
					//start a transaction
					session.beginTransaction();
					
					// query students
					List<Student> theStudents = session.createQuery("from Student").getResultList();
					
					//display the students
					displayStudents(theStudents);
					
					// query students: lastName='Koneru'
					theStudents = session.createQuery("from Student s where s.lastName='Koneru'").getResultList();
					
					//display the students
					System.out.println("Students with last name Koneru");
					displayStudents(theStudents);
					
					//query students: lastName='Koneru' OR firstName='Santhosh'
					theStudents = session.createQuery("from Student s where s.lastName='Koneru' OR s.firstName='Santhosh'").getResultList();
					
					//display the students
					System.out.println("Students with last name Koneru or first name Santhosh");
					displayStudents(theStudents);
					
					//query students: where email like '%gmail.com''
					theStudents = session.createQuery("from Student s where s.email LIKE '%s@gmail.com'").getResultList();
					
					//display the students
					System.out.println("Students with email like '%s@gmail.com'");
					displayStudents(theStudents);
					
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		
		for(Student tempStudent: theStudents)
			System.out.println(tempStudent);
	}

}
