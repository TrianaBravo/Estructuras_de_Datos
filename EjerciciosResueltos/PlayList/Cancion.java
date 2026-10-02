// Codigo del Nodo que guarda una cancion de la playlist 

class Cancion {
    //atributos
    private String titulo;
    private String Artista; 
    private int Duracion_segundos; //Segundos de la cancion 
    private Cancion siguiente;

    //constructor
    public Cancion(String titulo, String Artista, int Duracion_segundos){
        this.titulo= titulo;
        this.Artista=Artista;
        this.Duracion_segundos=Duracion_segundos;
        this.siguiente=null;
    }

    public String get_titulo(){
        return titulo;
    }
    public void set_titulo(String titulo) {
        this.titulo = titulo;
    }

    public String get_Artista() {
        return Artista;
    }

    public void set_Artista(String Artista) {
        this.Artista = Artista;
    }

    public int get_DuracionSegundos() {
        return Duracion_segundos;
    }

    public void set_DuracionSegundos(int Duracion_segundos) {
        this.Duracion_segundos = Duracion_segundos;
    }

    public Cancion get_Siguiente() {
        return siguiente;
    }

    public void set_Siguiente(Cancion siguiente) {
        this.siguiente = siguiente;
    }

    // Método auxiliar para formatear la duración
    public String get_DuracionFormateada() {
        int minutos = Duracion_segundos / 60;
        int segundos = Duracion_segundos % 60;
        //retorna la duracion en formato mm:ss
        //si segundos es menor a 10, se agrega un 0 al inicio
        return minutos + ":" + (segundos < 10 ? "0" : "") + segundos;
    }



}