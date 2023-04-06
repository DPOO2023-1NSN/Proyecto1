package modelo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

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

public class ManejadorPrecio {
	
	private static final File XML_Reservas = new File("data/precios.xml");
	private static final String PRECIOS = "PRECIOS";
	private static final String PRECIOSFECHA = "PRECIOSFECHA";
	private static final String PRECIOADULTO = "PRECIOADULTO";
	private static final String PRECIONINIO = "PRECIONINIO";
	private static final String PRECIOBALCON = "PRECIOBALCON";
	private static final String PRECIOVISTA= "PRECIOVISTA";
	private static final String PRECIOCOCINA = "PRECIOCOCINA";
	
	private Document document;

	public ManejadorPrecio(){
		try {
			this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_Reservas);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarPrecioFecha(LocalDate fecha, int precio, int tipo) {
		Node nodoFecha = document.getElementsByTagName("f"+fecha.toString()+"_"+tipo).item(0);
		
		// Si no existe la fecha crea el nodo
		if (nodoFecha == null) {
			Element elementFecha = document.createElement("f"+fecha.toString()+"_"+tipo);
			elementFecha.setAttribute("precio", Integer.toString(precio));
			
			// Agregar el nodo de reserva al final del archivo
	        Node preciosNode = document.getElementsByTagName(PRECIOSFECHA).item(0);
	        preciosNode.appendChild(elementFecha);
		}
		
		// Si ya existe la fecha modifica el precio
		else {
			Element elementFecha = (Element) nodoFecha;
			int precioFecha = Integer.parseInt(elementFecha.getAttribute("precio"));
			if (precio < precioFecha)
				elementFecha.getAttributeNode("precio").setValue(Integer.toString(precio));
		}
		
        
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
        StreamResult result = new StreamResult(XML_Reservas);
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void setPrecioAdulto(int precio) {
		Node nodePrecioAdulto = document.getElementsByTagName(PRECIOADULTO).item(0);
		
		if (nodePrecioAdulto == null) {
			Element elementPrecioAdulto = document.createElement(PRECIOADULTO);
			elementPrecioAdulto.setAttribute("precio", Integer.toString(precio));
			
			// Agregar el nodo de reserva al final del archivo
	        Node preciosNode = document.getElementsByTagName(PRECIOS).item(0);
	        preciosNode.appendChild(elementPrecioAdulto);
		}
		
		else {
			Element elementPrecioAdulto = (Element) nodePrecioAdulto;
			elementPrecioAdulto.getAttributeNode("precio").setValue(Integer.toString(precio));
		}
		
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
        StreamResult result = new StreamResult(XML_Reservas);
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void setPrecioNinio(int precio) {
		Node nodePrecioNinio = document.getElementsByTagName(PRECIONINIO).item(0);
		
		if (nodePrecioNinio == null) {
			Element elementPrecioNinio = document.createElement(PRECIONINIO);
			elementPrecioNinio.setAttribute("precio", Integer.toString(precio));
			
			// Agregar el nodo de reserva al final del archivo
	        Node preciosNode = document.getElementsByTagName(PRECIOS).item(0);
	        preciosNode.appendChild(elementPrecioNinio);
		}
		
		else {
			Element elementPrecioAdulto = (Element) nodePrecioNinio;
			elementPrecioAdulto.getAttributeNode("precio").setValue(Integer.toString(precio));
		}
		
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
        StreamResult result = new StreamResult(XML_Reservas);
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void setPrecioBalcon(int precio) {
		Node nodePrecioBalcon = document.getElementsByTagName(PRECIOBALCON).item(0);
		
		if (nodePrecioBalcon == null) {
			Element elementPrecioBalcon = document.createElement(PRECIOBALCON);
			elementPrecioBalcon.setAttribute("precio", Integer.toString(precio));
			
			// Agregar el nodo de reserva al final del archivo
	        Node preciosNode = document.getElementsByTagName(PRECIOS).item(0);
	        preciosNode.appendChild(elementPrecioBalcon);
		}
		
		else {
			Element elementPrecioAdulto = (Element) nodePrecioBalcon;
			elementPrecioAdulto.getAttributeNode("precio").setValue(Integer.toString(precio));
		}
		
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
        StreamResult result = new StreamResult(XML_Reservas);
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void setPrecioVista(int precio) {
		Node nodePrecioVista = document.getElementsByTagName(PRECIOVISTA).item(0);
		
		if (nodePrecioVista == null) {
			Element elementPrecioVista = document.createElement(PRECIOVISTA);
			elementPrecioVista.setAttribute("precio", Integer.toString(precio));
			
			// Agregar el nodo de reserva al final del archivo
	        Node preciosNode = document.getElementsByTagName(PRECIOS).item(0);
	        preciosNode.appendChild(elementPrecioVista);
		}
		
		else {
			Element elementPrecioAdulto = (Element) nodePrecioVista;
			elementPrecioAdulto.getAttributeNode("precio").setValue(Integer.toString(precio));
		}
		
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
        StreamResult result = new StreamResult(XML_Reservas);
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void setPrecioCocina(int precio) {
		Node nodePrecioCocina = document.getElementsByTagName(PRECIOCOCINA).item(0);
		
		if (nodePrecioCocina == null) {
			Element elementPrecioCocina = document.createElement(PRECIOCOCINA);
			elementPrecioCocina.setAttribute("precio", Integer.toString(precio));
			
			// Agregar el nodo de reserva al final del archivo
	        Node preciosNode = document.getElementsByTagName(PRECIOS).item(0);
	        preciosNode.appendChild(elementPrecioCocina);
		}
		
		else {
			Element elementPrecioAdulto = (Element) nodePrecioCocina;
			elementPrecioAdulto.getAttributeNode("precio").setValue(Integer.toString(precio));
		}
		
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
        StreamResult result = new StreamResult(XML_Reservas);
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void obtenerPrecios(){
			
		}
	
	public static void main(String[] args) {
		ManejadorPrecio mp = new ManejadorPrecio();
		System.out.println(LocalDate.parse("2022-10-23").toString());
		mp.agregarPrecioFecha(LocalDate.parse("2022-10-30"), 4000, 0);
		mp.setPrecioAdulto(1000);
		mp.setPrecioNinio(4800);
		mp.setPrecioBalcon(4000);
		mp.setPrecioVista(53200);
		mp.setPrecioCocina(56000);
	}
}
