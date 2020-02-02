package dao;

import pojos.Department;
import org.hibernate.*;
import static utils.HibernateUtils.*;

public class DepartmentDaoImpl implements IDepartmentDao {

	@Override
	public String createNewDept(Department d) {
		String mesg="adding dept failed";
		// session
		Session hs=getSf().getCurrentSession();
		//tx
		Transaction tx=hs.beginTransaction();
		try {
			//d -- transient
			hs.save(d);//persistent
			tx.commit();//ins, l1 cache destroyed , cn rets to pool
		    mesg="successfully added new dept";
		}catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
