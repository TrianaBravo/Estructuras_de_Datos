
/**
 * Lista enlazada simple genérica.
 * Operaciones: insertar, eliminar, buscar, recorrer.
 */


public class lista_simple {
    private Nodo cabeza; // Primer nodo de la lista
    private int Tamanio; // Tamaño de la lista

    // Constructor
    public lista_simple() {
        this.cabeza = null;
        this.Tamanio = 0;
    }

    // ¿La lista está vacía? funcion que retorna true si la lista está vacía, false
    // en caso contrario
    public boolean esVacia() {
        return cabeza == null;
    }

    // Número de elementos
    public int tamanio() {
        return Tamanio;
    }

// --- INSERCIÓN ---

    /*Inserta al inicio de la lista— */
    public void insertarAlInicio(Object obj) {
        Nodo nuevoNodo = new Nodo(obj); // Crear un nuevo nodo con el objeto
        if (esVacia()) { // Si la lista está vacía, el nuevo nodo será la cabeza
            cabeza = nuevoNodo;
        } else { // Si no está vacía, enlazar el nuevo nodo al inicio
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        }
        Tamanio++; // Incrementar el tamaño de la lista
    }
    
    /** Inserta al final de la lista  */
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
        Tamanio++; // Incrementar el tamaño de la lista
    }

    // --- ELIMINACIÓN ---
    /** Elimina el primer nodo de la lista */
    public void eliminarAlInicio() {
        if (!esVacia()) { // Si la lista no está vacía
            cabeza = cabeza.getSiguiente(); // La cabeza apunta al siguiente nodo
            Tamanio--; // Decrementar el tamaño de la lista
        }
    }

    /** Elimina el último nodo de la lista */
    public void eliminarAlFinal() {
        if (!esVacia()) { // Si la lista no está vacía
            if (cabeza.getSiguiente() == null) { // Si solo hay un nodo
                cabeza = null; // La lista queda vacía
            } else { // Si hay más de un nodo, recorrer hasta el penúltimo
                Nodo actual = cabeza;
                while (actual.getSiguiente().getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(null); // El penúltimo nodo apunta a null
            }
            Tamanio--; // Decrementar el tamaño de la lista
        }
    }

    // --- RECORRIDO ---
    /** Recorre la lista e imprime los datos de cada nodo */
    public void recorrer() {
        Nodo actual = cabeza; // Comenzar desde la cabeza
        while (actual != null) { // Mientras no se llegue al final de la lista
            System.out.print(actual.getDato() + " -> "); // Imprimir el dato del nodo
            actual = actual.getSiguiente(); // Avanzar al siguiente nodo
        }
        System.out.println("null"); // Indicar el final de la lista
    }


    

    
}
