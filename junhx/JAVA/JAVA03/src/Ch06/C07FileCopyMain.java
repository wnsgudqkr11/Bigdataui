package Ch06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Reader;
import java.io.Writer;

public class C07FileCopyMain {

	private static final String PATH="c:\\IOTEST\\";
	
	public static void main(String[] args) throws Exception{
		// args[0] : 원본파일 경로
				// args[1] : 원본파일 경로
				Reader fin = new FileInputStream(PATH+args[0]);
				Writer fout = new FileOutputStream(PATH+args[1]);
				
				while(true) {
					int data = fin.read();
					if(data == -1)
						break;
					fout.write((char)data);
					fout.flush();
				}
				fout.close();
				fin.close();

	}

}
