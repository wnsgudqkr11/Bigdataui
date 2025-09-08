package Ch18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
	private String name;
	private Integer age;
	
	//
	public Person() {}
	
	//
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	//
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	//
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}

public class C01Map {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
		
		//filter
		List<Integer> list2 = list.stream()
			.filter((n)->{return n%2==0;})
			.collect(Collectors.toList());
		System.out.println(list2);
		
		//map
		List<Integer> list3 = list.stream()
			.filter((n)->{return n%2==1;})
			.map((n)->{return n*n;})
			.collect(Collectors.toList());
			System.out.println(list3);
			
		//sorted
		List<Person> list4 = Arrays.asList(
				new Person("a", 1),
				new Person("b", 2),
				new Person("c", 3),
				new Person("d", 4)
				);
		System.out.println(list4);
		
		// 나이순으로 내림차순 출력
		List<Person> list5 = list4.stream()
		     .sorted((a, b) -> b.getAge() - a.getAge()) // 나이 내림차순
		     .collect(Collectors.toList());
		
		list5.forEach(System.out::println);
		
		//
		List<Integer> list6 =
		list4.stream()
//			.map((el)->{return el.getAge();})
//			.map(el->el.getAge())
			.map(Person::getAge)
			.collect(Collectors.toList());
				
		System.out.println(list6);
	}
	
	

}
