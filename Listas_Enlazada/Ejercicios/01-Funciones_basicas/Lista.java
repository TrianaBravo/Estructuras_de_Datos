
//Ejercicio 1: Crear funciones: Eliminar en cualquier posición, obtener 
// el elemento en cualquier posición, insertar en cualquier posición,
// invertir la lista
public class Lista {
    private Nodo cabeza; // referencia al primer nodo de la lista
    private int tamanio; // variable para almacenar el tamaño de la lista

    // Constructor para inicializar la lista vacía
    public Lista() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    // Método para verificar si la lista está vacía
    public boolean esVacia() {
        return cabeza == null;
    }

    // Método para obtener el tamaño de la lista
    public int tamanio() {
        return tamanio;
    }

    // Método para insertar un elemento al inicio de la lista
    public void insertarAlInicio(Object obj) {
        Nodo nuevoNodo = new Nodo(obj); // Crear un nuevo nodo con el objeto
        if (esVacia()) { // Si la lista está vacía, el nuevo nodo será la cabeza
            cabeza = nuevoNodo;
        } else { // Si no está vacía, enlazar el nuevo nodo al inicio
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        }
        tamanio++; // Incrementar el tamaño de la lista
    }

    // Método para insertar un elemento al final de la lista
    public void insertarAlFinal(Object obj) {
        Nodo nuevoNodo = new Nodo(obj); // Crear un nuevo nodo con el objeto
        if (esVacia()) { // Si la lista está vacía, el nuevo nodo será la cabeza
            cabeza = nuevoNodo;
        } else { // Si no está vacía, recorrer hasta el último nodo y enlazarlo
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamanio++; // Incrementar el tamaño de la lista
    }

// ** Insertar en cualquier posición **
    public void insertarEnPosicion(Object obj, int posicion) {
        // Validar la posición
        if (posicion < 0 || posicion > tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        // Insertar al inicio o al final según la posición
        if (posicion == 0) {
            insertarAlInicio(obj);
        } else if (posicion == tamanio) {
            insertarAlFinal(obj);
        } else {
            // Insertar en una posición intermedia
            Nodo nuevoNodo = new Nodo(obj); // Crear un nuevo nodo con el objeto
            Nodo actual = cabeza;// Empezar desde la cabeza
            for (int i = 0; i < posicion - 1; i++) {// Recorrer hasta el nodo anterior a la posición deseada
                actual = actual.getSiguiente(); // Mover al siguiente nodo
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());// Enlazar el nuevo nodo al siguiente nodo
            actual.setSiguiente(nuevoNodo);// Enlazar el nodo anterior al nuevo nodo
            tamanio++;
        }
    }

// Eliminar en cualquier posición
    public void eliminarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            cabeza = cabeza.getSiguiente(); // Mover la cabeza al siguiente nodo
        } else {
            Nodo actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente(); // Mover al siguiente nodo
            }
            actual.setSiguiente(actual.getSiguiente().getSiguiente()); // Saltar el nodo en la posición deseada
        }
        tamanio--;
    }

// funcion que elimina el dato del medio
    public void eliminarDelMedio() {
        if (esVacia()) {
            System.out.println("La lista está vacía. No se puede eliminar el elemento del medio.");
            return;
        }

        int posicionDelMedio = tamanio / 2; // Calcular la posición del medio
        eliminarEnPosicion(posicionDelMedio); // Llamar a la función para eliminar en esa posición
    }

// Obtener el elemento en cualquier posición
    public Object obtenerEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        Nodo actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

// Invertir la lista
    public void invertir() {
        Nodo anterior = null; // Nodo para almacenar el nodo anterior
        Nodo actual = cabeza; // Nodo para recorrer la lista
        Nodo siguiente = null;// Nodo para almacenar el siguiente nodo
        while (actual != null) { // Mientras no se llegue al final de la lista
            siguiente = actual.getSiguiente(); // Guardar el siguiente nodo
            actual.setSiguiente(anterior); // Invertir el enlace
            anterior = actual; // Mover anterior a actual
            actual = siguiente; // Mover actual al siguiente nodo
        }
        cabeza = anterior; // La nueva cabeza es el último nodo visitado
    }

    //mostrar lista
    public void mostrarLista() {
        Nodo actual = cabeza; // Empezar desde la cabeza
        while (actual != null) { // Mientras no se llegue al final de la lista
            System.out.print("|"+ actual.getDato() +"|" +" -> "); // Imprimir el dato del nodo actual
            actual = actual.getSiguiente(); // Mover al siguiente nodo
        }
        System.out.println("null"); // Indicar el final de la lista
    }
}
