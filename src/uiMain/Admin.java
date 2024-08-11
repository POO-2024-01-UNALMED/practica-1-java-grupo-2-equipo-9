// CLASE ADMIN PARA LA INTERACCION DEL USUARIO CON EL SISTEMA
package uiMain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import gestorAplicacion.adminVuelos.Aerolinea;

public class Admin {
	static Scanner sc = new Scanner(System.in);
	static GeneradorDeTablas generadorDeTablas = new TablasConsola();
	//EL APUNTADOR DEBE SER DEL TIPO DE LA INTERFAZ, POR SI EN ALGUN MOMENTO HACEMOS OTRA CLASE QUE IMPLEMENTE LA INTERFACE
	// Y QUERAMOS GENERAR LAS TABLAS EN OTRO FORMATO.

	public static void main(String[] args) {

		Deserializador.deserializar();

//		MENU PRINCIPAL
		int opcion;
		do {
			System.out.println("---- SISTEMA DE RESERVAS DE VUELO ---");
			System.out.println("Que operacion desea realizar?");
			System.out.println("1. Ver todos los vuelos disponibles por Aerolinea");
			System.out.println("2. Comprar tiquete para un vuelo por destino y fecha");
			System.out.println("3. Agregar alojamiento en el destino del vuelo");
			System.out.println("4. Modificar tiquete comprado");
			System.out.println("5. Ver opciones de administrador");
			System.out.println("6. Terminar");
			System.out.println("Por favor escoja una opcion: ");
			opcion = sc.nextInt();

			switch (opcion) {
				case 1:
					;
					mostrarVuelosPorAerolineas();
					break;
				case 2:
					generarTiquete();
					break;
				case 3:
					agregarAlojamiento();
					break;
				case 4:
					modificarTiquete();
					break;
				case 5:
					opcionesAdministrador();
					break;
				case 6:
					salirDelSistema();

					break;
			}
		} while (opcion != 6);
	}
	static void mostrarVuelosPorAerolineas() {
		ArrayList<Aerolinea> aerolineasDisponibles = Aerolinea.getAerolineas();
		generadorDeTablas.mostrarTablaDeVuelosDisponiblesPorAerolineas(aerolineasDisponibles);
	}
}
