package Generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_File 
{
	public String getpropertyVTIGERkeyvalue(String key) throws Throwable 
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Vtigercommondata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
}
