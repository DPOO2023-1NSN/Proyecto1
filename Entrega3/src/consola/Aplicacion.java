package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import procesamiento.Hotel;

public class Aplicacion {

	//PRIMERA FASE
	private static Hotel hotel;

	public static void mostrarPrimerMenu (){
		System.out.println("Bienvenido, ingrese el número de la opción que desea ejecutar");
		System.out.println("1. Ingresar al sistema");
		System.out.println("2. Crear un nuevo usuario");
	}

	public static void ejecutarLogIn() {
		String nombreUsuario= input("nombre de usuario: ");
		String contrasenia= input("contraseña: ");
		int usuarioActual= hotel.ejecutarLogIn(nombreUsuario,contrasenia );
		
		if (usuarioActual==0){
			System.out.println("El usuario no existe o la información es incorrecta, vuelva a intentarlo");
		}
		else if (usuarioActual==1){
			ejecutarMenuAdministrador();
		}
		else if (usuarioActual==2){
			ejecutarMenuEmpleado();
		}
		else {
			ejecutarMenuHuesped();
		}
	}
	public static void ejecutarRegistro(){

		System.out.println("que tipo de usuario desea crear?");
		System.out.println("1. Administrador");
		System.out.println("2. Empleado");
		System.out.println("3. Huesped");
		int tipoUsuario= Integer.parseInt(input("Escriba el numero de la opcion: "));
		if (tipoUsuario== 1){
			String nombreUsuarioR= input("nombre de Usuario: ");
			String contraseniaR= input("contraseña: ");
			String nombreR= input("nombre del administrador: ");
			String documentoR= input("documento: ");
			hotel.registrarAdmin(nombreUsuarioR, contraseniaR, nombreR, documentoR);
		}
		else if (tipoUsuario== 2){
			String nombreUsuarioR= input("nombre de Usuario: ");
			String contraseniaR= input("contraseña: ");
			String nombreR= input("nombre del administrador: ");
			String documentoR= input("documento: ");
			String servicioR= input("servicio encargado: ");
			hotel.registrarEmpleado(nombreUsuarioR, contraseniaR, nombreR, documentoR, servicioR);;
		}
		else{ //ES HUESPED
			String nombreUsuarioR= input("nombre de Usuario: ");
			String contraseniaR= input("contraseña: ");
			String nombreR= input("nombre del administrador: ");
			String documentoR= input("documento: ");
			int edadR= Integer.parseInt(input("servicio encargado: "));
			String correoR= input("correo electrónico: ");
			String telefonoR= input("teléfono: ");
			hotel.registrarHuesped(nombreUsuarioR, contraseniaR, nombreR, documentoR, edadR, correoR, telefonoR);
		}

	}




	//TODO LO REFERENTE AL ADMIN_____-----------------------------------------------------------------------------------------------
	
public static void mostrarMenuAdministrador(){
	System.out.println("\nOpciones de la aplicación\n");
	System.out.println("1. Asignar Precio de las habitaciones");
	System.out.println("2. Cargar menus del restaurante");
	System.out.println("3. Configurar platos del menu del restaurante");
	System.out.println("4. Asignar precios del menú del restaurante");
	System.out.println("5. Crear habitacion");
	System.out.println("6. Cargar archivo de habitaciones");
	System.out.println("7. Cargar tarifas de servicios");
	System.out.println("8. Salir");
	}

//EJECUCIONES DE LAS FUNCIONES DEL ADMIN
	public static void ejecutarAdmin1() {
		int opcionTipoHab= Integer.parseInt(input("para que tipo de habitación quiere cambiar los precios? 1. Estandar, 2. Suit, 3. Suit doble "));
			int diaInicio= Integer.parseInt(input("ingrese el dia de inicio (dos dígitos) "));
			int mesInicio= Integer.parseInt(input("ingrese el mes de inicio (dos dígitos) "));
			int diaFin= Integer.parseInt(input("ingrese el dia de fin (dos dígitos) "));
			int mesfin= Integer.parseInt(input("ingrese el mes de fin (dos dígitos) "));
			int diaSemanaInicio= Integer.parseInt(input("ingrese el dia de inicio de la semana (1 para lunes, etc.) "));
			int diaSemanaFin= Integer.parseInt(input("ingrese el dia de fin de la semana (1 para lunes, etc.) "));
			int precio= Integer.parseInt(input("ingrese el precio "));
			hotel.asignarPrecioHabitaciones(opcionTipoHab, diaInicio, diaFin, mesInicio, mesfin, diaSemanaInicio, diaSemanaFin, precio);
	}
	public static void ejecutarAdmin2(){
		String rutaArchivo= input("ingrese la ruta del archivo");
		hotel.asignarMenusRestaurante(rutaArchivo);
	}
	public static void ejecutarAdmin3(){
		
	}
	public static void ejecutarAdmin4(){
		String nombrePlato= input("ingrese el nombre del plato");
		int nuevoPrecio= Integer.parseInt(input("ingrese el nuevo precio del plato"));
		hotel.cambiarPlatoRestaurante(nombrePlato, nuevoPrecio);
	}
	public static void ejecutarAdmin5(){
		int id= Integer.parseInt(input("ingrese el id de la habitación"));
		int tipo=Integer.parseInt(input("ingrese el tipo de habitación, 0. estándar, 1. Suit, 2. Suit doble"));
		int capacidadAdultos=Integer.parseInt(input("ingrese la capacidad de los adultos"));
		int capacidadNiños= Integer.parseInt(input("ingrese la capacidad de los niños"));
		Boolean balcon= Boolean.parseBoolean(input("ingrese si la habitación tiene balcón (escriba true/false)"));
		Boolean vista=Boolean.parseBoolean(input("ingrese si la habitación tiene vista (escriba true/false)"));
		Boolean cocina=Boolean.parseBoolean(input("ingrese si la habitación tiene cocina (escriba true/false)"));
	}
	public static void ejecutarAdmin6(){
		String rutaArchivo= input("ingrese la ruta del archivo");
		hotel.caragarArchivoHabitaciones(rutaArchivo);
	}
	public static void ejecutarAdmin7(){
		String rutaArchivo= input("ingrese la ruta del archivo");
		hotel.caragarArchivoServicios(rutaArchivo);
	}


