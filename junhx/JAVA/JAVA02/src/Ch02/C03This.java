package Ch02;

//this
//클래스 내에서 사용되는 예약어
//생성되는 객체의 위치정보(메모리주소-해시코드값)을 확인하는데 사용

//this : 멤버변수와 지역변수 구별에 사용
//this : 다른생성자 호출 사용


class C03Simple{
	// 속성
	int x;
	int y;
	
	
	// 기능
	public C03Simple getThis() {
		return this;
	}
	
}
public class C03This {

	public static void main(String[] args) {
		
		C03Simple ob = new C03Simple();
		System.out.println(ob);
//		System.out.println(ob.getThis());
		
	}
}