package factura;

public class Cliente {
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String direccion;
	private String correoElectronico;
	private String genero;
	private String fechaNacimiento;
	private static Cliente cliente;
	
	public Cliente(String nombre, String primerApellido, String segundoApellido, String direccion,
			String correoElectronico, String genero, String fechaNacimiento) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.direccion = direccion;
		this.correoElectronico = correoElectronico;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public String getGenero() {
		return genero;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public static Cliente getCliente() {
		return cliente;
	}
	public static void setCliente(Cliente cliente) {
		Cliente.cliente = cliente;
	}
	
	//to String para ver el objeto, borrar al finalizar
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + ", direccion=" + direccion + ", correoElectronico=" + correoElectronico
				+ ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
}
