package servicios;
import java.util.Date;
import servicios.TipoProducto;


public class Producto {
    private TipoProducto tipoProducto;
    private float precioVenta;
    private int codigo;
    private Date fechaVencimiento;

    public Producto() {
        this(null, 0, 0, null);
    }

    public Producto(TipoProducto tipoProducto, float precioVenta, int codigo, Date fechaVencimiento) {
        this.tipoProducto = tipoProducto;
        this.precioVenta = precioVenta;
        this.codigo = codigo;
        this.fechaVencimiento = fechaVencimiento;
    }

}