package gestorAplicacion.hangar;

import gestorAplicacion.adminVuelos.*;

public class Avion extends Aeronave {
	private final static int NUM_SILLAS_ECONOMICAS = 24;
	private final static int NUM_SILLAS_EJECUTIVAS = 12;

	// CONSTRUCTOR
	public Avion(String nombre, Aerolinea aerolinea) {
		super(nombre, aerolinea);
		this.setSILLASECONOMICAS(new Silla[NUM_SILLAS_ECONOMICAS]);
		this.setSILLASEJECUTIVAS(new Silla[NUM_SILLAS_EJECUTIVAS]);