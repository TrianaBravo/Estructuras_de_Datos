public class Pila {
    //atributos
    private Nodo cima;
    private int tamanio;
    //constructor
    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    //Verificar si la pila está vacía
    public boolean estaVacia() {
        return cima == null;
    }

    //insertar un elemento en la pila
    public void push(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        tamanio++;
    }
    //desapilar un elemento de la pila
    public Object pop() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        Object dato = cima.getDato();
        cima = cima.getSiguiente();
        tamanio--;
        return dato;
    }
    //obtener el elemento en la cima de la pila sin desapilarlo
    public Object peek() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return cima.getDato();
    }
    //obtener el tamaño de la pila
    public int getTamanio() {
        return tamanio;
    }
    //mostrar los elementos de la pila
    public void mostrar() {
        Nodo actual = cima;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }
}
