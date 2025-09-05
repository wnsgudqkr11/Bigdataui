package Ch07;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class C03DataInoutStreamMain {

	public static void main(String[] args) throws Exception{
		
//		FileOutputStream out = new FileOutputStream("c:\\IOTEST\\test3.txt");
//		DataOutputStream dout = new DataOutputStream(out);
//		dout.writeUTF("홍길동");
//		dout.writeDouble(95.5);
//		dout.writeInt(100);
//		dout.flush();
//		dout.close();
		
		FileInputStream in = new FileInputStream("c:\\IOTEST\\test3.txt");
		DataInputStream din = new DataInputStream(in);
		String name= din.readUTF();
		System.out.println(name);
		double weight = din.readDouble();
		System.out.println(weight);
		int data = din.readInt();
		System.out.println(data);
		
	}
}