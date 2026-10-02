import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        
        playlist.cargarEstadoInicial();

        int opcion;
        do {
            System.out.println("\n===== MENÚ PLAYLIST MUSICAL =====");
            System.out.println("1. Agregar canción al final");
            System.out.println("2. Insertar canción después de otra");
            System.out.println("3. Buscar canción");
            System.out.println("4. Mostrar playlist");
            System.out.println("5. Calcular duración total");
            System.out.println("6. Eliminar canción");
            System.out.println("7. Mover canción adelante");
            System.out.println("8. Modo Caos (filtrar por duración mínima)");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título: ");
                    String t1 = scanner.nextLine();
                    System.out.print("Ingrese el artista: ");
                    String a1 = scanner.nextLine();
                    System.out.print("Ingrese la duración en segundos: ");
                    int d1 = scanner.nextInt();
                    scanner.nextLine();
                    playlist.AgregarcancionFinal(t1, a1, d1);
                    break;
                case 2:
                    System.out.print("Ingrese el título de la canción existente de referencia: ");
                    String ref = scanner.nextLine();
                    System.out.print("Ingrese el título de la nueva canción: ");
                    String t2 = scanner.nextLine();
                    System.out.print("Ingrese el artista de la nueva canción: ");
                    String a2 = scanner.nextLine();
                    System.out.print("Ingrese la duración en segundos: ");
                    int d2 = scanner.nextInt();
                    scanner.nextLine();
                    playlist.insertarDespuesDe(ref, t2, a2, d2);
                    break;
                case 3:
                    System.out.print("Ingrese el título de la canción a buscar: ");
                    String tBusqueda = scanner.nextLine();
                    playlist.buscarCancion(tBusqueda);
                    break;
                case 4:
                    playlist.mostrarPlaylist();
                    break;
                case 5:
                    playlist.duracionTotal();
                    break;
                case 6:
                    System.out.print("Ingrese el título de la canción a eliminar: ");
                    String tEliminar = scanner.nextLine();
                    playlist.eliminarCancion(tEliminar);
                    break;
                case 7:
                    System.out.print("Ingrese el título de la canción a adelantar: ");
                    String tAdelantar = scanner.nextLine();
                    playlist.moverAdelante(tAdelantar);
                    break;
                case 8:
                    System.out.print("Ingrese la duración límite en segundos (X): ");
                    int limite = scanner.nextInt();
                    scanner.nextLine();
                    playlist.modoCaos(limite);
                    break;
                case 9:
                    System.out.println("Saliendo del programa. ¡Disfrute su música!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}