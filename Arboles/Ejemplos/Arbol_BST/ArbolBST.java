//Propiedad BST: Para todo nodo del árbol,
// todos los valores en su subárbol izquierdo son estrictamente menores,
// y todos los valores en su subárbol derecho son estrictamente mayores.
public class ArbolBST {
    private Nodo raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    // --- Inserción ---
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.dato) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
        } else if (valor > nodo.dato) {
            nodo.derecho = insertarRec(nodo.derecho, valor);
        }
        // Si valor == nodo.dato, no se inserta (sin duplicados)
        return nodo;
    }

    // --- Búsqueda ---
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.dato) return true;
        if (valor < nodo.dato) return buscarRec(nodo.izquierdo, valor);
        return buscarRec(nodo.derecho, valor);
    }

    // --- Valor mínimo (nodo más a la izquierda) ---
    public int minimo() {
        if (raiz == null) throw new IllegalStateException("Árbol vacío");
        Nodo actual = raiz;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual.dato;
    }

    // --- Valor máximo (nodo más a la derecha) ---
    public int maximo() {
        if (raiz == null) throw new IllegalStateException("Árbol vacío");
        Nodo actual = raiz;
        while (actual.derecho != null) {
            actual = actual.derecho;
        }
        return actual.dato;
    }

    // Getter para la raíz (usado en recorridos)
    public Nodo getRaiz() {
        return raiz;
    }
}