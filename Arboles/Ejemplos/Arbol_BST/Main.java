public class Main {
    public static void main(String[] args) {
        ArbolBST bst = new ArbolBST();
        bst.insertar(50);
        bst.insertar(30);
        bst.insertar(70);
        bst.insertar(20);
        bst.insertar(40);
        bst.insertar(60);
        bst.insertar(80);

        // Árbol resultante:
        //         50
        //       /    \
        //     30      70
        //    /  \    /  \
        //  20   40  60   80

        System.out.println(bst.buscar(40));  // true
        System.out.println(bst.buscar(55));  // false
        System.out.println(bst.minimo());    // 20
        System.out.println(bst.maximo());    // 80
    }
    
}
