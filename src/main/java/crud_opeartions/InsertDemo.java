package crud_opeartions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entites.Student;
import entites.Subject;

public class InsertDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//now we r inserting 1st Subjects
		
		Subject sub1=new Subject(101, "Physics");
		Subject sub2=new Subject(102, "Chemsitry");
		Subject sub3=new Subject(103, "Math");
		Subject sub4=new Subject(104, "Bio");
		
		//now creating list of subject
		
		List<Subject> subs1=new ArrayList<Subject>();
		subs1.add(sub1);
		sub1.equals(sub2);
		subs1.add(sub3);
		
		
		//now creating 2nd lsit of subject
		
		List<Subject> subs2=new ArrayList<Subject>();
		subs2.add(sub1);
		subs2.add(sub2);
		subs2.add(sub4);
		
		//now inserting Student
		
		Student s1=new Student(1, "Rohit", subs1);
		
		Student s2=new Student(2, "Virat", subs2);
		
		//now saving into database
		
		et.begin();
		
		em.persist(sub1);
		em.persist(sub2);
		em.persist(sub3);
		em.persist(sub4);
		
		em.persist(s1);
		em.persist(s2);
		
		et.commit();
	}
}
