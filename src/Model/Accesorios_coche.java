package Model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.jgoodies.forms.layout.CellConstraints.Alignment;

import app_config.ConfigurationLoader;
import app_config.User;
import app_config.langLoader;
import configuracion_vehiculo.Accesori;
import configuracion_vehiculo.CarConfiguration;
import configuracion_vehiculo.Model;
import factura.Cliente;
import factura.SelectedCar;

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
	private JCheckBox[] ac;
	private ArrayList<Accesori> accesorios;

	/**
	 * Create the frame.
	 */
	public Accesorios_coche(Model m, String mo, String usuario, int preciosm, int numSM) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		
		JLabel lblCompraAccesoris = new JLabel(langLoader.getText("lblCompraAccesoris"));
		;
		if(User.getUsuario().getEmployee_version() == true) {
			lblCompraAccesoris.setToolTipText(langLoader.getText("mensajesDescuento"));
		}
		lblCompraAccesoris.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblCompraAccesoris = new GridBagConstraints();
		gbc_lblCompraAccesoris.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompraAccesoris.gridx = 13;
		gbc_lblCompraAccesoris.gridy = 0;
		panel_1.add(lblCompraAccesoris, gbc_lblCompraAccesoris);

		JLabel label = new JLabel(langLoader.getText("label"));
		;
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

		JLabel lblAugmentoDePrecio = new JLabel(langLoader.getText("lblAugmentoDePrecio"));
		;
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

		JButton btnAtras = new JButton(langLoader.getText("btnAtras"));
		
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
				new PantallaSubmodelos(m, usuario);
			}
		});
		
		CarConfiguration car_config = new CarConfiguration();
		car_config.load_Car_Config();

		JButton btnFinalizar = new JButton(langLoader.getText("btnFinalizar"));
		
		GridBagConstraints gbc_btnFinalizar = new GridBagConstraints();
		gbc_btnFinalizar.fill = GridBagConstraints.BOTH;
		gbc_btnFinalizar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFinalizar.gridx = 9;
		gbc_btnFinalizar.gridy = 3;
		panel_2.add(btnFinalizar, gbc_btnFinalizar);
		btnFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String mod = null;
				ArrayList<Accesori> selectedAcc = new ArrayList<Accesori>();
				for (int i = 0; i < ac.length; i++) {
					if (ac[i].isSelected()) {				
						String nombre_accesorio = accesorios.get(i).getNom();
						selectedAcc.add(accesorios.get(i));
						if (mod == null) {
							mod = nombre_accesorio;
						} else {
							mod = mod + "," + (nombre_accesorio);
						}						
					}
				}
				int precioAccs = Integer.parseInt(textField.getText());
				int pf = 0;
				int seguir = JOptionPane.showConfirmDialog(null, langLoader.getText("btnFinalizarListenerOp1Text1"), langLoader.getText("btnFinalizarListenerOp1Text2"),
						JOptionPane.YES_NO_OPTION);
				if (seguir == JOptionPane.YES_OPTION) {
					pf = preciosm + precioAccs;
					if(User.getUsuario().getEmployee_version() == true) {
						double pfDescuento = pf-((pf/100)*20);
						JOptionPane.showMessageDialog(panel,langLoader.getText("btnFinalizarListenerOp2Text1") + pf + langLoader.getText("btnFinalizarListenerOp2Text2")+(int)pfDescuento, langLoader.getText("OptionPaneAlert"),
								JOptionPane.WARNING_MESSAGE);
						//el precio no tendra decimales
						pf = (int) pfDescuento;
					}else {
						JOptionPane.showMessageDialog(panel, langLoader.getText("btnFinalizarListenerOp3Text1") + pf, langLoader.getText("OptionPaneAlert"),
								JOptionPane.WARNING_MESSAGE);
					}
					dispose();
					String preciof = Integer.toString(pf);
					if (selectedAcc.size() == 0) {
						//como en este caso no hay accesorios, crearemos uno vacio
						selectedAcc.add(new Accesori("", "no accesorios", "", "", 0, new ArrayList<String>()));
						SelectedCar sCar = new SelectedCar(m, car_config.getMotores().get(numSM), selectedAcc, pf);
						SelectedCar.setSelectedCar(sCar);
					}else {
						SelectedCar sCar = new SelectedCar(m, car_config.getMotores().get(numSM), selectedAcc, pf);
						SelectedCar.setSelectedCar(sCar);
					}
					setVisible(false);
					new Resumen(m, mo, usuario, preciof, mod);
				}
			}
		});

		accesorios = car_config.getAccesorios();
		int x = 0;
		int y = 0;
		ac = new JCheckBox[accesorios.size()];
		for (int a = 0; a < accesorios.size(); a++) {
			String nombre_accesorio = accesorios.get(a).getNom();
			ArrayList<String> acc_mod_disponible = accesorios.get(a).getModels_disponibles();
			ac[a] = new JCheckBox(nombre_accesorio);
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
			String selec = null;
			for (int i = 0; i < acc_mod_disponible.size(); i++) {
				// si el modelo tiene el accesorio disponible lo podremos seleccionar
				if (acc_mod_disponible.get(i).equals(m.getNom())) {
					activado = true;
				}
				if (selec == null) {
					selec = "<b>" + acc_mod_disponible.get(i) + "</b>";
				} else {
					selec = selec + ", " + "<b>" + acc_mod_disponible.get(i) + "</b>";
				}
			}
			selec = "<html>" + langLoader.getText("selec") + "<p>" + selec + "</p>" + "</html>";
			ac[a].setToolTipText(selec);
			ac[a].setEnabled(activado);
			int point = a;
			ac[a].addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent event) {
					//estado del checkBox (seleccionado o deseleccionado)
					int estadoItem = event.getStateChange();
					
					//si lo deseleccionamos, restamos el precio
					if (estadoItem == ItemEvent.DESELECTED) {
						//recogemos el precio que tenia el textField
						int parseado = Integer.parseInt(textField.getText());
						//nuevo precio
						parseado = parseado-accesorios.get(point).getPreu();
						textField.setText(parseado+"");
						
					//si lo seleccionamos, aumentamos el precio
					}else if (estadoItem == ItemEvent.SELECTED) {
						//recogemos el precio que tenia el textField
						int parseado = Integer.parseInt(textField.getText());
						//nuevo precio
						parseado = parseado+accesorios.get(point).getPreu();
						textField.setText(parseado+"");
					}
				}
			});
			panel.add(ac[a], ap);
			setVisible(true);
		}
	}
}
