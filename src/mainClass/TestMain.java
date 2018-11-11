package mainClass;

import java.util.ArrayList;

import Model.*;
import app_config.ConfigurationLoader;
import app_config.langLoader;
public class TestMain {

	public static void main(String[] args) {
		ConfigurationLoader.getConfigurador();
		langLoader.getTextos();
		new loginFrame();
	}
}

