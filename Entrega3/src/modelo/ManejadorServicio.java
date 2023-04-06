package modelo;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManejadorServicio {

	private static final File XML_Servicios = new File("data/servicios.xml");
	private static final String SERVICIO = "SERVICIO";
	private static final String SERVICIOS = "SERVICIOS";
	private Document document;
	
	public ManejadorServicio(){
		try {
			this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_Servicios);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void agregarServicio(Servicio servicio){
		Element elementoServicio = document.createElement(SERVICIO); 
		
		// Crea los atributos del elemento servicio
		elementoServicio.setAttribute("id", Integer.toString(servicio.getId()));
		elementoServicio.setAttribute("nombre", servicio.getNombre());
		elementoServicio.setAttribute("precio", Integer.toString(servicio.getPrecio()));
		elementoServicio.setAttribute("pagado", Boolean.toString(servicio.getPagado()));
		
		// Comprueba si es un objeto tipo ProductoMenu
		if (servicio instanceof ProductoMenu) {
			ProductoMenu servicioProducto = (ProductoMenu) servicio;
			elementoServicio.setAttribute("type", "producto");
			elementoServicio.setAttribute("horainicio", servicioProducto.getHoraInicio().toString());
			elementoServicio.setAttribute("horafin", servicioProducto.getHoraFin().toString());
		}
		else {
			elementoServicio.setAttribute("type", "servicio");
		}
		
		// Agregar el nodo de usuario al final del archivo
        Node serviciosNode = document.getElementsByTagName(SERVICIOS).item(0);
        serviciosNode.appendChild(elementoServicio);
		
        // Guardar los cambios en el archivo
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(XML_Servicios);
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Servicio> obtenerServicios() {
	    ArrayList<Servicio> servicios = new ArrayList<>();

	    // Obtiene los nodos de servicios
	    NodeList servicioNodes = document.getElementsByTagName(SERVICIO);

	    // Recorre cada nodo
	    for (int i = 0; i < servicioNodes.getLength(); i++) {
	    	Element elementoServicio = (Element) servicioNodes.item(i);
	    	Servicio servicio = null;
	    	
	    	// Obtiene los atributos de la clase Servicio
            String tipoServicio = elementoServicio.getAttribute("type");
            int id = Integer.parseInt(elementoServicio.getAttribute("id"));
            String nombre = elementoServicio.getAttribute("nombre");
            int precio = Integer.parseInt(elementoServicio.getAttribute("precio"));
            boolean pagado = Boolean.parseBoolean(elementoServicio.getAttribute("pagado"));

            // Si es un ProductoMenu obtiene sus atributos y lo crea
            if (tipoServicio.equals("producto")) {
                LocalTime horaInicio = LocalTime.parse(elementoServicio.getAttribute("horainicio"));
                LocalTime horaFin = LocalTime.parse(elementoServicio.getAttribute("horafin"));
                servicio = new ProductoMenu(id, nombre, precio, horaInicio, horaFin);
            // Si solo es un servicio solo lo crea
            } else {
                servicio = new Servicio(id, nombre, precio);
            }

            servicio.setPagado(pagado);
            
            servicios.add(servicio);
	        
	    }

	    return servicios;
	}
	
}
