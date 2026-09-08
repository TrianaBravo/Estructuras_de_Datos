package Pilas.Ejemplos.Pila_Estatica;
//Codigo generico para una pila estatica, se puede usar para cualquier tipo de dato
public class Pila_Estatica {
    private Object[] pila;
    private int cima;
    private int Tamanio;

    public Pila_Estatica(int Tamanio) {
        this.Tamanio = Tamanio;
        this.pila = new Object[Tamanio];// Se crea un arreglo de objetos con el tamaño especificado
        this.cima = -1; // Indica que la pila está vacía
    }

    public boolean estaVacia() {
        return cima == -1;// si la cima es -1, significa que la pila está vacía
    }

    public boolean estaLlena() {
        return cima == Tamanio - 1;// si la cima es Tamanio - 1, significa que la pila está llena
    }

    public void apilar(Object dato) {
        if (estaLlena()) {
            System.out.println("La pila está llena. No se puede apilar.");
            return;
        }
        pila[++cima] = dato;// Se incrementa la cima y se asigna el dato en esa posición
    }

    public Object desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía. No se puede desapilar.");
            return null;
        }
        return pila[cima--];// Se retorna el dato en la cima y se decrementa la cima
    }

    public Object cima() {
        if (estaVacia()) {
            System.out.println("La pila está vacía. No hay cima.");
            return null;
        }
        return pila[cima];// Se muestra el dato en la cima sin modificar la cima
    }

    // Método para mostrar los elementos de la pila
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return;
        }
        System.out.println("Elementos en la pila:");
        // Se recorre la pila desde la cima hasta la base para mostrar los elementos
        for (int i = cima; i >= 0; i--) {
            System.out.println(pila[i]);
        }
    }
    
}
