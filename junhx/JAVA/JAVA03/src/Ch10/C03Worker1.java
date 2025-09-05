package Ch10;

public class C03Worker1 implements Runnable {

	C03GUI gui;

	public C03Worker1(C03GUI c03gui) {
		this.gui = c03gui;
	}

	@Override
	public void run() {
		while (true) {
			try {
				gui.area1.append("TASK01...\n");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("WORKER01 THREAD INTERRUPED...");
	}

}
