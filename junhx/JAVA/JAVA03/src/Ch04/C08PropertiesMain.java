package Ch04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class C08PropertiesMain {

	public static void main(String[] args) throws IOException {
		
		String classPath = System.getProperty("java.class.path");
		System.out.println("classPath : " + classPath);
		String dirPath = System.getProperty("user.dir");
		System.out.println("dirPath : " + dirPath);
		String packagePath = C08PropertiesMain.class.getPackageName();
		System.out.println("packagePath : " + packagePath);
		
		String filePath = dirPath+File.separator +"src"+File.separator +packagePath+File.separator+"application.properties";
		System.out.println("filePath : " + filePath);
		FileInputStream fin = new FileInputStream(filePath);
		
		Properties properties = new Properties();
		properties.load(fin);
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.printf("%s %s %s \n", url,username,password);
	}

}