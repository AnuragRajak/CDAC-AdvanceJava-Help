package java_8_features3;
interface Formula {
    double calculate(double a);

    default double sqrt(double a,double b) {
    	System.out.println("1");
        return Math.sqrt(a+b);
    }
    static void test()
    {
    	System.out.println("2");
    	System.out.println("in i/f static method");
    }
}
