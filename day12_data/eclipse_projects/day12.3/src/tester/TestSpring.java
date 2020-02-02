package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATM;
import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml")) {
			System.out.println("SC strted...");
			// get bean from SC
			ATM ref1 = ctx.getBean("my_atm", ATMImpl.class);
			ref1.deposit(100);
			ATM ref2 = ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(ref1 == ref2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
