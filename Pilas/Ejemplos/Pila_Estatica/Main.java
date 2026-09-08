package Pilas.Ejemplos.Pila_Estatica;

public class Main {
    public static void main(String[] args) {
        Pila_Estatica pila = new Pila_Estatica(5); // Crear una pila con tamaño 5

        // Apilar elementos
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);

        // Mostrar elementos de la pila
        pila.mostrarPila();

        // Desapilar un elemento
        System.out.println("Elemento desapilado: " + pila.desapilar());

        // Mostrar elementos de la pila después de desapilar
        pila.mostrarPila();

        // Mostrar el elemento en la cima
        System.out.println("Elemento en la cima: " + pila.cima());
    }
    
}
