package config;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class saveProperties {			//saves the server's properties to an XML file

	private static final String FILE_NAME = "resources/Properties.xml";
	
	public static void writeProperties(ServerProperties server) {
		File f = new File(FILE_NAME);
		XMLEncoder encoder = null;
		try {
			f.createNewFile();
			encoder = new XMLEncoder(new FileOutputStream(f));
			encoder.writeObject(server);
			System.out.println("file was successfully saved");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			encoder.close();
		}
		
	}
}
