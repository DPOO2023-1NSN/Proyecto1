package modelo;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Informacion {
	
	private ManejadorHabitacion manejadorHabitacion;
	private ManejadorReserva manejadorReserva;
	private ManejadorUsuario manejadorUsuario;
	private ManejadorServicio manejadorServicio;
	
	public Informacion(){
		this.manejadorHabitacion = new ManejadorHabitacion();
		this.manejadorReserva = new ManejadorReserva();
		this.manejadorUsuario = new ManejadorUsuario();
		this.manejadorServicio = new ManejadorServicio();
	}
	
	public ArrayList<Habitacion> getHabitaciones() {
		return manejadorHabitacion.obtenerHabitaciones();
	}
	
	public void addHabitacion(Habitacion habitacion){
		manejadorHabitacion.agregarHabitacion(habitacion);
	}
	
	public ArrayList<Reserva> getReservas() {
		return manejadorReserva.obtenerReservas();
	}
	
	public void addReserva(Reserva reserva){
		manejadorReserva.agregarReserva(reserva);
	}
	
	public void addUsuario(Usuario usuario){
		manejadorUsuario.agregarUsuario(usuario);
	}
	
	public Usuario getUsuario(String nombreUsuario, String contraseña) {
		return (manejadorUsuario.obtenerUsuario(nombreUsuario, contraseña));
	}
	
	public static Precio getPrecios() {
		return precios;
	}


	public static void setPrecios(Precio precios) {
		Informacion.precios = precios;
	}
	

	public ArrayList<Servicio> getServicios() {
		return manejadorServicio.obtenerServicios();
	}


	public void addServicio(Servicio servicio){
		manejadorServicio.agregarServicio(servicio);
	}
	
	
	
	

}
