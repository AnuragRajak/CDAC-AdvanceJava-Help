package lambdas1;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<>();
		for (int i = 1; i <= 20; i++)
			l1.add(i);
		System.out.println("orig list");
		l1.forEach(i->System.out.println(i));
		l1.removeIf(i->i % 2 == 0);
		l1.forEach(i->System.out.println(i));

	}

}
