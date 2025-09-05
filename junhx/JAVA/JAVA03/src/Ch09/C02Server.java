package Ch09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Server {

	public static void main(String[] args) throws Exception{

		ServerSocket server = new ServerSocket(7000);
		System.out.println("[INFO] SERVER SOCKET LISTENING..");
		
		Socket client = server.accept();
		System.out.println("[INFO] SERVER ACCEPT.. CLIENT IP : " + client.getInetAddress());
		
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		
		Scanner sc = new Scanner(System.in);
		String recv = null;	// 수신용
		String send = null;	// 송신용
		
		while(true) {
			System.out.println("[SERVER (q:종료)] : ");
			send = sc.nextLine();
			if(send.equals("q"))
				break;
			// Server -> Client (송신)
			dout.writeUTF(send);
			dout.flush();
			// Client -> Server(수신)
			recv = din.readUTF();
			if(recv.equals("q"))
				break;
			System.out.println("[CLIENT] : " + recv);
		}
		
		sc.close();
		dout.close();
		din.close();
		out.close();
		in.close();
		client.close();
		server.close();
		System.out.println("[SERVER] 연결 종료합니다");
	}
}