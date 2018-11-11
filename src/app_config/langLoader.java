package app_config;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class langLoader {

	private static langLoader language;
	private static ArrayList<clave> diccionario;

	public static langLoader getTextos() {
		if (language == null) {
			language = new langLoader();
		}
		return language;
	}

	private langLoader() {
		leerLenguajes();
	}

	public void leerLenguajes() {
		try {
		diccionario = new ArrayList<clave>();
		 DataInputStream dataIn = new DataInputStream(new FileInputStream(ConfigurationLoader.getConfigurador().getLanguage()));
		 while (dataIn.available()>0) {
			 String k = dataIn.readLine();
			 String[] parts = k.split("==");
			 diccionario.add(new clave(parts[0],parts[1]));
		 }
		 dataIn.close();
		}catch (Exception e) {
			System.out.println("ERROR");
			
		}finally {
			
		}
	}
	public static String getText(String clave) {
		String valor = "NO--FOUND--MISSING";
		for (clave tmp: diccionario) {
			if (tmp.getClaveName().equals(clave)) {
				valor = tmp.getValue();
				break;
			}
		}
		
		return valor;
	}
	

}
