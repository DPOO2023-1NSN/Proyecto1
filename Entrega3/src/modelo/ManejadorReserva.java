package modelo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManejadorReserva {
	
	private static final File XML_Reservas = new File("data/reservas.xml");
	private static final String RESERVA = "RESERVA";
	private static final String HABITACION = "HABITACION";
	private static final String GRUPO = "GRUPO";
	private static final String HUESPED = "HUESPED";
	private static final String HUESPEDR = "HUESPEDR";

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
	        
	        // Crea un nodohijo de grupo para huesped responsable
	        Element huespedRNode = document.createElement(HUESPEDR);
	        huespedRNode.setAttribute("nombreUsuario", grupo.getHuespedResponsable().getNombreUsuario()); 
	        huespedRNode.setAttribute("contraseña", grupo.getHuespedResponsable().getContraseña());
	        huespedRNode.setAttribute("nombre", grupo.getHuespedResponsable().getNombre());
	        huespedRNode.setAttribute("documento", grupo.getHuespedResponsable().getDocumento());
	        huespedRNode.setAttribute("edad", Integer.toString(grupo.getHuespedResponsable().getEdad()));
	        huespedRNode.setAttribute("correoElectronico", grupo.getHuespedResponsable().getCorreoElectronico());
	        huespedRNode.setAttribute("telefono", grupo.getHuespedResponsable().getTelefono());
            grupoNode.appendChild(huespedRNode);
	        
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
	            reservaNode.appendChild(habitacionNode);
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
	

	public ArrayList<Reserva> obtenerReservas(){
		ArrayList<Reserva> reservas = new ArrayList<>();
		// Obtiene la lista de nodos de reservas
		NodeList nodosReservas = document.getElementsByTagName(RESERVA);
		
		// Recorre cada nodo de reservas
		for (int i = 0; i < nodosReservas.getLength(); i++) {
			Element elementoReserva = (Element) nodosReservas.item(i);
			
			// Encuentra los atributos de la reserva
			LocalDate fechaInicio = LocalDate.parse(elementoReserva.getAttribute("fechaInicio"));
			LocalDate fechaFin = LocalDate.parse(elementoReserva.getAttribute("fechaFin"));
			Estado estado = Estado.valueOf(elementoReserva.getAttribute("estado"));
			int id = Integer.parseInt(elementoReserva.getAttribute("id"));
			int precio = Integer.parseInt(elementoReserva.getAttribute("precio"));
			
			// Obtiene la lista de nodos de habitaciones y obtiene un ArrayList de habitaciones
			NodeList nodosHabitaciones = elementoReserva.getElementsByTagName(HABITACION);
			ArrayList<Habitacion> habitaciones = obtenerHabDeNodeList(nodosHabitaciones);
			
			// Encuentra el elemento grupo y obtiene un objeto tipo Grupo
			Element elementoGrupo = (Element) elementoReserva.getElementsByTagName(GRUPO).item(0);
			Grupo grupo = obtenerGrupoDeElmento(elementoGrupo);
			
			// Crea la reserva y le da sus atributos
			Reserva reserva = new Reserva(grupo, fechaInicio, fechaFin);
			reserva.setEstado(estado);
			reserva.setId(id);
			reserva.setPrecio(precio);
			
			// Agrega las habitaciones
			for(Habitacion habitacion: habitaciones) {
				reserva.agregarHabitacion(habitacion);
			}
			reservas.add(reserva);
			
		}
		
		return reservas;
	}
	
	public ArrayList<Habitacion> obtenerHabDeNodeList(NodeList nodosHabitaciones){
		ArrayList<Habitacion> habitaciones = new ArrayList<>();
		for (int i = 0; i < nodosHabitaciones.getLength(); i++) {
			Element elementoHabitacion = (Element) nodosHabitaciones.item(i);
			int id = Integer.parseInt(elementoHabitacion.getAttribute("id"));
            int tipo = Integer.parseInt(elementoHabitacion.getAttribute("tipo"));
            int capacidadAdultos = Integer.parseInt(elementoHabitacion.getAttribute("capacidadAdultos"));
            int capacidadNinios = Integer.parseInt(elementoHabitacion.getAttribute("capacidadNinios"));
            boolean balcon = Boolean.parseBoolean(elementoHabitacion.getAttribute("balcon"));
            boolean vista = Boolean.parseBoolean(elementoHabitacion.getAttribute("vista"));
            boolean cocina = Boolean.parseBoolean(elementoHabitacion.getAttribute("cocina"));
            
            Habitacion habitacion = new Habitacion(id, tipo, capacidadAdultos, capacidadNinios, balcon, vista, cocina);
            habitaciones.add(habitacion);
		}
		
		return habitaciones;
	}
	
	
	public Grupo obtenerGrupoDeElmento(Element elementoGrupo) {
		LocalDate fechaCheckIn = LocalDate.parse(elementoGrupo.getAttribute("fechaCheckIn"));
		LocalDate fechaCheckOut = LocalDate.parse(elementoGrupo.getAttribute("fechaCheckOut"));
		Boolean realizoCheckIn = Boolean.parseBoolean(elementoGrupo.getAttribute("realizoCheckIn"));
		Boolean realizoCheckOut = Boolean.parseBoolean(elementoGrupo.getAttribute("realizoCheckOut"));
		
		// Obtiene el huesped responsable
		Element elementoHuespedR = (Element) elementoGrupo.getElementsByTagName(HUESPEDR).item(0);
		String nombreUsuario = elementoHuespedR.getAttribute("nombre");
		String contraseña = elementoHuespedR.getAttribute("contraseña");
		String nombre = elementoHuespedR.getAttribute("nombre");
		String documento = elementoHuespedR.getAttribute("documento");
		int edad = Integer.parseInt(elementoHuespedR.getAttribute("edad"));
		String correoElectronico = elementoHuespedR.getAttribute("correoElectronico");
		String telefono = elementoHuespedR.getAttribute("telefono");
		
		Huesped huespedR = new Huesped(nombreUsuario, contraseña, nombre, documento, edad, correoElectronico, telefono);
		
		// Crea la lista de huespedes
		NodeList nodosHuespedes = elementoGrupo.getElementsByTagName(HUESPED);
		ArrayList<Huesped> listaHuespedes = new ArrayList<Huesped>();
		
		for (int i = 0; i < nodosHuespedes.getLength(); i++) {
			Element elementoHuesped = (Element) nodosHuespedes.item(i);
			
			nombreUsuario = elementoHuesped.getAttribute("nombre");
			contraseña = elementoHuesped.getAttribute("contraseña");
			nombre = elementoHuesped.getAttribute("nombre");
			documento = elementoHuesped.getAttribute("documento");
			edad = Integer.parseInt(elementoHuesped.getAttribute("edad"));
			correoElectronico = elementoHuesped.getAttribute("correoElectronico");
			telefono = elementoHuesped.getAttribute("telefono");
			
			Huesped huesped = new Huesped(nombreUsuario, contraseña, nombre, documento, edad, correoElectronico, telefono);
			listaHuespedes.add(huesped);
		}
		
		// Crea el grupo y actualiza sus datos
		Grupo grupo = new Grupo(listaHuespedes, huespedR, fechaCheckIn, fechaCheckOut);
		grupo.setRealizoCheckIn(realizoCheckIn);
		grupo.setRealizocheckOut(realizoCheckOut);
		return grupo;
	}
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		Huesped huesped1 = new Huesped("user1", "pass1", "Juan", "12345678", 25, "juan@example.com", "12345678");
        Huesped huesped2 = new Huesped("user2", "pass2", "Pedro", "87654321", 30, "pedro@example.com", "87654321");
        Huesped huespedR = new Huesped("huesped", "pass2", "jajajasoyyo", "87654321", 30, "pedro@example.com", "87654321");
        ArrayList<Huesped> hp = new ArrayList<Huesped>();
        hp.add(huesped1);
        hp.add(huesped2);
        Grupo grupo = new Grupo(hp, huespedR, LocalDate.now(), LocalDate.now().plusDays(7));
		
        Reserva reserva = new Reserva(grupo, LocalDate.now(), LocalDate.now().plusDays(7));
        Reserva reserva2 = new Reserva(grupo, LocalDate.now(), LocalDate.now().plusDays(7));
        
        
        
        Habitacion habitacion1 = new Habitacion(506, 0, 2, 0, false, true, false);
        Habitacion habitacion2 = new Habitacion(405, 1, 2, 2, false, true, true);
        reserva.agregarHabitacion(habitacion1);
        reserva.agregarHabitacion(habitacion2);
        ManejadorReserva manejadorReserva = new ManejadorReserva();
        try {
            manejadorReserva.agregarReserva(reserva);
            System.out.println("Reserva agregada exitosamente.");
            manejadorReserva.agregarReserva(reserva2);
            System.out.println("Reserva agregada exitosamente.");
            ArrayList<Reserva> re = manejadorReserva.obtenerReservas();
            System.out.println(re.get(2).getGrupo().getHuespedResponsable().getNombre());
            
        } catch (TransformerException e) {
            System.out.println("Error al agregar reserva: " + e.getMessage());
        }
    }
	}

