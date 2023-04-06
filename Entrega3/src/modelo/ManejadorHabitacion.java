package modelo;

import java.io.File;
import java.io.IOException;
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

public class ManejadorHabitacion {
	private static final File XML_Habitaciones = new File("data/habitaciones.xml");
	private static final String HABITACION = "HABITACION";
	private static final String ID = "ID";
	private static final String TIPO = "TIPO";
	private static final String CAPACIDADADULTOS = "CAPACIDADADULTOS";
	private static final String CAPACIDADNINIOS = "CAPACIDADNINIOS";
	private static final String BALCON = "BALCON";
	private static final String VISTA = "VISTA";
	private static final String COCINA = "COCINA";
	
	
	private Document document;
	
	public ManejadorHabitacion(){
		try {
			this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_Habitaciones);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public NodeList getNodosHabitaciones() {
		return document.getElementsByTagName("HABITACION");
	}
	
	public void agregarHabitacion(Habitacion habitacion){
		Node nodoHabitaciones = document.getFirstChild();
		Element nuevaHabitacion = document.createElement(HABITACION);
		nuevaHabitacion.setAttribute(ID, Integer.toString(habitacion.getId()));
		nodoHabitaciones.appendChild(nuevaHabitacion);
		
		Element tipo = document.createElement(TIPO);
		tipo.appendChild(document.createTextNode(Integer.toString(habitacion.getTipo())));
		nuevaHabitacion.appendChild(tipo);
		
		Element capacidadAdultos = document.createElement(CAPACIDADADULTOS);
		capacidadAdultos.appendChild(document.createTextNode(Integer.toString(habitacion.getCapacidadAdultos())));
		nuevaHabitacion.appendChild(capacidadAdultos);
		
		Element capacidadNinios = document.createElement(CAPACIDADNINIOS);
		capacidadNinios.appendChild(document.createTextNode(Integer.toString(habitacion.getCapacidadNinios())));
		nuevaHabitacion.appendChild(capacidadNinios);
		
		Element balcon = document.createElement(BALCON);
		balcon.appendChild(document.createTextNode(Boolean.toString(habitacion.getBalcon())));
		nuevaHabitacion.appendChild(balcon);
		
		Element vista = document.createElement(VISTA);
		vista.appendChild(document.createTextNode(Boolean.toString(habitacion.getVista())));
		nuevaHabitacion.appendChild(vista);
		
		Element cocina = document.createElement(COCINA);
		cocina.appendChild(document.createTextNode(Boolean.toString(habitacion.getCocina())));
		nuevaHabitacion.appendChild(cocina);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(XML_Habitaciones);
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Habitacion> obtenerHabitaciones() {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        
        NodeList nodosHabitaciones = document.getElementsByTagName(HABITACION);
        
        for (int i = 0; i < nodosHabitaciones.getLength(); i++) {
            Element elementoHabitacion = (Element) nodosHabitaciones.item(i);
            int id = Integer.parseInt(elementoHabitacion.getAttribute("ID"));
            int tipo = Integer.parseInt(elementoHabitacion.getElementsByTagName("TIPO").item(0).getTextContent());
            int capacidadAdultos = Integer.parseInt(elementoHabitacion.getElementsByTagName("CAPACIDADADULTOS").item(0).getTextContent());
            int capacidadNinios = Integer.parseInt(elementoHabitacion.getElementsByTagName("CAPACIDADNINIOS").item(0).getTextContent());
            boolean balcon = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName("BALCON").item(0).getTextContent());
            boolean vista = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName("VISTA").item(0).getTextContent());
            boolean cocina = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName("COCINA").item(0).getTextContent());
            
            Habitacion habitacion = new Habitacion(id, tipo, capacidadAdultos, capacidadNinios, balcon, vista, cocina);
            habitaciones.add(habitacion);
        }
        
        return habitaciones;
	}
	

	
}
