package Ch05;

import javax.swing.JFrame;

// 상속
class C02GUI extends JFrame{
	C02GUI(String title){
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class C02SwingMain {

	public static void main(String[] args) {
		new C02GUI("두번째 프레임 창이요");
	}

}
