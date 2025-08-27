package crud_opeartions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entites.Student;

public class RemoveStudent {

	public static void main(String[] args) {
		
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_bi");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			//let say if we want to remove student with id 1
			
			Student remobj=em.find(Student.class, 1);
			
			et.begin();
			em.remove(remobj);
			et.commit();
			if(remobj==null) {
				System.out.println("REMOVED STUDENT SUCESSFULLY BECaUSE FROM 3RD TABLE IS ACTING F.K");
			}
			
			
			
			
	}
}
