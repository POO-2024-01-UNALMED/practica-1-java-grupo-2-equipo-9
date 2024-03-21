public class Proveedor {
  private String nombre;
  private float precioCompra;
  private Producto producto;

  public Proveedor() {
    this(null, 0, null);
  }

  public Proveedor(String nombre, float precioCompra, Producto producto) {
    this.nombre = nombre;
    this.precioCompra = precioCompra;
    this.producto = producto;
  }
//Getters y Setters----------------------------------------
  public String getNombre() {
  	return nombre;
  }
  
  public void setNombre(String nombre) {
  	this.nombre = nombre;
  }
  
  public float getPrecioCompra() {
  	return precioCompra;
  }
  
  public void setPrecioCompra(float precioCompra) {
  	this.precioCompra = precioCompra;
  }
  
  public Producto getProducto() {
  	return producto;
  }
  
  public void setProducto(Producto producto) {
  	this.producto = producto;
  }
}