	public static void ejecutarMenuAdministrador() {
		mostrarMenuAdministrador();
		int opcionAdmin= Integer.parseInt(input("seleccione el numero de la opción: "));

		if (opcionAdmin==1 ){ejecutarAdmin1(); }
		else if (opcionAdmin==2 ){ejecutarAdmin2(); }
		else if (opcionAdmin==3 ){ejecutarAdmin3(); }
		else if (opcionAdmin==4 ){ejecutarAdmin4(); }
		else if (opcionAdmin==5 ){ejecutarAdmin5(); }
		else if (opcionAdmin==6 ){ejecutarAdmin6(); }
		else if (opcionAdmin==7 ){ejecutarAdmin7();}
	}









//REFERENTE AL EMPLEADO------------------------------------


	public static void mostrarMenuEmpleado() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Reservar Habitación");
		System.out.println("2. Cancelar Reserva");
		System.out.println("3. Consultar pagos pendientes");
		System.out.println("4. Registrar Cobro");
		System.out.println("5. Registrar Check In");
		System.out.println("6. Registrar Check Out");
		System.out.println("7. Consultar Inventario");
		System.out.println("8. Consultar Habitación");
		System.out.println("9. Salir");
	}
public static void ejecutarEmpleado1(){
	;
	LocalDate fechaCheckIn= LocalDate.of(Integer.parseInt(input("ingrese el año en el que hará el check In")),
										 Integer.parseInt(input("ingrese el mes en el que hará el check In")),
										 Integer.parseInt(input("ingrese el dia en el que hará el check In")));

	LocalDate fechaCheckOut= LocalDate.of(Integer.parseInt(input("ingrese el año en el que hará el check Out")),
										 Integer.parseInt(input("ingrese el mes en el que hará el check Out")),
										 Integer.parseInt(input("ingrese el dia en el que hará el check Out")));
	
	hotel.crearGrupoYReserva(crearlistaGrupo(),fechaCheckIn, fechaCheckOut );


}
public static ArrayList<ArrayList<String>> crearlistaGrupo(){

	int numHuespedes =Integer.parseInt(input("ingrese el numero de integrantes del grupo, incluyento el huesped responsable"));
	System.out.println("A continuación se le pedirán los datos de los huespedes del grupo, empiece por el huesped responsable ");
	ArrayList<ArrayList<String>> listaHuespedes= new ArrayList<ArrayList<String>>();
	
	for (int i=0; i<numHuespedes; i++){
//String nombreUsuario, String contraseña, String nombre, String documento, int edad, String correoElectronico, String telefono
		System.out.println("Usted está creando la información del huesped #" + (i+1));
		ArrayList<String> listaUnHuesped= new ArrayList<String>();
		listaUnHuesped.add(input("ingrese el nombre de usuario: "));
		listaUnHuesped.add(input("ingrese la contraseña: "));
		listaUnHuesped.add(input("ingrese el nombre: "));
		listaUnHuesped.add(input("ingrese el número de documento: "));
		listaUnHuesped.add(input("ingrese la edad: "));
		listaUnHuesped.add(input("ingrese el correo electrónico: "));
		listaUnHuesped.add(input("ingrese el teléfono: "));

		listaHuespedes.add(listaUnHuesped);

		}
		return listaHuespedes;
}





public static void ejecutarEmpleado2(){
	
	
}
public static void ejecutarEmpleado3(){
	
}
public static void ejecutarEmpleado4(){
	
}
public static void ejecutarEmpleado5(){
	
}
public static void ejecutarEmpleado6(){
	
}
public static void ejecutarEmpleado7(){
	
}
public static void ejecutarEmpleado8(){
	
}


	public static void ejecutarMenuEmpleado() {
		mostrarMenuEmpleado();
		int opcionEmpleado= Integer.parseInt(input("seleccione el numero de la opción: "));

		if (opcionEmpleado==1 ){ejecutarEmpleado1(); }
		else if (opcionEmpleado==2 ){ejecutarEmpleado2(); }
		else if (opcionEmpleado==3 ){ejecutarEmpleado3(); }
		else if (opcionEmpleado==4 ){ejecutarEmpleado4(); }
		else if (opcionEmpleado==5 ){ejecutarEmpleado5(); }
		else if (opcionEmpleado==6 ){ejecutarEmpleado6(); }
		else if (opcionEmpleado==7 ){ejecutarEmpleado7();}
		else if (opcionEmpleado==6 ){ejecutarEmpleado8(); }

	}



//RELACIONADO A HUESPED

	public static void ejecutarMenuHuesped() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Reservar Habitación");
		System.out.println("2. Cancelar Reserva");
		System.out.println("3. Consultar pagos pendientes");
		System.out.println("4. Salir");
	}
	


	public static void main(String[]args) throws TransformerException, SAXException, IOException, ParserConfigurationException{
		hotel = new Hotel();
		mostrarPrimerMenu();
		int OpcionPrimerMenu= Integer.parseInt(input("selecione: "));
		if (OpcionPrimerMenu== 1) {ejecutarLogIn();}
		else {ejecutarRegistro();}
		
		

	}
	


	public static String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}
