public class Main {
    public static void main(String[] args) {
        // Crear una lista doblemente enlazada
        lista_doble listaDoble = new lista_doble();

        // Insertar elementos al inicio y al final de la lista
        listaDoble.insertarAlInicio("blanco");
        listaDoble.insertarAlFinal("negro");
        listaDoble.insertarAlInicio("rojo");
        listaDoble.insertarAlFinal("verde");
        // Mostrar los elementos de la lista
        System.out.println("Elementos de la lista doble:");
        listaDoble.imprimirLista();

        // Mostrar el tamaño de la lista
        System.out.println("Tamaño de la lista doble: " + listaDoble.tamanio());

        // Eliminar elementos al inicio y al final de la lista
        listaDoble.eliminarAlInicio();
        listaDoble.eliminarAlFinal();

        // Mostrar el tamaño de la lista después de las eliminaciones
        System.out.println("Tamaño de la lista doble después de eliminar: " + listaDoble.tamanio());
    }
    
}
