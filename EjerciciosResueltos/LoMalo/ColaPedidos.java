// Archivo: ColaPedidos.java
// Cola dinámica que administra, prioriza y calcula ganancias de los pedidos de Jumbo.
public class ColaPedidos {
    private Pedido frente;
    private Pedido fin;

    // Filas auxiliares internas para separar y aplicar la regla Jumbo Prime (2 normales : 1 prime)
    private Pedido frenteNormal, finNormal;
    private Pedido frentePrime, finPrime;

    public ColaPedidos() {
        this.frente = null;
        this.fin = null;
        this.frenteNormal = null;
        this.finNormal = null;
        this.frentePrime = null;
        this.finPrime = null;
    }

    // Ingresa un pedido a su respectiva fila interna (Normal o Prime)
    public void ingresarPedido(Pedido p) {
        if (p.esPrime) {
            if (frentePrime == null) {
                frentePrime = p;
            } else {
                finPrime.siguiente = p;
            }
            finPrime = p;
        } else {
            if (frenteNormal == null) {
                frenteNormal = p;
            } else {
                finNormal.siguiente = p;
            }
            finNormal = p;
        }
    }

    // Organiza la cola principal respetando la regla: por cada 2 normales se ingresa 1 Prime[cite: 2]
    public void organizarColaPrioritaria() {
        frente = null;
        fin = null;

        while (frenteNormal != null || frentePrime != null) {
            // Inserta hasta 2 clientes normales (si hay disponibles)
            int normalesAgregados = 0;
            while (normalesAgregados < 2 && frenteNormal != null) {
                Pedido temp = frenteNormal;
                frenteNormal = frenteNormal.siguiente;
                temp.siguiente = null;
                agregarAColaFinal(temp);
                normalesAgregados++;
            }

            // Inserta 1 cliente Prime (si hay disponible)
            if (frentePrime != null) {
                Pedido temp = frentePrime;
                frentePrime = frentePrime.siguiente;
                temp.siguiente = null;
                agregarAColaFinal(temp);
            }
        }
    }

    // Método auxiliar interno para armar la cola final
    private void agregarAColaFinal(Pedido p) {
        if (frente == null) {
            frente = p;
        } else {
            fin.siguiente = p;
        }
        fin = p;
    }

    // Permite marcar un pedido como cancelado en cualquier momento[cite: 2]
    public boolean marcarComoCancelado(String nombreCliente) {
        Pedido actual = frente;
        while (actual != null) {
            if (actual.nombreCliente.equalsIgnoreCase(nombreCliente)) {
                actual.cancelado = true;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Retorna las ganancias totales sumando (cantidad * valor unitario), excluyendo cancelados[cite: 2]
    public double calcularGananciasTotales() {
        double gananciasTotales = 0.0;
        Pedido actual = frente;

        while (actual != null) {
            // Solo se consideran los pedidos que NO están cancelados[cite: 2]
            if (!actual.cancelado) {
                NodoProducto prodActual = actual.cabezaProductos;
                while (prodActual != null) {
                    gananciasTotales += (prodActual.producto.cantidad * prodActual.producto.valorUnitario);
                    prodActual = prodActual.siguiente;
                }
            }
            actual = actual.siguiente;
        }
        return gananciasTotales;
    }

    // Muestra toda la información almacenada en la cola de pedidos[cite: 2]
    public void mostrarCola() {
        if (frente == null) {
            System.out.println("La cola de pedidos está vacía.");
            return;
        }

        Pedido actual = frente;
        int contador = 1;
        System.out.println("\n===============COLA DE PEDIDOS=====================");
        

        while (actual != null) {
            System.out.println("Pedido N°: " + contador);
            System.out.println("Cliente: " + actual.nombreCliente + (actual.esPrime ? " [JUMBO PRIME]" : " [Normal]"));
            System.out.println("Dirección: " + actual.direccion);
            System.out.println("Método de Pago: " + actual.metodoPago);
            System.out.println("Estado: " + (actual.cancelado ? " CANCELADO" : "Activo"));
            System.out.println("Productos solicitados:");

            NodoProducto prodActual = actual.cabezaProductos;
            double subtotalPedido = 0;
            while (prodActual != null) {
                Producto p = prodActual.producto;
                double subtotalProd = p.cantidad * p.valorUnitario;
                subtotalPedido += subtotalProd;
                System.out.println("   - " + p.nombre + " | Cant: " + p.cantidad + " | V.Unit: $" + p.valorUnitario + " | Subtotal: $" + subtotalProd);
                prodActual = prodActual.siguiente;
            }
            System.out.println("Subtotal del Pedido: $" + subtotalPedido);
            System.out.println("--------------------------------------------------");
            actual = actual.siguiente;
            contador++;
        }
    }
}