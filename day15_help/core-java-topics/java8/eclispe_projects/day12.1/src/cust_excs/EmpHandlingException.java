package cust_excs;

@SuppressWarnings("serial")
public class EmpHandlingException extends Exception {
	public EmpHandlingException(String mesg) {
		super(mesg);
	}
}
