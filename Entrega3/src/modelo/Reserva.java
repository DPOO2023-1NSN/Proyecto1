package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
	private Grupo grupo;
	private ArrayList <Habitacion> listaHabitaciones;
	private static int id;
	private Estado estado;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int precio;
	
	
	public Reserva(Grupo grupo, LocalDate fechaInicio, LocalDate fechaFin) {
		this.grupo = grupo;
		this.estado = Estado.RESERVADA;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public void agregarHabitacion(Habitacion habitacion) {
		listaHabitaciones.add(habitacion);
	}
	
	public int calcularPrecioReserva(Precio precios) {
		int precioReserva = 0;
	    for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusDays(1)) {
	      for (Habitacion habitacion: listaHabitaciones) {
	    	  precioReserva = precioReserva + habitacion.calcularBaseporNoche(precios, date);
	      }
	    }
	    
	    this.precio = precioReserva;
	    
		return precioReserva;
		}

	
}
