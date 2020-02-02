package dao;

import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {
	List<Candidate> getCandidateList();
	String incrementVotes(int candidateId);

}
