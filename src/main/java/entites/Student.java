package entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	private Integer stud_id;
	private String stud_name;
	
	//now 1 student can associate with multiple subject ,so we need provide list of subjects
	
	@ManyToMany // @JoinTable defines the **join table** that Hibernate will use to link Students and Subjects
	@JoinTable(
			name="student_subject", // name of the join table in the database
			
			joinColumns = @JoinColumn(name="stud_id"),//This creates a foreign key column in student_subject table called stud_id.
					//It points back to the Student table’s primary key (stud_id).
			
			
			inverseJoinColumns = @JoinColumn(name="sub_id")//This creates a foreign key column in student_subject table called sub_id.

									//It points back to the Subject table’s primary key (sub_id).


			)
	private List<Subject> subjects;//the list of subjects for this student is stored.

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer stud_id, String stud_name, List<Subject> subjects) {
		super();
		this.stud_id = stud_id;
		this.stud_name = stud_name;
		this.subjects = subjects;
	}

	public Integer getStud_id() {
		return stud_id;
	}

	public void setStud_id(Integer stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", stud_name=" + stud_name + "]";
	}
	
	
	
	
}
