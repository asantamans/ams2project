package Model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app_config.ConfigurationLoader;
import app_config.langLoader;

public class Login {

	public static boolean comprovarLogin(String user,String pass,JPanel panel,ConfigurationLoader config) {
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
		//Servira para cambiar el texto del boton aceptar de los JOptionPane
		Object[] ok_option = {langLoader.getText("OptionPaneOkOption")};
		
		if(!esCorrectoLogin) {
			JOptionPane.showOptionDialog(panel, langLoader.getText("loginErrorOp1"), langLoader.getText("OptionPaneError"), JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, ok_option, ok_option[0]);
			return false;
		}else if(!esCorrectoPassword){
			JOptionPane.showOptionDialog(panel, langLoader.getText("loginErrorOp2"), langLoader.getText("OptionPaneError"), JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, ok_option, ok_option[0]);
			return false;
		}else if(!esCorrectoLogin && !esCorrectoPassword) {
			JOptionPane.showOptionDialog(panel, langLoader.getText("loginErrorOp3"),langLoader.getText("OptionPaneError"), JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, ok_option, ok_option[0]);
			return false;
		}
		else {
			return true;
		}
	}

	public static Image  icono() {
		ImageIcon icon = new ImageIcon("src/icono.png");
		Image imagen = icon.getImage();
		return imagen;
	}

}
