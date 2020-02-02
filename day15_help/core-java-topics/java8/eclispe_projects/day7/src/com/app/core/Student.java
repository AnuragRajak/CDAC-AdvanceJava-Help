package com.app.core;

import java.util.Date;
import static utils.StudentUtils.*;

public class Student {
	private String prn, name;
	private Date dob;
	private double gpa;
	private Subject subject;

	public Student(String prn, String name, Date dob, double gpa, Subject subject) {
		super();
		this.prn = prn;
		this.name = name;
		this.dob = dob;
		this.gpa = gpa;
		this.subject = subject;
	}

	public Student(String prn) {
		super();
		this.prn = prn;
	}

	@Override
	public String toString() {
		return "Student [prn=" + prn + ", name=" + name + ", dob=" + sdf.format(dob) + ", gpa=" + gpa + "subject "
				+ subject;
	}

	public String getPrn() {
		return prn;
	}

	public String getName() {
		return name;
	}

	public Date getDob() {
		return dob;
	}

	public double getGpa() {
		return gpa;
	}

	public Subject getSubject() {
		return subject;
	}

}
