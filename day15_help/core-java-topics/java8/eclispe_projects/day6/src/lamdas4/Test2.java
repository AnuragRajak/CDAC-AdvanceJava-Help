package lamdas4;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Test2 {

	public static void main(String[] args) {
		// create empty AL of ints
		ArrayList<Integer> l1 = new ArrayList<>();
		for (int i = 1; i <= 20; i++)
			l1.add(i);
		System.out.println("orig list");
		l1.forEach(i -> System.out.print(i + " "));
	/*	l1.removeIf(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t % 2 != 0;
			}

		});*/
		
		l1.removeIf(t -> t % 2 != 0);
		System.out.println("even no  list");
		l1.forEach(i -> System.out.print(i + " "));

	}

}
