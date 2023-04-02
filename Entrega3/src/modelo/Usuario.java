package modelo;

public class Usuario {
	private String nombreUsuario;
	private String contraseña;
	private String nombre;
	private String documento;
	
	public Usuario(String nombreUsuario, String contraseña, String nombre, String documento) {
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.documento = documento;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDocumento() {
		return documento;
	}

	
	

}
