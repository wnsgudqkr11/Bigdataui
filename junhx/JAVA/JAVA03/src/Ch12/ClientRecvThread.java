package Ch12;

import java.io.DataInputStream;

public class ClientRecvThread implements Runnable{

	//InputStream
	DataInputStream din;
	Cgui gui;
	ClientRecvThread(DataInputStream din,Cgui gui){
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
//				System.out.println("[SERVER ] : " + recv);
				gui.area.append("[SERVER] : " + recv+"\n");
			}
		}catch(Exception e) {
			System.out.println("[EXCEPTION] 예외발생 ClientRecvThread 종료");	
		}finally {
			try {din.close();}catch(Exception e2) {}
		}	
		
	}

}
