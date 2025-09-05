package Ch06;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class C04BufferAddrMain {

	public static void main(String[] args) throws IOException {
		Reader fin = new FileReader("c:\\IOTEST\\origin.txt");
		
		long startTime = System.currentTimeMillis();
		
		StringBuffer strBuffer = new StringBuffer();
		
		char [] buff = new char[4096];
		
		while(true) {
			int data = fin.read(buff, 0, buff.length);
			if(data==-1)
				break;
			strBuffer.append((char) data);
		}
		
		System.out.println("총길이 : " + strBuffer.length());
		fin.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 : "+ (endTime-startTime)+"ms");
	}
}