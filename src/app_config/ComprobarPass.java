package app_config;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class ComprobarPass {
	static JFrame f;
	static Button entrar;
	static JPasswordField pField;
	
	//es para ver que funciona, se borrara cuando implementemos la pantalla de login
	public static void main(String[] args) {
		
		ConfigurationLoader config = ConfigurationLoader.getConfigurador();
		config.cargarConfiguracion();
		f = new JFrame();
		
		f.setLayout(new FlowLayout());
		entrar = new Button("Login");
		f.add(entrar);
		entrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean cp = comprobarPass(config.getEmployee_password());
				if (cp == true) {
					System.out.println("Pass correcta!");
					//añadir metodo que cree la ventana del formulario
				}
			}
		});
		pField = new JPasswordField();
		pField.setColumns(5);
		f.add(pField);
		f.setSize(200, 150);
		f.setVisible(true);
	}
	
	/**
	 * Comprueba si el password introducido en el JPasswordField esta en el ArrayList que le pasamos
	 * @param passwords - Es el ArrayList con las contraseñas que leemos del archivo XML de configuracion
	 * @return Devuelve <b>true</b> si el password introducido esta en el ArrayList, si el password no
	 * existe devolverá <b>false</b>
	 * @author Marc
	 */
	public static boolean comprobarPass(ArrayList<String> passwords) {
		char [] arrPass = pField.getPassword();
		
		String pass = "";
		for (int i = 0; i < arrPass.length; i++) {
			pass = pass+arrPass[i];
		}
		System.out.println(pass);
		for (int i = 0; i < passwords.size(); i++) {
			if (pass.equals(passwords.get(i))) {
				return true;
			}
		}
		return false;
	}
}
