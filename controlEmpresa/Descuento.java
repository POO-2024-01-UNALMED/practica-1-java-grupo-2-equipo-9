import java.util.Date;

public class Descuento {
  private Producto producto;
  private Date fechaDeInicio;
  private Date fechaFinal;
  private float porcentajeDeDescuento;

  public Descuento() {
    this(null, null, null, 0);
  }

  public Descuento(Producto producto, Date fechaDeInicio, Date fechaFinal, float porcentajeDeDescuento) {
    this.producto = producto;
    this.fechaDeInicio = fechaDeInicio;
    this.fechaFinal = fechaFinal;
    this.porcentajeDeDescuento = porcentajeDeDescuento;
  }

  public void definirDescuento () {
  } 

//Getters y Setters----------------------------------------
  public Producto getProducto() {
    return producto;
  }
  public Date getFechaDeInicio() {
    return fechaDeInicio;
  }

  public Date getFechaFinal() {
    return fechaFinal;
  }

  public float porcentajeDeDescuento() {
    return porcentajeDeDescuento;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }
  
  public void setFechaDeInicio(Date fechaDeInicio) {
    this.fechaDeInicio = fechaDeInicio;
  }

  public void setFechaFinal(Date fechaFinal) {
    this.fechaFinal = fechaFinal;
  }

  public void setPorcentajeDeDescuentos(float porcentajeDeDescuentos) {
    this.porcentajeDeDescuento = porcentajeDeDescuentos;
  }
}