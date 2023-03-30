package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
	private Grupo grupo;
	private ArrayList <Habitacion> listaHabitaciones;
	private static int ultimoId;
	private int id;
	private Estado estado;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int precio;
	
	
	@SuppressWarnings("static-access")
	public Reserva(Grupo grupo, LocalDate fechaInicio, LocalDate fechaFin) {
		this.grupo = grupo;
		this.estado = Estado.RESERVADA;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.id = this.ultimoId + 1;
		this.ultimoId++;
	}
	
	public void agregarHabitacion(Habitacion habitacion) {
		listaHabitaciones.add(habitacion);
	}
	
	public int calcularPrecioReserva(Precio precios) {
		int precioReserva = 0;
	    for (LocalDate date = this.fechaInicio; !date.isAfter(this.fechaFin); date = date.plusDays(1)) {
	      for (Habitacion habitacion: listaHabitaciones) {
	    	  precioReserva += habitacion.calcularBaseporNoche(precios, date);
	      }
	    }
	    
	    this.precio = precioReserva;
	    
		return precioReserva;
		}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	

	
}
