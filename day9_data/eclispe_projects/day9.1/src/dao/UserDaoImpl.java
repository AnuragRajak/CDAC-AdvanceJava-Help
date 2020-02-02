package dao;

import org.hibernate.*;
import static utils.HibernateUtils.*;

import java.util.Date;
import java.util.List;

import pojos.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User u) {

		// u --transient -- obj heap
		// get session
		Session hs = getSf().openSession();
		Session hs2 = getSf().openSession();

		// tx
		Transaction tx = hs.beginTransaction();
		System.out.println(hs == hs2);
		try {
			Integer id = (Integer) hs.save(u);// u -- PERSISTENT
			System.out.println("id " + id);
			System.out.println("Press enter to continue");
			System.in.read();
			tx.commit();// hib performs auto dirty checking
			// to synch state of db with that of L1 cache
			// insert query , auto session is closed
			// , db cn rets to pool.
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException("err", e);
		}
		System.out.println("is open " + hs.isOpen() + " is conn " + hs.isConnected());
		// u --- DETACHED
		return "User reg succeeded with ID " + u.getUserId();
	}

	@Override
	public User getUserDetails(int userId) {
		User u = null;// NA
		// HS
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			u = hs.get(User.class, userId);// u -- PERSISTENT
			u = hs.get(User.class, userId);
			u = hs.get(User.class, userId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return u;// u -- DETACHED
	}

	@Override
	public List<User> getAllUsers() {
		String jpql = "select u from User u";
		List<User> l1 = null;
		// HS
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, User.class).getResultList();
			// l1 -- list of PERSISTENT pojos
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;// l1 -- list of DETACHED pojos
	}

	@Override
	public List<User> getAllSelectedUsers(String role1, Date d1) {
		List<User> l1 = null;
		String jpql = "select u from User u where u.role = :rl and u.regDate > :dt";
		// HS
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, User.class).setParameter("rl", role1).setParameter("dt", d1).getResultList();
			// l1 --- list of persistent pojos
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;// l1 --- list of detached pojos
	}

	@Override
	public String updateUserDetails(String email1, String pass1, String newPass, double incrAmt) {
		String jpql = "select u from User u where u.email = :em and u.password =:pass";
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			User u = hs.createQuery(jpql, User.class).setParameter("em", email1).setParameter("pass", pass1)
					.getSingleResult();
			// user validated
			u.setPassword(newPass);
			u.setRegAmount(u.getRegAmount() + incrAmt);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "User's details updated...";
	}

	@Override
	public String deleteUserDetails(int userId) {
		String mesg = "User details deletion failed";
		// session
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			// get
			User u = hs.get(User.class, userId);// u --null / PERSISTENT
			if (u != null) {
				hs.delete(u);// u --- REMOVED
				mesg = "user dtls deleted successfully...";
			}
			tx.commit();// delete/l1 cache destroyed/db cn rets to the pool
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public List<User> deleteUserDetails(Date d) {
		String jpql = "select u from User u where u.regDate < :dt";

		List<User> users = null;
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			users = hs.createQuery(jpql, User.class).setParameter("dt", d).getResultList();
			// users --- list of persistent pojos
			for (User u : users)
				hs.delete(u); // u -- removed
			tx.commit();// delete queries / l1 cache destroyed / cn rets to pool
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;// users --- list of transient pojos
	}

	@Override
	public String bulkUpdateUserDetails(double discount, Date d1) {
		String mesg = "User updation failed";
		String jpql = "update User u set u.regAmount=u.regAmount-:d where u.regDate < :dt";
		// session
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			int updateCount = hs.createQuery(jpql).setParameter("d", discount).setParameter("dt", d1).executeUpdate();
			tx.commit();
			mesg=updateCount+" users are updated...";
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
