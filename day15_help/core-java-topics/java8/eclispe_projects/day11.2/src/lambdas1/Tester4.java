package lambdas1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Tester4 {

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(10, 1, 34, 45, 20, 67, 1);
		//display list elems using forEach method
		//public void forEach(Consumer<? super T> c)
		l1.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.print(t+" ");
				
			}
			
		});
		//lambda expr
		l1.forEach(i -> System.out.println(i));
	}

}
