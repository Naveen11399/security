package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		File file= new File("./configuraton/config.properties");
		try {
			FileInputStream src= new FileInputStream(file);
			pro=new Properties();
			pro.load(src);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String  getAdminUrl() {
		String url=pro.getProperty("adminUrl");
		return url;
		
	}
	public String  getAdminUname() {
		String uname=pro.getProperty("adminuserName");
		return uname;
		
	}
	public String  getAdminPword() {
		String Pword=pro.getProperty("adminpword");
		return Pword;
		
	}

}
