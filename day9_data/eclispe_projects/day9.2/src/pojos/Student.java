package pojos;
import javax.persistence.*;
@Entity
@Table(name="students")
public class Student extends AbstractEntity{
	@Column(length = 20)
	private String name;
	//many to one side of association
	@ManyToOne //mandatory o.w MappingExc
	//to specify name of FK column name in the owning side of asso.
	@JoinColumn(name="course_id")//optional BUT reco
	private Course selectedCourse;
	public Student() {
		System.out.println("in stud constr");
	}
	public Student(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course getSelectedCourse() {
		return selectedCourse;
	}
	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	@Override
	public String toString() {
		return "Student [name=" + name  + ", getId()=" + getId() + "]";
	}
	
	

}
