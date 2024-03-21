import java.util.ArrayList;

public class Canasta {
    private int id;
    private Cliente cliente;
    private Producto producto;
    private ArrayList<Canasta> lista = new ArrayList<>();

    public Canasta() {
        this(0, null, null);
    }

    public Canasta(int id, Cliente cliente, Producto producto) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
    }

    public void agregarProducto(Producto producto) {
      /*Retornar lista de productos 
      con sus numeros para ver cual quiere agregar*/
      Canasta.lista.add(producto);
    }

    public String eliminarProducto(Producto producto) {
        /*Retornar lista de productos de 
        la canasta para ver cual quiere eliminar*/
      
        if (lista.size() == 0) {
            return "No ha agregado ningún producto a la canasta";
        }
        else {
            for (int i = 0; i <= lista.size(); i++) {
                if (lista.get(i).equals(producto)) {
                  lista.remove(i);
                }
            }
        }
      return "Producto eliminado";
    }
}