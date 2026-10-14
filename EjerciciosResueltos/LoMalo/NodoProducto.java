public class NodoProducto {
    Producto producto;
    NodoProducto siguiente;

    // Constructor para inicializar el nodo con un producto
    public NodoProducto(Producto producto) {
        this.producto = producto;
        this.siguiente = null; // Inicialmente, el siguiente nodo es nulo
    }
}