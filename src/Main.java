public class Main {
    public static void main(String[] args) {
        // Crear cliente, productos y venta
        Cliente cliente = new Cliente(1, "Juan Perez", "Calle Falsa 123");
        Producto p1 = new Producto(1, "Lápiz", 2.5, 10);
        Producto p2 = new Producto(2, "Cuaderno", 15.5, 5);
        Producto p3 = new Producto(3, "Borrador", 12.5, 0); // sin stock
        Venta venta = new Venta(1001, cliente, "2025-10-15");

        // (DEBUG) Mostrar estado de stock inicial
        System.out.println("--- Stock inicial ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // (DEBUG) Mostrar estado inicial de la venta
        System.out.println("--- Agregando productos a la venta ---");
        System.out.println("Agregando 3 lápices: " + venta.agregarProducto(p1, 3));
        System.out.println("Agregando 2 cuadernos: " + venta.agregarProducto(p2, 2));
        System.out.println("Agregando 1 borradores: " + venta.agregarProducto(p3, 1));

        // (DEBUG) Mostrar estado final de la venta y stock
        System.out.println("--- Estado de la venta ---");
        System.out.println("Venta actual:");
        System.out.println(venta);

        // (DEBUG) Mostrar detalles de la venta e iterarlos
        System.out.println("--- Detalles de la venta ---");
        System.out.println("Detalles de la venta:");
        for (DetalleVenta d : venta.getDetalles()) {
            System.out.println(d);
        }

        // Mostrar totales
        System.out.println("--- Totales ---");
        System.out.println("Total (recalculado): " + venta.calcularTotal());
        System.out.println("Total (almacenado): " + venta.getTotal());

        // (DEBUG) Mostrar estado final de stock
        System.out.println("--- Stock final ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}

