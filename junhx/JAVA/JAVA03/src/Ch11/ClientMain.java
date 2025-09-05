package Ch11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientMain {

	public static void main(String[] args) throws Exception {

		//
		Socket client = new Socket("192.168.5.11",7005);
		System.out.println("SERVER 와 연결 되었습니다.");
		//
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		//
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		
		//Worker생성
		ClientRecvThread recv = new ClientRecvThread(din);
		ClientSendThread send = new ClientSendThread(dout);
		//
		Thread th1 = new Thread(recv);
		Thread th2 = new Thread(send);
		//
		th1.start();
		th2.start();
		
		//
		th1.join();
		th2.join();
		
		//	
		dout.close();
		din.close();
		out.close();
		in.close();
		client.close();	
		System.out.println("[CLIENT] 연결 종료합니다");	

	}

}