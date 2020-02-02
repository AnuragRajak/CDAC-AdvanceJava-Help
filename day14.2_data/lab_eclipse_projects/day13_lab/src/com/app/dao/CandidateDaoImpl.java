package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Analysis;
import com.app.pojos.Candidate;
import org.hibernate.*;

@Repository
@Transactional 
public class CandidateDaoImpl implements ICandidateDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Candidate> getCandidateList() {
		String jpql = "select c from Candidate c";
		return sf.getCurrentSession().
				createQuery(jpql, Candidate.class).
				getResultList();
	}

	@Override
	public String incrementVotes(int candidateId) {
		Session hs=sf.getCurrentSession();
		Candidate c=hs.get(Candidate.class, candidateId);
		if(c != null)
		{
			c.setVotes(c.getVotes()+1);
			return "Votes incremented....";
		}
		return "Inc votes failed";
	}

	@Override
	public List<Analysis> votesAnalysis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> maxVotesCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

}
