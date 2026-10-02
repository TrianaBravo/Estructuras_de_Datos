public class SistemaEvaluaciones {
    private Nodo listaGeneral; // Registro de todas las evaluaciones
    private Nodo frenteCola;   // Inicio de la cola (siguiente en corregir)
    private Nodo finCola;      // Final de la cola
    private Nodo cimaPila;     // Cima de la pila (historial de correcciones)

    public SistemaEvaluaciones() {
        this.listaGeneral = null;
        this.frenteCola = null;
        this.finCola = null;
        this.cimaPila = null;
    }

    // --- 1. REGISTRAR EVALUACIÓN (en la lista general) ---
    public void registrarEvaluacion(String nombre, String rut, String asignatura) {
        Evaluacion nueva = new Evaluacion(nombre, rut, asignatura);
        Nodo nuevoNodo = new Nodo(nueva);

        // Insertar al final de la lista general
        if (listaGeneral == null) {
            listaGeneral = nuevoNodo;
        } else {
            Nodo actual = listaGeneral;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        System.out.println("Evaluación registrada exitosamente en el sistema.");
    }

    // --- 2. AGREGAR A LA ESPERA DE CORRECCIÓN (Añadir a la Cola) ---
    public void agregarAEspera(String rut) {
        Evaluacion eval = buscarEnLista(rut);
        if (eval == null) {
            System.out.println("Error: No existe una evaluación registrada con el RUT " + rut);
            return;
        }
        if (!eval.getEstado().equals("pendiente")) {
            System.out.println("Aviso: La evaluación ya se encuentra en corrección o fue corregida.");
            return;
        }

        // Agregar a la Cola (FIFO)
        Nodo nuevoNodo = new Nodo(eval);
        if (finCola == null) {
            frenteCola = finCola = nuevoNodo;
        } else {
            finCola.setSiguiente(nuevoNodo);
            finCola = nuevoNodo;
        }
        System.out.println("Evaluación de " + eval.getNombreEstudiante() + " agregada a la cola de espera.");
    }

    // --- 3. CORREGIR SIGUIENTE EVALUACIÓN (Desencolar de la Cola y Apilar en Historial) ---
    public void corregirSiguiente(double nota) {
        if (frenteCola == null) {
            System.out.println("No hay evaluaciones pendientes en la cola de espera.");
            return;
        }

        // Extraer de la Cola
        Nodo nodoAProcesar = frenteCola;
        frenteCola = frenteCola.getSiguiente();
        if (frenteCola == null) {
            finCola = null;
        }

        Evaluacion eval = nodoAProcesar.getEvaluacion();
        eval.setNota(nota);
        eval.setEstado("corregida");

        // Agregar a la Pila de historial (LIFO)
        nodoAProcesar.setSiguiente(cimaPila);
        cimaPila = nodoAProcesar;

        System.out.println("Evaluación corregida con éxito para: " + eval.getNombreEstudiante() + " (Nota: " + nota + ")");
    }

    // --- 4. CONSULTAR HISTORIAL (Ver última corrección) ---
    public void consultarUltimaCorreccion() {
        if (cimaPila == null) {
            System.out.println("El historial de correcciones está vacío.");
            return;
        }
        System.out.println("\n--- ÚLTIMA EVALUACIÓN CORREGIDA ---");
        System.out.println(cimaPila.getEvaluacion());
    }

    // --- 5. DESHACER ÚLTIMA CORRECCIÓN (Desapilar y reincorporar a la Cola) ---
    public void deshacerUltimaCorreccion() {
        if (cimaPila == null) {
            System.out.println("No hay correcciones recientes para deshacer.");
            return;
        }

        // Sacar de la Pila
        Nodo nodoDeshacer = cimaPila;
        cimaPila = cimaPila.getSiguiente();

        Evaluacion eval = nodoDeshacer.getEvaluacion();
        eval.setNota(0.0);
        eval.setEstado("pendiente");

        // Volver a colocar al frente de la cola de espera
        nodoDeshacer.setSiguiente(frenteCola);
        frenteCola = nodoDeshacer;
        if (finCola == null) {
            finCola = frenteCola;
        }

        System.out.println("Se ha deshecho la corrección de: " + eval.getNombreEstudiante() + ". Vuelve a estado pendiente.");
    }

    // --- 6. BUSCAR EVALUACIÓN ---
    public Evaluacion buscarEnLista(String rut) {
        Nodo actual = listaGeneral;
        while (actual != null) {
            if (actual.getEvaluacion().getRut().equalsIgnoreCase(rut)) {
                return actual.getEvaluacion();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void buscarEvaluacion(String rut) {
        Evaluacion eval = buscarEnLista(rut);
        if (eval == null) {
            System.out.println("Evaluación no encontrada.");
        } else {
            System.out.println("\n--- DATOS DE LA EVALUACIÓN ---");
            System.out.println(eval);
        }
    }

    // --- 7. MODIFICAR EVALUACIÓN ---
    public void modificarEvaluacion(String rut, String nuevoNombre, String nuevaAsignatura) {
        Evaluacion eval = buscarEnLista(rut);
        if (eval == null) {
            System.out.println("No se puede modificar. Evaluación no encontrada.");
            return;
        }
        eval.setNombreEstudiante(nuevoNombre);
        eval.setAsignatura(nuevaAsignatura);
        System.out.println("Evaluación modificada correctamente.");
    }

    // --- 8. ELIMINAR EVALUACIÓN ---
    public void eliminarEvaluacion(String rut) {
        if (listaGeneral == null) {
            System.out.println("El sistema no tiene evaluaciones registradas.");
            return;
        }

        if (listaGeneral.getEvaluacion().getRut().equalsIgnoreCase(rut)) {
            listaGeneral = listaGeneral.getSiguiente();
            System.out.println("Evaluación eliminada del sistema.");
            return;
        }

        Nodo anterior = listaGeneral;
        Nodo actual = listaGeneral.getSiguiente();

        while (actual != null && !actual.getEvaluacion().getRut().equalsIgnoreCase(rut)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            System.out.println("No se encontró una evaluación con el RUT especificado.");
        } else {
            anterior.setSiguiente(actual.getSiguiente());
            System.out.println("Evaluación eliminada del sistema.");
        }
    }

    // --- 9. MOSTRAR TODAS LAS EVALUACIONES ---
    public void mostrarTodas() {
        if (listaGeneral == null) {
            System.out.println("No hay evaluaciones registradas en el sistema.");
            return;
        }
        System.out.println("\n--- LISTADO GENERAL DE EVALUACIONES ---");
        Nodo actual = listaGeneral;
        while (actual != null) {
            System.out.println(actual.getEvaluacion());
            actual = actual.getSiguiente();
        }
    }
}