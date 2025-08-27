package crud_opeartions;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entites.Student;
import entites.Subject;

public class FetchDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_bi");
		EntityManager em=emf.createEntityManager();
		
		//lets find student with id 1
		Student s=em.find(Student.class, 1);//it return null if not found
		
		System.out.println(s);
		//also we can find subjects associates with this student with id 1
		System.out.println();
		System.out.println("========================================================");
		List<Subject> subjects=s.getSubjects();
		
		for(Subject s1:subjects) {
			System.out.println(s1);
		}
		
		//now we can fetch From subject as student record also
		
		Subject sub=em.find(Subject.class, 101);
		
		if(sub!=null) {
			System.out.println(sub);
		}
		else {
			System.out.println("NOT FOUND!..........");
		}
		
		System.out.println();
		System.out.println("NOW FROM SUBJECT WE CAN FETCH LIST OF STUDENT ASSOCIATE TO THIS SUBJECT ID 103");
		
		List<Student> students=sub.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		
	}
}
