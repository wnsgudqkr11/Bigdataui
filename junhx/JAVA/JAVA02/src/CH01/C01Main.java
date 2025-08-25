package CH01;

public class C01Main {

	public static void main(String[] args) {
		C01Person Park = new C01Person();
		Park.name = "박준형";
		Park.age = 25;
		Park.height = 172.9f;
		Park.weight = 59.9;

		System.out.printf("%s %d %f %f\n", Park.name, Park.age, Park.height, Park.weight);
	}

}
