package Ch05;

import javax.swing.JFrame;

public class C01SwingMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("첫번째 프레임");
		frame.setBounds(100, 100, 500, 500);	// x축, y축, width, height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}