public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Verifica que la cantidad sea positiva y que haya stock suficiente
    public boolean reducirStock(int cantidad) {
        if (cantidad <= 0) return false;
        if (cantidad > stock) return false;
        stock -= cantidad;
        return true;
    }

    // Permite aumentar el stock
    public void aumentarStock(int cantidad) {
        if (cantidad > 0) stock += cantidad;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio + ", stock=" + stock + "}";
    }
}
