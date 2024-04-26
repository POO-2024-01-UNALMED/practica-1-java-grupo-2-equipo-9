package adminVuelos;

public class Tiquete {
	//ATRIBUTOS
		private static final long serialVersionUID = 1L;
		private int id;
		private int precio;
		private Vuelo vuelo;
		private Silla silla;
		private Pasajero pasajero;
		private Alojamiento alojamiento;

		//CONSTRUCTORES

		public Tiquete(int id, int precio, Vuelo vuelo) {
			this.id = id;
			this.precio = precio;
			this.vuelo = vuelo;
			vuelo.getTiquetes().add(this);
		}

		public Tiquete(int id, int precio, Vuelo vuelo, Silla silla, Pasajero pasajero, Alojamiento alojamiento) {
			this.id = id;
			this.precio = precio;
			this.vuelo = vuelo;
			this.silla = silla;
			this.pasajero = pasajero;
			this.alojamiento = alojamiento;
			vuelo.getTiquetes().add(this);
		}


}
