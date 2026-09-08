package Colas.Ejemplos.Cola_Estatica;

public class Main {
    public static void main(String[] args) {
        // Crear una cola estática con capacidad para 5 nodos
        Cola_Estatica cola = new Cola_Estatica(5);

        // Crear nodos y agregarlos a la cola
        Nodo nodo1 = new Nodo("Nodo 1");
        Nodo nodo2 = new Nodo("Nodo 2");
        Nodo nodo3 = new Nodo("Nodo 3");

        cola.encolar(nodo1);
        cola.encolar(nodo2);
        cola.encolar(nodo3);

        // Mostrar el contenido de la cola
        System.out.println("Contenido de la cola:");
        cola.mostrarCola();

        // Eliminar un nodo de la cola
        Nodo nodoEliminado = cola.desencolar();
        System.out.println("Nodo eliminado: " + nodoEliminado.getDato());

        // Mostrar el contenido de la cola después de eliminar un nodo
        System.out.println("Contenido de la cola después de eliminar un nodo:");
        cola.mostrarCola();
    }
    
}
