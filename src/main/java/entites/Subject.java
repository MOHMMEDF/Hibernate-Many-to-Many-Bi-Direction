package entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {

	@Id
	private Integer sub_id;
	private String sub_name;
	
	//now from here also 1 subject can associate with multiple Student so we,
	//need to provide list of students,
	
	@ManyToMany(mappedBy = "subjects")
	private List<Student> students;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(Integer sub_id, String sub_name) {
		super();
		this.sub_id = sub_id;
		this.sub_name = sub_name;
	}

	public Integer getSub_id() {
		return sub_id;
	}

	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Subject [sub_id=" + sub_id + ", sub_name=" + sub_name + "]";
	}
	
	
	
	
}
