package lambdas1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Tester5 {

	public static void main(String[] args) {
		List<Integer> l1=new ArrayList<>();
		int[] data= {10, 1, 34, 45, 20, 67, 1};
		for(int i : data)
			l1.add(i);
		l1.forEach(i->System.out.print(i+" "));
		// remove odd elems from the list
		//public boolean removeIf(Predicate<? super E> filter)
		/*l1.removeIf(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				
				return t % 2 != 0;
			}
			
		});*/
		l1.removeIf(i->i % 2 != 0);
		System.out.println();
		l1.forEach(i->System.out.print(i+" "));
	}

}
