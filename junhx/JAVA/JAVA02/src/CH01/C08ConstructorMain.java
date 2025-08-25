//package CH01;
//
//
//class C08Simple{
//	// 속성
//	int n1;
//	double n2;
//	boolean n3;
//	String n4;
//	
//	//기능
//	
//	// 디폴트 생성자
//	C08Simple(){
//		System.out.println("C08Simple() 생성자 호출");
//		this.n1 = 10;
//		this.n2 = 10.10;
//		this.n3 = true;
//		this.n4 = "TEST";
//	}
//	C08Simple(int n1){
//		System.out.println("C08Simple(int n1)");
//		this.n1 = n1;
//	}
//	C08Simple(int n1, double n2){
//		System.out.println("C08Simple(int n1, double n2)");
//		this.n1 = n1;
//		this.n2 = n2;
//	}
//	C08Simple(int n1, double n2, boolean n3){
//		System.out.println("C08Simple(int n1, double n2, boolean n3)");
//		this.n1 = n1;
//		this.n2 = n2;
//		this.n3 = n3;
//	}
//	C08Simple(int n1, double n2, boolean n3, String n4){
//		System.out.println("C08Simple(int n1, double n2, boolean n3, String n4)");
//		this.n1 = n1;
//		this.n2 = n2;
//		this.n3 = n3; 
//		this.n4 = n4; 
//	}
//	
//	@Override
//	public String toString() {
//		return "C08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
//	}
//	public C08Simple(int n1, double n2, boolean n3, String n4) {
//		super();
//		this.n1 = n1;
//		this.n2 = n2;
//		this.n3 = n3;
//		this.n4 = n4;
//	}
//	
//	
//	
//}
//
//
//public class C08ConstructorMain {
//
//	public static void main(String[] args) {
//		C08Simple ob0 = new C08Simple();
//		C08Simple ob1 = new C08Simple(10);
//		C08Simple ob2 = new C08Simple(10, 10, 10);
//		C08Simple ob3 = new C08Simple(10, 20, 20, true);
//		C08Simple ob4 = new C08Simple(10, 20, 20, true, "박준형");
//		
//		System.out.println(ob0);
//
//	}
//
//}
