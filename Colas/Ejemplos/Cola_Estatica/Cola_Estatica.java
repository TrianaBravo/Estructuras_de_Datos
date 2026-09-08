package Colas.Ejemplos.Cola_Estatica;

public class Cola_Estatica {
    // Atributos de la clase Cola_Estatica
    private Nodo[] cola; // Arreglo de nodos que representa la cola
    private int frente; // Índice del frente de la cola
    private int fin; // Índice del final de la cola
    private int tamanio; // Capacidad máxima de la cola

    // Constructor de la clase Cola_Estatica
    public Cola_Estatica(int tamanio) {
        this.tamanio = tamanio;
        this.cola = new Nodo[tamanio];
        this.frente = -1; // Inicializa el frente en -1 (cola vacía)
        this.fin = -1; // Inicializa el fin en -1 (cola vacía)
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == -1; // La cola está vacía si el frente es -1
    }

    // Método para verificar si la cola está llena
    public boolean estaLlena() {
        return fin == tamanio - 1; // La cola está llena si el fin es igual al tamaño - 1
    }

    // Método para agregar un nodo a la cola
    public void encolar(Nodo nodo) {
        if (estaLlena()) {
            System.out.println("La cola está llena. No se puede agregar el nodo.");
            return;
        }
        if (estaVacia()) {
            frente = 0; // Si la cola estaba vacía, actualiza el frente a 0
        }
        fin++; // Incrementa el índice del fin
        cola[fin] = nodo; // Agrega el nodo al final de la cola
    }

    // Método para eliminar un nodo de la cola
    public Nodo desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía. No se puede eliminar un nodo.");
            return null;
        }
        Nodo nodoEliminado = cola[frente]; // Obtiene el nodo en el frente de la cola
        if (frente == fin) {
            // Si solo hay un nodo en la cola, reinicia los índices
            frente = -1;
            fin = -1;
        } else {
            frente++; // Incrementa el índice del frente
        }
        return nodoEliminado; // Retorna el nodo eliminado
    }


    // Mostrar el contenido de la cola
    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        System.out.print("Contenido de la cola: ");
        for (int i = frente; i <= fin; i++) {
            System.out.print(cola[i].getDato() + " "); // Muestra el valor del nodo
        }
        System.out.println(); // Salto de línea al final
    }

}
