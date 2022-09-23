package beans;


public class Producto {
    private int id_producto;
    private String producto;
    private String categoria;
    private double precio;
    private int stock;

    public Producto(int id_producto, String producto, String categoria, double precio, int stock) {
        this.id_producto = id_producto;
        this.producto = producto;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", producto=" + producto + ", categoria=" + categoria + ", precio=" + precio + ", stock=" + stock + '}';
    }
    
    
}
