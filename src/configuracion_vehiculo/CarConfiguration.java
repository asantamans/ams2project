package configuracion_vehiculo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CarConfiguration {
	private ArrayList<Model> modelos;
	private ArrayList<Motor> motores;
	private ArrayList<Accesori> accesorios;
	
	public static void main(String[] args) {
		CarConfiguration car_config = new CarConfiguration();
		car_config.leerXML_Car_Config();
	}
	
	/**
	 * Lee el archivo XML de configuracion de coches de los diferentes modelos, motores y accesorios
	 *  y guarda los datos en diferentes ArrayList
	 *  @author Marc
	 */
	public void leerXML_Car_Config() {
		modelos = new ArrayList<Model>();
		motores = new ArrayList<Motor>();
		accesorios = new ArrayList<Accesori>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("car_config.xml"));

			//Lee del XML los modelos de coches y los guarda en un ArrayList de objetos Model llamado modelos
			NodeList nl_modelos = doc.getElementsByTagName("model");
			for (int i = 0; i < nl_modelos.getLength(); i++) {
				Node n_model = nl_modelos.item(i);
				if (n_model.getNodeType() == Node.ELEMENT_NODE) {
					Element eModelo = (Element) n_model;
					String id = eModelo.getElementsByTagName("id").item(0).getTextContent();
					String nom = eModelo.getElementsByTagName("nom").item(0).getTextContent();
					String descripcio = eModelo.getElementsByTagName("descripcio").item(0).getTextContent();
					String imatge_nom = eModelo.getElementsByTagName("imatge_nom").item(0).getTextContent();
					int preu = Integer.parseInt(eModelo.getElementsByTagName("preu").item(0).getTextContent());
					Model md = new Model(id, nom, descripcio, imatge_nom, preu);
					modelos.add(md);
				}
			}
			
			
			//Lee del XML los motores disponibles y los guarda en un ArrayList de objetos Motor llamado motores
			NodeList nl_motores = doc.getElementsByTagName("motor");
			for (int i = 0; i < nl_motores.getLength(); i++) {
				Node n_motor = nl_motores.item(i);
				if (n_motor.getNodeType() == Node.ELEMENT_NODE) {
					Element eModelo = (Element) n_motor;
					String id = eModelo.getElementsByTagName("id").item(0).getTextContent();
					String nom = eModelo.getElementsByTagName("nom").item(0).getTextContent();
					String descripcio = eModelo.getElementsByTagName("descripcio").item(0).getTextContent();
					String imatge_nom = eModelo.getElementsByTagName("imatge_nom").item(0).getTextContent();
					int preu = Integer.parseInt(eModelo.getElementsByTagName("preu").item(0).getTextContent());
					Motor motor = new Motor(id, nom, descripcio, imatge_nom, preu);
					motores.add(motor);
				}
			}
		
			
			//Lee del XML los acccesorios disponibles y los guarda en un ArrayList de objetos Accesorio llamado accesorios
			NodeList nl_accesorio = doc.getElementsByTagName("accessori");
			
			for (int i = 0; i < nl_accesorio.getLength(); i++) {
				Node n_acc = nl_accesorio.item(i);
				if (n_acc.getNodeType() == Node.ELEMENT_NODE) {
					Element eModelo = (Element) n_acc;
					String id = eModelo.getElementsByTagName("id").item(0).getTextContent();
					String nom = eModelo.getElementsByTagName("nom").item(0).getTextContent();
					String descripcio = eModelo.getElementsByTagName("descripcio").item(0).getTextContent();
					String imatge_nom = eModelo.getElementsByTagName("imatge_nom").item(0).getTextContent();
					int preu = Integer.parseInt(eModelo.getElementsByTagName("preu").item(0).getTextContent());
					
					//Modelos que tengan el accesorio
					Node n_md = eModelo.getElementsByTagName("models_disponibles").item(0);
					Element eModDisp = (Element) n_md;
					NodeList nl_mDisp = eModDisp.getElementsByTagName("model_d");
					ArrayList<String> models_disponibles = new ArrayList<String>();
					for (int j = 0; j < nl_mDisp.getLength(); j++) {
						Node node_mDisp = nl_mDisp.item(j);
						Element eDispMod = (Element) node_mDisp;
						String modDisp = eDispMod.getTextContent();
						models_disponibles.add(modDisp);
					}
					Accesori accesori = new Accesori(id, nom, descripcio, imatge_nom, preu, models_disponibles);
					accesorios.add(accesori);
				}
			}
		
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//getters
	public ArrayList<Model> getModelos() {
		return modelos;
	}

	public ArrayList<Motor> getMotores() {
		return motores;
	}

	public ArrayList<Accesori> getAccesorios() {
		return accesorios;
	}
}
