package modelo;

public class Huesped extends Usuario{
	private int edad;
	private String correoElectronico;
	private String telefono;
	
	
	public Huesped(int edad, String correoElectronico, String telefono) {
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
