package servicios;
import servicios.Canasta;

public class Cliente {
    private String nombre;
    private long cedula;
    private float saldo;
    private int numeroDeCompras;
    private boolean deudor;
    private Canasta canasta;

    public Cliente() {
        this(null, 0, 0, 0, false);
    }

    public Cliente(String nombre, long cedula, float saldo, int numeroDeCompras, boolean deudor) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.saldo = saldo;
        this.numeroDeCompras = numeroDeCompras;
        this.deudor = deudor;
    }

    public void pagar(int cantidad) {
        /*Conexiòn con factura*/
    }

}