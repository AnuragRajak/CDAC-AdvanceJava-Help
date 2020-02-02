package dao;

import java.util.List;
import static utils.HibernateUtils.*;
import org.hibernate.*;

import pojos.Stock2;

public class StockDao {
	
	public Integer addStock(Stock2 s){
		Integer id=null;
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			id=(Integer)hs.save(s);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return id;
	}
	public List<Stock2> getStocks() {
		List<Stock2> l1 = null;
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery("select s from Stock2 s", Stock2.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	public String purchaseStock(int stockId, int qty) throws Exception {
		String mesg = "Stock purchase failed!";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Stock2 s = hs.get(Stock2.class, stockId);
			if (s != null) {
				s.setQuantity(s.getQuantity() - qty);
				mesg = "stock purchase successful @ price =" + s.getPrice();
				System.out.println("Press enter to continue");
				System.in.read();
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	public List<Stock2> updateStockPrices() {
		List<Stock2> l1 = null;
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery("select s from Stock2 s", Stock2.class).getResultList();
			l1.forEach(s->s.setPrice(s.getPrice()+500));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

}
