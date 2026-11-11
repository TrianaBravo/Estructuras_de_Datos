//Este arbol cumple las reglas de un arbol binario de busqueda (BST), 
// es decir, que los valores menores a la raiz se encuentran a la izquierda y los mayores a la derecha

public class ArbolBinario {
//arbol binario de enteros el nodo ya tiene los hijos
    private Nodo raiz;
    // Constructor para crear un árbol binario vacío
    public ArbolBinario() {
        this.raiz = null;
    }

//funcion para insertar un valor en el arbol binario de enteros
//si el valor ya existe no se inserta    
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }
//toma un nodo y un valor,
//y devuelve el nodo actualizado después de insertar el valor en el lugar correcto según las reglas del árbol binario de búsqueda  
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        //caso base: si el nodo es nulo, se crea un nuevo nodo con el valor
        if (nodo == null) {
            return new Nodo(valor);
        }
        //si el valor es menor que el dato del nodo actual, se inserta en el subárbol izquierdo
        if (valor < nodo.dato) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        //sino en el derecho
        } else if (valor > nodo.dato) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        return nodo;
    }

    
    // buscar un valor en el arbol binario de enteros
    public boolean buscar(int valor) {
        Nodo actual = raiz;
        while (actual != null) {
            if (valor == actual.dato) {
                return true;
            } else if (valor < actual.dato) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }
        return false;
    }

    //eliminar un valor del arbol binario de enteros
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }
//eliminar con recursion, se busca el nodo a eliminar y se reorganiza el árbol según los casos posibles (nodo hoja, nodo con un hijo, nodo con dos hijos)
    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        //caso base: si el nodo es nulo, se retorna nulo
        if (nodo == null) {
            return null;
        }
        //si el valor es menor que el dato del nodo actual, se busca en el subárbol izquierdo
        if (valor < nodo.dato) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, valor);
        //si el valor es mayor que el dato del nodo actual, se busca en el subárbol derecho    
        } else if (valor > nodo.dato) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, valor);
        } else {
            // Nodo encontrado, se deben considerar los casos posibles para eliminarlo
            if (nodo.esHoja()) {
                return null; // Caso 1: Nodo hoja, simplemente se elimina retornando null

            } else if (nodo.izquierdo == null) {
                return nodo.derecho; // Caso 2: Nodo con un hijo derecho, se retorna el hijo derecho para reemplazar al nodo eliminado

            } else if (nodo.derecho == null) {
                return nodo.izquierdo; // Caso 2: Nodo con un hijo izquierdo, se retorna el hijo izquierdo para reemplazar al nodo eliminado
            } else {
                // Caso 3: Nodo con dos hijos
                Nodo sucesor = encontrarMinimo(nodo.derecho); // Se encuentra el sucesor (el nodo más pequeño del subárbol derecho)
                nodo.dato = sucesor.dato;
                nodo.derecho = eliminarRecursivo(nodo.derecho, sucesor.dato);
            }
        }
        return nodo;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    // Método para imprimir el árbol en orden (in-order traversal)
    public void imprimirInOrden() {
        imprimirInOrdenRecursivo(raiz);
    }
    //izquierdo, raiz, derecho
    private void imprimirInOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            imprimirInOrdenRecursivo(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            imprimirInOrdenRecursivo(nodo.derecho);
        }
    }
    // Método para imprimir el árbol en preorden (pre-order traversal)
    public void imprimirPreOrden() {
        imprimirPreOrdenRecursivo(raiz);
    }
    //raiz, izquierdo, derecho
    private void imprimirPreOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            imprimirPreOrdenRecursivo(nodo.izquierdo);
            imprimirPreOrdenRecursivo(nodo.derecho);
        }
    }
    
    // Método para imprimir el árbol en postorden (post-order traversal)
    public void imprimirPostOrden() {
        imprimirPostOrdenRecursivo(raiz);
    }
    //izquierdo, derecho, raiz
    private void imprimirPostOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            imprimirPostOrdenRecursivo(nodo.izquierdo);
            imprimirPostOrdenRecursivo(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    
}