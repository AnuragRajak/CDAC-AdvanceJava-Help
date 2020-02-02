package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="stocks")
public class Stock {
	private Integer id;
	private String name,desc,company;
	private double price;
	@JsonFormat(pattern="dd-MM-yyyy") //at the of marshalling date ---> formatted string
	private Date publishDate;
	public Stock() {
		System.out.println("in stock constr");
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=20,unique=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,name="s_desc")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Column(length=20)
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Column(columnDefinition="double(9,1)")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="pub_date")
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", desc=" + desc + ", company=" + company + ", price=" + price
				+ ", publishDate=" + publishDate + "]";
	}
	
	

}
