package Ch11;

import java.io.DataInputStream;

public class ServerRecvThread implements Runnable{

	DataInputStream din;
	public ServerRecvThread(DataInputStream din) {
		this.din = din;
	}

	@Override
	public void run() {
		String recv = null;
		while(true)
		{
			//
			try {
				//Client->Sever(수신)
				recv = din.readUTF();
				if(recv.equals("q"))
					break;
				System.out.println("[CLIENT] : "+recv);
			}catch(Exception e) {
				System.out.println("[EXCEPTION] 예외발생 SEND THREAD 종료");
				break;
			}
			
		}
	}
	

}