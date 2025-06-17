package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyFileUtility {
	
	@SuppressWarnings("unused")
	public static String ReadPropertyFile(String FilePath, String Key) {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(FilePath));
			if (fis != null) {
				props.load(fis);
				String keyread = props.getProperty(Key);
				fis.close();
				return keyread;
			} else {
				throw new FileNotFoundException();
			}
		} catch (Exception e) {
			System.out.println("  --> Returning NULL property value due to : " + e.getMessage());
			return null;
		}

	}

	public static void WritePropertyFile(String FilePath, String Key, String Value) {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(FilePath));
			props.load(fis);

			props.setProperty(Key, Value);

			FileOutputStream fos = new FileOutputStream(new File(FilePath));
			props.store(fos, " --> Value for \"" + Key + "\" is updated as \"" + Value + "\"");
			fos.close();
			
		} catch (Exception e) {
			System.out.println("  --> Unable to write into property file : " + e.getMessage());
		}
	}
	
	public static void ClearAllContentInPropertyFile(String FilePath) {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(FilePath));
			props.load(fis);

			props.clear();

			FileOutputStream fos = new FileOutputStream(new File(FilePath));
			props.store(fos, " --> Entire Property file is cleared!!");
			fos.close();
			
		} catch (Exception e) {
			System.out.println("  --> Unable to remove attribute from property file : " + e.getMessage());
		}
	}
	
	public static void RemoveVariableFromPropertyFile(String FilePath, String Key) {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(FilePath));
			props.load(fis);

			props.remove(Key);

			FileOutputStream fos = new FileOutputStream(new File(FilePath));
			props.store(fos, " --> Attribute \"" + Key + "\" is removed!!");
			fos.close();
			
		} catch (Exception e) {
			System.out.println("  --> Unable to remove attribute from property file : " + e.getMessage());
		}
	}

}
