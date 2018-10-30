package Model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app_config.ConfigurationLoader;
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

import javax.swing.JButton;

public class PantallaSubmodelos extends JFrame {

	private JPanel contentPane;
	private int selectedSubmodel;//la posicion del submodelo que seleccionamos
	private ArrayList<Integer> preciosSubmodelos = new ArrayList<Integer>();//guarda los precios de los submodelos
	
	/**
	 * Create the frame.
	 */
	public PantallaSubmodelos(Model modelo, String usuario) {
		//implementacion de DAO cada vez que se inicia la pantalla carga los datos de los coches
		ICarConfiguration car_config = new CarConfiguration();
		car_config.load_Car_Config();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 435);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 20, 0, 20));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{69, 169, 169, 169, 169, 169, 169, 169};
		gbl_contentPane.rowHeights = new int[]{19, 1, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lbTitulo = new JLabel("Selecci\u00F3n de caracter\u00EDsticas del modelo");
		lbTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lbTitulo = new GridBagConstraints();
		gbc_lbTitulo.gridwidth = 6;
		gbc_lbTitulo.insets = new Insets(10, 0, 5, 5);
		gbc_lbTitulo.gridx = 0;
		gbc_lbTitulo.gridy = 0;
		contentPane.add(lbTitulo, gbc_lbTitulo);
		
		JList list;
		ArrayList<Motor> motores = car_config.getMotores();
		String [] submodelos = new String [motores.size()];
		//añado submodelos al JList
		for (int i = 0; i < submodelos.length; i++) {
			int precio = modelo.getPreu()+motores.get(i).getPreu();
			preciosSubmodelos.add(precio);
			String submdTxt = modelo.getNom()+" "+motores.get(i).getNom()+" | "+motores.get(i).getDescripcio()+" | "+precio+"€";
			submodelos[i] = submdTxt;
		}
		
		JLabel lblUsuario = new JLabel("Usuario: "+usuario);
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.gridwidth = 2;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 6;
		gbc_lblUsuario.gridy = 0;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		list = new JList(submodelos);
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
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new modelChooserFrame(ConfigurationLoader.getConfigurador(), usuario);
				
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
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Abrir ventana accesorios
				int precioSm = preciosSubmodelos.get(selectedSubmodel);//le pasamos el precio del submodelo a la siguiente ventana
				//tambien le pasaremos el modelo para saber los accesorios disponibles
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

}
