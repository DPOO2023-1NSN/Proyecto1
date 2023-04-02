package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Reserva {
	private Grupo grupo;
	private ArrayList <Habitacion> listaHabitaciones;
	private int id;
	private Estado estado;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int precio;
	private Random rd = new Random();
	
	
	@SuppressWarnings("static-access")
	public Reserva(Grupo grupo, LocalDate fechaInicio, LocalDate fechaFin) {
		this.grupo = grupo;
		this.estado = Estado.RESERVADA;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.id = rd.nextInt(9000) + 1000;
		this.listaHabitaciones = new ArrayList <Habitacion>();
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

	public Grupo getGrupo() {
		return grupo;
	}

	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}

	public int getId() {
		return id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public int getPrecio() {
		return precio;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	

	
}
