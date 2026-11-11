class Main{
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("In-order traversal:");
        arbol.imprimirInOrden();
        System.out.println("\nPre-order traversal:");
        arbol.imprimirPreOrden();
        System.out.println("\nPost-order traversal:");
        arbol.imprimirPostOrden();

        arbol.eliminar(20);
        System.out.println("\nIn-order traversal after deleting 20:");
        arbol.imprimirInOrden();
        
    }
}