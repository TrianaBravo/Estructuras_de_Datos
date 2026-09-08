

public class Main {
    public static void main(String[] args) {
        lista_Circular lista = new lista_Circular(); // Crea una nueva lista circular

        // Agrega elementos a la lista
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(30);
        lista.agregarAlFinal(40);

        // Recorre e imprime los elementos de la lista
        System.out.println("Elementos de la lista circular:");
        lista.recorrer();
    }
    
}
