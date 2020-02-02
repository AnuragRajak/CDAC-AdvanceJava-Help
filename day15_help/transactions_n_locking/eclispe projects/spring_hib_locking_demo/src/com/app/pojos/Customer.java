package com.app.pojos;

import java.util.Date;
import javax.persistence.*;

import javax.validation.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.*;

@Entity
@Table(name="new_custs")
public class Customer {

	private Integer id;
	@NotNull
	@Range(min = 200, max = 2000)
	private double depositAmt;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String name;
//	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{3,20})", message = "Blank or Invalid Format")
	private String password;
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date regDate;
	@NotEmpty
	private String role;
	
	private int version;
	

	public Customer() {
		System.out.println("in cust constr...");
	}

	public Customer(double depositAmt, String email, String name,
			String password, Date regDate, String role) {
		super();
		this.depositAmt = depositAmt;
		this.email = email;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
		this.role = role;
	}
	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="dep_amt",columnDefinition="double(7,1)")
	public double getDepositAmt() {
		return this.depositAmt;
	}

	public void setDepositAmt(double depositAmt) {
		this.depositAmt = depositAmt;
	}
	@Column(length=20,unique=true)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="reg_dt")
	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Column(length=20)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	@Version
	@Column(name="ver_no")
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", depositAmt=" + depositAmt + ", email="
				+ email + ", name=" + name + ", password=" + password
				+ ", regDate=" + regDate + ", role=" + role + "]";
	}

}