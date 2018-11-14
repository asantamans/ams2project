package mainClass;

import java.util.ArrayList;

import Model.*;
import app_config.ConfigurationLoader;
import app_config.langLoader;
public class TestMain {

	public static void main(String[] args) {
		ConfigurationLoader.getConfigurador();
		ArrayList<String> texto = new ArrayList<String>();
		texto = langLoader.getText(ConfigurationLoader.getLanguage());
		new loginFrame(texto);
	}
}

