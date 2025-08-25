package Ch05;

class Parent{
	void func1() {System.out.println("Parent's func1() call!");}
	void func2() {System.out.println("Parent's func2() call!");}
}


class Son extends Parent{
	// 만약 Parent에 void func2() {System.out.println("Parent's func2() call!");} 가 없다면 밑은 확장 / 지금은 재정의 !
	void func2() {System.out.println("Son's func2() call!");}
}


public class C08UpDownCastingMain {

	public static void main(String[] args) {
		// NoCasting
		Parent ob1 = new Parent();
		ob1.func1();
		
		System.out.println("-----------------");
		// NoCasting
		Son ob2 = new Son();
		ob2.func1();
		ob2.func2();
		
		System.out.println("-----------------");
		// UpCasting
		Parent ob3 = new Son();
		ob3.func1();
		ob3.func2();
		
		// Upcasting 된 상태에서
		// 확장된 (멤버추가) 멤버변수 접근 가능한가 ? x -> DownCasting 해야 가능
		// 확장된 (멤버추가) 멤버함수 접근 가능한가 ? x -> DownCasting 해야 가능 
		// 제정의된 멤버함수 접근 가능한가 ? O !!!!!!

	}

}
