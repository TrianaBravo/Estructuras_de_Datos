
public class Main {
    public static void main(String[] args) {

        //comprobacion de la clase nodo
        Nodo primerNodo = new Nodo(10); // Crear el primer nodo con el valor 10
        Nodo segundoNodo = new Nodo(20); // Crear el segundo nodo con el valor
        primerNodo.setSiguiente(segundoNodo); // Enlazar el primer nodo al segundo

        // Imprimir los valores de los nodos
        System.out.println("Valor del primer nodo: " + primerNodo.getDato());
        System.out.println("Valor del segundo nodo: " + primerNodo.getSiguiente().getDato());


        //comprobacion de la lista simple
        lista_simple lista = new lista_simple(); // Crear una nueva lista enlazada simple
        lista.insertarAlInicio(10); // Insertar un elemento al inicio
        lista.insertarAlFinal(20); // Insertar un elemento al final
        lista.insertarAlFinal(30); // Insertar otro elemento al final
        lista.recorrer(); // Recorrer e imprimir los elementos de la lista
        

    }

}
