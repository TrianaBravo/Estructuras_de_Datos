package Pilas.Ejemplos.Pila_Dinamica;

public class Main {
    public static void main(String[] args) {
        Pila_Dinamica pila = new Pila_Dinamica();

        // Apilar elementos
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);

        // Mostrar elementos de la pila
        pila.mostrarPila();

        // Desapilar un elemento
        System.out.println("Desapilando: " + pila.desapilar());

        // Mostrar elementos de la pila después de desapilar
        pila.mostrarPila();

        // Mostrar el elemento en la cima
        System.out.println("Elemento en la cima: " + pila.cima());
    }
    
}
