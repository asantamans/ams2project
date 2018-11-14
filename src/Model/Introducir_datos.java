package Model;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import app_config.langLoader;
import factura.Cliente;

public class Introducir_datos extends JFrame {

	public Introducir_datos() throws HeadlessException {
		super();
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnNoDeterminado;
	private JDateChooser dateChooser;
	private boolean guardado = false;

	/**
	 * Create the frame.
	 */
	public  Introducir_datos(String user) {
		setIconImage(Login.icono());
		setTitle(loginFrame.titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 399);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 38, 0, 56, 36, 37, 40, 42, 37, 35, 31, 0 };
		gbl_panel.rowHeights = new int[] { 51, 34, 35, 35, 35, 35, 35, 26, 28, 18, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblD = new JLabel(langLoader.getText("lblD"));
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setFont(new Font("Arial Black", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.gridwidth = 3;
		gbc_lblD.fill = GridBagConstraints.VERTICAL;
		gbc_lblD.anchor = GridBagConstraints.EAST;
		gbc_lblD.insets = new Insets(0, 0, 5, 5);
		gbc_lblD.gridx = 1;
		gbc_lblD.gridy = 0;
		panel.add(lblD, gbc_lblD);

		JLabel lblUsuariousuario = new JLabel(langLoader.getText("lblUsuariousuario") + user);
		GridBagConstraints gbc_lblUsuariousuario = new GridBagConstraints();
		gbc_lblUsuariousuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuariousuario.gridx = 7;
		gbc_lblUsuariousuario.gridy = 0;
		panel.add(lblUsuariousuario, gbc_lblUsuariousuario);

		JLabel lblNombre = new JLabel(langLoader.getText("lblNombre"));
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setVerticalAlignment(SwingConstants.TOP);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblPrimerApellido = new JLabel(langLoader.getText("lblPrimerApellido"));
		lblPrimerApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrimerApellido.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.anchor = GridBagConstraints.WEST;
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.gridx = 1;
		gbc_lblPrimerApellido.gridy = 2;
		panel.add(lblPrimerApellido, gbc_lblPrimerApellido);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 5;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 2;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblSegundoApellido = new JLabel(langLoader.getText("lblSegundoApellido"));
		lblSegundoApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.anchor = GridBagConstraints.WEST;
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.gridx = 1;
		gbc_lblSegundoApellido.gridy = 3;
		panel.add(lblSegundoApellido, gbc_lblSegundoApellido);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 5;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 3;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblDireccin = new JLabel(langLoader.getText("lblDireccin"));
		lblDireccin.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.WEST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 1;
		gbc_lblDireccin.gridy = 4;
		panel.add(lblDireccin, gbc_lblDireccin);

		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 5;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 4;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		JLabel lblCorreoElectronico = new JLabel(langLoader.getText("lblCorreoElectronico"));
		lblCorreoElectronico.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCorreoElectronico = new GridBagConstraints();
		gbc_lblCorreoElectronico.anchor = GridBagConstraints.WEST;
		gbc_lblCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoElectronico.gridx = 1;
		gbc_lblCorreoElectronico.gridy = 5;
		panel.add(lblCorreoElectronico, gbc_lblCorreoElectronico);

		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 5;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 5;
		panel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		JLabel lblGnero = new JLabel(langLoader.getText("lblGnero"));
		lblGnero.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.WEST;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 1;
		gbc_lblGnero.gridy = 6;
		panel.add(lblGnero, gbc_lblGnero);

		rdbtnHombre = new JRadioButton(langLoader.getText("rdbtnHombre"));
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_rdbtnHombre = new GridBagConstraints();
		gbc_rdbtnHombre.gridwidth = 3;
		gbc_rdbtnHombre.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHombre.gridx = 3;
		gbc_rdbtnHombre.gridy = 6;
		panel.add(rdbtnHombre, gbc_rdbtnHombre);

		rdbtnMujer = new JRadioButton(langLoader.getText("rdbtnMujer"));
		rdbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_rdbtnMujer = new GridBagConstraints();
		gbc_rdbtnMujer.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMujer.gridx = 6;
		gbc_rdbtnMujer.gridy = 6;
		panel.add(rdbtnMujer, gbc_rdbtnMujer);

		rdbtnNoDeterminado = new JRadioButton(langLoader.getText("rdbtnNoDeterminado"));
		rdbtnNoDeterminado.setSelected(true);
		rdbtnNoDeterminado.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_rdbtnNoDeterminado = new GridBagConstraints();
		gbc_rdbtnNoDeterminado.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNoDeterminado.gridx = 7;
		gbc_rdbtnNoDeterminado.gridy = 6;
		panel.add(rdbtnNoDeterminado, gbc_rdbtnNoDeterminado);

		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(rdbtnHombre);
		grupo1.add(rdbtnMujer);
		grupo1.add(rdbtnNoDeterminado);

		JLabel lblFechaNacimiento = new JLabel(langLoader.getText("lblFechaNacimiento"));
		lblFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 7;
		panel.add(lblFechaNacimiento, gbc_lblFechaNacimiento);

		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridwidth = 5;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 7;
		panel.add(dateChooser, gbc_dateChooser);

		JButton btnGuardar = new JButton(langLoader.getText("btnGuardar"));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.BOTH;
		gbc_btnGuardar.ipadx = 2;
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 9;
		panel.add(btnGuardar, gbc_btnGuardar);

		JButton btnS = new JButton(langLoader.getText("btnS"));
		GridBagConstraints gbc_btnS = new GridBagConstraints();
		gbc_btnS.fill = GridBagConstraints.BOTH;
		gbc_btnS.ipady = 1;
		gbc_btnS.ipadx = 1;
		gbc_btnS.gridwidth = 2;
		gbc_btnS.insets = new Insets(0, 0, 0, 5);
		gbc_btnS.gridx = 6;
		gbc_btnS.gridy = 9;
		panel.add(btnS, gbc_btnS);
		
		atras();

		/**
		 * 
		 * Listener del boton guardar,en el cual antes de guardar los datos comprobamos
		 * que los campos obligatorios no estan en blanco
		 * 
		 * @author carlos
		 */
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Servira para cambiar el texto del boton aceptar de los JOptionPane
				Object[] ok_option = {langLoader.getText("OptionPaneOkOption")};
				
				String campos_blanco = comprobarDatos();
				if (!campos_blanco.equals(langLoader.getText("OptionPaneArtic")) || !comprobarEmail()) {
					if (!campos_blanco.equals(langLoader.getText("OptionPaneArtic")))
						JOptionPane.showOptionDialog(panel, campos_blanco +langLoader.getText("btnGuardarListenerOp1"), langLoader.getText("OptionPaneError"),
								JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, ok_option, ok_option[0]);
					if (!comprobarEmail())
						JOptionPane.showOptionDialog(panel, langLoader.getText("btnGuardarListenerOp2"), langLoader.getText("OptionPaneError"),
								JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, ok_option, ok_option[0]);
				}else {
					guardado = true;
					JOptionPane.showOptionDialog(panel, langLoader.getText("btnGuardarListenerOp3"), langLoader.getText("OptionPaneInformation"),
							JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, ok_option, ok_option[0]);
					escribirFichero();
				}
			}

		});
		/**
		 * 
		 * Listener del boton siguiente, en el cual se comprueba que los campos
		 * obligatorios no estan vacios y te avisa si no has guardado.
		 * 
		 * @author carlos
		 * 
		 */
		btnS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Servira para cambiar el texto del boton aceptar de los JOptionPane
				Object[] ok_option = {langLoader.getText("OptionPaneOkOption")};
				
				String campos_blanco = comprobarDatos();
				boolean error = false;
				if (!campos_blanco.equals(langLoader.getText("OptionPaneArtic")) || !comprobarEmail()) {
					error = true;
					if (!campos_blanco.equals(langLoader.getText("OptionPaneArtic")))
						JOptionPane.showOptionDialog(panel, campos_blanco + langLoader.getText("btnSListenerOp1"), langLoader.getText("OptionPaneError"),
								JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, ok_option, ok_option[0]);
						
					if (!comprobarEmail()) {
						JOptionPane.showOptionDialog(panel,langLoader.getText("btnSListenerOp2"), langLoader.getText("OptionPaneError"),
								JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, ok_option, ok_option[0]);
					}
				} else if (!guardado && !error) {
					//Cambiar texto botones JOptionPane
					Object[] options = {langLoader.getText("OptionPaneYesButton"), "No"};
					int seguir = JOptionPane.showOptionDialog(null,
							langLoader.getText("btnSListenerOp3"), langLoader.getText("OptionPaneExtra1"),
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (seguir == JOptionPane.YES_OPTION) {				
						JOptionPane.showOptionDialog(panel, langLoader.getText("btnSListenerOp4"), langLoader.getText("OptionPaneAlert"),
								JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, ok_option, ok_option[0]);
						Cliente sinDatos = new Cliente("no name", "no primerApellido", "no segundoApellido", "no direccion", "no correoElectronico", "no genero", "no fechaNacimiento");
						boolean a=false;
						new modelChooserFrame(user,a);
						Cliente.setCliente(sinDatos);
					}
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String date = "";
					try {
						//le pasamos la fecha seleccionada
						date = sdf.format(dateChooser.getDate());
					} catch (Exception e2) {
						//si no hay ninguna fecha seleccionada le pasamos la fecha del sistema
						date = sdf.format(new Date());
					}					
					//comprueba que genero esta seleccionado
					if (rdbtnHombre.isSelected()) {
						//guardamos el cliente para poder consultarlo mas tarde
						Cliente datos_cliente = new Cliente(textField.getText(),
						textField_1.getText(), textField_2.getText(), textField_3.getText(),
						textField_4.getText(), rdbtnHombre.getText(), date);
						Cliente.setCliente(datos_cliente);
					} else if (rdbtnMujer.isSelected()) {
						//guardamos el cliente para poder consultarlo mas tarde
						Cliente datos_cliente = new Cliente(textField.getText(),
						textField_1.getText(), textField_2.getText(), textField_3.getText(),
						textField_4.getText(), rdbtnMujer.getText(), date);
						Cliente.setCliente(datos_cliente);
					} else if (rdbtnNoDeterminado.isSelected()) {
						//guardamos el cliente para poder consultarlo mas tarde
						Cliente datos_cliente = new Cliente(textField.getText(),
						textField_1.getText(), textField_2.getText(), textField_3.getText(),
						textField_4.getText(), rdbtnNoDeterminado.getText(), date);
						Cliente.setCliente(datos_cliente);
					}
					esconderFrame();
					boolean a=false;
					new modelChooserFrame(user,a);
				}

			}

		});
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//Cambiar texto botones JOptionPane
				Object[] options = {langLoader.getText("OptionPaneYesButton"), "No"};
				if(!guardado) {
					int op=JOptionPane.showOptionDialog(null,
							langLoader.getText("OptionPaneNotSaving"), langLoader.getText("OptionPaneClosing"),
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if(op == JOptionPane.NO_OPTION) {
						int op1=JOptionPane.showOptionDialog(null,
								langLoader.getText("OptionPaneSaving"), langLoader.getText("OptionPaneClosing"),
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if(op1==JOptionPane.YES_OPTION) {
						escribirFichero();
						//Servira para cambiar el texto del boton aceptar de los JOptionPane
						Object[] ok_option = {langLoader.getText("OptionPaneOkOption")};
						JOptionPane.showOptionDialog(panel, langLoader.getText("btnGuardarListenerOp3"), langLoader.getText("OptionPaneInformation"),
								JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, ok_option, ok_option[0]);
						int op3=JOptionPane.showOptionDialog(null,
								langLoader.getText("OptionPaneClosingConfirmation"), langLoader.getText("OptionPaneClosing"),
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						if(op3 == JOptionPane.NO_OPTION) {
							setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						}else {
							dispose();
						}
						
					}else if(op1==JOptionPane.NO_OPTION) {
						dispose();
					}
						setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}else {
						dispose();
					}
				}else {
					int op=JOptionPane.showOptionDialog(null,
							langLoader.getText("OptionPaneClosingConfirmation"), langLoader.getText("OptionPaneClosing"),
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if(op == JOptionPane.NO_OPTION) {
						setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}else {
						dispose();
					}
				}
			
			}

			});

	}

	private void esconderFrame() {
		setVisible(false);
	}

	private boolean comprobarEmail() {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		// El email a validar hola
		String email = textField_4.getText();

		Matcher mather = pattern.matcher(email);

		if (mather.find() == true) {
			return true;
		} else {
			return false;
		}

	}
	private void escribirFichero() {
		File f = new File ("fs_employee.txt");
		if(f.exists()) {
			f.delete();
		}
		try {
			FileWriter fr= new FileWriter(f.getAbsoluteFile(), true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write("Nombre: "+textField.getText()+System.getProperty("line.separator"));
			br.write("PrimerApellido: "+textField_1.getText()+System.getProperty("line.separator"));
			br.write("segundoApellido: "+textField_2.getText()+System.getProperty("line.separator"));
			br.write("Direccion: "+textField_3.getText()+System.getProperty("line.separator"));
			br.write("Email: "+textField_4.getText()+System.getProperty("line.separator"));
			if(rdbtnHombre.isSelected()) {
				br.write("Genero: "+rdbtnHombre.getText()+System.getProperty("line.separator"));
			}else if(rdbtnMujer.isSelected()) {
				br.write("Genero: "+rdbtnMujer.getText()+System.getProperty("line.separator"));
			}else {
				br.write("Genero: "+rdbtnNoDeterminado.getText()+System.getProperty("line.separator"));
			}
			if(dateChooser.getDate()==null) {
				SimpleDateFormat sdf_day = new SimpleDateFormat("dd-MMM-yyyy");
				String date = sdf_day.format(new Date());
				br.write("Fecha nacimiento: "+date+System.getProperty("line.separator"));
			}else {
			SimpleDateFormat sdf_day = new SimpleDateFormat("dd-MMM-yyyy");
			String date = sdf_day.format(dateChooser.getDate());
			br.write("Fecha nacimiento: "+date+System.getProperty("line.separator"));
			}
			br.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private String comprobarDatos() {
		String campos_blanco = langLoader.getText("OptionPaneArtic")+";";
		if (textField.getText().equals("")) {
			campos_blanco = campos_blanco.concat(langLoader.getText("lblNombre").substring(0, langLoader.getText("lblNombre").length()-1)+";");
		}
		if (textField_1.getText().equals("")) {
			campos_blanco = campos_blanco.concat(langLoader.getText("lblPrimerApellido").substring(0, langLoader.getText("lblPrimerApellido").length()-1)+";");
		}
		if (textField_2.getText().equals("")) {
			campos_blanco = campos_blanco.concat(langLoader.getText("lblSegundoApellido").substring(0, langLoader.getText("lblSegundoApellido").length()-1)+";");
		}
		if (textField_3.getText().equals("")) {
			if (campos_blanco.equals(langLoader.getText("OptionPaneArtic")))
				campos_blanco = langLoader.getText("OptionPaneArticFem")+";"+langLoader.getText("lblDireccin").substring(0, langLoader.getText("lblDireccin").length()-1);
			else
				campos_blanco = campos_blanco.concat(langLoader.getText("lblDireccin").substring(0, langLoader.getText("lblDireccin").length()-1)+";");
		}
		if (textField_4.getText().equals("")) {
			campos_blanco = campos_blanco.concat(langLoader.getText("lblCorreoElectronico").substring(0, langLoader.getText("lblCorreoElectronico").length()-1)+";");
		}

		int st = 0;
		String gd = "";
		for (int i = 0; i < campos_blanco.length(); i++) {
			if (campos_blanco.charAt(i) == ';') {
				if(i == campos_blanco.lastIndexOf(";")) {
					gd = gd+"";
				} 
				else if (st == 0){
					gd = gd+" ";
				} else {
					gd = gd+", ";
				}
				st++;
			}else {
				gd = gd+campos_blanco.charAt(i)+"";
			}
		}
		campos_blanco = gd;
		if (!comprobarEmail()) {

		}
		return campos_blanco;
	}
	private void atras() {
		File f = new File ("fs_employee.txt");
		if(f.exists()) {
			FileReader fr;
			try {
				fr = new FileReader(f.getAbsoluteFile());
				BufferedReader br = new BufferedReader(fr);
				String linea;
				String datos[]=new String[7];
				int con=0;
				while((linea=br.readLine())!=null){
					if(con<=6) {
						String [] temp=linea.split(": ");
						datos[con]=temp[1];
					}
					con++;
				}
				textField.setText(datos[0]);
				textField_1.setText(datos[1]);
				textField_2.setText(datos[2]);
				textField_3.setText(datos[3]);
				textField_4.setText(datos[4]);
				if(datos[5].equalsIgnoreCase("hombre")) {
					rdbtnHombre.setSelected(true);
				}else if(datos[5].equalsIgnoreCase("mujer")) {
					rdbtnMujer.setSelected(true);
				}else {
					rdbtnNoDeterminado.setSelected(true);
				}
				Date date = new Date(datos[6]);
				dateChooser.setDate(date);
				fr.close();
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
}
