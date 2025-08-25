package CH01;

class C07Simple{
	
	int sum(int ...arg) {
		// ...arg 배열을 만듦
		System.out.println(arg);
		int s=0;
		for(int item : arg) {
			System.out.println(item);
			s+=item;
		}
		return s;
	}
}

public class C07가변인자 {

	public static void main(String[] args) {
		C07Simple obj = new C07Simple();
		obj.sum(10 ,20, 30, 40);

	}

}
