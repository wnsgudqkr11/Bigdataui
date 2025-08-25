package CH01;

// 변수 종류









class C05Simple{
	// 속성
	int num = 10;
	
	// 기능
	void Func1() {
		System.out.println("num : " + num);
		int num = 20; // Func1 의 지역변수
		num++;
		this.num++;
		System.out.println("num : " + num);
	}
	void Func2() {
		System.out.println("num : " + num);
		if(num>0) {				// 멤버변수 num
			int num = 100;		// if문 내의 지역변수 num
			System.out.println("num : " + num);
		}
		System.out.println("num : " + num);	// 멤버변수 num
		while(num<15) {			// 무한 루프
			int num=7;
			System.out.println("num : " + num);
			num++;
		}
	}
	void Func3(int num) {
		this.num = num; // 멤버에 넣으려면 this를 붙여야 함 웬만하면 멤버는 this 붙이기
	}
	
}

public class C05LocalVarMain {
	public static void main(String[] args) {
		
		C05Simple obj = new C05Simple();
		obj.Func1();
		System.out.println("-----------------");
		obj.Func2();

	}

}
