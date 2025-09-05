package Ch10;

public class C02ThreadMain {

	public static void main(String[] args) throws Exception{
		
		// Runnable
		// Runnable interface 를 이용한 스레드 분할
		
		// 01
		C02Worker1 w1 = new C02Worker1();
		C02Worker2 w2 = new C02Worker2();
		
		// 02
		Thread th1 = new Thread(w1);
		Thread th2 = new Thread(w2);
		
		// 03
		th1.start();
		th2.start();
		
		// Thread class를 바로 이용한 스레드 분할
		new Thread() {

			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("TASK03...");
					
					try {
						Thread.sleep(600);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}.start();
	}

}
