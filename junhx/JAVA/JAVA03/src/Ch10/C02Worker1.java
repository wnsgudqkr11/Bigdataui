package Ch10;

public class C02Worker1 implements Runnable{

	@Override
	public void run() {
		for(int i=0; i <5; i++) {
			System.out.println("Task01...");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
