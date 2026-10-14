public class Pila {
    private Nodo cima;
    private int tamaño;
    private String nombre;

    public Pila(String nombre) {
        this.cima = null;
        this.tamaño = 0;
        this.nombre = nombre;
    }

    public boolean vacio() {
        return cima == null;
    }

    public void apilar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        tamaño++;
    }
    
    public int desapilar() {
        if (vacio()) {
            throw new IllegalStateException("La pila " + nombre + " está vacía");
        }
        int dato = cima.getDato();
        cima = cima.getSiguiente();
        tamaño--;
        return dato;
    }

    public int getTamaño() {
        return tamaño;
    }

    //nombre de la pila
    public String getNombre() {
        return nombre;
    }
    //mostrar
    public void mostrar() {
        if (vacio()) {
            System.out.println("La pila " + nombre + " está vacía");
            return;
        }
        Nodo actual = cima;
        System.out.print("Pila " + nombre + ": ");
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}
