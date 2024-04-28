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
	//SI ES ASI, RETORNA ESE OBJETO AEROLINEA, SI NO, DEVUELVE NULL.
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

	//BUSCAR VUELO POR...
	
	// RECIBE UNA LISTA DE VUELOS (ARRAYLIST<VUELO>) Y UN ID (INT) Y SE ENCARGA DE RETORNAR EL OBJETO VUELO QUE TENGA EL ID QUE PASAMOS 
	// COMO PARAMETRO, SI NO LO ENCUENTRA EN ESA LISTA DE VUELOS RETORNA NULL.
	public Vuelo buscarVueloPorID (ArrayList<Vuelo> vuelos, int ID)
	{
		for (int i = 0; i < vuelos.size(); i++)
		{
		  if (vuelos.get(i).getID() == ID )
		  {
			  return vuelos.get(i);
		  }
		}
		return null;
	}
	
	// RECIBE UNA LISTA DE VUELOS (ARRAYLIST<VUELO>) Y UN NOMBRE_AERONAVE(STRING) Y SE ENCARGA DE RETORNAR EL OBJETO VUELO QUE TENGA 
	// ASOCIADA LA AERONAVE QUE TIENE EL NOMBRE QUE PASAMOS COMO PARAMETRO, SI NO LO ENCUENTRA EN ESA LISTA DE VUELOS RETORNA NULL.
	public Vuelo buscarVueloPorAeronave (ArrayList<Vuelo> vuelos, String nombre_Aeronave)
	{
		for (int i = 0; i < vuelos.size(); i++)
		{
		  if (vuelos.get(i).getAeronave().getNombre().equals(nombre_Aeronave) )
		  {
			  return vuelos.get(i);
		  }
		}
		return null;
	}
	
	// RECIBE UNA LISTA DE VUELOS (ARRAYLIST<VUELO>) Y UN DESTINO(STRING) Y SE ENCARGA DE RETORNAR UNA LISTA DE VUELOS, 
	// CON TODOS LOS VUELOS QUE TENGAN ASOCIADO EL DESTINO QUE PASAMOS COMO PARAMETRO.
	public ArrayList<Vuelo> buscarVueloPorDestino (ArrayList<Vuelo> vuelos, String destino)
	{
		ArrayList<Vuelo> vuelosPorDestino = new ArrayList<Vuelo>();
		for (int i = 0; i < vuelos.size(); i++)
		{
		  if (vuelos.get(i).getDestino().equalsIgnoreCase(destino)) // cambio del equals
		  {
			  vuelosPorDestino.add(vuelos.get(i));
		  }
		}
		return vuelosPorDestino;
	}

	// RECIBE UNA LISTA DE VUELOS (ARRAYLIST<VUELO> ) Y UNA FECHA (STRING) Y SE ENCARGA DE RETORNAR UNA LISTA DE VUELOS, 
	// CON TODOS LOS VUELOS QUE TENGAN ASOCIADA LA FECHA QUE PASAMOS COMO PARAMETRO.
	public ArrayList<Vuelo> buscarVueloPorFecha (ArrayList<Vuelo> vuelos, String fecha)
	{
		ArrayList<Vuelo> vuelosPorFecha = new ArrayList<Vuelo>();
		for (int i = 0; i < vuelos.size(); i++)
		{
		  if (vuelos.get(i).getFecha_de_salida().equals(fecha))
		  {
			  vuelosPorFecha.add(vuelos.get(i));
		  }
		}
		return vuelosPorFecha;
	}

	//VUELOS DISPONIBLES