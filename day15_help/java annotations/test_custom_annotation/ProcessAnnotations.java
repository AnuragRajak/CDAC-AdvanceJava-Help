package test_custom_annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ProcessAnnotations {

	public static void main(String[] args) {
		try {
			processAnnotation(ApplyToClass.class);
			Method m = ApplyToMethod.class.getMethod("someMethod");
			processAnnotation(m);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void processAnnotation(AnnotatedElement c) {
		System.out.println("Finding annotations on " + c.getClass().getName());
		Annotation[] annotations = c.getAnnotations();
		for (Annotation a : annotations) {
			if (a instanceof SomeInfo) {
				SomeInfo info = (SomeInfo) a;
				System.out.println("Author :" + info.author());
				System.out.println("Version :" + info.version());
				System.out.println("Price " + info.price());
			}
		}
	}

}
