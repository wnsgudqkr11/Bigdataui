package Ch10;

public class C03Worker2 implements Runnable{

	C03GUI gui;

	public C03Worker2(C03GUI c03gui) {
		this.gui = c03gui;
	}

	@Override
	public void run() {
		while (true) {
			try {
				gui.area2.append("TASK02...\n");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("WORKER02 THREAD INTERRUPED...");
	}

}
