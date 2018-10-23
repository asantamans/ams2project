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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import configuracion_vehiculo.CarConfiguration;
import configuracion_vehiculo.Model;

public class modelChooserFrame extends JFrame {
	private  String userName;
	private ArrayList<JButton> modelList;
	private JPanel contentPane;
	private JTextArea textArea = new JTextArea();
	private int point = 0;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public modelChooserFrame(ConfigurationLoader config,String user) {
		setResizable(false);
		setMaximumSize(new Dimension(594, 2147483647));
		setMinimumSize(new Dimension(594, 511));
		inicializaParametros();
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
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("SELECCIONAR EL MODELO DE COCHE");
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
		
		JLabel foto = new JLabel(new ImageIcon("src\\carPhoto.jpg"));
		GridBagConstraints gbc_foto = new GridBagConstraints();
		gbc_foto.gridwidth = 3;
		gbc_foto.fill = GridBagConstraints.BOTH;
		gbc_foto.insets = new Insets(0, 0, 15, 5);
		gbc_foto.gridx = 3;
		gbc_foto.gridy = 3;
		panel.add(foto, gbc_foto);
		
		
		
		
		
		textArea.setText("Coche n4\n Modelo 43a\nMotor X\nInformacion extra");
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 55);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 4;
		gbc_textArea.gridy = 4;
		panel.add(textArea, gbc_textArea);
		
		JButton anteriorButton = new JButton("Anterior");
		GridBagConstraints gbc_anteriorButton = new GridBagConstraints();
		gbc_anteriorButton.insets = new Insets(0, 0, 5, 25);
		gbc_anteriorButton.gridx = 3;
		gbc_anteriorButton.gridy = 7;
		panel.add(anteriorButton, gbc_anteriorButton);
		
		JButton siguienteButton = new JButton("Siguiente");
		GridBagConstraints gbc_siguienteButton = new GridBagConstraints();
		gbc_siguienteButton.insets = new Insets(0, 0, 5, 5);
		gbc_siguienteButton.gridx = 4;
		gbc_siguienteButton.gridy = 7;
		panel.add(siguienteButton, gbc_siguienteButton);
	
		
		siguienteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(foto.getSize());
			}
		});
		
		setVisible(true);
		
		
		
		
	}
	private void inicializaParametros() {
		modelList = new ArrayList<JButton>();
		CarConfiguration car_config = new CarConfiguration();
		car_config.leerXML_Car_Config();
		ArrayList<Model> modelos = car_config.getModelos();
		for (int i= 0; i < modelos.size(); ++i) {
			String rutaImg = "src\\configuracion_vehiculo\\car_images\\"+modelos.get(i).getImatge_nom();
			ImageIcon imageIcon = new ImageIcon(rutaImg);
			Image image = imageIcon.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT);
			imageIcon = new ImageIcon(image);
			JButton a = new JButton(imageIcon);
			point = i;
		/*
			a.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					textArea.setText(modelos.get(point).getDescripcio());
					
				}
			});
			*/
			
			modelList.add(a);
		}
		
	
		
	}

}
