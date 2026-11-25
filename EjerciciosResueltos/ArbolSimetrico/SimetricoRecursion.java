//comprobacion de arbol simetrico usando recursion
public class SimetricoRecursion {
    
    public static boolean esSimetrico(Nodo raiz) {
        if (raiz == null) {
            return true; // Un árbol vacío es simétrico
        }
        return esSimetricoRecursivo(raiz.getHijoIzquierdo(), raiz.getHijoDerecho());
    }

    private static boolean esSimetricoRecursivo(Nodo nodo1, Nodo nodo2) {
        if (nodo1 == null && nodo2 == null) {
            return true; // Ambos nodos son nulos, simétricos
        }
        if (nodo1 == null || nodo2 == null) {
            return false; // Uno de los nodos es nulo, no simétricos
        }
        if (nodo1.getDato() != nodo2.getDato()) {
            return false; // Los datos de los nodos no coinciden, no simétricos
        }
        // Comprobar recursivamente los hijos izquierdo y derecho
        return esSimetricoRecursivo(nodo1.getHijoIzquierdo(), nodo2.getHijoDerecho()) &&
               esSimetricoRecursivo(nodo1.getHijoDerecho(), nodo2.getHijoIzquierdo());
    }
}