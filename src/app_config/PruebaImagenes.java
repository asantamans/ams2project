package app_config;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import configuracion_vehiculo.CarConfiguration;
import configuracion_vehiculo.Model;

public class PruebaImagenes {
	public static void main(String[] args) {
		JFrame f = new JFrame("Botones con imagenes");
		f.setLayout(new FlowLayout());
		
		CarConfiguration car_config = new CarConfiguration();
		car_config.leerXML_Car_Config();
		ArrayList<Model> modelos = car_config.getModelos();
		System.out.println("\n\n"+modelos);
		
		//Creo array de JButtons
		JButton [] botones = new JButton[modelos.size()];
		for (int i = 0; i < modelos.size(); i++) {
			try {
				botones[i] = new JButton();
				//hago un string con la ruta de la imagen que es la direccion de la carpeta car_images y el nombre de la imagen que guarde en el objeto Model
				String rutaImg = "src\\configuracion_vehiculo\\car_images\\"+modelos.get(i).getImatge_nom();
				ImageIcon imageIcon = new ImageIcon(rutaImg);
				Image image = imageIcon.getImage().getScaledInstance(160, 90, Image.SCALE_DEFAULT);
				imageIcon = new ImageIcon(image);
				botones[i].setIcon(imageIcon);
				f.add(botones[i]);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		f.setSize(1000, 800);
		f.setVisible(true);
	}
}
