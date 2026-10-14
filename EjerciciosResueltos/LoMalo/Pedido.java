// Archivo: Pedido.java
// Representa un pedido realizado en línea por un cliente.
public class Pedido {
    String nombreCliente;
    String direccion;
    String metodoPago;
    NodoProducto cabezaProductos; // Lista enlazada de productos del pedido
    boolean esPrime;            // True si es cliente Jumbo Prime
    boolean cancelado;          // True si el pedido fue cancelado antes de procesarse
    Pedido siguiente;           // Puntero para la cola dinámica

    // Constructor del pedido
    public Pedido(String nombreCliente, String direccion, String metodoPago, boolean esPrime) {
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.metodoPago = metodoPago;
        this.cabezaProductos = null;
        this.esPrime = esPrime;
        this.cancelado = false; // Por defecto el pedido está activo
        this.siguiente = null;
    }

    // Método para agregar un producto a la lista enlazada del pedido
    public void agregarProducto(Producto p) {
        NodoProducto nuevo = new NodoProducto(p);
        if (cabezaProductos == null) {
            cabezaProductos = nuevo;
        } else {
            NodoProducto actual = cabezaProductos;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
}