package CH01;

class C03Person{
	public String name;
	public int age;
	public float height;
	public double weight;

	//기능	
	void talk() {System.out.printf("%s 님이 말합니다.\n",this.name);}
	void walk() {System.out.printf("%s 님이 걷습니다.\n",this.name);}
	//속성정보 확인
	void showInfo() {
		System.out.printf("%s %d %f %f\n", this.name,this.age,this.height,this.weight);
	}
	
	//toString
	@Override
	public String toString() {
		return "C03Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
}
public class C03PersonMain {

	public static void main(String[] args) {
		
		C03Person hong = new C03Person();
		// 속성 저장
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		
		// 기능 사용
		hong.talk();
		hong.walk();
		hong.showInfo();
		
		System.out.println(hong);
		
		System.out.println(hong.toString());
//		System.out.println(hong);

	}

}
