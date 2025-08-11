package CH02;

public class C04변수_자료형 {

	public static void main(String[] args) {
//		int n2 =173;
//		int n3 = 0255;
//		int n4 = 0xad;
//		System.out.printf("%d %d %d\n", n2, n3, n4);

		byte n5 = (byte)-129;
		System.out.println(n5);
		System.out.println(0b10101101);
		
		char ch1 = 'a';
		System.out.println(ch1);
		System.out.println((int)ch1); // 011000001
		System.out.println(Integer.toBinaryString(ch1)); // 011000001
	}

}
