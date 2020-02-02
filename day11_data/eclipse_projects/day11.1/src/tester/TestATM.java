package tester;

import dependency.HttpTransport;
import dependency.SoapTransport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		ATMImpl atm=new ATMImpl();
		//inject the dependency --by invoking a setter
		atm.setMyTransport(new SoapTransport());
		atm.withdraw(1000);
				

	}

}
