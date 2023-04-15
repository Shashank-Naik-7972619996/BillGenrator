package Functions;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesCaller {

	Properties obj;
	
	public PropertiesCaller(){
		obj = new Properties();
		try {
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+ ".\\application.properties");
			obj.load(objfile);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		} 
	}
	public String Properties(String element) {
		
				String Obj1 = obj.getProperty(element);
				return Obj1;
	}
}