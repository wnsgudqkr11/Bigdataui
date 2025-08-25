package Ch06;

// 일반 클래스 상속관계
class Parent{
	void func() {}
}

class Son extends Parent{
	void func() {System.out.println("Son's func2() call!");}
}

// 추상 클래스 상속관계 
//사용이유 : 메서드 구현의 강제성 부여
abstract class Parent2{
	abstract void func();	// 추상메서드(미완성된 함수, {}가 없는)
}

class Son2 extends Parent2 {
	void func() {System.out.println("Son2's func2() call!");}
}


public class C01AbstractMain {

	public static void main(String[] args) {
		
		// 일반 클래스 상속관계
		Parent ob1 = new Parent();		// 상위클래스형으로 객체 생성 O
		Son ob2 = new Son();			// 하위클래스형으로 객체 생성 O
		Parent ob3 = new Son();			// Upcasting 연결 O
		ob3.func();						// 재정의된 func() 접근 O
		
		
		System.out.println("------");
		// 추상 클래스 상속관계
//		Parent obj1 = new Parent2();	// 추상클래스로 객체 생성 X
		Son2 obj2 = new Son2();			// 하위클래스형으로 객체 생성 O
		Parent2 obj3 = new Son2();		// Upcasting 연결 O
		obj3.func();					// 재정의된 함수 접근 가능
	}

}
