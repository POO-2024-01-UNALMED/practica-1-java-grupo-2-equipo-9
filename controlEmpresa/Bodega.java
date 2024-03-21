public class Bodega {
  private Producto producto;
  private int stock;
  private Proveedor proveedor;

  public Bodega() {
    this(null, 0, null);
  }

  public Bodega(Producto producto, int stock, Proveedor proveedor) {
    this.producto = producto;
    this.stock = stock;
    this.proveedor = proveedor;
  }

  public void agregarStock() {
    /*Se hace un pedido al proveedor*/
  }

  public void eliminarStock() {
    /*Cuando un cliente ingresa un producto a la canasta*/
  }

  //Getters y Setters----------------------------------------
  public Producto getProducto() {
  	return producto;
  }
  
  public void setProducto(Producto producto) {
  	this.producto = producto;
  }
  
  public int getStock() {
  	return stock;
  }
  
  public void setStock(int stock) {
  	this.stock = stock;
  }
  
  public Proveedor getProveedor() {
  	return proveedor;
  }
  
  public void setProveedor(Proveedor proveedor) {
  	this.proveedor = proveedor;
  }
  
    
}