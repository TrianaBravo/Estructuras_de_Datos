import java.util.LinkedList;
public class SimetricoListas {
    //comprobacion de arbol simetrico usando listas
    public static boolean esSimetrico(Nodo raiz) {
        if (raiz == null) {
            return true; // Un árbol vacío es simétrico
        }

        LinkedList<Nodo> listaIzquierda = new LinkedList<>();
        LinkedList<Nodo> listaDerecha = new LinkedList<>();
        //tambien se puede usar push

        listaIzquierda.add(raiz.getHijoIzquierdo());
        listaDerecha.add(raiz.getHijoDerecho());

        while (!listaIzquierda.isEmpty() && !listaDerecha.isEmpty()) {
            Nodo nodoIzquierdo = listaIzquierda.poll();
            Nodo nodoDerecho = listaDerecha.poll();
            //también se puede usar pop

            if (nodoIzquierdo == null && nodoDerecho == null) {
                continue; // Ambos nodos son nulos, simétricos
            }
            if (nodoIzquierdo == null || nodoDerecho == null) {
                return false; // Uno de los nodos es nulo, no simétricos
            }
            if (nodoIzquierdo.getDato() != nodoDerecho.getDato()) {
                return false; // Los datos de los nodos no coinciden, no simétricos
            }

            // Agregar los hijos izquierdo y derecho a las listas
            listaIzquierda.add(nodoIzquierdo.getHijoIzquierdo());
            listaIzquierda.add(nodoIzquierdo.getHijoDerecho());

            listaDerecha.add(nodoDerecho.getHijoDerecho());
            listaDerecha.add(nodoDerecho.getHijoIzquierdo());
        }
         return listaIzquierda.isEmpty() && listaDerecha.isEmpty(); // Ambos deben estar vacíos para ser simétricos


    }
}
