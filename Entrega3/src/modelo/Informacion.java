package modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Informacion {
	
	private ManejadorHabitacion manejadorHabitacion;
	private ManejadorReserva manejadorReserva;
	private ManejadorUsuario manejadorUsuario;
	private ManejadorServicio manejadorServicio;
	private ManejadorPrecio manejadorPrecio;
	
	public Informacion(){
		this.manejadorHabitacion = new ManejadorHabitacion();
		this.manejadorReserva = new ManejadorReserva();
		this.manejadorUsuario = new ManejadorUsuario();
		this.manejadorServicio = new ManejadorServicio();
		this.manejadorPrecio = new ManejadorPrecio();
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
	
	public  void addReserva(Reserva reserva){
		manejadorReserva.agregarReserva(reserva);
	}
	
	public void addUsuario(Usuario usuario){
		manejadorUsuario.agregarUsuario(usuario);
	}
	
	public Usuario getUsuario(String nombreUsuario, String contraseña) {
		return (manejadorUsuario.obtenerUsuario(nombreUsuario, contraseña));
	}
	
	public Precio getPrecio() {
		return manejadorPrecio.obtenerPrecios();
	}


	public void addPrecioFecha(LocalDate fecha, int precio, int tipo) {
		manejadorPrecio.agregarPrecioFecha(fecha, precio, tipo);
	}
	
	public void setPrecioAdulto(int precio) {
		manejadorPrecio.setPrecioAdulto(precio);
	}
	
	public void setPrecioNinio(int precio) {
		manejadorPrecio.setPrecioNinio(precio);
	}
	
	public void setPrecioBalcon(int precio) {
		manejadorPrecio.setPrecioBalcon(precio);
	}
	
	public void setPrecioVista(int precio) {
		manejadorPrecio.setPrecioVista(precio);
	}
	
	public void setPrecioCocina(int precio) {
		manejadorPrecio.setPrecioCocina(precio);
	}

	public ArrayList<Servicio> getServicios() {
		return manejadorServicio.obtenerServicios();
	}


	public void addServicio(Servicio servicio){
		manejadorServicio.agregarServicio(servicio);
	}
	
	public void cambiarEstadoReserva(int id, Estado estado) {
		
	}
	
	
	
	

}
