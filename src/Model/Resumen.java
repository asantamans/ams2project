package Model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import configuracion_vehiculo.Model;
import factura.Cliente;
import factura.Factura;
import factura.SelectedCar;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;

public class Resumen extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param mod 
	 */
	public Resumen(Model m,String mo, ArrayList <String> text,String usuario,String precioF, String acc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 261);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{30, 0, 30, 31, 0};
		gbl_panel.rowHeights = new int[]{30, 0, 31, 0, 30, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblModelo = new JLabel(text.get(0));
		text.remove(0);
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 1;
		gbc_lblModelo.gridy = 1;
		panel.add(lblModelo, gbc_lblModelo);
		
		JLabel modelo = new JLabel(mo);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		panel.add(modelo, gbc_lblNewLabel);
		
		JLabel lblAccesorios = new JLabel(text.get(0));
		text.remove(0);
		GridBagConstraints gbc_lblAccesorios = new GridBagConstraints();
		gbc_lblAccesorios.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccesorios.gridx = 1;
		gbc_lblAccesorios.gridy = 3;
		panel.add(lblAccesorios, gbc_lblAccesorios);
		
		JLabel Accesorios= new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 3;
		Accesorios.setText(acc);
		panel.add(Accesorios, gbc_lblNewLabel_1);
		
		JLabel lblPrecioFinal = new JLabel(text.get(0));
		text.remove(0);
		GridBagConstraints gbc_lblPrecioFinal = new GridBagConstraints();
		gbc_lblPrecioFinal.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrecioFinal.gridx = 1;
		gbc_lblPrecioFinal.gridy = 5;
		panel.add(lblPrecioFinal, gbc_lblPrecioFinal);
		
		JLabel precio = new JLabel(precioF);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 5;
		panel.add(precio, gbc_lblNewLabel_2);
		setVisible(true);
		
		File f = new File ("fs_employee.txt");
		//cuando se implemente, se borraran el delete() es temporal
		if (f.exists()) {
			f.delete();
			f = new File("fs_employee.txt");
		}
		try {
			FileWriter fr= new FileWriter(f.getAbsoluteFile(), true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write("Modelo: "+mo+System.getProperty("line.separator"));
			if (acc == null) {
				br.write("Accesorios: sin accesorios"+System.getProperty("line.separator"));
			}else {
				br.write("Accesorios: "+acc+System.getProperty("line.separator"));
			}
			br.write("Precio Final: "+precioF);
			br.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//generamos la factura en formato XML
		Factura factura = new Factura();
		factura.generateXML(usuario, Cliente.getCliente(), SelectedCar.getSelectedCar());
		
		//cuando el usuario cierre la aplicacion, se cambiaran los nombre de los ficheros fs_employee.txt y fs_employee.xml
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowClosing(WindowEvent e) {			
				SimpleDateFormat sdf_day = new SimpleDateFormat("dd-MM-yyyy");
				String date = sdf_day.format(new Date());
				SimpleDateFormat sdf = new SimpleDateFormat("HH;mm");
				String hour = sdf.format(new Date());
				
				if (new File("fs_employee_"+date+"_i_"+hour+".txt").exists()) {
					File deleteFile = new File("fs_employee_"+date+"_i_"+hour+".txt");
					deleteFile.delete();
				}
				
				if (new File("fs_employee_"+date+"_i_"+hour+".xml").exists()) {
					File deleteFile = new File("fs_employee_"+date+"_i_"+hour+".xml");
					deleteFile.delete();
				}
				
				File fTxt = new File("fs_employee.txt");
				File fXml = new File("fs_employee.xml");
				Path source = fTxt.toPath();
				Path sourceXML = fXml.toPath();
				try {
				     Files.move(source, source.resolveSibling("fs_employee_"+date+"_i_"+hour+".txt"));
				     Files.move(sourceXML, sourceXML.resolveSibling("fs_employee_"+date+"_i_"+hour+".xml"));
				} catch (IOException ex) {
				     ex.printStackTrace();
				}
				System.exit(0);
			}
			
			//como WindowListener es una interfaz nos obliga a implementar estos metodos, pero no los utilizaremos
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
	}
}
