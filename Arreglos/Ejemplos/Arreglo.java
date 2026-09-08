public class Arreglo {
    public static void main(String[] args) {
        // Crear un arreglo de enteros con 5 elementos
        int[] arreglo = new int[5];

        // Asignar valores al arreglo manualmente
        arreglo[0] = 10;
        arreglo[1] = 20;
        arreglo[2] = 30;
        arreglo[3] = 40;
        arreglo[4] = 50;
        
    

        // Imprimir los elementos del arreglo
        System.out.println("Elementos del arreglo:");
        for (int elemento : arreglo) {
            System.out.print(elemento + " ");
        }

        //asignar valores al arreglo usando un bucle
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (i + 1) * 10; // Asignar valores 10, 20, 30, 40, 50
        }

        // Imprimir los elementos del arreglo después de la asignación
        System.out.println("\nElementos del arreglo después de la asignación:");
        for (int elemento : arreglo) {
            System.out.print(elemento + " ");
        }
    }
}
