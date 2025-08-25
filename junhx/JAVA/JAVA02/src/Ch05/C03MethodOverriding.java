package Ch05;


// 함수 재정의 (Method Overriding)
// 상속관계를 전제로 상위클래스의 메서드를 하위클래스가 재정의(고쳐 사용)하는 것을 허용한 문법
// 메서드의 헤더 부분을 동일하고 두고 본체({})의 로직을 수정하게끔 허용함으로 다양한 형태의 객체가
// 형성될 수 있도록 유도(다형성)
// 상위클래스로 부터 동일한 메서드를 물려받더라도 각 하위클래스마다 다른 기능구현의 결과물을 만들어낼 수 있다

// 오버로딩 VS 오버라이딩
// 오버로딩?
// 상속전제 X
// 함수 헤더 변경(함수 이름 중복 허용, 파라미터는 다양하게 허용)
// 개발자의 편의성에 중점(함수이름 단일화)

// 오버라이딩?
// 상속전제 O
// 함수의 본문 변경(헤더 고정)
// 다형성을 목적으로 한 문법요소


class Animal{
	void Sound() {System.out.println("소리낸다...");}
}

class Dog extends Animal{
	void Sound() {System.out.println("와르르ㅡ르라왈왈...");}
	
}

class Cat extends Animal{

	@Override
	void Sound() {
		// TODO Auto-generated method stub
		super.Sound();
	}
}

public class C03MethodOverriding {

	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.Sound();
		
		Dog dog = new Dog();
		dog.Sound();
		
		Cat cat = new Cat();
		cat.Sound();

		System.out.println("--------------------");
		animal = dog;		// 상위클래스형 참조변수 = 하위객체     // 자료형이 다르지만 오류가 안나는 이유 자동형변황 > 업캐스팅
		animal.Sound();
		animal = cat;
		animal.Sound();
	}

}
