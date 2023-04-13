package procesamiento;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modelo.Administrador;
import modelo.Empleado;
import modelo.Grupo;
import modelo.Habitacion;
import modelo.Huesped;
import modelo.Informacion;
import modelo.Reserva;
import modelo.Servicio;
import modelo.Usuario;
import modelo.Estado;

public class Hotel {
	private static ArrayList <Usuario> listaUsuarios;
	

	public Hotel () throws SAXException, IOException, ParserConfigurationException{
		Hotel.listaUsuarios= new ArrayList<Usuario>();
		listaUsuarios.add(new Usuario("Absoluto", "none", "absoluto", "none"));
	}
//LOGIN Y REGISTRO
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

//FUNCCIONES ADMIN
public static void asignarPrecioHabitaciones(int tipo, int diaInicio, int diaFin, int mesInicio, int mesfin, int diaSemanaInicio, int diaSemanaFin,
											int precio)
				 {
	//COMPLETAR-----------------------------------------------------
				}
public static void asignarMenusRestaurante( String rutaArchivo)
				 {
	//COMPLETAR---------------------------------------------------------------
				}
public static void cambiarPlatoRestaurante( String nombrePlato, int nuevoPrecio)
				 {
	//COMPLETAR---------------------------------------------------------------
				}
public static void crearHabitacion(int id, int tipo, int capacidadAdultos, int capacidadNiños, Boolean balcon, Boolean vista, Boolean cocina){
	Habitacion nuevHabitacion= new Habitacion(id, tipo, capacidadAdultos, capacidadNiños, balcon, vista, cocina);
	listaUsuarios.get(0).getinfo().addHabitacion(nuevHabitacion);
}
public static void caragarArchivoHabitaciones(String rutaArchivo){
	//COMPLETAR______________________________________________________
}
public static void caragarArchivoServicios(String rutaArchivo){
	//COMPLETAR______________________________________________________
}

//FUNCIONES EMPLEADO
//NECESARIAS PARA CREAR RESERVA



public void crearGrupoYReserva (ArrayList<ArrayList<String>> listaHuespedes, LocalDate fechaCheckIn, LocalDate fechaCheckOut){
	ArrayList<Huesped> listhuespedes= new ArrayList <Huesped>();
	for (int i=0; i< listaHuespedes.size();i++ ){
		Huesped huespedTemporal= new Huesped(listaHuespedes.get(i).get(0),
											 listaHuespedes.get(i).get(1),
											 listaHuespedes.get(i).get(2),
											 listaHuespedes.get(i).get(3),
											 Integer.parseInt(listaHuespedes.get(i).get(4)),
											 listaHuespedes.get(i).get(5),
											 listaHuespedes.get(i).get(6)
																			);
		listhuespedes.add(huespedTemporal);
		listaUsuarios.get(0).getinfo().addUsuario(huespedTemporal); //ADICIONALMENTE SE REGISTRA EN EL SISTEMA
		}
	Huesped huespedResponsable= listhuespedes.get(0);
	listhuespedes.remove(0);

	Grupo nuevoGrupo = new Grupo(listhuespedes, huespedResponsable, fechaCheckIn, fechaCheckOut);
	Reserva nuevaReserva= new Reserva(nuevoGrupo, fechaCheckIn, fechaCheckOut);
	listaUsuarios.get(0).getinfo().addReserva(nuevaReserva);

}

public void cancelarReserva(int id) {
	Estado nuevoEstado= Estado.TERMINADA;
	listaUsuarios.get(0).getinfo().cambiarEstadoReserva(id, nuevoEstado);
}
public ArrayList<Integer> consultarPagosPendientesPrecio(int id) {
	 ArrayList<Integer> listPrecios= new  ArrayList<Integer>();
	ArrayList<Reserva> listReservas= listaUsuarios.get(0).getinfo().getReservas();
	Reserva reserva= null;
	for (int i=0; i<listReservas.size(); i++) {
		if (listReservas.get(i).getId()== (id)) {
			reserva= listReservas.get(i);
		}
	}
	ArrayList<Servicio> listservicios= reserva.getGrupo().getServicios();
	
	for (int i=0; i<listservicios.size(); i++) {
	listPrecios.add(listservicios.get(i).getPrecio());
	}
	return listPrecios;
}
public ArrayList<String> consultarPagosPendientesNombre(int id) {
	 ArrayList<String> listPrecios= new  ArrayList<String>();
	ArrayList<Reserva> listReservas= listaUsuarios.get(0).getinfo().getReservas();
	Reserva reserva= null;
	for (int i=0; i<listReservas.size(); i++) {
		if (listReservas.get(i).getId()== (id)) {
			reserva= listReservas.get(i);
		}
	}
	ArrayList<Servicio> listservicios= reserva.getGrupo().getServicios();
	
	for (int i=0; i<listservicios.size(); i++) {
		if (listservicios.get(i).getPagado()== false) {
	listPrecios.add(listservicios.get(i).getNombre());
		}
	}
	return listPrecios;
	}

public void registrarCobro (int idReserva , String nombreServicio) {
	Servicio servicioActual= null;
	ArrayList<Servicio> listaServicios= listaUsuarios.get(0).getinfo().getServicios();
	for (int i=0; i<listaServicios.size(); i++) {
		if (listaServicios.get(i).getNombre().equals(nombreServicio)) {
			servicioActual= listaServicios.get(i);
		}
	}
	listaUsuarios.get(0).getinfo().agregarServicioReserva(idReserva, servicioActual);	
	}
public void checkIn (int idReserva) {
	listaUsuarios.get(0).getinfo().cambiarEstadoReserva(idReserva, (Estado.ENPROCESO));
}
public void checkOut (int idReserva) {
	listaUsuarios.get(0).getinfo().cambiarEstadoReserva(idReserva, (Estado.TERMINADA));
}
public Boolean añadirALaReserva(int idHabitacion, int idReserva) {
	ArrayList<Habitacion> listaHabitaciones= listaUsuarios.get(0).getinfo().getHabitaciones();
	for (int i=0; i<listaHabitaciones.size(); i++) {
		if (listaHabitaciones.get(i).getId()==idHabitacion) {
			Habitacion habitacion= listaHabitaciones.get(i);
			if (habitacion.getReservada()==false) {
				ArrayList<Reserva> listaReservas= listaUsuarios.get(0).getinfo().getReservas();
				for (int j=0; j<listaReservas.size(); j++) {
					if (listaReservas.get(i).getId()== idReserva) {
						listaReservas.get(i).agregarHabitacion(habitacion);
					}
				}
				return true;}	
		}
	}
	return false;
}
}
