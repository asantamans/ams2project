package Model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import app_config.ConfigurationLoader;
import app_config.User;
import app_config.langLoader;
import configuracion_vehiculo.CarConfiguration;
import configuracion_vehiculo.Model;
import idao.ICarConfiguration;
import Model.PantallaSubmodelos;

public class modelChooserFrame extends JFrame {
	private int numBtn = 0;
	private ArrayList<JButton> modelList;
	private JPanel contentPane;
	private JTextArea textArea = new JTextArea();
	private JLabel foto;
	private ArrayList<Model> modelos;
	private static String user;
	private ImageIcon icn;
	private Image imgen;
	private int pos=0;
	/**
	 * Create the frame.
	 */
	public modelChooserFrame(String user,boolean atras) {
		setIconImage(Login.icono());
		setTitle(loginFrame.titulo);
		this.user = user;
		setResizable(false);
		setMaximumSize(new Dimension(594, 2147483647));
		setMinimumSize(new Dimension(594, 511));
		/*if(atras) {
			atras();
		}else {*/
			inicializaParametros(pos);
		//}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 590);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(594, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(594, 10));
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{25, 87, 37, 239, 141, 31, 0, 0};
		gbl_panel.rowHeights = new int[]{29, 0, 27, 277, 77, 37, 37, 0, 35, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		JLabel lblNewLabel_2 = new JLabel(langLoader.getText("lblNewLabel_2")+user);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel(langLoader.getText("lblNewLabel_1"));
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.insets = new Insets(0, 55, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(113, 32767));
		scrollPane.setMinimumSize(new Dimension(113, 23));
		scrollPane.setBorder(null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		panel.add(scrollPane, gbc_scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMinimumSize(new Dimension(113, 10));
		panel_1.setMaximumSize(new Dimension(113, 32767));
		panel_1.setBorder(null);
		panel_1.setForeground(SystemColor.menu);
		panel_1.setLayout(new BoxLayout(panel_1,BoxLayout.Y_AXIS));
		for (JButton a : modelList) {
			panel_1.add(a);
		}
		
		scrollPane.setViewportView(panel_1);
		
		icn = new ImageIcon(ConfigurationLoader.getConfigurador().getCar_configuration_path()+modelos.get(0).getImatge_nom());
		imgen = icn.getImage().getScaledInstance(406, 237, Image.SCALE_DEFAULT);
		icn = new ImageIcon(imgen);
		foto = new JLabel(icn);
		GridBagConstraints gbc_foto = new GridBagConstraints();
		gbc_foto.gridwidth = 3;
		gbc_foto.fill = GridBagConstraints.BOTH;
		gbc_foto.insets = new Insets(0, 0, 15, 5);
		gbc_foto.gridx = 3;
		gbc_foto.gridy = 3;
		panel.add(foto, gbc_foto);
		
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 4;
		gbc_textArea.gridheight = 2;
		gbc_textArea.gridwidth = 3;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		textArea.setEditable(false);
		JScrollPane scPane = new JScrollPane(textArea);
		panel.add(scPane, gbc_textArea);
		
		JButton anteriorButton = new JButton(langLoader.getText("anteriorButton"));
		
		GridBagConstraints gbc_anteriorButton = new GridBagConstraints();
		gbc_anteriorButton.insets = new Insets(0, 0, 5, 25);
		gbc_anteriorButton.gridx = 3;
		gbc_anteriorButton.gridy = 7;
		panel.add(anteriorButton, gbc_anteriorButton);
		
		
		anteriorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				new Introducir_datos(user).setVisible(true);
				setVisible(false);
				
			}
		});
		
		JButton siguienteButton = new JButton(langLoader.getText("btnSiguiente"));
	
		GridBagConstraints gbc_siguienteButton = new GridBagConstraints();
		gbc_siguienteButton.insets = new Insets(0, 0, 5, 5);
		gbc_siguienteButton.gridx = 4;
		gbc_siguienteButton.gridy = 7;
		panel.add(siguienteButton, gbc_siguienteButton);
	
		
		siguienteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File ("fs_employee.txt");
					try {
						FileReader fr = new FileReader(f.getAbsoluteFile());
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
						File f2 = new File("fichero2.txt");
						f.renameTo(f2);
						fr.close();
						br.close();
					if(f.exists()) {
						f.delete();
					}
				
					escribir(datos);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
				new PantallaSubmodelos(modelos.get(numBtn), user);
				
			}
		});
		
		setVisible(true);
	}
	private void escribir(String [] datos) {
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
			fw.write("Modelo: "+modelos.get(numBtn).getNom()+System.getProperty("line.separator"));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void atras() {
		/*ICarConfiguration car_config = new CarConfiguration();
		car_config.load_Car_Config();
		modelos = car_config.getModelos();
		File f = new File ("fs_employee.txt");
		if(f.exists()) {
			FileReader fr;
			try {
				fr = new FileReader(f.getAbsoluteFile());
				BufferedReader br = new BufferedReader(fr);
				String linea;
				String modelo = null;
				int con=0;
				while((linea=br.readLine())!=null){
					if(con==7) {
						String [] temp=linea.split(": ");
						modelo=temp[1];
					}
					con++;
				}
					int pos=0;
					for(int i=0;i<modelos.size();i++) {
						if(modelos.get(i).getNom().equalsIgnoreCase(modelo)) {
							pos=i;
						}
					}
					this.pos=pos;
					System.out.println(this.pos);
					inicializaParametros(this.pos);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
	}
	private void inicializaParametros(int pos) {
		modelList = new ArrayList<JButton>();
		//implementacion de DAO cada vez que se inicia la pantalla carga los datos de los coches
		ICarConfiguration car_config = new CarConfiguration();
		car_config.load_Car_Config();
		modelos = car_config.getModelos();
		for (int i= 0; i < modelos.size(); ++i) {
			String rutaImg = ConfigurationLoader.getConfigurador().getCar_configuration_path()+modelos.get(i).getImatge_nom();
			String [] sp = modelos.get(i).getDescripcio().split(";");
			String descr = "";
			for (int j = 0; j < sp.length; j++) {
				if(j == sp.length-1) {
					descr = descr+""+sp[j];
				}else {
					descr = descr+""+sp[j]+"\n";
				}
			}
			String descripcion = descr;
			//El textArea tendra por defecto la descripción del primer modelo
			if (i == pos) {
				textArea.setText(descripcion);
				textArea.select(0, 0);
			}
			ImageIcon imageIcon = new ImageIcon(rutaImg);
			Image image = imageIcon.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT);
			imageIcon = new ImageIcon(image);
			JButton a = new JButton(imageIcon);
			a.setToolTipText(modelos.get(i).getNom());
			int point = i;
			a.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					numBtn = point;
					ImageIcon imageIcn = new ImageIcon(rutaImg);
					Image img = imageIcn.getImage().getScaledInstance(406, 237, Image.SCALE_DEFAULT);
					imageIcn = new ImageIcon(img);
					foto.setIcon(imageIcn);
					textArea.setText(descripcion);
					textArea.select(0, 0);
				}
			});
			
			modelList.add(a);
		}
	}
}
