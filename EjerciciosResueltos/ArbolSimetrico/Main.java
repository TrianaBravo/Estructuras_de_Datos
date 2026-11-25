public class Main {
    public static void main(String[] args) {
        
        // Crear un árbol binario de ejemplo
        Nodo raiz = new Nodo(1);
        raiz.setHijoIzquierdo(new Nodo(2));
        raiz.setHijoDerecho(new Nodo(2));
        raiz.getHijoIzquierdo().setHijoIzquierdo(new Nodo(3));
        raiz.getHijoIzquierdo().setHijoDerecho(new Nodo(4));
        raiz.getHijoDerecho().setHijoIzquierdo(new Nodo(4));
        raiz.getHijoDerecho().setHijoDerecho(new Nodo(3));

        // Comprobar si el árbol es simétrico usando listas
        boolean esSimetricoListas = SimetricoListas.esSimetrico(raiz);
        System.out.println("El árbol es simétrico (usando listas): " + esSimetricoListas);

        // Comprobar si el árbol es simétrico usando recursión
        boolean esSimetricoRecursion = SimetricoRecursion.esSimetrico(raiz);
        System.out.println("El árbol es simétrico (usando recursión): " + esSimetricoRecursion);
    }
}
