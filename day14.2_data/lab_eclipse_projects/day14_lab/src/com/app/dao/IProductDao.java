package com.app.dao;

import com.app.pojos.Product;

public interface IProductDao {
	Product getById(int pid);
	String createNewProduct(Product p);//p --transient
	String updateProductDetails(Product p);//p --detached
	String deleteProductDetails(int pid);
}
