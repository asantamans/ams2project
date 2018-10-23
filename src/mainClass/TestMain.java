package mainClass;

import java.util.ArrayList;

import Model.*;
import app_config.ConfigurationLoader;
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurationLoader config = ConfigurationLoader.getConfigurador();
		new loginFrame(config);
	}

}
