// Archivo: PrincipalEjercicio2.java
// Clase de prueba para ejecutar el sistema de pedidos de Jumbo.
public class Main {
    public static void main(String[] args) {
        ColaPedidos cola = new ColaPedidos();

        // Creamos productos basados en la tabla del enunciado
        Producto prod1 = new Producto("Caja Plástica Esencial 60 L", 1952132, 1, 5990, "Krea", "2.5 kg", "Sí (6 meses)");
        Producto prod2 = new Producto("Huevos Santa Marta Blanco 60 un.", 2017578, 1, 17100, "Santa Marta", "4.5 kg", "No");
        Producto prod3 = new Producto("Detergente Polvo Omo Matic 800g", 1976582, 2, 2990, "OMO", "0.8 kg", "Sí (6 meses)");

        // Creamos pedidos de clientes normales y Prime
        Pedido pedido1 = new Pedido("Carlos Pérez", "Av. Alemania 111", "Tarjeta Crédito", false);
        pedido1.agregarProducto(prod1);

        Pedido pedido2 = new Pedido("Ana Gómez", "Calle Mackenna 222", "Efectivo", false);
        pedido2.agregarProducto(prod2);

        Pedido pedido3 = new Pedido("Sofía Prime", "Eusebio Lillo 333", "Débito", true); // Prime
        pedido3.agregarProducto(prod3);

        Pedido pedido4 = new Pedido("Pedro Soto", "Lord Cochrane 444", "Tarjeta Crédito", false);
        pedido4.agregarProducto(prod1);

        Pedido pedido5 = new Pedido("Matías Prime", "Bulnes 555", "Tarjeta Débito", true); // Prime
        pedido5.agregarProducto(prod2);

        // Ingresamos los pedidos al sistema
        cola.ingresarPedido(pedido1); // Normal 1
        cola.ingresarPedido(pedido2); // Normal 2
        cola.ingresarPedido(pedido3); // Prime 1
        cola.ingresarPedido(pedido4); // Normal 3
        cola.ingresarPedido(pedido5); // Prime 2

        // Aplicamos la regla de negocio: intercalar por prioridad (2 normales : 1 prime)[cite: 2]
        cola.organizarColaPrioritaria();

        // 1. Mostrar la cola con todos los datos procesados
        cola.mostrarCola();

        // 2. Marcar un pedido como cancelado (Ej: El de Carlos Pérez)
        System.out.println("\n[!] Acción: Marcando como cancelado el pedido de Carlos Pérez...");
        cola.marcarComoCancelado("Carlos Pérez");

        // Mostramos la cola actualizada
        cola.mostrarCola();

        // 3. Mostrar ganancias totales (excluyendo el pedido cancelado)[cite: 2]
        double gananciasFinales = cola.calcularGananciasTotales();
        System.out.println("\n💰 Ganancias Totales Proyectadas (Sin pedidos cancelados): $" + gananciasFinales);
    }
}