package Ch05;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

class C03GUI extends JFrame{
	C03GUI(String title){
		// Frame Setting
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// Panel Setting
		JPanel panel = new JPanel();
		Color col = new Color(255,255,0);
		panel.setBackground(col);
		
		add(panel);	// Frame에 Panel 추가
	}
}

public class C03SwingMain {

	public static void main(String[] args) {
		new C03GUI("세번째 프레임 창이요");
	}

}
