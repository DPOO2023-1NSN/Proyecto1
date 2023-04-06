package procesamiento;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modelo.Administrador;
import modelo.Empleado;
import modelo.Huesped;
import modelo.Usuario;

public class Hotel {
	private ArrayList <Usuario> listaUsuarios;
	

	public Hotel () throws SAXException, IOException, ParserConfigurationException{
		this.listaUsuarios= new ArrayList<Usuario>();
		listaUsuarios.add(new Usuario("Absoluto", "none", "absoluto", "none"));
	}

	public int ejecutarLogIn (String nombreUsuario, String contrasenia){
		 Usuario usuarioActual= (listaUsuarios.get(0).getinfo().getUsuario(nombreUsuario, contrasenia));
		 if (usuarioActual== null) {
			return 0;
		 	}
		else if (usuarioActual instanceof Administrador){
			return 1;
		}
		else if (usuarioActual instanceof Empleado){
			return 2;
		}
		else {
			return 3; //ES HUESPED
		}

	}
	public void registrarAdmin(String nombreUsuario, String contraseña, String nombre, String documento){
		Administrador admin= new Administrador(nombreUsuario, contraseña, nombre, documento);
		listaUsuarios.get(0).getinfo().addUsuario(admin);
	}
	public void registrarEmpleado(String nombreUsuario, String contraseña, String nombre, String documento, String servicioEncargado){
		Empleado empleado= new Empleado (nombreUsuario, contraseña, nombre, documento, servicioEncargado);
		listaUsuarios.get(0).getinfo().addUsuario(empleado);
	}
	public void registrarHuesped(String nombreUsuario, String contraseña, String nombre, String documento, int edad, String correo, String telefono ){
		Huesped huesped= new Huesped (nombreUsuario, contraseña, nombre, documento, edad, correo, telefono );
		listaUsuarios.get(0).getinfo().addUsuario(huesped);
	}





}
