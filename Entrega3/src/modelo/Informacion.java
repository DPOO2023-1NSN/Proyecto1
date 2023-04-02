package modelo;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Informacion {
	
	private ManejadorHabitacion manejadorHabitacion;
	private ManejadorReserva manejadorReserva;
	
	public Informacion() throws SAXException, IOException, ParserConfigurationException {
		this.manejadorHabitacion = new ManejadorHabitacion();
		this.manejadorReserva = new ManejadorReserva();
	}
	
	public ArrayList<Habitacion> getHabitaciones() {
		return manejadorHabitacion.obtenerHabitaciones();
	}
	
	public void addHabitacion(Habitacion habitacion) throws TransformerException {
		manejadorHabitacion.agregarHabitacion(habitacion);
	}
	
	public ArrayList<Reserva> getReservas() {
		return manejadorReserva.obtenerReservas();
	}
	
	public void addReserva(Reserva reserva) throws TransformerException {
		manejadorReserva.agregarReserva(reserva);
	}
	
	public static Precio getPrecios() {
		return precios;
	}


	public static void setPrecios(Precio precios) {
		Informacion.precios = precios;
	}
	

	public static ArrayList<Servicio> getListaServicios() {
		return Informacion.listaServicios;
	}


	public static void addServicio(Servicio servicio) {
		Informacion.listaServicios.add(servicio);
	}
	
	
	
	

}
