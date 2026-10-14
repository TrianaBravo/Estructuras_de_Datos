public class Main {
    //Función 1: Encuentra el elemento del medio, lo elimina de la pila original y lo almacena en una pila auxiliar.
    public static void extraerElementoDelMedio(Pila pilaoriginal, Pila pilaauxiliar) {
        int n = pilaoriginal.getTamanio();
        if (n == 0) {   
            System.out.println("La pila original está vacía.");
                return;
            }
         //Calculamos la posición del medio (índice basado en 0 desde la base o cima)
        // Si hay un número impar, es el centro exacto. Si es par, se toma uno de los centrales
        int medio = n / 2;    

        Pila tempPila = new Pila();

        //Desapilamos de la original hasta llegar al elemento de la mitad
        for (int i = 0; i < medio; i++) {
            tempPila.push(pilaoriginal.pop());
        }
        // El elemento que está en la cima ahora es el del centro exacto
        int elementoMedio = (int) pilaoriginal.pop(); 
        pilaauxiliar.push(elementoMedio);
        // Volvemos a apilar los elementos restantes en la pila original
        while (!tempPila.estaVacia()) {
            pilaoriginal.push(tempPila.pop());
        }
    }

        // Función 2: Proceso inverso para devolver los datos a la pila original desde la mitad
    public static void devolverInverso(Pila original, Pila auxiliar){
        while(!auxiliar.estaVacia()){
            original.push(auxiliar.pop());
        }
    }
    public static void main(String[] args) {
        Pila pilaoriginal = new Pila();
        Pila pilaauxiliar = new Pila();

        // Agregar elementos a la pila original
        pilaoriginal.push(5);
        pilaoriginal.push(4);
        pilaoriginal.push(3);
        pilaoriginal.push(2);
        pilaoriginal.push(1);

        System.out.println("Pila original antes de extraer el elemento del medio:");
        pilaoriginal.mostrar();

        // Extraer el elemento del medio y almacenarlo en la pila auxiliar
        extraerElementoDelMedio(pilaoriginal, pilaauxiliar);

        System.out.println("\nPila original después de extraer el elemento del medio:");
        pilaoriginal.mostrar();

        System.out.println("\nElemento extraído almacenado en la pila auxiliar:");
        pilaauxiliar.mostrar();

        // Devolver los elementos de la pila auxiliar a la original
        devolverInverso(pilaoriginal, pilaauxiliar);

        System.out.println("\nPila original después de devolver los elementos desde la auxiliar:");
        pilaoriginal.mostrar();
    }

}