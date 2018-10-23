package configuracion_vehiculo;

public class Model {
	private String id;
	private String nom;
	private String descripcio;
	private String imatge_nom;
	private int preu;
	
	/**
	 * Constructor de modelo de coche con parametros
	 * @param id - ID del modelo
	 * @param nom - Nombre del modelo
	 * @param descripcio - Pequeña descripción del modelo
	 * @param imatge_nom - Nombre de la imagen del modelo (archivo)
	 * @param preu - Precio del modelo
	 * @author Marc
	 */
	public Model(String id, String nom, String descripcio, String imatge_nom, int preu) {
		this.id = id;
		this.nom = nom;
		this.descripcio = descripcio;
		this.imatge_nom = imatge_nom;
		this.preu = preu;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + ", imatge_nom=" + imatge_nom
				+ ", preu=" + preu + "]";
	}
	
	//getters
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
}
