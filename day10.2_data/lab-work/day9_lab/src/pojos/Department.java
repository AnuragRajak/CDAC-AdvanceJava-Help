package pojos;
/*
 * deptId(Integer),name(unique)
 * ,location(string),emps
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="dac_depts")
public class Department extends AbstractEntity {
	@Column(length = 20,unique = true)
	private String name;
	@Column(length = 20)
	private String location;
	//one to many
	@OneToMany(mappedBy = "dept",cascade = CascadeType.ALL)
	private List<Employee> emps = new ArrayList<>();

	public Department() {
		System.out.println("dept constr");
	}
	
	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", location=" + location + ", getId()=" + getId() + "]";
	}
	//add helper methods for add/remove emp
	public void addEmp(Employee e)
	{
		emps.add(e);//dept ---> emp
		System.out.println(e.getDept());
		e.setDept(this);//emp--->dept
	}
	public void removeEmp(Employee e)
	{
		emps.remove(e);//dept -XX--> emp
		e.setDept(null);//emp--XX->dept
	}
}
