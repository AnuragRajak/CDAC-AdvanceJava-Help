package pojos;

import java.util.Date;
import javax.persistence.*;

@Entity //mandatory
@Table(name="vendors")
public class Vendor {
	private Integer id;
	private String name,email,city,phoneNo;
	private double regAmount;
	private Date regDate;
	public Vendor() {
		System.out.println("in vendor constr");
	}
	public Vendor(String name, String email, String city, String phoneNo, double regAmount, Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.phoneNo = phoneNo;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	@Id //mandatory
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="vendor_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=10,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=10)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="ph_no",length=10)
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Column(name="reg_amt",columnDefinition="double(6,1)")
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="reg_date")
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", phoneNo=" + phoneNo
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}
	
	
	
	
}
