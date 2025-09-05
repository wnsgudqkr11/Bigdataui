package Ch11;

import java.io.DataOutputStream;
import java.util.Scanner;

public class ClientSendThread implements Runnable {

	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);
	
	public ClientSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	@Override
	public void run() {
		String send = null;
		while(true)
		{
			//
			try {
				System.out.print("[CLIENT (q:종료)] : ");
				send = sc.nextLine();
				//Client->Server(송신)
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