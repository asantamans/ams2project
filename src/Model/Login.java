package Model;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app_config.ConfigurationLoader;
import app_config.User;
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
	public static void datosguardados() {
		File f = new File ("fs_employee.txt");
		if(f.exists()) {
			int op=JOptionPane.showConfirmDialog(null,
					"Hay datos guardados,desea cargarlos?", "Datos guardados",JOptionPane.YES_NO_OPTION);
			if(op==JOptionPane.YES_OPTION) {
				System.out.println("Cargar ventana pertienente");
			}else {
				f.delete();
			}
		}
	}
	public static Image  icono() {
		ImageIcon icon = new ImageIcon("src/icono.png");
		Image imagen = icon.getImage();
		return imagen;
	}

}
