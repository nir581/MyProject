package config;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class saveProperties {			//saves the Client's properties to an XML file

	private static final String FILE_NAME = "resources/Properties.xml";
	
	public static void writeProperties(ClientProperties client) {
		File f = new File(FILE_NAME);
		XMLEncoder encoder = null;
		try {
			f.createNewFile();
			encoder = new XMLEncoder(new FileOutputStream(f));
			encoder.writeObject(client);
			System.out.println("file was successfully saved");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			encoder.close();
		}
		
	}
}
