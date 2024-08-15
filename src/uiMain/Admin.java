// CLASE ADMIN PARA LA INTERACCION DEL USUARIO CON EL SISTEMA
package uiMain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import gestorAplicacion.adminVuelos.Aerolinea;
import gestorAplicacion.adminVuelos.Pasajero;
import gestorAplicacion.adminVuelos.Tiquete;
import gestorAplicacion.adminVuelos.Vuelo;
import gestorAplicacion.alojamiento.Alojamiento;
import gestorAplicacion.hangar.Avion;
import gestorAplicacion.hangar.Avioneta;
import gestorAplicacion.hangar.Silla;

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
			System.out.println("¿Que operacion desea realizar?");
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
	
	static void generarTiquete() {
		System.out.println("Quieres buscar un vuelo por:");
		System.out.println("1. Destino");
		System.out.println("2. Destino y fecha");
		System.out.println("3. Regresar");
		int opcion = sc.nextInt();
		while (opcion != 1 & opcion != 2 & opcion != 3) {
			System.out.println("Por favor ingresa una opcion valida");
			opcion = sc.nextInt();
		}

		if (opcion == 1) {
			System.out.println("Por favor ingrese un destino:");
			String destino_1 = sc.next();
			boolean hayVuelos = consultarVuelosPorDestino(destino_1);
			if (!hayVuelos) {
				return;
			}
		} else if (opcion == 2) {
			System.out.println("Por favor ingrese un destino");
			String destino_2 = sc.next();
			System.out.println("Por favor ingrese una fecha (dd-mm-aaaa):");
			String fecha_2 = sc.next();
			boolean hayVuelos = consultarVuelosPorDestinoYFecha(destino_2, fecha_2);
			if (!hayVuelos) {
				return;
			}
		} else {
			return;
		}

		System.out.println("Por favor ingrese el nombre de la aerolinea con la que desea viajar");
		String nombre_aerolinea = sc.next();
		Aerolinea aerolinea = Aerolinea.buscarAerolineaPorNombre(nombre_aerolinea); 

		while (aerolinea == null) {
			System.out.println("Por favor ingrese un nombre valido");
			nombre_aerolinea = sc.next();
			aerolinea = Aerolinea.buscarAerolineaPorNombre(nombre_aerolinea);
		}

		System.out.println("Por favor ingrese el ID del vuelo que desea comprar");
		int ID = sc.nextInt();
		Vuelo vuelo = aerolinea.buscarVueloPorID(aerolinea.getVuelos(), ID); 
		while (vuelo == null) {
			System.out.println("Por favor ingrese un ID valido");
			ID = sc.nextInt();
			vuelo = aerolinea.buscarVueloPorID(aerolinea.getVuelos(), ID);
		}

		double ID_tiquete = 100 + Math.random() * 900; // DEVUELVE UN NUMERO ALEATORIO DE 3 CIFRAS
		while (Aerolinea.BuscarTiquete((int) ID_tiquete) != null) {
			ID_tiquete = 100 + Math.random() * 900;
		}
		
		System.out.println("Que tipo de silla desea comprar?");
		Silla silla = elegirSilla(vuelo);
		if (silla == null) {
			System.out.println("Lo sentimos no se encuentran sillas disponibles con esas caracteristicas\n");
			return;
		}
		Tiquete tiquete = new Tiquete((int) ID_tiquete, vuelo.getPrecio(), vuelo);
		tiquete.setSilla(silla);
		
		System.out.println("DATOS DEL PASAJERO:");
		System.out.println("Ingrese el nombre:");
		String nombre = sc.next();
		System.out.println("Ingrese su edad:");
		int edad = sc.nextInt();
		System.out.println("Ingrese el numero de su pasaporte:");
		String pasaporte = sc.next();
		System.out.println("Ingrese un e-mail");
		String correo = sc.next();
		
		Pasajero pasajero = new Pasajero(pasaporte, nombre, tiquete, edad, correo);
		tiquete.setPasajero(pasajero);
		
		tiquete.asignarPrecio();
		System.out.println(tiquete);
		
	}
	

	static void agregarAlojamiento() {
		System.out.println("Deseas agregar un alojamiento a tu compra?");
		System.out.println("Por favor ingresa el ID del tiquete que se genero al comprar su vuelo:");
		int tiqueteID = sc.nextInt();
		Tiquete tiquete_solicitado = Aerolinea.BuscarTiquete(tiqueteID);
		
		if (tiquete_solicitado == null) { 
			System.out.println("Lo sentimos, no tenemos un tiquete identificado con ese ID");
			System.out.println();
		}else if(tiquete_solicitado.getAlojamiento() != null) {
			System.out.println("El tiquete ya posee un alojamiento, si quiere cambiarlo hagalo desde la opcion 4.\n");
			return;
		} else { 
			String destino = tiquete_solicitado.getVuelo().getDestino();
			boolean hayAlojamientos = mostrarAlojamientosPorUbicacion(destino); //ESTE METODO SE DETALLA MAS ABAJO 
			if (!hayAlojamientos) { 
				return;
			}
			System.out.println("Por favor ingresa el nombre del alojamiento que desea anadir a su compra:");
			String alojamiento = sc.next();
			Alojamiento alojamiento_solicitado = Alojamiento.buscarAlojamientoPorNombre(alojamiento);
			if (alojamiento_solicitado == null) { 
				System.out.println("Lo sentimos, no tenemos un alojamiento con ese nombre");
				System.out.println();
			}else if(!alojamiento_solicitado.getLocacion().equals(destino) ){ 
				System.out.println("Lo sentimos, no tenemos un alojamiento con ese nombre en esa locacion\n");
				return; }
			else { 
				System.out.println("Cuantos dias desea quedarse en el alojamiento?");
				int num_dias = sc.nextInt();
				tiquete_solicitado.setAlojamiento(alojamiento_solicitado);
				tiquete_solicitado.asignarPrecio(num_dias);

				System.out.println("Perfecto! el alojamiento " + alojamiento_solicitado.getNombre()
						+ " se ha agregado correctamente a su tiquete de compra.");
				System.out.println();
				System.out.println(tiquete_solicitado);
			}
		}
	}
	
	
	
	static void modificarTiquete() {
		System.out.println("Ingrese el ID del tiquete que desea modificar.");
		int ID = sc.nextInt();
		Tiquete tiquete = Aerolinea.BuscarTiquete(ID);
		if (tiquete == null) {
			System.out.println("El ID ingresado no se encuentra\n");
		} else {
			System.out.println("Que aspectos de su tiquete desea modificar?");
			System.out.println("1: Modificar alojamiento");
			System.out.println("2: Modificar Silla");

			int opcion = sc.nextInt();

			switch (opcion) {

				case 1:
					int dias = modificarAlojamiento(tiquete);
					if (dias > 0) {
						tiquete.asignarPrecio(dias);
						System.out.println(tiquete);
					}
					break;
				case 2:
					modificarSilla(tiquete);
			}
		}
	}
	
	
	private static void modificarSilla(Tiquete tiquete) {

		System.out.println("A que tipo de silla desea cambiar?");
		Silla silla = elegirSilla(tiquete.getVuelo());
		if (silla == null) {
			System.out.println("Lo sentimos no se encuentran sillas disponibles con esas caracteristicas\n");
			return;
		}
		tiquete.getSilla().setEstado(true);
		tiquete.setSilla(silla);

		System.out.println("*************************************");
		System.out.println("SU SILLA HA SIDO MODIFICADA CON EXITO");
		System.out.println("*************************************\n");
		tiquete.asignarPrecio();
		System.out.println(tiquete);

	}
	
	
	private static int modificarAlojamiento(Tiquete tiquete_solicitado) {
		if (tiquete_solicitado.getAlojamiento() == null) {
			System.out.println("Aun no tiene un alojamiento asociado a su tiquete, puede agregar uno en la opcion 3.");
			System.out.println();
			return 0;
		}
		String destino = tiquete_solicitado.getVuelo().getDestino();
		mostrarAlojamientosPorUbicacion(destino);
		System.out.println("Por favor ingresa el nombre del alojamiento al que desea cambiar");
		String alojamiento = sc.next();
		Alojamiento alojamiento_solicitado = Alojamiento.buscarAlojamientoPorNombre(alojamiento);
		if (alojamiento_solicitado == null) {
			System.out.println("Lo sentimos, no tenemos un alojamiento con ese nombre\n");
			return -1;
		}else if(!alojamiento_solicitado.getLocacion().equals(destino) ){
			System.out.println("Lo sentimos, no tenemos un alojamiento con ese nombre en esa locacion\n");
			return -1;
			
		}else {
			System.out.println("Por favor ingrese el numero de dias que se va a quedar en el alojamiento");
			int dias = sc.nextInt();
			tiquete_solicitado.setAlojamiento(alojamiento_solicitado);
			System.out.println("Perfecto! su alojamiento ha sido modificado a " + alojamiento_solicitado.getNombre()
					+ " exitosamente.");
			System.out.println();
			return dias;
		}
	}
	
	static void opcionesAdministrador() {

		int opcion;
		do {

			System.out.println("Que opcion desea realizar como administrador?");
			System.out.println("1. Listar Pasajeros.");
			System.out.println("2. Agregar Vuelo.");
			System.out.println("3. Cancelar vuelo.");
			System.out.println("4. Retirar un avion.");
			System.out.println("5. Agregar Alojamiento.");
			System.out.println("6. Eliminar Alojamiento.");
			System.out.println("7. Salir del administrador.");
			System.out.println("Por favor escoja una opcion: ");

			opcion = sc.nextInt();

			switch (opcion) {
				case 1:
					listarPasajeros();
					break;
				case 2:
					agregarNuevoVuelo();
					break;
				case 3:
					cancelarVuelos();
					break;
				case 4:
					retirarAvion();
					break;
				case 5:
					nuevoAlojamiento();
					break;
				case 6:
					retirarAlojamiento();
					break;
				case 7:
					salirDelAdministrador();
					break;
			}
		} while (opcion != 7);
	}
	
	private static void listarPasajeros() {
		ArrayList<Aerolinea> aerolineas = Aerolinea.getAerolineas();
		generadorDeTablas.mostrarTablaDeVuelosPorAerolineas(aerolineas);

		System.out.println("Ingrese el ID del vuelo: ");
		int IDBusqueda = sc.nextInt();

		ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();
		Vuelo vuelo = null;
		for (Aerolinea i : aerolineas) {
			if (i.buscarVueloPorID(i.getVuelos(), IDBusqueda) != null) {
				vuelo = i.buscarVueloPorID(i.getVuelos(), IDBusqueda);
				break;
			}
		}
		if (vuelo == null) {
			System.out.println("No tenemos vuelos con ese ID.\n");
			return;
		}
		tiquetes = vuelo.getTiquetes();
		System.out.println("LISTA DE PASAJEROS PARA EL VUELO " + IDBusqueda);

		if (tiquetes.size() == 0) {
			System.out.println("El vuelo aun no tiene pasajeros asociados \n");
		} else {
			generadorDeTablas.mostrarTablaDePasajeros(tiquetes);
		}
	}
	
	private static void agregarNuevoVuelo() {
		ArrayList<Aerolinea> aerolineas = Aerolinea.getAerolineas();
		System.out.println("AGREGAR NUEVO VUELO \n");
		generadorDeTablas.mostrarTablaDeAerolineas(aerolineas);
		System.out.println("Ingrese el nombre de la aerolinea para agregar vuelo\n");
		String nombreAerolinea = sc.next();

		ArrayList<String> list = new ArrayList<>();
		for (Aerolinea i : aerolineas) {
			list.add(i.getNombre());
		}
		boolean existe = list.contains(nombreAerolinea);

		while (existe == false) {
			System.out.println("\nESA AEROLINEA NO EXISTE");
			System.out.println("Ingrese un nombre del listado anterior\n");
			String nombreAerolinean = sc.next();
			existe = list.contains(nombreAerolinean);
		}
		System.out.println();

		System.out.println("Ingrese el ID del nuevo vuelo (3 cifras):");
		int iD = sc.nextInt();
		Aerolinea aerolinea_busqueda = Aerolinea.buscarAerolineaPorNombre(nombreAerolinea);
		while (Integer.toString(iD).length() != 3) {
			System.out.println("Por favor ingrese un ID de 3 cifras.");
			iD = sc.nextInt();
		}
		while (aerolinea_busqueda.buscarVueloPorID(aerolinea_busqueda.getVuelos(), iD) != null) {
			System.out.println("El ID que ingreso ya esta en uso, por favor ingrese uno distinto.");
			iD = sc.nextInt();
		}

		System.out.println("\nIngrese el precio:");
		int precio = sc.nextInt();
		System.out.println();

		System.out.println("Ingrese el origen:");
		String origen = sc.next();
		System.out.println();

		System.out.println("Ingrese el destino:");
		String destino = sc.next();
		System.out.println();

		System.out.println("Ingrese la distancia (KM):");
		double distancia = sc.nextDouble();
		System.out.println();

		System.out.println("Ingrese fecha de salida (DD-MM-AAAA):");
		String fechaSalida = sc.next();
		System.out.println();

		System.out.println("Ingrese hora de salida (24:00):");
		String horaSalida = sc.next();
		System.out.println();

		System.out.println("Que tipo de aeronave es?");
		System.out.println("Ingrese 1 para avion" + "\n" + "Ingrese 2 para avioneta");
		int aeronave = sc.nextInt();

		if (aeronave == 1) {
			System.out.println("Ingrese el nombre del avion:");
			String nombreAvion = sc.next();
			System.out.println();

			Avion avion = new Avion(nombreAvion, Aerolinea.buscarAerolineaPorNombre(nombreAerolinea));
			Vuelo vuelo = new Vuelo(iD, precio, origen, destino, avion, distancia, fechaSalida, horaSalida);
			System.out.println("***************************************");
			System.out.println("SU VUELO SE HA REGISTRADO CORRECTAMENTE");
			System.out.println("***************************************\n");

		} else if (aeronave == 2) {
			System.out.println("INGRESE EL NOMBRE DE LA AVIONETA:");
			String nombreAvioneta = sc.next();
			System.out.println();
			Avioneta avioneta = new Avioneta(nombreAvioneta, Aerolinea.buscarAerolineaPorNombre(nombreAerolinea));
			Vuelo vuelo = new Vuelo(iD, precio, origen, destino, avioneta, distancia, fechaSalida, horaSalida);
			System.out.println("***************************************");
			System.out.println("SU VUELO SE HA REGISTRADO CORRECTAMENTE");
			System.out.println("***************************************\n");
		} else {
			System.out.println("No manejamos ese tipo de aeronave");

		}
	}

	
}