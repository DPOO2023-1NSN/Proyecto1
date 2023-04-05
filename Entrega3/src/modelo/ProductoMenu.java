package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProductoMenu extends Servicio{
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	public ProductoMenu(int id, String nombre, int precio, LocalTime horaInicio, LocalTime horaFin) {
		super(id, nombre, precio);
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	@Override
	public int getPrecio() {
		return super.getPrecio();
	}

	public void setPrecio(int precio) {
		super.setPrecio(precio);
	}

	public Boolean getPagado() {
		return super.getPagado();
	}

	public void setPagado(Boolean pagado) {
		super.setPagado(pagado);
	}

	public String getNombre() {
		return super.getNombre();
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}
	
	
	
	

}
