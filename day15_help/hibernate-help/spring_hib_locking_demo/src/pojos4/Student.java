package pojos4;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "dac_stud1")
public class Student {

	private Long id;
	private String name;
	private Address adr;
	private long version;

	public Student() {
		System.out.println("in stud constr");
	}

	public Student(String name) {
		super();
		this.name = name;
	}


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="adr_id")
	public Address getAdr() {
		return adr;
	}
	public void setAdr(Address adr) {
		this.adr = adr;
	}
	@Version
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", adr=" + adr + "]";
	}



	

}