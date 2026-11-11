public class Nodo {
    int dato;
    Nodo izquierdo;
    Nodo derecho;

    // Constructor para nodo hoja (sin hijos)
    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Constructor para nodo con hijos
    public Nodo(int dato, Nodo izquierdo, Nodo derecho) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }
}
