package adminVuelos;

public class Pasajero {
	
	private static final long serialVersionUID = 1L;
	private String pasaporte;
	public String nombre;
	private Tiquete tiquete;
	private int edad;
	private String email;

	public Pasajero(String pasaporte, String nombre, Tiquete tiquete, int edad, String email) {
		this.pasaporte = pasaporte;
		this.nombre = nombre;
		this.tiquete = tiquete;
		this.edad = edad;
		this.email = email;
		tiquete.setPasajero(this);
	}

	//GETTERS Y SETTERS
