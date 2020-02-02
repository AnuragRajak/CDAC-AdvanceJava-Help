package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml")) {
			System.out.println("SC started....");
			ATMImpl ref = ctx.getBean("my_atm", ATMImpl.class);
			ref.withdraw(100);
			ATMImpl ref2 = ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(ref == ref2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
