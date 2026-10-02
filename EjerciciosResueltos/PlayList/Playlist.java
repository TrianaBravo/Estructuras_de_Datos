public class Playlist {
    //atributo
    private Cancion cabeza;
    //constructor
    public Playlist(){
        this.cabeza= null;
    }

    //funcion que agrega un elemento/cancion al final de la lista
    public void AgregarcancionFinal(String titulo, String artista, int duracion){
        //crea un nuevo nodo con los datos de la cancion
        Cancion nueva_Cancion = new Cancion(titulo,artista,duracion);
        //si la lista esta vacia, el nuevo nodo se convierte en la cabeza de la lista
        if(cabeza==null){
            cabeza = nueva_Cancion;
        }else{
            //si la lista no esta vacia, recorre la lista hasta llegar al ultimo nodo y agrega el nuevo nodo al final
            Cancion actualCancion= cabeza;
            while (actualCancion.get_Siguiente() != null){
                actualCancion= actualCancion.get_Siguiente();
            }
            actualCancion.set_Siguiente(nueva_Cancion);
        }
        System.out.println("Canción \"" + titulo + "\" agregada al final.");
    }

    //insertar canciones de inicio
    public void cargarEstadoInicial() {
        AgregarcancionFinal("Gritos.mptres", "Artista 1", 210);
        AgregarcancionFinal("zipzipzipremix", "Artista 2", 145);
        AgregarcancionFinal("NeverGonnaGiveYouUp", "Rick Astley", 213);
        AgregarcancionFinal("BohemianRhapsody", "Queen", 354);
    }

    // La nueva cancion debera ser insertada inmediatamente despues de la cancion indicada.
    public void insertarDespuesDe(String tituloBusqueda, String tituloNuevo, String artistaNuevo, int duracionNueva) {
        Cancion actual = cabeza;
        //recorre toda a ista buscando el lugar en donde esta la cancion
        while (actual != null && !actual.get_titulo().equalsIgnoreCase(tituloBusqueda)) {
            actual = actual.get_Siguiente();
        }
        //si no se encuentra la cancion, se muestra un mensaje de error
        if (actual == null) {
            System.out.println("Error: La canción \"" + tituloBusqueda + "\" no existe en la playlist.");
            return;
        }
        //si se encuentra la cancion, se crea un nuevo nodo y se inserta despues de la cancion encontrada
        Cancion nuevoNodo = new Cancion(tituloNuevo, artistaNuevo, duracionNueva);
        nuevoNodo.set_Siguiente(actual.get_Siguiente());
        actual.set_Siguiente(nuevoNodo);
        System.out.println("Canción \"" + tituloNuevo + "\" insertada después de \"" + tituloBusqueda + "\".");
    }


    public void buscarCancion(String titulo) {
        //recorre la lista buscando la cancion con el titulo indicado
        Cancion actual = cabeza;
        while (actual != null && !actual.get_titulo().equalsIgnoreCase(titulo)) {
            actual = actual.get_Siguiente();
        }
        //sino se encuentra la cancion, se muestra un mensaje indicando que no se encontro
        if (actual == null) {
            System.out.println("La canción \"" + titulo + "\" no se encuentra en la playlist.");
        } else {
            //si se encuentra la cancion, se muestran los datos de la cancion
            System.out.println("\n--- DATOS DE LA CANCIÓN ---");
            System.out.println("Título   : " + actual.get_titulo());
            System.out.println("Artista  : " + actual.get_Artista());
            System.out.println("Duración : " + actual.get_DuracionFormateada() + " (" + actual.get_DuracionSegundos() + " segundos)");
        }
    }

    public void mostrarPlaylist() {
        if (cabeza == null) {
            System.out.println("La playlist está vacía.");
            return;
        }
        //recorre la lista mostrando los datos de cada cancion
        System.out.println("\n--- PLAYLIST ACTUAL ---");
        Cancion actual = cabeza;
        while (actual != null) {
            System.out.print("[" + actual.get_titulo() + " (" + actual.get_DuracionFormateada() + ")]");
            if (actual.get_Siguiente() != null) {
                System.out.print(" -> ");
            }
            actual = actual.get_Siguiente();
        }
        System.out.println(" -> NULL\n");
    }

    public void duracionTotal() {
        //recorre la lista sumando la duracion de cada cancion
        int totalSegundos = 0;
        Cancion actual = cabeza;
        while (actual != null) {
            totalSegundos += actual.get_DuracionSegundos();
            actual = actual.get_Siguiente();
        }

        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;
        System.out.println("Duración total de la playlist: " + totalSegundos + " segundos (" + minutos + ":" + (segundos < 10 ? "0" : "") + segundos + ")");
    }

    public void eliminarCancion(String titulo) {
        if (cabeza == null) {
            System.out.println("La playlist está vacía.");
            return;
        }
        //si la cancion a eliminar es la cabeza, se actualiza la cabeza al siguiente nodo
        if (cabeza.get_titulo().equalsIgnoreCase(titulo)) {
            cabeza = cabeza.get_Siguiente();
            System.out.println("Canción \"" + titulo + "\" eliminada correctamente.");
            return;
        }
        //si la cancion a eliminar no es la cabeza, se recorre la lista buscando la cancion
        Cancion anterior = cabeza;
        Cancion actual = cabeza.get_Siguiente();

        while (actual != null && !actual.get_titulo().equalsIgnoreCase(titulo)) {
            anterior = actual;
            actual = actual.get_Siguiente();
        }
        //si no se encuentra la cancion, se muestra un mensaje de error
        if (actual == null) {
            System.out.println("Error: La canción \"" + titulo + "\" no existe en la playlist.");
        } else { //si se encuentra la cancion, se elimina de la lista actualizando el puntero del nodo anterior
            anterior.set_Siguiente(actual.get_Siguiente());
            System.out.println("Canción \"" + titulo + "\" eliminada correctamente.");
        }
    }

    public void moverAdelante(String titulo) {

        if (cabeza == null || cabeza.get_Siguiente() == null) {
            System.out.println("No se puede adelantar (la lista tiene 0 o 1 elemento).");
            return;
        }
        //si la cancion a adelantar es la cabeza, no se puede adelantar
        if (cabeza.get_titulo().equalsIgnoreCase(titulo)) {
            System.out.println("La canción \"" + titulo + "\" ya es la primera de la lista.");
            return;
        }

        Cancion anteriorDelAnterior = null;
        Cancion anterior = cabeza;
        Cancion actual = cabeza.get_Siguiente();
        //recorre la lista buscando la cancion a adelantar
        while (actual != null && !actual.get_titulo().equalsIgnoreCase(titulo)) {
            anteriorDelAnterior = anterior;
            anterior = actual;
            actual = actual.get_Siguiente();
        }

        if (actual == null) {
            System.out.println("Error: La canción \"" + titulo + "\" no existe en la playlist.");
            return;
        }

        if (anterior == cabeza) {
            cabeza = actual;
            anterior.set_Siguiente(actual.get_Siguiente());
            actual.set_Siguiente(anterior);
        } else {
            anterior.set_Siguiente(actual.get_Siguiente());
            actual.set_Siguiente(anterior);
            anteriorDelAnterior.set_Siguiente(actual);
        }

        System.out.println("Canción \"" + titulo + "\" adelantada una posición.");
    }


    //Solucion desafio
    // Elimina todas las canciones cuya duración sea menor a la duración mínima especificada.
    public void modoCaos(int duracionMinima) {
        if (cabeza == null) {
            System.out.println("La playlist está vacía.");
            return;
        }

        while (cabeza != null && cabeza.get_DuracionSegundos() < duracionMinima) {
            cabeza = cabeza.get_Siguiente();
        }

        if (cabeza == null) {
            System.out.println("Modo Caos aplicado. Todas las canciones fueron eliminadas.");
            return;
        }

        Cancion anterior = cabeza;
        Cancion actual = cabeza.get_Siguiente();
        //recorre la lista eliminando las canciones que no cumplen con la duracion minima
        while (actual != null) {
            if (actual.get_DuracionSegundos() < duracionMinima) {
                anterior.set_Siguiente(actual.get_Siguiente());
            } else {
                anterior = actual;
            }
            actual = actual.get_Siguiente();
        }
        System.out.println("Modo Caos aplicado correctamente.");
    }
}