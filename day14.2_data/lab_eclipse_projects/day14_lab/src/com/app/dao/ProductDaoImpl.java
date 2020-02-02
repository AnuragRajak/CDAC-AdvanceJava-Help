package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Product;
import org.hibernate.*;

@Repository
@Transactional
public class ProductDaoImpl implements IProductDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Product getById(int pid) {
		System.out.println("dao id "+pid);
		return sf.getCurrentSession().get(Product.class, pid);
	}

	@Override
	public String createNewProduct(Product p) {
		sf.getCurrentSession().save(p);
		return "Product added with ID "+p.getId();
	}

	@Override
	public String updateProductDetails(Product p) {
		//p -- detached Product with updated state.
		//detached--->persistent ---update
		sf.getCurrentSession().update(p);
		return "Product updated with ID "+p.getId();
	}

	@Override
	public String deleteProductDetails(int pid) {
		Session hs=sf.getCurrentSession();
		Product p=hs.get(Product.class, pid);
		if(p != null) {
			hs.delete(p);
			return "Product deleted successfully";
		}
		
		return "Product Not found!!!!!";
	}

}
