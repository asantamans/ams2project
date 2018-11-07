package factura;

import java.util.ArrayList;

import configuracion_vehiculo.Accesori;
import configuracion_vehiculo.Model;
import configuracion_vehiculo.Motor;

public class SelectedCar {
	private Model modeloSeleccionado;
	private Motor submodeloSeleccionado;
	private ArrayList<Accesori> accesoriosSeleccionados;
	private int precioFinal;//el precio final no tendra decimales
	private static SelectedCar selectedCar;
	/**
	 * Al crearlo le pasaremos el modelo de coche seleccionado, el submodelo seleccionado, los accesorios que se hayan seleccionado y el coste total del coche
	 * @param modeloSeleccionado - El modelo que el usuario haya seleccionado
	 * @param submodeloSeleccionado - El submodelo (Motor) que el usuario haya seleccionado
	 * @param accesoriosSeleccionados - Un ArrayList con todos los accesorios que el usuario haya seleccionado
	 * @param precioFinal - El precio total del coche (la suma del precio modelo del coche, precio del motor y precio de los accesorios)
	 * @author Marc
	 */
	public SelectedCar(Model modeloSeleccionado, Motor submodeloSeleccionado,
			ArrayList<Accesori> accesoriosSeleccionados, int precioFinal) {
		this.modeloSeleccionado = modeloSeleccionado;
		this.submodeloSeleccionado = submodeloSeleccionado;
		this.accesoriosSeleccionados = accesoriosSeleccionados;
		this.precioFinal = precioFinal;
	}
	
	//getters
	public Model getModeloSeleccionado() {
		return modeloSeleccionado;
	}

	public Motor getSubmodeloSeleccionado() {
		return submodeloSeleccionado;
	}

	public ArrayList<Accesori> getAccesoriosSeleccionados() {
		return accesoriosSeleccionados;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public static SelectedCar getSelectedCar() {
		return selectedCar;
	}

	public static void setSelectedCar(SelectedCar selectedCar) {
		SelectedCar.selectedCar = selectedCar;
	}
	
}
