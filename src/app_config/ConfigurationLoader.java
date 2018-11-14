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
	private static int descompte;
	private String specifications_file_path;
	private static String language;
	private static String language_default;
	private static String langPostfix;
	private static String langFilePath;
	private static String version;
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
						
				String descompte = eElement.getElementsByTagName("descompte").item(0).getTextContent();
				try {
					int parsed = Integer.parseInt(descompte);
					if (parsed > 0 && parsed < 22) {
						ConfigurationLoader.descompte = parsed;
					}else {
						ConfigurationLoader.descompte = 0;
					}
				} catch (Exception exc) {
					ConfigurationLoader.descompte = 0;
				}

				String spec_fp = eElement.getElementsByTagName("specifications_file_path").item(0).getTextContent();
				specifications_file_path = spec_fp;				
				
				//Cargado de lenguage en configuracion
				ConfigurationLoader.language =eElement.getElementsByTagName("language").item(0).getTextContent();
				ConfigurationLoader.language_default = eElement.getElementsByTagName("language_default").item(0).getTextContent();
				ConfigurationLoader.langPostfix = eElement.getElementsByTagName("postfix_language_file_name").item(0).getTextContent();
				ConfigurationLoader.langFilePath = eElement.getElementsByTagName("language_files_path").item(0).getTextContent();
				ConfigurationLoader.version = eElement.getElementsByTagName("version").item(0).getTextContent();
				if(!comprobarArchivosLenguaje()) {
					language = langFilePath+language_default+langPostfix;		
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
	
	public int getDescompte() {
		return descompte;
	}
	
	public static String getLanguage() {
		return language;
	}

	private boolean comprobarArchivosLenguaje() {
		File comprovador = new File(langFilePath);
		String[] languages = language.split(";");
		String retorno;
		for (int i = 0; i< languages.length;++i) {
			retorno = languages[i];
			comprovador = new File(langFilePath+retorno+langPostfix);
			if (comprovador.exists()) {
				language = langFilePath+retorno+langPostfix;
				return true;
			}
		}
		return false;

	}
}
