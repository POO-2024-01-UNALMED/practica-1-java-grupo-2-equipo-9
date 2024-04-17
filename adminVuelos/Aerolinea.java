package adminVuelos;

//ALMACENA LA INFORMACION DE TODAS LAS AEROLINEAS CREADAS, ADEMAS DE LOS VUELOS Y AERONAVES ASOCIADOS A CADA UNA DE ELLAS 
//CON LOS METODOS NECESARIOS PARA ACCEDER A ESTA INFORMACION A TRAVES DE DISTINTOS PARAMETROS.
public class Aerolinea implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS
	private String nombre;
	private ArrayList<Aeronave> aeronaves = new ArrayList<Aeronave>();
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	private static ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();

	//CONSTRUCTOR
	public Aerolinea(String nombre) {
		this.nombre = nombre;
		aerolineas.add(this);
	}

	@Override
	public String toString() {
		return this.nombre;
	}

	//BUSCAR AEROLINEA
	
	// METODO DE CLASE QUE RECIBE UN NOMBRE DE AEROLINEA Y BUSCA ENTRE LAS AEROLINEAS DISPONIBLES SI HAY ALGUNA CON ESTE NOMBRE, 
	//SI ES AS�, RETORNA ESE OBJETO AEROLINEA, SI NO, DEVUELVE NULL.
	public static Aerolinea buscarAerolineaPorNombre(String nombre2)
	{
		Aerolinea retorno = null;
		for (int i = 0; i < Aerolinea.getAerolineas().size(); i++)
		{
			if( Aerolinea.getAerolineas().get(i).getNombre().equalsIgnoreCase(nombre2))
			{
				// SI ENCUENTRA UNA AEROLINEA CUYO NOMBRE COINCIDA CON EL PARAMETRO PASADO, IGNORANDO MINUSCULAS Y MAYUSCULAS,
				// RETORNA ESA AEROLINEA.
				retorno=  Aerolinea.getAerolineas().get(i);
			}
		}
		return retorno;
	}
