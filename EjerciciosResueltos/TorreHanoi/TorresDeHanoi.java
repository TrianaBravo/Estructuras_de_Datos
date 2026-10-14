
public class TorresDeHanoi {

    // Método recursivo para mover los discos entre las torres (pilas)
    
    public static void resolverHanoi(int n, Pila origen, Pila destino, Pila auxiliar) {
        // Caso base: si solo queda 1 disco, se mueve directamente
        if (n == 1) {
            moverDisco(origen, destino);
            return;
        }

        // Paso 1: Mover n-1 discos de origen a auxiliar, usando destino como apoyo
        resolverHanoi(n - 1, origen, auxiliar, destino);

        // Paso 2: Mover el disco restante de origen a destino
        moverDisco(origen, destino);

        // Paso 3: Mover los n-1 discos de auxiliar a destino, usando origen como apoyo
        resolverHanoi(n - 1, auxiliar, destino, origen);
    }

    // Método para realizar el traslado físico del elemento (disco) de una pila a otra.
   
   
    public static void moverDisco(Pila origen, Pila destino) {
        int disco = origen.desapilar();
        if (disco != -1) {
            destino.apilar(disco);
            System.out.println("Movimiento: Se pasa el disco " + disco + " desde la torre [" + origen.getNombre() + "] hacia la torre [" + destino.getNombre() + "]");
        }
    }

    public static void main(String[] args) {
        // Se definen las tres torres (pilas) requeridas por el problema[cite: 1]
        Pila izquierdo = new Pila("izquierdo");
        Pila central = new Pila("central");
        Pila derecho = new Pila("derecho");

        int numeroDiscos = 4; // Configurado con 4 discos según el enunciado[cite: 1]

        // Inicialización: Apilar los 4 discos en la torre izquierda.
        // El disco 4 es el más grande (base) y el 1 es el más pequeño (cima).
        for (int i = numeroDiscos; i >= 1; i--) {
            izquierdo.apilar(i);
        }

        System.out.println("=== ESTADO INICIAL DE LAS TORRES ===");
        izquierdo.mostrar();
        central.mostrar();
        derecho.mostrar();
        System.out.println("=====================================\n");

        System.out.println("=== INICIO DE MOVIMIENTOS ===");
        // Llamada al algoritmo para pasar los 4 discos desde 'izquierdo' hasta 'derecho' usando 'central'
        resolverHanoi(numeroDiscos, izquierdo, derecho, central);
        System.out.println("=== FIN DE MOVIMIENTOS ===\n");

        System.out.println("=== ESTADO FINAL DE LAS TORRES ===");
        izquierdo.mostrar();
        central.mostrar();
        derecho.mostrar();
        System.out.println("====================================");
    }
}