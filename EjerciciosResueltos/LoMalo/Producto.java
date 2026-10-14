// Archivo: Producto.java
// Representa un producto individual dentro de un pedido del supermercado Jumbo.
public class Producto {
    String nombre;
    int id;
    int cantidad;
    double valorUnitario; // en CLP
    String marca;
    String peso;
    String garantiaLegal;

    // Constructor para inicializar el producto
    public Producto(String nombre, int id, int cantidad, double valorUnitario, String marca, String peso, String garantiaLegal) {
        this.nombre = nombre;
        this.id = id;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.marca = marca;
        this.peso = peso;
        this.garantiaLegal = garantiaLegal;
    }
}