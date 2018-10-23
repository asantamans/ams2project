package configuracion_vehiculo;

public class Motor {
	private String id;
	private String nom;
	private String descripcio;
	private String imatge_nom;
	private int preu;
	
	/**
	 * Constructor de motor de coche con parametros
	 * @param id - ID del motor
	 * @param nom - Nombre del motor y sus especificaciones
	 * @param descripcio - Pequeña descripción del motor
	 * @param imatge_nom - Nombre de la imagen del motor (archivo)
	 * @param preu - Precio del motor
	 * @author Marc
	 */
	public Motor(String id, String nom, String descripcio, String imatge_nom, int preu) {
		this.id = id;
		this.nom = nom;
		this.descripcio = descripcio;
		this.imatge_nom = imatge_nom;
		this.preu = preu;
	}

	@Override
	public String toString() {
		return "Motor [id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + ", imatge_nom=" + imatge_nom
				+ ", preu=" + preu + "]";
	}
	
}
