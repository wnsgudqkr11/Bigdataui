package Ch02;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

public class C04ClassCastExceptionMain {

	public static void main(String[] args) {

		Animal poppi = new Dog(); // 업캐스팅
		Animal tori = new Cat(); // 업캐스팅

		// Dog로 다운캐스팅
		try {
			Dog down1 = (Dog) poppi; // O
			Dog down2 = (Dog) tori; // X
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}
}
