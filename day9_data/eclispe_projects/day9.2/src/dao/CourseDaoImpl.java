package dao;

import pojos.Course;
import org.hibernate.*;
import static utils.HibernateUtils.*;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchCourse(Course c) {
		String mesg="Launching course failed...";
		// session
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			hs.persist(c);
			tx.commit();
			mesg="Course launched with ID : "+c.getId();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
