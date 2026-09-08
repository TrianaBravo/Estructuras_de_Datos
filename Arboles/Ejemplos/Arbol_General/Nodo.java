public class Nodo {
    private Object dato;
    private Nodo hijoIzquierdo; // Referencia al hijo izquierdo
    private Nodo hijoDerecho; // Referencia al hijo derecho

    public Nodo(Object dato) {
        this.dato = dato;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
// Getters y setters
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    
}
