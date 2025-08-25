package Ch05;

public class aaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



package Ch05;

class Employee {
	public String name;
	protected int age;
	protected String addr;
	
//	기본　생성자
//	모든　인자　생성자
	public Employee(String name, int age, String addr) {
	super();
	this.name = name;
	this.age = age;
	this.addr = addr;
}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}

class Parttimer extends Employee {
	private int hour_pay;
	
	// 기본
	public Parttimer() {}
	// 모든 인자
	public Parttimer(String name, int age, String addr, int hour_pay) {
		super(name, age, addr);
		this.hour_pay=hour_pay;
	}
	
	
	
	
	
	
	
}

class Regular extends Employee {

	private int salary;
}

public class C05Ex {

	public static void main(String[] args) {
		Parttimer emp1 = new Parttimer("홍길동", 25, "대구", 20000);
		emp1.setAge(100);
		
		Regular emp2 = new Regular("서길동", 45, "울산", 50000000);
		System.out.println(emp1);
		System.out.println(emp2);
	}

}

