package config;


public class BuildClientXML {

	public static void main(String[] args) {
		ClientProperties cp = new ClientProperties(6636, "127.0.0.1");
		saveProperties.writeProperties(cp);
	}
}
