package Ch05;

// 부모
class Super{
	int n1;
}

// 자식
class Sub extends Super{
	int n2;
}

public class C06UpDownCastingMain {

	public static void main(String[] args) {
		
		// NoCasting ( 형변환 없음 / 자료형 일치 )
		Super ob1 = new Super();
		ob1.n1 = 10;
		Sub ob2 = new Sub();
		ob2.n1 = 10;
		ob2.n2 = 20;		
		
		// UpCasting ( 상위클래스 참조변수 = 하위클래스형 객체 ) ( 자동형변환 )
		// 자동형변환이 일어나는 이유 ? 메모리 영역을 침범할 유려가 없기 때문에
		// UpCasting을 사용하는 이유 ? 1) 상속관계로 구성된 모든 하위객체를 연결할 수 있다 !!
//								   2) Upcasting된 상태에서는 재정의된 함수에 접근이 가능하다 !
		Super ob3 = new Sub();
		ob3.n1 = 100;
//		ob3.n2 = 200;
		Sub ob4 = ob2;
		ob4.n1 = 200;
//		ob4.n2 = 300;
		
		// DownCasting ( 하위클래스 참조변수 = 상위클래스형 객체 ) ( 강제형변환 )
		// 다운캐스팅은 업캐스팅을 전제로 하지만 이건 바로 다운캐스팅
//		Sub ob5 = (Sub)ob1;
//		ob5.n1 = 100; //실제 있는 n1공간에 값 대입 (문제 없음)
//		ob5.n2 = 200;
		
		Sub down = (Sub)ob4; // Upcasting을 전제로 한 Downcasting
		down.n1 = 1000;
		down.n2 = 2000;
		

	}

}
