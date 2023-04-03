package modelo;

public class Servicio {
	private int id;
	private String nombre;
	private int precio;
	private Boolean pagado;
	
	public Servicio(int id, String nombre, int precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.pagado = false;
	}
	

	public int getId() {
		return id;
	}


	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
	
	
	
}
