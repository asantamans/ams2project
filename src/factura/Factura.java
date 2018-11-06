package factura;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

//import configuracion_vehiculo.CarConfiguration;

public class Factura {
	/* main para hacer pruebas
	public static void main(String[] args) {
		Factura fac = new Factura();
		CarConfiguration car_config = new CarConfiguration();
		car_config.load_Car_Config();
		double precioFinal = car_config.getModelos().get(0).getPreu()+car_config.getMotores().get(0).getPreu();
		SelectedCar car = new SelectedCar(car_config.getModelos().get(0), car_config.getMotores().get(0), car_config.getAccesorios(), precioFinal);
		fac.generateXML("Marc", new Cliente("nombre", "primerApellido", "segundoApellido", "direccion", "correoElectronico", "genero", "01-01-1990"), car);
	}*/
	
	/**
	 * Genera una factura (archivo xml) con los datos mas relevantes
	 * @param nombreEmpleado - Es el nombre del empleado (usuario) que se loguea en la aplicacion
	 * @param cliente - El objeto donde se guardan los datos del cliente cuando llena el formulario y lo guarda
	 * @param cocheSelec - El coche con todos los extras que hayamos seleccionado
	 * @author Marc
	 */
	public void generateXML(String nombreEmpleado, Cliente cliente, SelectedCar cocheSelec) {
		try {
			String nombre_xml = "fs_employee";
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "factura", null);
            document.setXmlVersion("1.0");

            //Nodo principal
            Element root = document.getDocumentElement();
            //Creo el nodo nombre_vendedor
            Element namevNode = document.createElement("nombre_vendedor");
			Text namevValue = document.createTextNode(nombreEmpleado);
			namevNode.appendChild(namevValue);
			//Creo el nodo cliente
			Element clienteNode = document.createElement("cliente");
			//datos del cliente
			Element nombreNode = document.createElement("nombre");
			Text nombreValue = document.createTextNode(cliente.getNombre());
			nombreNode.appendChild(nombreValue);
			
			Element pApellidoNode = document.createElement("primer_apellido");
			Text paValue = document.createTextNode(cliente.getPrimerApellido());
			pApellidoNode.appendChild(paValue);
			
			Element sApellidoNode = document.createElement("segundo_apellido");
			Text saValue = document.createTextNode(cliente.getSegundoApellido());
			sApellidoNode.appendChild(saValue); 

			Element direccionNode = document.createElement("direccion");
			Text direccionValue = document.createTextNode(cliente.getDireccion());
			direccionNode.appendChild(direccionValue);
			
			Element correoElecNode = document.createElement("correo_electronico");
			Text correoElecValue = document.createTextNode(cliente.getCorreoElectronico());
			correoElecNode.appendChild(correoElecValue);
			
			Element generoNode = document.createElement("genero");
			Text generoValue = document.createTextNode(cliente.getGenero());
			generoNode.appendChild(generoValue);
			
			Element fechaNacimientoNode = document.createElement("fecha_nacimiento");
			Text fechaNcValue = document.createTextNode(cliente.getFechaNacimiento());
			fechaNacimientoNode.appendChild(fechaNcValue);
			
			//añado los nodos a cliente
			clienteNode.appendChild(nombreNode);
			clienteNode.appendChild(pApellidoNode);
			clienteNode.appendChild(sApellidoNode);
			clienteNode.appendChild(direccionNode);
			clienteNode.appendChild(correoElecNode);
			clienteNode.appendChild(generoNode);
			clienteNode.appendChild(fechaNacimientoNode);
			
			//creo el nodo coche_seleccionado
			Element cocheNode = document.createElement("coche_seleccionado");
			//datos del coche seleccionado
			Element modeloNode = document.createElement("modelo");
			//nombre del modelo
			Element nameModNode = document.createElement("nombre_modelo");
			Text nameModValue = document.createTextNode(cocheSelec.getModeloSeleccionado().getNom());
			nameModNode.appendChild(nameModValue);
			//precio del modelo
			Element precioModNode = document.createElement("precio_modelo");
			Text precioModValue = document.createTextNode(cocheSelec.getModeloSeleccionado().getPreu()+"");
			precioModNode.appendChild(precioModValue);
			//añado los nodos a modelo
			modeloNode.appendChild(nameModNode);
			modeloNode.appendChild(precioModNode);
			
			Element submodelNode = document.createElement("submodelo");
			
			Element nameSbNode = document.createElement("nombre_submodelo");
			Text nameSbValue = document.createTextNode(cocheSelec.getSubmodeloSeleccionado().getNom());
			nameSbNode.appendChild(nameSbValue);
			
			Element descrSbNode = document.createElement("tipo_motor");
			Text descrSbValue = document.createTextNode(cocheSelec.getSubmodeloSeleccionado().getDescripcio());
			descrSbNode.appendChild(descrSbValue);
			
			Element precioSbNode = document.createElement("precio_motor");
			Text precioSbValue = document.createTextNode(cocheSelec.getSubmodeloSeleccionado().getPreu()+"");
			precioSbNode.appendChild(precioSbValue);
			//añado los nodos al submodelo
			submodelNode.appendChild(nameSbNode);
			submodelNode.appendChild(descrSbNode);
			submodelNode.appendChild(precioSbNode);
			
			Element accesoriosNode = document.createElement("accesorios_comprados");
			//añado los accesorios que se hayan seleccionado
			for (int i = 0; i < cocheSelec.getAccesoriosSeleccionados().size(); i++) {
				Element accesorioNode = document.createElement("accesorio");
				//nombre del accesorio
				Element accNameNode = document.createElement("nombre_accesorio");
				Text accNameValue = document.createTextNode(cocheSelec.getAccesoriosSeleccionados().get(i).getNom());
				accNameNode.appendChild(accNameValue);
				//precio del accesorio
				Element precioAccNode = document.createElement("precio_accesorio");
				Text precioAccValue = document.createTextNode(cocheSelec.getAccesoriosSeleccionados().get(i).getPreu()+"");
				precioAccNode.appendChild(precioAccValue);
				//añado los nodos a accesorio
				accesorioNode.appendChild(accNameNode);
				accesorioNode.appendChild(precioAccNode);
				//añado el nodo accesorio a accesorios_comprados
				accesoriosNode.appendChild(accesorioNode);
			}
			
			Element precioNode = document.createElement("precio_total");
			Text precioValue = document.createTextNode(cocheSelec.getPrecioFinal()+"");
			precioNode.appendChild(precioValue);
			
			//añado los nodos a coche_seleccionado
			cocheNode.appendChild(modeloNode);
			cocheNode.appendChild(submodelNode);
			cocheNode.appendChild(accesoriosNode);
			cocheNode.appendChild(precioNode);
			
			root.appendChild(namevNode);
			root.appendChild(clienteNode);
			root.appendChild(cocheNode);
			
            //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File(nombre_xml+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //las 3 proximas lineas son importantes, sirven para que genere el xml con saltos de linea, si no se mostrara todo en una linea
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount","2");
            transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
