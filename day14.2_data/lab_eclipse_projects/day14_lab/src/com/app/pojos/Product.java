package com.app.pojos;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="products")
public class Product {
	private Integer id;
	private String name,category;
	private double price;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expDate;
	public Product() {
		System.out.println("product constr");
	}
	public Product(String name, String category, double price, Date expDate) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.expDate = expDate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 20,unique = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 20)
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column(name="exp_date")
	@Temporal(TemporalType.DATE)
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	

}
