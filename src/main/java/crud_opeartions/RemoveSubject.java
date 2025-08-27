package crud_opeartions;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entites.Student;
import entites.Subject;

public class RemoveSubject {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//let say want to remove subject with id 102
		
		Subject remObj=em.find(Subject.class, 102);
		
		//now we need to fetch all students who is associate with this student ,since 
		//it is bi directional so we can acess from here only no need to write HQL query
		
		List<Student> students=remObj.getStudents();
		
		//now we r iterate using for each loop a Student 1 by 1
		for(Student s:students) {
			//using Iterator over subject which we r fetching with help of s.getSubjects
			
			Iterator<Subject> itr=s.getSubjects().iterator();
			
			//now using itr we r moving cursor all lsit of subject in arraylist
			
			//1st using while loop checking in the list if object present then go inside
			//and then move cursor 1 by 1
			
			while(itr.hasNext()) {
				Subject temp=itr.next();
				//now checking if subject id==remObj id then remove from 3rd table
				
				if(temp.getSub_id()==remObj.getSub_id()) {
					itr.remove();//it will remove where the cursor is pointing
				}
			}
		}
		
		//to do in database also
		
		et.begin();
		
		for(Student s:students) {
			em.merge(s);//now 1 by 1 student updating who is associating with this subject 
		}
		
		em.remove(remObj);
		
		et.commit();
	}
}
