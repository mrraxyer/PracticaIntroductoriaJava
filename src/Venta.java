import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int id;
    private Cliente cliente;
    private String fecha;
    private List<DetalleVenta> detalles;
    private double total;

    // Constructor con detalles
    public Venta(int id, Cliente cliente, String fecha, List<DetalleVenta> detalles) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.detalles = (detalles != null) ? detalles : new ArrayList<>();
        this.total = calcularTotal();
    }

    // Constructor sin detalles
    public Venta(int id, Cliente cliente, String fecha) {
        this(id, cliente, fecha, new ArrayList<>());
    }

    // Agrega un producto a la venta si hay stock suficiente.
    public boolean agregarProducto(Producto producto, int cantidad) {
        // Reducir stock del producto
        boolean reduccionPosible = producto.reducirStock(cantidad);
        if (!reduccionPosible) {
            return false;
        }

        // Crear detalle y añadirlo
        DetalleVenta detalle = new DetalleVenta(producto, cantidad);
        detalles.add(detalle);

        // Actualizar total
        total += detalle.getSubtotal();
        return true;
    }

    // Recalcula el total sumando subtotales
    public double calcularTotal() {
        double suma = 0.0;
        for (DetalleVenta d : detalles) {
            suma += d.getSubtotal();
        }
        return suma;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Venta{id=" + id + ", cliente=" + cliente.getNombre() + ", fecha='" + fecha + "', total=" + total + ", detalles=" + detalles + "}";
    }
}
