package Ch06;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URL;

public class C08URLStreamMain {

	public static void main(String[] args) throws Exception {

		URL url = (new URI("https://n.news.naver.com/mnews/article/014/0005397414").toURL());
		InputStream in = url.openStream();
		
		// 보조스트림 추가
		BufferedInputStream buffin = new BufferedInputStream(in);	// 보조스트림 (버퍼공간) 추가
		Reader rin = new InputStreamReader(buffin);					// byte -> char 변환
		
		Writer fout = new FileWriter("c:\\IOTEST\\index.html");
		
		 while(true) {
			 int data = rin.read();
			 if(data == -1)
				 break;
//			 System.out.print((char)data);
			 fout.write((char)data);
			 fout.flush();
		 }
		 fout.close();
		 rin.close();
		 buffin.close();
		 in.close();
	}

}
