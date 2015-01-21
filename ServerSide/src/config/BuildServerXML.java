package config;


public class BuildServerXML {

	public static void main(String[] args) {
		ServerProperties sp = new ServerProperties(6636, 3);
		saveProperties.writeProperties(sp);
	}

}
