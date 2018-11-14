package Model;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app_config.ConfigurationLoader;
import app_config.langLoader;
import configuracion_vehiculo.CarConfiguration;
import configuracion_vehiculo.Model;
import factura.Cliente;
import idao.ICarConfiguration;

public class loginFrame extends JFrame {
	private static JTextField textField;
	private JPasswordField passwordField;
	public static String titulo ="Car_Configurator";

	/**
	 * Create the frame.
	 */
	public loginFrame() {
		setIconImage(Login.icono());
		setTitle(titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{38, 11, 0, 38, 98, 0, 43, 58, 0};
		gbl_panel.rowHeights = new int[]{54, 0, 0, 29, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel(langLoader.getText("lblNewLabel"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel(langLoader.getText("lblPassword"));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 4;
		panel.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 4;
		panel.add(passwordField, gbc_passwordField);
		
		JButton btnNewButton = new JButton(langLoader.getText("btnNewButton"));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Login.comprovarLogin(textField.getText(),passwordField.getText(),panel,ConfigurationLoader.getConfigurador())) {
					datosguardados();
					panel.setVisible(false);
					esconderLogin();
				}
			}
		});
		
		
		passwordField.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				 if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					 if(Login.comprovarLogin(textField.getText(),passwordField.getText(),panel,ConfigurationLoader.getConfigurador())) {
						 datosguardados();	
						 panel.setVisible(false);
						 esconderLogin();
						}
	                }
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 6;
		panel.add(btnNewButton, gbc_btnNewButton);
		this.setVisible(true);
	}
	public void esconderLogin() {
		setVisible(false);
	}
	public static void datosguardados() {
		File f = new File ("fs_employee.txt");
		if(f.exists()) {
			//Cambiar texto botones JOptionPane
			Object[] options = {langLoader.getText("OptionPaneYesButton"), "No"};
			int op=JOptionPane.showOptionDialog(null, 
					langLoader.getText("OptionPaneSavedData"), langLoader.getText("OptionPaneInformation"),
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
			if(op==JOptionPane.YES_OPTION) {
				try {
					FileReader fr = new FileReader(f.getAbsoluteFile());
					BufferedReader br = new BufferedReader(fr);
					String linea;
					String modelo=null;
					int con=0;
					ArrayList <String> line = new ArrayList<>();
					while((linea=br.readLine())!=null){
						if (con <= 8) {
							String [] sp = linea.split(": ");
							line.add(sp[1]);
						}
						con++;
						if(con==8) {
							modelo=linea;
						}
					}
					if(con==7) {
						new Introducir_datos(textField.getText());
					}else if(con==8) {
						Cliente.setCliente(new Cliente(line.get(0), line.get(1), line.get(2), line.get(3), line.get(4), line.get(5), line.get(6)));
						new modelChooserFrame(textField.getText(),true);
					}else if(con==9) {
						ArrayList<Model> modelos;
						ICarConfiguration car_config = new CarConfiguration();
						car_config.load_Car_Config();
						modelos = car_config.getModelos();
						String []mod=modelo.split(": ");
						int pos=0;
						for(int a=0;a<modelos.size();a++) {
							if(modelos.get(a).getNom().equals(mod[1])) {
								pos=a;
							}
						}
						Cliente.setCliente(new Cliente(line.get(0), line.get(1), line.get(2), line.get(3), line.get(4), line.get(5), line.get(6)));
						new PantallaSubmodelos(modelos.get(pos),textField.getText(),true);
					}
					fr.close();
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else {
				f.delete();
				new Introducir_datos(textField.getText());
			}
		}else {
			new Introducir_datos(textField.getText());
		}
	}
}