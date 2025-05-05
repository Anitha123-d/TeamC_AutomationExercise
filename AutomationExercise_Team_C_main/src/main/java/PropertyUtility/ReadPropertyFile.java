package PropertyUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import GenericRepository.FrameworkConstant;

/**
 * This class is used to provide the Utility Methods To Handle Property file
 * 
 * 
 * @author USER
 */

public class ReadPropertyFile implements FrameworkConstant {
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public Properties property_obj = null;

	public String readData(String key) {
		// step1: Convert the physical file into java readable object by using
		// FileInputStream
		try {
			fis = new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// step2:Create an Object For Properties Class
		property_obj = new Properties();

		// step3: Load all the properties inside the file

		try {
			property_obj.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// step3: fetch the data
		String value = property_obj.getProperty(key);

		return value;

	}

	public void writeData(String key, String value) {
		// step1: Convert the physical file into java readable object by using
		// FileInputStream
		try {
			fis = new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// step2: Load all the properties inside the file
		try {
			property_obj.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// step4: write the new data using put method
		try {
			property_obj.put(key, value);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		// step5: convert the readable object into physical file using FileOutputStream
		try {
			fos = new FileOutputStream(propertypath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Step6: Strore the data
		try {
			property_obj.store(fos, value);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}