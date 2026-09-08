public class lista_doble {
    private NodoDoble cabeza; // referencia al primer nodo de la lista
    private NodoDoble cola; // referencia al último nodo de la lista
    private int Tamanio; // variable para almacenar el tamaño de la lista

    // Constructor para inicializar la lista vacía
    public lista_doble() {
        this.cabeza = null;
        this.cola = null;
        this.Tamanio = 0; // Inicialmente, el tamaño de la lista es 0
    }

    // Método para verificar si la lista está vacía
    public boolean esVacia() {
        return cabeza == null; // Retorna true si la cabeza es nula, indicando que la lista está vacía
    }

    // Método para obtener el tamaño de la lista
    public int tamanio() {
        return Tamanio; // Retorna el tamaño actual de la lista
    }

    // --- INSERCIÓN ---
    public void insertarAlInicio(Object dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato); // Crear un nuevo nodo con el dato proporcionado
        if (esVacia()) { // Si la lista está vacía
            cabeza = nuevoNodo; // El nuevo nodo se convierte en la cabeza
            cola = nuevoNodo; // El nuevo nodo también se convierte en la cola
        } else { // Si la lista no está vacía
            nuevoNodo.setSiguiente(cabeza); // El siguiente del nuevo nodo apunta a la cabeza actual
            cabeza.setAnterior(nuevoNodo); // La cabeza actual apunta al nuevo nodo como anterior
            cabeza = nuevoNodo; // Actualizar la cabeza para que sea el nuevo nodo
        }
        Tamanio++; // Incrementar el tamaño de la lista
    }

    public void insertarAlFinal(Object dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato); // Crear un nuevo nodo con el dato proporcionado
        if (esVacia()) { // Si la lista está vacía
            cabeza = nuevoNodo; // El nuevo nodo se convierte en la cabeza
            cola = nuevoNodo; // El nuevo nodo también se convierte en la cola
        } else { // Si la lista no está vacía
            cola.setSiguiente(nuevoNodo); // La cola actual apunta al nuevo nodo como siguiente
            nuevoNodo.setAnterior(cola); // El nuevo nodo apunta a la cola actual como anterior
            cola = nuevoNodo; // Actualizar la cola para que sea el nuevo nodo
        }
        Tamanio++; // Incrementar el tamaño de la lista
    }

    // --- ELIMINACIÓN ---
    public void eliminarAlInicio() {
        if (!esVacia()) { // Si la lista no está vacía
            if (cabeza == cola) { // Si hay un solo nodo en la lista
                cabeza = null; // La cabeza se establece en nulo
                cola = null; // La cola se establece en nulo
            } else { // Si hay más de un nodo en la lista
                cabeza = cabeza.getSiguiente(); // La cabeza apunta al siguiente nodo
                cabeza.setAnterior(null); // El nuevo nodo cabeza no tiene anterior
            }
            Tamanio--; // Decrementar el tamaño de la lista
        }
    }

    public void eliminarAlFinal() {
        if (!esVacia()) { // Si la lista no está vacía
            if (cabeza == cola) { // Si hay un solo nodo en la lista
                cabeza = null; // La cabeza se establece en nulo
                cola = null; // La cola se establece en nulo
            } else { // Si hay más de un nodo en la lista
                cola = cola.getAnterior(); // La cola apunta al nodo anterior
                cola.setSiguiente(null); // El nuevo nodo cola no tiene siguiente
            }
            Tamanio--; // Decrementar el tamaño de la lista
        }
    }

    // Método para imprimir la lista desde la cabeza hasta la cola
    public void imprimirLista() {
        NodoDoble actual = cabeza; // Comenzar desde la cabeza
        while (actual != null) { // Mientras no se llegue al final de la lista
            System.out.print(actual.getDato() + "-> "); // Imprimir el dato del nodo actual
            actual = actual.getSiguiente(); // Moverse al siguiente nodo
        }
        System.out.println(); // Nueva línea después de imprimir todos los nodos
    }

}
