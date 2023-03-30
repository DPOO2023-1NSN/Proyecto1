package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Usuario;
import procesamiento.Hotel;

public class Aplicacion {
	private Hotel hotel;

	public void mostrarMenuAdministrador() {
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

	public void mostrarMenuHuesped() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Reservar Habitación");
		System.out.println("2. Cancelar Reserva");
		System.out.println("3. Consultar pagos pendientes");
		System.out.println("4. Salir");
	}
	
	public void mostrarMenuEmpleado() {
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
	

	public void ejecutarMenuAdministrador()
	{
		System.out.println("Estadísticas sobre los Juegos Olímpicos\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenuAdministrador();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarCargarAtletas();
				else if (opcion_seleccionada == 2 && calculadora != null)
					ejecutarAtletasPorAnio();
				else if (opcion_seleccionada == 3 && calculadora != null)
					ejecutarMedallasEnRango();
				else if (opcion_seleccionada == 4 && calculadora != null)
					ejecutarAtletasPorPais();
				else if (opcion_seleccionada == 5 && calculadora != null)
					ejecutarPaisConMasMedallistas();
				else if (opcion_seleccionada == 6 && calculadora != null)
					ejecutarMedallistasPorEvento();
				else if (opcion_seleccionada == 7 && calculadora != null)
					ejecutarAtletasConMasMedallasQue();
				else if (opcion_seleccionada == 8)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (calculadora == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	public void ejecutarMenuEmpleado()
	{
		System.out.println("Estadísticas sobre los Juegos Olímpicos\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenuAdministrador();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					//ejecutarCargarAtletas();
				else if (opcion_seleccionada == 2 && calculadora != null)
					//ejecutarAtletasPorAnio();
				else if (opcion_seleccionada == 3 && calculadora != null)
					//ejecutarMedallasEnRango();
				else if (opcion_seleccionada == 4)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (calculadora == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	public String input(String mensaje) {
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
