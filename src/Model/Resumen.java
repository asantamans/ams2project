package Model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import configuracion_vehiculo.Model;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Resumen extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param mod 
	 */
	public Resumen(Model m,String mo, ArrayList idioma,String usuario,String precioF, String acc) {
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
		
		JLabel lblModelo = new JLabel("Modelo");
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
		
		JLabel lblAccesorios = new JLabel("Accesorios");
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
		
		JLabel lblPrecioFinal = new JLabel("Precio final");
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
		try {
			FileWriter fr= new FileWriter(f.getAbsoluteFile(), true);
			BufferedWriter br = new BufferedWriter(fr);
			System.out.println(mo);
			br.write("modelo "+mo);
			br.write("accesorios "+acc);
			br.write("Precio Final "+precioF);
			br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
