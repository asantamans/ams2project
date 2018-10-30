package idao;

import java.util.ArrayList;

import configuracion_vehiculo.Accesori;
import configuracion_vehiculo.Model;
import configuracion_vehiculo.Motor;

//clase para implementar los metodos que haran falta para cargar la configuración de los coches
public interface ICarConfiguration {
	void load_Car_Config();
	ArrayList<Model> getModelos();
	ArrayList<Motor> getMotores();
	ArrayList<Accesori> getAccesorios();
}
