package Ch04;

class C01Simple{
	int n1;
	int n2;
	//디폴트 생성자
	C01Simple(){}
	
	// 모든 인자 생성자
	public C01Simple(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}

	// toString 재정의
	@Override
	public String toString() {
		return "C01Simple [n1=" + n1 + ", n2=" + n2 + "]";
	}
}

public class C01StaticMain {

	public static void main(String[] args) {
		C01Simple.n1=100;
		System.out.println(C01Simple.n1);
		
		C01Simple ob1 = new 

	}

}
