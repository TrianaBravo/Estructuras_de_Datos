public class Nodo {
    //atributos
    private Evaluacion evaluacion;
    private Nodo siguiente;

    public Nodo(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
        this.siguiente = null;
    }

    public Evaluacion getEvaluacion() { return evaluacion; }
    
    public void setEvaluacion(Evaluacion evaluacion) { this.evaluacion = evaluacion; }

    public Nodo getSiguiente() { return siguiente; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
}