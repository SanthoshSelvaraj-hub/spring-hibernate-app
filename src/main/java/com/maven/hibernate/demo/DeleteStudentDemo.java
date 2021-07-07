package com.maven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maven.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					int studentId = 6;

					//now get a new session and start transaction
					session = factory.getCurrentSession();
					session.beginTransaction();
					
					//retrieve student based on the id
					System.out.println("\nGetting student with id: " + studentId);
					
					Student myStudent = session.get(Student.class, studentId);
					
//					session.delete(myStudent);
					
					session.createQuery("delete from Student where id=5").executeUpdate();
					
					//commit transaction
					session.getTransaction().commit();
					
				}
				finally {
					factory.close();
				}
		
	}

}
