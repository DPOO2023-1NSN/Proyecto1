package modelo;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Usuario {
	private String nombreUsuario;
	private String contraseña;
	private String nombre;
	private String documento;
	private static Informacion informacion;
	
	public Usuario(String nombreUsuario, String contraseña, String nombre, String documento) throws SAXException, IOException, ParserConfigurationException {
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.documento = documento;
		this.informacion= new Informacion();
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
	public Informacion getinfo() {
		return informacion;
	}

	
	

}
