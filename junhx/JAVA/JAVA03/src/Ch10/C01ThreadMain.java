package Ch10;

public class C01ThreadMain {

	public static void main(String[] args) throws Exception{

		for(int i=0; i <5; i++) {
			System.out.println("Task01...");
			Thread.sleep(500);
		}
		for(int i=0; i <5; i++) {
			System.out.println("Task0...");
			Thread.sleep(500);
		}
		
	}

}
