package app_config;
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

public class ConfigurationLoader {
	private String car_configuration_path;
	private String car_configuration_file_name;
	private static ArrayList <String> employee_list;
	private static ArrayList <String> employee_password;
	private static ArrayList <String> employee_version; 
	private String specifications_file_path;
	private static ConfigurationLoader config;
	
	/**
	 * Crea un constructor nuevo si config no es null
	 * @return Devuelve un constructor nuevo si config es null, si no devolvera el contructor que ya tenemos creado
	 * @author Marc
	 */
	public static ConfigurationLoader getConfigurador() {
		 if (config == null) {
			 config = new ConfigurationLoader();
		 }
		 return config;
	}
	private ConfigurationLoader() {
		cargarConfiguracion();
	}
	
	/**
	 * Carga la configuracion del archivo XML cv_config.xml
	 * @author Marc
	 */
	public void cargarConfiguracion() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("cv_config.xml"));
			NodeList nList = doc.getElementsByTagName("configuration");
			Node nNode = nList.item(0);
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				String cc_path = eElement.getElementsByTagName("car_configuration_path").item(0).getTextContent();
				car_configuration_path = cc_path;

				
				String cc_name = eElement.getElementsByTagName("car_configuration_file_name").item(0).getTextContent();
				car_configuration_file_name = cc_name;
				
				
				employee_list = new ArrayList<String>();
				NodeList nl_users = doc.getElementsByTagName("employee_user");
				for (int i = 0; i < nl_users.getLength(); i++) {
					Node node_user = nl_users.item(i);
					if(node_user.getNodeType() == Node.ELEMENT_NODE) {
						Element element_user = (Element) node_user;
						String usuario = element_user.getTextContent();
						employee_list.add(usuario);
					}
				}
				
				employee_password = new ArrayList<String>();
				NodeList nl_pwd = doc.getElementsByTagName("user_password");
				for (int i = 0; i < nl_pwd.getLength(); i++) {
					Node node_pwd = nl_pwd.item(i);
					if(node_pwd.getNodeType() == Node.ELEMENT_NODE) {
						Element element_user = (Element) node_pwd;
						String pass = element_user.getTextContent();
						employee_password.add(pass);
					}
				}
				
				
				String spec_fp = eElement.getElementsByTagName("specifications_file_path").item(0).getTextContent();
				specifications_file_path = spec_fp;
				//System.out.println(spec_fp);
				
				employee_version = new ArrayList<String>();
				NodeList nl_vrs = doc.getElementsByTagName("version");
				for (int i = 0; i < nl_vrs.getLength(); i++) {
					Node node_vrs = nl_vrs.item(i);
					if(node_vrs.getNodeType() == Node.ELEMENT_NODE) {
						Element element_vrs = (Element) node_vrs;
						String version = element_vrs.getTextContent();
						employee_version.add(version);
					}
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
	public String getCar_configuration_path() {
		return car_configuration_path;
	}

	public String getCar_configuration_file_name() {
		return car_configuration_file_name;
	}


	public ArrayList <String> getEmployee_list() {
		return employee_list;
	}

	public String getSpecifications_file_path() {
		return specifications_file_path;
	}

	public ArrayList <String> getEmployee_password() {
		return employee_password;
	}
	
	public ArrayList<String> getEmployee_version() {
		return employee_version;
	}
}
