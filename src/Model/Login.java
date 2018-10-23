package Model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app_config.ConfigurationLoader;

public class Login {

	public static boolean comprovarLogin(String user,String pass,JPanel panel,ConfigurationLoader config) {
		//login.getText();
		String tField = user,pField=pass;
		boolean esCorrectoLogin=false;
		boolean esCorrectoPassword = false;
		ArrayList<String> usuario = config.getEmployee_list();
		ArrayList<String> password = config.getEmployee_password();
		for (int i = 0; i< usuario.size();++i) {
			String tUser = usuario.get(i);
			
			if (tUser.equals(user)) {
				String tPassword = password.get(i);
				esCorrectoLogin = true;
				if (tPassword.equals(pass)) {
					
					esCorrectoPassword = true;
				}
				
			}
		}
		if(!esCorrectoLogin) {
			JOptionPane.showMessageDialog(panel, "El Usuairo es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(!esCorrectoPassword){
			JOptionPane.showMessageDialog(panel, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(!esCorrectoLogin && !esCorrectoPassword) {
			JOptionPane.showMessageDialog(panel, "El Usuario y la contraseña son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			return true;
		}
	}
}
