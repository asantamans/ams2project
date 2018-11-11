package Model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app_config.ConfigurationLoader;
import app_config.User;
import app_config.langLoader;

public class Login {

	public static boolean comprovarLogin(String user,String pass,JPanel panel,ConfigurationLoader config) {
		//login.getText();
		//String tField = user,pField=pass;
		boolean esCorrectoLogin=false;
		boolean esCorrectoPassword = false;
		ArrayList<String> usuario = config.getEmployee_list();
		ArrayList<String> password = config.getEmployee_password();
		ArrayList<String> emp_version = config.getEmployee_version();
		for (int i = 0; i< usuario.size();++i) {
			String tUser = usuario.get(i);
			
			if (tUser.equals(user)) {
				String tPassword = password.get(i);
				esCorrectoLogin = true;
				if (tPassword.equals(pass)) {
					if (emp_version.get(i).equals("true")) {
						User usu = new User(usuario.get(i), true);
						User.setUsuario(usu);
					}
					else if (emp_version.get(i).equals("false")) {
						User usu = new User(usuario.get(i), false);
						User.setUsuario(usu);
					}
					esCorrectoPassword = true;
				}
				
			}
			
		
		}
		if(!esCorrectoLogin) {
			JOptionPane.showMessageDialog(panel, langLoader.getText("loginErrorOp1"), langLoader.getText("OptionPaneError"), JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(!esCorrectoPassword){
			JOptionPane.showMessageDialog(panel, langLoader.getText("loginErrorOp2"), langLoader.getText("OptionPaneError"), JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(!esCorrectoLogin && !esCorrectoPassword) {
			JOptionPane.showMessageDialog(panel, langLoader.getText("loginErrorOp3"),langLoader.getText("OptionPaneError"), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			return true;
		}
	}
}
