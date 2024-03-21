package usuario;

public class Cliente {
    private String nombre;
    private long cedula;
    private float saldo;
    private int numeroDeCompras;
    private boolean deudor;
    private Canasta canasta;

    public Cliente() {
        this(null, 0, 0, 0, false, null);
    }

    public Cliente(String nombre, long cedula, float saldo, int numeroDeCompras, boolean deudor, Canasta canasta) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.saldo = saldo;
        this.numeroDeCompras = numeroDeCompras;
        this.deudor = deudor;
        this.canasta = canasta;
    }

    public void pagar(int cantidad) {
        /*Conexiòn con factura*/
    }


//Getters y Setters----------------------------------------
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getNumeroDeCompras() {
		return numeroDeCompras;
	}

	public void setNumeroDeCompras(int numeroDeCompras) {
		this.numeroDeCompras = numeroDeCompras;
	}

	public boolean isDeudor() {
		return deudor;
	}

	public void setDeudor(boolean deudor) {
		this.deudor = deudor;
	}

	public Canasta getCanasta() {
		return canasta;
	}

	public void setCanasta(Canasta canasta) {
		this.canasta = canasta;
	}
}