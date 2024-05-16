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

	// EL METODO RECIBE UN PARAMETRO DIAS (int) Y RETORNA EL PRECIO RESULTANTE AL MULTIPLICAR EL PRECIO POR DIA DEL ALOJAMIENTO
	// CON EL PARAMETRO DIAS QUE SE LE PASO.	
	public int calcularPrecio(int dias) {
		return (int)( dias * this.precio_dia);
	}
	// METODO DE CLASE QUE RECIBE UNA UBICACION(String) Y BUSCA ENTRE LAS ALOJAMIENTOS DISPONIBLES SI HAY ALGUNO EN ESTA LOCACION, 
	//SI ES AS�, RETORNA ESE OBJETO ALOJAMIENTO, SI NO, DEVUELVE NULL.
	public static ArrayList<Alojamiento> buscarAlojamientoPorUbicacion (String ubicacion) {
		ArrayList<Alojamiento> alojamientosEnUbicacion = new ArrayList<Alojamiento>();
		for (int i = 0; i < alojamientos.size(); i++)
		{
		  if (alojamientos.get(i).getLocacion().equalsIgnoreCase(ubicacion))
		  {
			  alojamientosEnUbicacion.add(alojamientos.get(i));
		  }
		}
		return alojamientosEnUbicacion;
	}
	
	// METODO DE CLASE QUE RECIBE UNA NOBRE(String) Y BUSCA ENTRE LAS ALOJAMIENTOS DISPONIBLES SI HAY ALGUNO CON ESTE NOMBRE, 
	//SI ES AS�, RETORNA ESE OBJETO ALOJAMIENTO, SI NO, DEVUELVE NULL.
	public static Alojamiento buscarAlojamientoPorNombre(String nombre) {
		for (int i = 0; i < alojamientos.size(); i++)
		{
		  if (alojamientos.get(i).getNombre().equalsIgnoreCase(nombre))
		  {
			  return alojamientos.get(i);
		  }
		}
		return null;
	}

	//GETTERS Y SETTERS