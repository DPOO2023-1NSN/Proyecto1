package modelo;

import java.util.ArrayList;

public class Informacion {
	
	private static Precio precios;
	private static ArrayList <Habitacion> listaHabitaciones;
	private static ArrayList <Servicio> listaServicios;
	
	
	public static Precio getPrecios() {
		return precios;
	}


	public static void setPrecios(Precio precios) {
		Informacion.precios = precios;
	}


	public static ArrayList<Habitacion> getListaHabitaciones() {
		return Informacion.listaHabitaciones;
	}


	public static void addHabitacion(Habitacion habitacion) {
		Informacion.listaHabitaciones.add(habitacion);
	}


	public static ArrayList<Servicio> getListaServicios() {
		return Informacion.listaServicios;
	}


	public static void addServicio(Servicio servicio) {
		Informacion.listaServicios.add(servicio);
	}
	
	
	
	

}
