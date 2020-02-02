package lamdas4;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Test1 {

	public static void main(String[] args) {
		//create empty AL of ints
		ArrayList<Integer> l1=new ArrayList<>();
		l1.add(10);l1.add(20);
		l1.add(30);l1.add(40);
		l1.add(50);l1.add(60);
		//System.out.println(l1);
		System.out.println("via ano inner class");
		l1.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.print(t+" ");
				
			}
			
		});
		System.out.println("via lambda expression");
		//inlining lambda expr
		l1.forEach(i->System.out.print(i+" "));
		System.out.println("\n contents again ");
		Consumer<Integer> c=t->System.out.println(t);
		l1.forEach(c);

	}

}
