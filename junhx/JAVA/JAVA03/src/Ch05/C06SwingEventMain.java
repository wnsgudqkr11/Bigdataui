//package Ch05;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//
//class GUI extends JFrame implements ActionListener{
//	JButton btn1;
//	JButton btn2;
//	JButton btn3;
//	JButton btn4;
//	
//	public GUI(String title) {
//		// Frame Setting
//		super(title);
//		setBounds(100, 100, 405, 475);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		// Panel Setting
//		JPanel panel = new JPanel();
//		panel.setLayout(null);
//
//		// Component Setting
//		JTextArea area1 = new JTextArea();
//		JScrollPane scroll1 = new JScrollPane(area1);
//		scroll1.setBounds(10, 10, 260, 350);
//		
//		JTextField txt1 = new JTextField();
//		txt1.setBounds(10, 380, 260, 40);
//		
//		btn1 = new JButton("파일로 저장");
//		btn1.setBounds(280, 10, 100, 40);
//		btn2 = new JButton("1 : 1 요청");
//		btn2.setBounds(280, 60, 100, 40);
//		btn3 = new JButton("대화기록보기");
//		btn3.setBounds(280, 110, 100, 40);
//		btn4 = new JButton("입력");
//		btn4.setBounds(280, 380, 100, 40);
//		
//		// Event 처리
//		btn1.addActionListener(this);
//		btn2.addActionListener(this);
//		
//		btn3.addActionListener(this);
//		btn4.addActionListener(this);
//		
//		// Panel에 Component 추가
//		panel.add(scroll1);
//		panel.add(txt1);
//		panel.add(btn1);
//		panel.add(btn2);
//		panel.add(btn3);
//		panel.add(btn4);
//
//		// Frame에 Panel 추가
//		add(panel);
//
//		// Frame 표시 여부
//		setVisible(true);
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println(btn1);
//		System.out.println("BTN 클릭!" + e.getSource());
//		if(e.getSource()==btn1) {
//			System.out.println("파일로 저장 버튼 클릭");
//		}else if(e.getSource()==btn2) {
//			System.out.println("1 : 1 요청 버튼 클릭");
//		}else if(e.getSource()==btn3){
//			System.out.println("대화기록보기 버튼 클릭");
//		}else if(e.getSource()==btn4){
//			System.out.println("입력 버튼 클릭");
//		}
//	}
//}
//
//public class C06SwingEventMain {
//
//	public static void main(String[] args) {
//		new GUI("Chatting Server");
//
//	}
//
//}
