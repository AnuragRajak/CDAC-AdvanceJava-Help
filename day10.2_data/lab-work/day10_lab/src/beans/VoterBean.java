package beans;

import dao.VoterDaoImpl;
import pojos.Voter;

public class VoterBean {
	private String email, password;
	private VoterDaoImpl dao;
	// results
	private Voter details;
	private String message;

	// constr
	public VoterBean() {
		System.out.println("voter bean constr");
		dao = new VoterDaoImpl();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Voter getDetails() {
		return details;
	}

	public String getMessage() {
		return message;
	}

	// B.L method for voter authentication
	public String validateVoter() {
		System.out.println("validate voter " + email + " " + password);
		try {
			details = dao.authenticateVoter(email, password);
			//chk if voter has alrdy voted 
			if(details.getStatus()) {
				message ="You have already voted!!!!!";
				return "status";
			}
			message="login successful";
			return "candidate_list";
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			// login failed
			message="Invalid login";
			return "login";
		}
	}
   //B.L method to update voting status
	public String updateStatus()
	{
		message=dao.updateVotingStatus(details);
		return "";
	}
}
