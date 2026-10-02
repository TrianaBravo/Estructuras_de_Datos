import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaEvaluaciones sistema = new SistemaEvaluaciones();
        int opcion;

        do {
            System.out.println("\n===== SISTEMA SEMANA DE PARCIALES - ULAGOS =====");
            System.out.println("1. Registrar nueva evaluación");
            System.out.println("2. Buscar evaluación por RUT");
            System.out.println("3. Modificar evaluación");
            System.out.println("4. Eliminar evaluación");
            System.out.println("5. Mostrar todas las evaluaciones");
            System.out.println("6. Agregar evaluación a la espera de corrección (Cola)");
            System.out.println("7. Corregir siguiente evaluación");
            System.out.println("8. Consultar última corrección (Historial)");
            System.out.println("9. Deshacer última corrección");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("RUT del estudiante: ");
                    String rut = scanner.nextLine();
                    System.out.print("Asignatura: ");
                    String asig = scanner.nextLine();
                    sistema.registrarEvaluacion(nombre, rut, asig);
                    break;
                case 2:
                    System.out.print("Ingrese el RUT a buscar: ");
                    String rutB = scanner.nextLine();
                    sistema.buscarEvaluacion(rutB);
                    break;
                case 3:
                    System.out.print("Ingrese el RUT de la evaluación a modificar: ");
                    String rutM = scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNom = scanner.nextLine();
                    System.out.print("Nueva asignatura: ");
                    String nuevaAsig = scanner.nextLine();
                    sistema.modificarEvaluacion(rutM, nuevoNom, nuevaAsig);
                    break;
                case 4:
                    System.out.print("Ingrese el RUT de la evaluación a eliminar: ");
                    String rutE = scanner.nextLine();
                    sistema.eliminarEvaluacion(rutE);
                    break;
                case 5:
                    sistema.mostrarTodas();
                    break;
                case 6:
                    System.out.print("Ingrese el RUT de la evaluación para enviar a cola de espera: ");
                    String rutC = scanner.nextLine();
                    sistema.agregarAEspera(rutC);
                    break;
                case 7:
                    System.out.print("Ingrese la nota obtenida (1.0 - 7.0): ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine();
                    sistema.corregirSiguiente(nota);
                    break;
                case 8:
                    sistema.consultarUltimaCorreccion();
                    break;
                case 9:
                    sistema.deshacerUltimaCorreccion();
                    break;
                case 10:
                    System.out.println("Saliendo del sistema de parciales. ¡Éxito en las correcciones!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 10);

        scanner.close();
    }
}