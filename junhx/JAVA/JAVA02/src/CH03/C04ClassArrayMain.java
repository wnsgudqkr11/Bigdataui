package CH03;

class C04Person{
	String name;
	int age;
	
	C04Person(){}
	
	//모든인자 생성자
	public C04Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//toSting 재정의
	@Override
	public String toString() {
		return "C04Person [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}

public class C04ClassArrayMain {
	
	public static void main(String[] args) {
		C04Person list[] = new C04Person[3];
		
		list[0] = new C04Person();
		list[0].name="홍길동";
		list[0].age = 66;
	
		System.out.println(list[0]);
		
	}
}
