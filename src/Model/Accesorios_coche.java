package Model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.CellConstraints.Alignment;

import app_config.ConfigurationLoader;
import configuracion_vehiculo.CarConfiguration;
import configuracion_vehiculo.Model;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Accesorios_coche extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<String> mm;
	private JCheckBox [] ac;
	private int i;
	private int p=0;
	private ArrayList accesorios;
	private int aaa=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Accesorios_coche frame = new Accesorios_coche();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Accesorios_coche(Model m,String mo, ArrayList idioma,String usuario,int preciosm) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBounds(0, 77, 618, 253);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 276, 271, 54, 0 };
		gbl_panel.rowHeights = new int[] { 18, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 604, 72);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 124, 31, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 18, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblCompraAccesoris = new JLabel("Compra de Accesoris");
		lblCompraAccesoris.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblCompraAccesoris = new GridBagConstraints();
		gbc_lblCompraAccesoris.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompraAccesoris.gridx = 13;
		gbc_lblCompraAccesoris.gridy = 0;
		panel_1.add(lblCompraAccesoris, gbc_lblCompraAccesoris);
		
				JLabel label = new JLabel(".");
				label.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.gridwidth = 13;
				gbc_label.insets = new Insets(0, 0, 0, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 2;
				panel_1.add(label, gbc_label);
				label.setText(mo);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 330, 618, 131);
		contentPane.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 30, 30, 0, 0, 30, 30, 30, 30, 30, 0, 32, 29, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 31, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblAugmentoDePrecio = new JLabel("Augmento de precio");
		lblAugmentoDePrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblAugmentoDePrecio = new GridBagConstraints();
		gbc_lblAugmentoDePrecio.gridwidth = 2;
		gbc_lblAugmentoDePrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAugmentoDePrecio.gridx = 2;
		gbc_lblAugmentoDePrecio.gridy = 1;
		panel_2.add(lblAugmentoDePrecio, gbc_lblAugmentoDePrecio);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 9;
		gbc_textField.gridy = 1;
		textField.setEditable(false);
		textField.setText("0");
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnAtras = new JButton("Atras");
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.fill = GridBagConstraints.BOTH;
		gbc_btnAtras.gridwidth = 2;
		gbc_btnAtras.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtras.gridx = 2;
		gbc_btnAtras.gridy = 3;
		panel_2.add(btnAtras, gbc_btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new PantallaSubmodelos(m,usuario, idioma);
				
			}
		});

		JButton btnFinalizar = new JButton("Finalizar");
		GridBagConstraints gbc_btnFinalizar = new GridBagConstraints();
		gbc_btnFinalizar.fill = GridBagConstraints.BOTH;
		gbc_btnFinalizar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFinalizar.gridx = 9;
		gbc_btnFinalizar.gridy = 3;
		panel_2.add(btnFinalizar, gbc_btnFinalizar);
		btnFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String mod=null;
				for(int i=0;i<ac.length;i++) {
					if(ac[i].isSelected()) {
						String precio=accesorios.get(i).toString();
						String []pre=precio.split("preu=");
						String []preu=pre[1].split(",");
						p=p+Integer.parseInt(preu[0]);
						String acc = accesorios.get(i).toString();
						String[] aa = acc.split("nom=");
						String[] accc = aa[1].split(",");
						if(mod==null) {
							mod=accc[0];
						}else {
							mod=mod+","+(accc[0]);
						}
						
					}
					
				}
				String pp=Integer.toString(p);
				textField.setText(pp);
				int pf=0;
				int seguir =JOptionPane.showConfirmDialog(null,"Son correctos los accesorios?","Quiere continuar?",JOptionPane.YES_NO_OPTION);
				if(seguir==JOptionPane.YES_OPTION) {
					pf=preciosm+p;
   				 JOptionPane.showMessageDialog(panel,"El precio final es"+pf, "Advertencia", JOptionPane.WARNING_MESSAGE);
   				 dispose();
   				 String preciof=Integer.toString(pf);
   				 new Resumen(m,mo,idioma,usuario,preciof,mod);
   				 
   			 }
			}
		});

		CarConfiguration car_config = new CarConfiguration();
		car_config.load_Car_Config();
		accesorios = car_config.getAccesorios();
		int x = 0;
		int y = 0;
		String[] mm = mo.split(" 1");
		String modelo = mm[0];
		ac=new JCheckBox[accesorios.size()];
		for (int a = 0; a < accesorios.size(); a++) {
			String acc = accesorios.get(a).toString();
			String[] aa = acc.split("nom=");
			String[] accc = aa[1].split(",");
			
			String[] preu = acc.split("preu=");
			String[] pre = preu[1].split(",");
			String[] preuf = new String[accesorios.size()];
			preuf[a] = pre[0];
			
			String[] mod = acc.split("=\\[");
			String[] mode = mod[1].split("\\]");
			String[] modelos = mode[0].split(", ");
			ac[a] = new JCheckBox(accc[0]);
			GridBagConstraints ap = new GridBagConstraints();
			ap.anchor = GridBagConstraints.WEST;
			ap.insets = new Insets(0, 30, 30, 11);
			ac[a].setVerticalTextPosition(ap.fill);
			ap.gridx = x;
			ap.gridy = y;
			if (x == 1) {
				x = 0;
				y++;
			} else {
				x++;
			}
			boolean activado = false;
			String selec=null;
			for(int i=0;i<modelos.length;i++) {
				if(modelos[i].equals(modelo)) {
					activado=true;
				}
				if(selec==null) {
					selec=modelos[i];
				}else {
					selec=selec+","+modelos[i];
				}
			}
			System.out.println(selec);
			ac[a].setToolTipText(selec);
			ac[a].setEnabled(activado);
			panel.add(ac[a], ap);
			
		}	
	}
}
