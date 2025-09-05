package Ch12;

import java.io.DataInputStream;

public class ServerRecvThread  implements Runnable{

	//InputStream
	DataInputStream din;
	Sgui gui;
	ServerRecvThread(DataInputStream din,Sgui gui){
		this.din = din;
		this.gui = gui;
	}
	
	
	@Override
	public void run() {
		String recv;
		try {
			while(true) {
				//CLIENT->SERVER (수신)
				recv = din.readUTF();
				if(recv.equals("q"))
					break;
//				System.out.println("[CLIENT ] : " + recv);			
				gui.area.append("[CLIENT] "+recv+"\n");
			}
		}catch(Exception e) {
			System.out.println("[EXCEPTION] 예외발생 ServerRecvThread 종료");
			e.printStackTrace();
		}finally {
			try {din.close();}catch(Exception e2) {}
		}	
		
	}
	

}
