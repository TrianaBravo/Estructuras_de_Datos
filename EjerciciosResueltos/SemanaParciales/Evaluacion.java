public class Evaluacion {
    //atributos
    private String nombreEstudiante;
    private String rut;
    private String asignatura;
    private double nota;
    private String estado; // "pendiente", "en correccion", "corregida"

    public Evaluacion(String nombreEstudiante, String rut, String asignatura) {
        //constructor
        this.nombreEstudiante = nombreEstudiante;
        this.rut = rut;
        this.asignatura = asignatura;
        this.nota = 0.0;
        this.estado = "pendiente";
    }

    // Getters y Setters
    public String getNombreEstudiante() { return nombreEstudiante; }
    public void setNombreEstudiante(String nombreEstudiante) { this.nombreEstudiante = nombreEstudiante; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Estudiante: " + nombreEstudiante + " | RUT: " + rut + 
               " | Asignatura: " + asignatura + " | Nota: " + nota + 
               " | Estado: " + estado;
    }
}