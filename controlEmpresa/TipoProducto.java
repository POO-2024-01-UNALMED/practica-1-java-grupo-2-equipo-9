public enum TipoProducto {
  FRUTASYVERDURAS(5000), LACTEOSHUEVOSYREFRIGERADOS(1250), DESPENSA(8547), CARNES(7761), ASEO(3000), CONGELADOS(3224),
  BEBIDAS(12312), SNACKS(21321);

  private float precioProducto;

  private TipoProducto() {
    this(0);
  }

  private TipoProducto(float precioProducto) {
    this.precioProducto = precioProducto;
  }

  public float getPrecioProducto() {
    return precioProducto;
  }

}