package dao;

import java.util.List;
import static utils.HibernateUtils.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {

	@Override
	public List<Candidate> getCandidateList() {
		String jpql = "select c from Candidate c";
		List<Candidate> l1 = null;
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Candidate.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	@Override
	public String incrementVotes(int candidateId) {
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Candidate c = hs.get(Candidate.class, candidateId);
			// c -- PERSISTENT
			c.setVotes(c.getVotes() + 1);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Votes updated";
	}

}
