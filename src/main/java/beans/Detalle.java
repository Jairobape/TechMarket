
package beans;


public class Detalle {
    private int id_detalle;
    private int id_factura;
    private int id_producto;
    private int cantidad;
    private double total;

    public Detalle(int id_detalle, int id_factura, int id_producto, int cantidad, double total) {
        this.id_detalle = id_detalle;
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setPrecio(double precio) {
        this.total = precio;
    }

    @Override
    public String toString() {
        return "Detalle{" + "id_detalle=" + id_detalle + ", id_factura=" + id_factura + ", id_producto=" + id_producto + ", cantidad=" + cantidad + ", total=" + total + '}';
    }
    
    
}
