public class Main {
    public static void main(String[] args) {
        Lista lista_inversa = new Lista(); // Crear una nueva lista enlazada

        // Insertar elementos en la lista
        lista_inversa.insertarAlInicio("azul");
        lista_inversa.insertarAlInicio("verde");
        lista_inversa.insertarAlInicio("amarillo");
        lista_inversa.insertarEnPosicion("rojo", 2);
        lista_inversa.insertarAlFinal("cafe");
        lista_inversa.insertarAlFinal("morado");

        // Imprimir el tamaño de la lista
        System.out.println("Tamaño de la lista: \n" + lista_inversa.tamanio());

        // Imprimir los elementos de la lista
        System.out.println("Elementos de la lista:\n");
        lista_inversa.mostrarLista();
        
        lista_inversa.eliminarEnPosicion(1);
        System.out.println("Lista después de eliminar el elemento en la posición:\n");
        lista_inversa.mostrarLista();

        // Invertir la lista
        lista_inversa.invertir();
        System.out.println("Lista invertida:\n");

        // Imprimir los elementos de la lista invertida
        lista_inversa.mostrarLista(); 

        
    }
}
