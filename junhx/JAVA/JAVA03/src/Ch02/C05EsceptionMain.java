package Ch02;

public class C05EsceptionMain {

	public static void main(String[] args) {

		try {
			String str = null;
			str.toString();
			
			int arr = {10, 20, 30};
//			arr[5] = 100;
			
			Animal tori = new Dog();
			Cat down = (Cat)tori;
	
		catch(Exception e) {
			System.out.println(e.getCause() + "예외처리");
		}
//		}catch(NullPointerException e1) {
//			System.out.println("NullPointer 예외처리 완");
//		}catch(ArrayIndexOutOfBoundsException e2) {
//			System.out.println("배열 예외처리 완");
//		}catch(ClassCastException e3) {
//			System.out.println("다운캐스팅 예외처리 완");
//		}
		
	}
}
