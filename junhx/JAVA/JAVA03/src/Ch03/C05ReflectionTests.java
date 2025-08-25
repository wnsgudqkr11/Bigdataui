package Ch03;

import java.lang.reflect.Field;

class A{
	private String a;
	private int b;
}
public class C05ReflectionTests {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz = Class.forName(String.valueOf(A.class).split(" ")[1]);
		System.out.println(clazz.getSimpleName());
		 Field[] fields =  clazz.getDeclaredFields();
		 
		 for(Field field :fields) {
			 String [] datatype = field.getType().toString().split(".");
			 
			 System.out.println(field.getType().toString());
			 System.out.println(field.getName());
		 }	
	}
}