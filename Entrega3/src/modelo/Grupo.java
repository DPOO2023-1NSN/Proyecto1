package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Grupo {
	private ArrayList <Huesped> listaHuespedes;
	private Huesped huespedResponsable;
	private LocalDate fechaCheckIn;
	private Boolean realizoCheckIn;
	private LocalDate fechaCheckOut;
	private Boolean realizocheckOut;
	private ArrayList<Servicio> servicios;
	
	public Grupo(ArrayList<Huesped> listaHuespedes, Huesped huespedResponsable, LocalDate fechaCheckIn, LocalDate fechaCheckOut) {
		this.listaHuespedes = listaHuespedes;
		this.huespedResponsable = huespedResponsable;
		this.fechaCheckIn = fechaCheckIn;
		this.realizoCheckIn = false;
		this.fechaCheckOut = fechaCheckOut;
		this.realizocheckOut = false;
		this.servicios = new ArrayList<Servicio>();
	}
	
	public LocalDate getFechaCheckIn() {
		return fechaCheckIn;
	}


	public void setFechaCheckIn(LocalDate fechaCheckIn) {
		this.fechaCheckIn = fechaCheckIn;
	}


	public LocalDate getFechaCheckOut() {
		return fechaCheckOut;
	}


	public void setFechaCheckOut(LocalDate fechaCheckOut) {
		this.fechaCheckOut = fechaCheckOut;
	}

	public Boolean getRealizoCheckIn() {
		return realizoCheckIn;
	}


	public void setRealizoCheckIn(Boolean realizoCheckIn) {
		this.realizoCheckIn = realizoCheckIn;
	}


	public Boolean getRealizocheckOut() {
		return realizocheckOut;
	}


	public void setRealizocheckOut(Boolean realizocheckOut) {
		this.realizocheckOut = realizocheckOut;
	}


	public ArrayList<Servicio> getServicios() {
		return servicios;
	}


	public void addServicio(Servicio servicio) {
		servicios.add(servicio);
	}

	public ArrayList<Huesped> getListaHuespedes() {
		return listaHuespedes;
	}

	public Huesped getHuespedResponsable() {
		return huespedResponsable;
	}
	
	
	
	

}
