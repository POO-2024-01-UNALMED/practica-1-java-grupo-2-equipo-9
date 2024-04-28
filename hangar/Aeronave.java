package gestorAplicacion.hangar;
import gestorAplicacion.adminVuelos.*;
import java.io.Serializable;
public abstract class Aeronave implements Serializable{

	private static final long serialVersionUID = 1L;
	// ATRIBUTOS
	protected final  int GASTO_GASOLINA = 120;
	private String nombre;
	private Aerolinea aerolinea;
	private boolean descompuesto;
	private Silla[] SILLAS_ECONOMICAS;
	private Silla[] SILLAS_EJECUTIVAS;

	// CONTRUCTOR
	protected Aeronave(String nombre, Aerolinea aerolinea) {
		this.nombre = nombre;
		this.aerolinea = aerolinea;
	}

	// GET AND SET
	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Silla[] getSILLASECONOMICAS() {
		return SILLAS_ECONOMICAS;
	}

	public void setSILLASECONOMICAS(Silla[] sILLAS_ECONOMICAS) {
		SILLAS_ECONOMICAS = sILLAS_ECONOMICAS;
	}

	public Silla[] getSILLASEJECUTIVAS() {
		return SILLAS_EJECUTIVAS;
	}

	public void setSILLASEJECUTIVAS(Silla[] sILLAS_EJECUTIVAS) {
		SILLAS_EJECUTIVAS = sILLAS_EJECUTIVAS;
	}

	public int getGastoGasolina() {
		return GASTO_GASOLINA;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}