package Model;

import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import app_config.langLoader;
import configuracion_vehiculo.Model;
import factura.Cliente;
import factura.Factura;
import factura.SelectedCar;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	public Resumen(Model m,String mo,String usuario,String precioF, String acc) {
		setIconImage(Login.icono());
		setTitle(loginFrame.titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 311);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{30, 0, 30, 31, 0};
		gbl_panel.rowHeights = new int[]{30, 30, 0, 30, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblModelo = new JLabel(langLoader.getText("lblModelo"));
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
		
		JLabel lblAccesorios = new JLabel(langLoader.getText("lblAccesorios"));
		GridBagConstraints gbc_lblAccesorios = new GridBagConstraints();
		gbc_lblAccesorios.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccesorios.gridx = 1;
		gbc_lblAccesorios.gridy = 2;
		panel.add(lblAccesorios, gbc_lblAccesorios);
		
		JTextArea textAreaAccesorios = new JTextArea();
		textAreaAccesorios.setMargin(new Insets(5, 5, 5, 5));
		GridBagConstraints gbc_taAccesorios = new GridBagConstraints();
		gbc_taAccesorios.fill = GridBagConstraints.HORIZONTAL;
		gbc_taAccesorios.insets = new Insets(0, 0, 5, 0);
		gbc_taAccesorios.gridx = 3;
		gbc_taAccesorios.gridy = 2;
		textAreaAccesorios.setEditable(false);
		textAreaAccesorios.setText(acc);
		panel.add(textAreaAccesorios, gbc_taAccesorios);
		
		JLabel lblPrecioFinal = new JLabel(langLoader.getText("lblPrecioFinal"));
		GridBagConstraints gbc_lblPrecioFinal = new GridBagConstraints();
		gbc_lblPrecioFinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioFinal.gridx = 1;
		gbc_lblPrecioFinal.gridy = 3;
		panel.add(lblPrecioFinal, gbc_lblPrecioFinal);
		
		JLabel precio = new JLabel(precioF);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(precio, gbc_lblNewLabel_2);
		setVisible(true);
		
		JButton btnNewPres = new JButton(langLoader.getText("btnNewPres"));
		btnNewPres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Introducir_datos(usuario);
			}
		});
		GridBagConstraints gbc_btnNewPres = new GridBagConstraints();
		gbc_btnNewPres.gridwidth = 2;
		gbc_btnNewPres.gridx = 2;
		gbc_btnNewPres.gridy = 4;
		panel.add(btnNewPres, gbc_btnNewPres);
		
		File f = new File ("fs_employee.txt");
		try {
			FileWriter fr= new FileWriter(f.getAbsoluteFile(), true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(langLoader.getText("FacturaWriterOp4")+precioF);
			br.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//generamos la factura en formato XML
		Factura factura = new Factura();
		factura.generateXML(usuario, Cliente.getCliente(), SelectedCar.getSelectedCar());
		//una vez generada la factura en xml podemos renombrar los archivos
		cambiarNombreFicheros();
	}
	
	/**
	 * Renombra los ficheros fs_employee.txt y fs_employee.xml, añadiendoles la fecha y hora actual
	 * @author Marc
	 */
	private void cambiarNombreFicheros() {
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
	}
}
