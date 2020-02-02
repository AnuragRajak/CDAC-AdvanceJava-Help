package test_def;

@FunctionalInterface
public interface Calculator {
	//public abstract
	double add(double d1, double d2);
	//public 
	default void test() {
		System.out.println("in def method imple.");
	}
}
