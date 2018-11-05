package mainClass;

import java.util.ArrayList;

import Model.*;
import app_config.ConfigurationLoader;
import app_config.langLoader;
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurationLoader config = ConfigurationLoader.getConfigurador();
		ArrayList<String> texto = new ArrayList<String>();
		texto = langLoader.getText(config.getLanguage());
		new loginFrame(texto);
	}
}

