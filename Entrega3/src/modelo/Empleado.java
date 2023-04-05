package modelo;

public class Empleado extends Usuario{

	private String servicioEncargado;
	
	public Empleado(String nombreUsuario, String contraseña, String nombre, String documento, String servicioEncargado) {
		super(nombreUsuario, contraseña, nombre, documento);
		this.servicioEncargado = servicioEncargado;
	}

	public String getServicioEncargado() {
		return servicioEncargado;
	}
	
}
