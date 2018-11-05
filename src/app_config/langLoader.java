package app_config;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class langLoader {
	private static Scanner lector;
	private static File langFile;
	
	public static  ArrayList<String> getText(String language) {
		ArrayList<String> text = new ArrayList<String>();
		langFile = new File(language);
		try {
			lector = new Scanner(langFile);
			while (lector.hasNext()) {
				String rawData = lector.nextLine();
				String[] procesing = rawData.split(";");
				for (int i = 0; i< procesing.length;++i) {
					text.add(procesing[i]);
					
				}
			}
			
		}catch (Exception e) {
			System.out.println("Error");
		}
		finally {
			lector.close();
			
		}
		
		return text;
	}
	public static  ArrayList<String> getText(String language,int z) {
		ArrayList<String> text = new ArrayList<String>();
		langFile = new File(language);
		try {
			lector = new Scanner(langFile);
			for (int tmp = 0; tmp < z;++tmp) {
				lector.nextLine();
			}
			while (lector.hasNext()) {
				String rawData = lector.nextLine();
				String[] procesing = rawData.split(";");
				for (int i = 0; i< procesing.length;++i) {
					text.add(procesing[i]);
				
				}
			}
			
		}catch (Exception e) {
			System.out.println("Error");
		}
		finally {
			lector.close();
			
		}
		
		return text;
	}
	
}
