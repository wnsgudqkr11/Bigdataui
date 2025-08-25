package Ch06;

interface Tire{
	void run();
}

class HankookTire implements Tire{

	@Override
	public void run() {
		System.out.println("Hankook Tire rolls");
	}
	
}

class KumhoTire implements Tire{

	@Override
	public void run() {
		System.out.println("Kumho Tire rolls");
	}
	
}

class Car {
	Tire FL;
	Tire FR;
	Tire BL;
	Tire BR;
	
	Car(){
		FL = new HankookTire();
		FR = new HankookTire();
		BL = new HankookTire();
		BR = new HankookTire();
	}
	void start() {
		FL.run();
		FR.run();
		BL.run();
		BR.run();
	}
}

public class C04InterfaceMain {

	public static void main(String[] args) {
		Car car = new Car();
		
		car.FL = new KumhoTire();
		car.BR = new KumhoTire();
		car.start();
		
	}

}
