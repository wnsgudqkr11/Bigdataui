package Ch11;

import java.io.DataOutputStream;
import java.util.Scanner;

public class ServerSendThread implements Runnable{

	// 멤버로 놓아야 런을 쓸 수 있음
	// 멤버 설정

	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);
	
	public ServerSendThread(DataOutputStream dout) {
		this.dout = dout;
	}
	@Override
	public void run() {
		String send = null;
		while(true)
		{
			//
			try {
				System.out.print("[SERVER (q:종료)] : ");
				send = sc.nextLine();
				//Server->Client(송신)
				dout.writeUTF(send);
				dout.flush();
				if(send.equals("q"))
					break;
			}catch(Exception e) {
				System.out.println("[EXCEPTION] 예외발생 SEND THREAD 종료");
				break;
			}
			
		}

		sc.close();
		
	}

}
