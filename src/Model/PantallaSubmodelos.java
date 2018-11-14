package Model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app_config.langLoader;
import configuracion_vehiculo.CarConfiguration;
import configuracion_vehiculo.Model;
import configuracion_vehiculo.Motor;
import idao.ICarConfiguration;

import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;

public class PantallaSubmodelos extends JFrame {

	private JPanel contentPane;
	private int selectedSubmodel;// la posicion del submodelo que seleccionamos
	private ArrayList<Integer> preciosSubmodelos = new ArrayList<Integer>();// guarda los precios de los submodelos
	private int pos = 0;
	private ArrayList<Motor> motores;
	private int precio;
	private JList list;
	private String nombre_submod;

	/**
	 * Create the frame.
	 */
	public PantallaSubmodelos(Model modelo, String usuari, boolean atras) {
		setIconImage(Login.icono());
		setTitle(loginFrame.titulo);
		// implementacion de DAO cada vez que se inicia la pantalla, carga los datos de
		// los coches
		ICarConfiguration car_config = new CarConfiguration();
		car_config.load_Car_Config();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 435);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 20, 0, 20));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 69, 169, 169, 169, 169, 169, 169, 169 };
		gbl_contentPane.rowHeights = new int[] { 19, 1, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lbTitulo = new JLabel(langLoader.getText("lbTitulo"));
		lbTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lbTitulo = new GridBagConstraints();
		gbc_lbTitulo.gridwidth = 6;
		gbc_lbTitulo.insets = new Insets(10, 0, 5, 5);
		gbc_lbTitulo.gridx = 0;
		gbc_lbTitulo.gridy = 0;
		contentPane.add(lbTitulo, gbc_lbTitulo);

		
		ArrayList<Motor> motores = car_config.getMotores();
		String[] submodelos = new String[motores.size()];
		// añado submodelos a un array de Strings
		for (int i = 0; i < submodelos.length; i++) {
			precio = modelo.getPreu() + motores.get(i).getPreu();
			String euro = "\u20ac";//Simbolo del euro
			preciosSubmodelos.add(precio);
			String submdTxt = modelo.getNom() + " " + motores.get(i).getNom() + " | " + motores.get(i).getDescripcio()
					+ " | " + precio + euro;
			submodelos[i] = submdTxt;
		}

		JLabel lblUsuario = new JLabel(langLoader.getText("lblUsuario") + usuari);
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.gridwidth = 2;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 6;
		gbc_lblUsuario.gridy = 0;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		// añado el array al JList
		list = new JList(submodelos);
		if (atras) {
			atras(modelo);
			list.setSelectedIndex(pos);
		} else {
			list.setSelectedIndex(pos);
		}
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				selectedSubmodel = list.getSelectedIndex();
			}
		});
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.HORIZONTAL;
		gbc_list.insets = new Insets(30, 0, 210, 0);
		gbc_list.gridwidth = 8;
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		contentPane.add(list, gbc_list);

		JButton btnAnterior = new JButton(langLoader.getText("btnAnterior"));
		btnAnterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				boolean a = true;
				new modelChooserFrame(usuari, a);

			}
		});
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.gridwidth = 2;
		gbc_btnAnterior.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnterior.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnterior.gridx = 1;
		gbc_btnAnterior.gridy = 2;
		contentPane.add(btnAnterior, gbc_btnAnterior);

		JButton btnSiguiente = new JButton(langLoader.getText("btnSiguiente"));
		btnSiguiente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File ("fs_employee.txt");
				try {
					FileReader fr = new FileReader(f.getAbsoluteFile());
					BufferedReader br = new BufferedReader(fr);
					String linea;
					String datos[]=new String[8];
					int con=0;
					while((linea=br.readLine())!=null){
						if(con<=7) {
							String [] temp=linea.split(": ");
							datos[con]=temp[1];
						}
						con++;
					}
					fr.close();
					br.close();
				if(f.exists()) {
					f.delete();
				}
			
				escribir(datos);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				setVisible(false);
				
				//Le pasamos el precio del submodelo seleccionado a la siguiente ventana
				int precioSm = preciosSubmodelos.get(selectedSubmodel);
				
				new Accesorios_coche(modelo, nombre_submod, usuari, precioSm, selectedSubmodel);
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.gridwidth = 2;
		gbc_btnSiguiente.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSiguiente.insets = new Insets(0, 0, 0, 5);
		gbc_btnSiguiente.gridx = 5;
		gbc_btnSiguiente.gridy = 2;
		contentPane.add(btnSiguiente, gbc_btnSiguiente);

		setVisible(true);
	}
	private void escribir(String [] datos) {
		nombre_submod = list.getSelectedValue().toString();
		File ff = new File ("fs_employee.txt");
		if(ff.exists()) {
			ff.delete();
		}
		FileWriter fw;
		try {
			fw = new FileWriter(ff.getAbsoluteFile(), true);
			fw.write("Nombre: "+datos[0]+System.getProperty("line.separator"));
			fw.write("PrimerApellido: "+datos[1]+System.getProperty("line.separator"));
			fw.write("segundoApellido: "+datos[2]+System.getProperty("line.separator"));
			fw.write("Direccion: "+datos[3]+System.getProperty("line.separator"));
			fw.write("Email: "+datos[4]+System.getProperty("line.separator"));
			fw.write("Genero: "+datos[5]+System.getProperty("line.separator"));
			fw.write("Fecha nacimiento: "+datos[6]+System.getProperty("line.separator"));
			fw.write("Modelo: "+datos[7]+System.getProperty("line.separator"));
			fw.write("SubModelo: " + nombre_submod + System.getProperty("line.separator"));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void atras(Model modelo) {
		ICarConfiguration car_config = new CarConfiguration();
		car_config.load_Car_Config();
		motores = car_config.getMotores();
		File f = new File("fs_employee.txt");
		if (f.exists()) {
			FileReader fr;
			try {
				fr = new FileReader(f.getAbsoluteFile());
				BufferedReader br = new BufferedReader(fr);
				String linea;
				String modelos = null;
				int con = 0;
				while ((linea = br.readLine()) != null) {
					if (con == 8) {
						String[] temp = linea.split(": ");
						modelos = temp[1];
					}
					con++;
				}
				br.close();
				fr.close();
				
				String euro = "\u20ac";//Simbolo del euro
				
				int pos = 0;
				String mot;
				for (int i = 0; i < motores.size(); i++) {
					precio = modelo.getPreu() + motores.get(i).getPreu();
					mot=modelo.getNom()+" " + motores.get(i).getNom() + " | " + motores.get(i).getDescripcio()
							+ " | " + precio + euro;
					if (mot.equalsIgnoreCase(modelos)) {
						pos = i;
					}
				}
				this.pos = pos;

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