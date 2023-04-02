package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Habitacion {
	//private static ArrayList <Cama> listaCamas;
	private int id;
	private int tipo;
	private int capacidadAdultos;
	private int capacidadNinios;
	private Boolean reservada;
	private Boolean balcon;
	private Boolean vista;
	private Boolean cocina;
	

	public Habitacion(int id, int tipo, int capacidadAdultos, int capacidadNiños, Boolean balcon, Boolean vista, Boolean cocina) {
		this.id = id;
		this.tipo = tipo;
		this.capacidadAdultos = capacidadAdultos;
		this.capacidadNinios = capacidadNiños;
		this.reservada = false;
		this.balcon = balcon;
		this.vista = vista;
		this.cocina = cocina;
	}
	
	public int calcularBaseporNoche(Precio precios, LocalDate fecha) {
		int precioBase = 0;
		int precioAdicionales = 0;
		int precioCapacidad = precios.getPrecioAdulto()*this.capacidadAdultos + precios.getPrecioNinio()*this.capacidadNinios;

		
		if (this.tipo == 0) {
			precioBase = precios.getPreciosEstandar().get(fecha);
		}
		else if (this.tipo == 1) {
			precioBase = precios.getPreciosSuit().get(fecha);
		}
		else if (this.tipo == 2) {
			precioBase = precios.getPreciosSuitDoble().get(fecha);
		}
		
		if (this.balcon == true) {
			precioAdicionales = precioAdicionales + precios.getPrecioBalcon();
		}
		if (this.cocina == true) {
			precioAdicionales = precioAdicionales + precios.getPrecioCocina();
		}
		if (this.vista == true) {
			precioAdicionales = precioAdicionales + precios.getPrecioVista();
		}
		
		return precioBase + precioAdicionales + precioCapacidad;
	}

	public int getCapacidadAdultos() {
		return capacidadAdultos;
	}

	public int getCapacidadNinios() {
		return capacidadNinios;
	}

	public void setReservada(Boolean reservada) {
		this.reservada = reservada;
	}

	public int getId() {
		return id;
	}

	public int getTipo() {
		return tipo;
	}

	public Boolean getReservada() {
		return reservada;
	}

	public Boolean getBalcon() {
		return balcon;
	}

	public Boolean getVista() {
		return vista;
	}

	public Boolean getCocina() {
		return cocina;
	}
	
	
}



