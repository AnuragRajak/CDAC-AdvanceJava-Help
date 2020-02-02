package java_8_features;
interface Formula {
    double calculate(double a);

    default double sqrt(double a,double b) {
    	System.out.println("in def method imple");
        return Math.sqrt(a+b);
    }
}
