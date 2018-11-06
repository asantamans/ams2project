package configuracion_vehiculo;

import java.util.ArrayList;

public class Accesori {
	private String id;
	private String nom;
	private String descripcio;
	private String imatge_nom;
	private int preu;
	private ArrayList <String> models_disponibles;
	
	/**
	 * Constructor de un accesorio para el coche
	 * @param id - ID del accesorio
	 * @param nom - Nombre del accesorio
	 * @param descripcio - Pequeña descripción del accesorio
	 * @param imatge_nom - Nombre de la imagen del accesorio (archivo)
	 * @param preu - Precio del accesorio
	 * @param models_disponibles - Modelos en los que esta disponible el accesorio
	 * @author Marc
	 */
	public Accesori(String id, String nom, String descripcio, String imatge_nom, int preu,
			ArrayList<String> models_disponibles) {
		this.id = id;
		this.nom = nom;
		this.descripcio = descripcio;
		this.imatge_nom = imatge_nom;
		this.preu = preu;
		this.models_disponibles = models_disponibles;
	}
	
	@Override
	public String toString() {
		return "Accesori [id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + ", imatge_nom=" + imatge_nom
				+ ", preu=" + preu + ", models_disponibles=" + models_disponibles + "]";
	}

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public String getImatge_nom() {
		return imatge_nom;
	}

	public int getPreu() {
		return preu;
	}

	public ArrayList<String> getModels_disponibles() {
		return models_disponibles;
	}
	
}
