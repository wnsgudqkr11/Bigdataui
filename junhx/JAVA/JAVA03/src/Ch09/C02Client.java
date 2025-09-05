package Ch09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class C02Client {
	
	public static void main(String[] args) throws Exception {
		
		//
		Socket client = new Socket("SERVERIP",7000);
		System.out.println("SERVER 와 연결 되었습니다.");
		//
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		//
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		//
		Scanner sc = new Scanner(System.in);
		String recv = null;	//수신용
		String send = null;	//송신용
		while(true)
		{
			//Server->Client(수신)
			recv = din.readUTF();
			if(recv.equals("q"))
				break;
			System.out.println("[Server] : "+recv);
			
			//
			System.out.print("[CLIENT (q:종료)] : ");
			send = sc.nextLine();
			//Client->Server(송신)
			dout.writeUTF(send);
			dout.flush();
			if(send.equals("q"))
				break;		
		}
		sc.close();
		dout.close();
		din.close();
		out.close();
		in.close();
		client.close();
		System.out.println("[CLIENT] 연결 종료합니다");
		
	}
}