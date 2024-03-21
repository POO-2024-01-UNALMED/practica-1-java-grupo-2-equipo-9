import java.util.Date;

public class Factura {
  private int idFactura;
  private Cliente cliente;
  private Canasta canasta;
  private Date fecha;
  private float total;
  private int descuento;

  public Factura() {
    this(0, null, null, null, 0, 0);
  }

  public Factura(int idFactura, Cliente cliente, Canasta canasta, Date fecha, float total, int descuento) {
    this.idFactura = idFactura;
    this.cliente = cliente;
    this.canasta = canasta;
    this.fecha = fecha;
    this.total = total;
    this.descuento = descuento;
  }
  
//Getters y Setters----------------------------------------
  public int getIdFactura() {
	return idFactura;
  }
  public void setIdFactura(int idFactura) {
  	this.idFactura = idFactura;
  }
  public Cliente getCliente() {
  	return cliente;
  }
  public void setCliente(Cliente cliente) {
  	this.cliente = cliente;
  }
  public Canasta getCanasta() {
  	return canasta;
  }
  public void setCanasta(Canasta canasta) {
  	this.canasta = canasta;
  }
  public Date getFecha() {
  	return fecha;
  }
  public void setFecha(Date fecha) {
  	this.fecha = fecha;
  }
  public float getTotal() {
  	return total;
  }
  public void setTotal(float total) {
  	this.total = total;
  }
  public int getDescuento() {
  	return descuento;
  }
  public void setDescuento(int descuento) {
  	this.descuento = descuento;
  }
}