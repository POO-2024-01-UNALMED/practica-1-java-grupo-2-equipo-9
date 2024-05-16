package gestorAplicacion.alojamiento;
import java.io.Serializable;
import java.util.ArrayList;

// LA CLASE ALOJAMIENTO POSEE LA INFORMACION DE TODOS LOS ALOJAMIENTOS CREADOS, CON LOS ATRIBUTOS NOMBRE, LOCACION, PRECIO POR DIA Y
// NUMERO DE ESTRELLAS.
public class Alojamiento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String locacion;
	private long precio_dia;
	private int estrellas;
	private static ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();

	//CONSTRUCTORES
	public Alojamiento(String nombre, String locacion, long precio_dia, int estrellas) {
		this.nombre = nombre;
		this.locacion = locacion;
		this.precio_dia = precio_dia;
		this.estrellas = estrellas;
		alojamientos.add(this);
	}

	// EL METODO RECIBE UN PARAMETRO DIAS (int) Y RETORNA EL PRECIO RESULTANTE AL MULTIPLICAR EL PRECIO POR DIA DEL ALOJAMIENTO
	// CON EL PARAMETRO DIAS QUE SE LE PASO.	
	public int calcularPrecio(int dias) {
		return (int)( dias * this.precio_dia);
	}