package tester;

import org.hibernate.*;

import pojos.Vendor;

import static utils.HibernateUtils.*;

import java.util.List;

public class ClearDemo {

	public static void main(String[] args) {
		try {
			
			Session hs = getSf().getCurrentSession();
			// tx
			Transaction tx = hs.beginTransaction();
			try {
				List<Vendor> l1 = 
						hs.createQuery("select v from Vendor v",
								Vendor.class).getResultList();
				//l1 --- list of persistent pojos
				for(Vendor v : l1)
					v.setRegAmount(v.getRegAmount()+50);
				hs.clear();
				//l1 --- list of DETACHED pojos
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getSf().close();// cn pool will be destroyed.
		}

	}

}
