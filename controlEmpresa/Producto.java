import java.util.Date;

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

//Getters y Setters----------------------------------------
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
}