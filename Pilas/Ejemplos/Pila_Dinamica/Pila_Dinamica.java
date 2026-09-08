package Pilas.Ejemplos.Pila_Dinamica;

public class Pila_Dinamica {
    private Nodo cima;

    public Pila_Dinamica() {
        this.cima = null; // Inicialmente, la pila está vacía
    }

    public boolean estaVacia() {
        return cima == null; // Si la cima es null, significa que la pila está vacía
    }

    public void apilar(Object dato) {
        Nodo nuevoNodo = new Nodo(dato); // Crear un nuevo nodo con el dato
        nuevoNodo.setSiguiente(cima); // El siguiente del nuevo nodo apunta a la cima actual
        cima = nuevoNodo; // La cima ahora es el nuevo nodo
    }

    public Object desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía. No se puede desapilar.");
            return null;
        }
        Object dato = cima.getDato(); // Obtener el dato de la cima
        cima = cima.getSiguiente(); // La cima ahora apunta al siguiente nodo
        return dato; // Retornar el dato desapilado
    }

    public Object cima() {
        if (estaVacia()) {
            System.out.println("La pila está vacía. No hay cima.");
            return null;
        }
        return cima.getDato(); // Retornar el dato en la cima sin modificarla
    }

    // Método para mostrar los elementos de la pila
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return;
        }
        System.out.println("Elementos en la pila:");
        Nodo actual = cima; // Comenzar desde la cima
        while (actual != null) { // Recorrer hasta que no haya más nodos
            System.out.println(actual.getDato()); // Mostrar el dato del nodo actual
            actual = actual.getSiguiente(); // Mover al siguiente nodo
        }
    }

    
}
