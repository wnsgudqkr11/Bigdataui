package Ch05;



class A{
	int a;
	
	//toString 재정의
	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
	
}
class B extends A{
	int b;
	
	//toString 재정의
	@Override
	public String toString() {
		return "B [b=" + b + ", a=" + a + "]";
	}

}
class C extends A{
	int c;
	
	//toString 재정의
	@Override
	public String toString() {
		return "C [c=" + c + ", a=" + a + "]";
	}
	
}
class D extends B{
	int d;
	
	//toString 재정의
	@Override
	public String toString() {
		return "D [d=" + d + ", b=" + b + ", a=" + a + "]";
	}
	
}
class E extends B{
	int e;
	
	//toString 재정의
	@Override
	public String toString() {
		return "E [e=" + e + ", b=" + b + ", a=" + a + "]";
	}
	
}
class F extends C{
	int f;
	
	//toString 재정의
	@Override
	public String toString() {
		return "F [f=" + f + ", c=" + c + ", a=" + a + "]";
	}
	
}
class G extends C{
	int g;
	
	//toString 재정의
	@Override
	public String toString() {
		return "G [g=" + g + ", c=" + c + ", a=" + a + "]";
	}
	
}

public class C07UpDownCastingMain {
	
	public static void UpDownCastTestFunc(A obj) {	// Upcasting
													// A obj = new A(); //NoCasting
													// A obj = new B(); //NoCasting
													// A obj = new C(); //NoCasting ...
		obj.a = 100;
		
		if(obj instanceof B) {
			B down = (B)obj;  // B에 맞게 다운캐스팅
			down.b = 200;
		}
		if(obj instanceof C) {
			C down = (C)obj;  // B에 맞게 다운캐스팅
			down.c = 300;
		}
		if(obj instanceof D) {
			D down = (D)obj;  // D에 맞게 다운캐스팅
			down.d = 400;
		}
		if(obj instanceof E) {
			E down = (E)obj;  // E에 맞게 다운캐스팅
			down.e = 300;
		}
		
		System.out.println(obj);
	}

	public static void main(String[] args) {
		UpDownCastTestFunc(new A());
		UpDownCastTestFunc(new B());
		UpDownCastTestFunc(new C());
		UpDownCastTestFunc(new D());
		UpDownCastTestFunc(new E());


	}

}
