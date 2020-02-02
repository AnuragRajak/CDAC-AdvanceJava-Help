package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Stock;

@Repository
@Transactional
public class StockDaoImpl implements IStockDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Stock getStockDetails(int id) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(Stock.class, id);
	}

	@Override
	public List<Stock> getAvailableStocks() {
		String jpql = "select s from Stock s";
		return sf.getCurrentSession().createQuery(jpql, Stock.class).getResultList();
	}

	@Override
	public String createNewStock(Stock s) {
		sf.getCurrentSession().save(s);
		return "Stock added with ID "+s.getId();
	}

	@Override
	public Stock updateStock(Stock s) {
		sf.getCurrentSession().update(s);
		return s;
 
	}

	@Override
	public String deleteStock(String name) {
		String jpql="select s from Stock s where s.name=:nm";
		Session hs=sf.getCurrentSession();
		Stock s=hs.createQuery(jpql, Stock.class).setParameter("nm", name).getSingleResult();
		hs.delete(s);
		return "Stock deleted with ID="+s.getId();
	}
	
	
	

}
