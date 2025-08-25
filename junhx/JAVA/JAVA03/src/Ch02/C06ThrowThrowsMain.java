package Ch02;

import java.awt.AWTException;

class A {
	public void Ex1() throws NullPointerException{
		System.out.println("A's Ex1 Func Call");
		
		String a = null;
		a.toString();
		
		System.out.println("Ex1에서 실행되어야 할 코드");
	}
}
class B {
	public void Ex2() throws AWTException{
		System.out.println("B's Ex1 Func Call");
		throw new AWTException("AWT 예외발생");
	}
}

public class C06ThrowThrowsMain {

	public static void main(String[] args) {
		
		A ob1 = new A();
		B ob2 = new B();
		
		try {
			ob1.Ex1();
			ob2.Ex2();
		}catch (NullPointerException e1) {
			System.out.println("Null 예외처리");
		}catch (AWTException e2) {
			System.out.println("AWT 예외처리");
		}
		
	}

}
