package modelo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class ManejadorReserva {
	
	private static final File XML_Reservas = new File("data/reservas.xml");

	private Document document;
		
	public ManejadorReserva() throws SAXException, IOException, ParserConfigurationException {
		this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_Reservas);
	}
	
	public void agregarReserva(Reserva reserva) throws TransformerException {
	        
	        // Crear el nodo de reserva con sus respectivos nodos hijos
	        Element reservaNode = document.createElement("RESERVA");
	        reservaNode.setAttribute("id", Integer.toString(reserva.getId()));
	        reservaNode.setAttribute("estado", reserva.getEstado().toString());
	        reservaNode.setAttribute("fechaInicio", reserva.getFechaInicio().toString());
	        reservaNode.setAttribute("fechaFin", reserva.getFechaFin().toString());
	        reservaNode.setAttribute("precio", Integer.toString(reserva.getPrecio()));
	        
	        // Crear el nodo de grupo y agregarlo como hijo del nodo de reserva
	        Grupo grupo = reserva.getGrupo();
	        Element grupoNode = document.createElement("GRUPO");
	        grupoNode.setAttribute("fechaCheckIn", grupo.getFechaCheckIn().toString());
	        grupoNode.setAttribute("realizoCheckIn", grupo.getRealizoCheckIn().toString());
	        grupoNode.setAttribute("fechaCheckOut", grupo.getFechaCheckOut().toString());
	        grupoNode.setAttribute("realizoCheckOut", grupo.getRealizocheckOut().toString());
	        
	        // Crear nodos hijos para la lista de huespedes
	        ArrayList<Huesped> huespedes = grupo.getListaHuespedes();
	        for (Huesped huesped : huespedes) {
	            Element huespedNode = document.createElement("HUESPED");
	            huespedNode.setAttribute("nombreUsuario", huesped.getNombreUsuario());
	            huespedNode.setAttribute("contraseña", huesped.getContraseña());
	            huespedNode.setAttribute("nombre", huesped.getNombre());
	            huespedNode.setAttribute("documento", huesped.getDocumento());
	            huespedNode.setAttribute("edad", Integer.toString(huesped.getEdad()));
	            huespedNode.setAttribute("correoElectronico", huesped.getCorreoElectronico());
	            huespedNode.setAttribute("telefono", huesped.getTelefono());
	            grupoNode.appendChild(huespedNode);
	        }
	        reservaNode.appendChild(grupoNode);
	        
	        // Crear nodos hijos para la lista de habitaciones
	        ArrayList<Habitacion> habitaciones = reserva.getListaHabitaciones();
	        for (Habitacion habitacion : habitaciones) {
	            Element habitacionNode = document.createElement("HABITACION");
	            habitacionNode.setAttribute("id", Integer.toString(habitacion.getId()));
	            habitacionNode.setAttribute("tipo", Integer.toString(habitacion.getTipo()));
	            habitacionNode.setAttribute("capacidadAdultos", Integer.toString(habitacion.getCapacidadAdultos()));
	            habitacionNode.setAttribute("capacidadNinios", Integer.toString(habitacion.getCapacidadNinios()));
	            habitacionNode.setAttribute("reservada", Boolean.toString(habitacion.getReservada()));
	            habitacionNode.setAttribute("balcon", Boolean.toString(habitacion.getBalcon()));
	            habitacionNode.setAttribute("vista", Boolean.toString(habitacion.getVista()));
	            habitacionNode.setAttribute("cocina", Boolean.toString(habitacion.getCocina()));
	            grupoNode.appendChild(habitacionNode);
	        }

	        reservaNode.appendChild(grupoNode);
	        
	        // Agregar el nodo de reserva al final del archivo
	        Node reservasNode = document.getElementsByTagName("RESERVAS").item(0);
	        reservasNode.appendChild(reservaNode);
	        
	        // Guardar los cambios en el archivo
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(document);
	        StreamResult result = new StreamResult(XML_Reservas);
	        transformer.transform(source, result);
	        
	    }
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		Huesped huesped1 = new Huesped("user1", "pass1", "Juan", "12345678", 25, "juan@example.com", "12345678");
        Huesped huesped2 = new Huesped("user2", "pass2", "Pedro", "87654321", 30, "pedro@example.com", "87654321");
        ArrayList<Huesped> hp = new ArrayList<Huesped>();
        hp.add(huesped1);
        hp.add(huesped2);
        Grupo grupo = new Grupo(hp, LocalDate.now(), LocalDate.now().plusDays(7));
		
        Reserva reserva = new Reserva(grupo, LocalDate.now(), LocalDate.now().plusDays(7));
        
        
        
        Habitacion habitacion1 = new Habitacion(506, 0, 2, 0, false, true, false);
        Habitacion habitacion2 = new Habitacion(405, 1, 2, 2, false, true, true);
        reserva.agregarHabitacion(habitacion1);
        reserva.agregarHabitacion(habitacion2);
        ManejadorReserva manejadorReserva = new ManejadorReserva();
        try {
            manejadorReserva.agregarReserva(reserva);
            System.out.println("Reserva agregada exitosamente.");
        } catch (TransformerException e) {
            System.out.println("Error al agregar reserva: " + e.getMessage());
        }
    }
	}

