package modelo;

public class Huesped extends Usuario{
	private int edad;
	private String correoElectronico;
	private String telefono;
	
	
	public Huesped(String nombreUsuario, String contraseña, String nombre, String documento, int edad, String correoElectronico, String telefono) {
		super(nombreUsuario, contraseña, nombre, documento);
		this.edad = edad;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
	}


	public int getEdad() {
		return edad;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public String getTelefono() {
		return telefono;
	}
	
	
	
	

}
