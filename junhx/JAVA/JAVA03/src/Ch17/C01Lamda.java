package Ch17;

import java.util.ArrayList;
import java.util.List;

class Person{
	private String name;
	private int age;
	private String addr;
	
	// 기본
	public Person () {}
	
	// 모든
	public Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	//	Getter and Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	// toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
}

public class C01Lamda {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("jh",25,"Daegu"));
		list.add(new Person("zephyr",23,"van"));
		list.add(new Person("bella",26,"jj"));
		
		list.stream().forEach((item)->{System.out.println(item);});
		System.out.println("------------");
		list.sort((a,b)->{return b.getAge()-a.getAge();});	// a-b = 오름차순 / b-a = 내림차순
		
		list.stream().forEach((item)->{System.out.println(item);});
	}

}
