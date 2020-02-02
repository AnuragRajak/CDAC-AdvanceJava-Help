package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Voter;
import org.hibernate.*;

@Repository
@Transactional
public class VoterDaoImpl implements IVoterDao {

	// dependency
	@Autowired // byType
	private SessionFactory sf;

	@Override
	public Voter authenticateVoter(String em, String pass) {
		String jpql = "select v from Voter v where v.email=:em and v.pass=:pa";
		return sf.getCurrentSession().
				createQuery(jpql, Voter.class).
				setParameter("em", em).
				setParameter("pa", pass)
				.getSingleResult();
	}

	@Override
	public String updateVotingStatus(Voter v) {
		// v -- detached pojo
		v.setStatus(true);
		sf.getCurrentSession().update(v);//copies detached pojo ref to l1 cache.
		return "Voting status updated....";
	}

}
