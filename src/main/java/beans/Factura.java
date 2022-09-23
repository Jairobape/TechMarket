
package beans;

import java.sql.Date;

public class Factura {
    private int id_factura;
    private int id_usuario;
    private Date fecha;
    private String metodo_de_pago;

    public Factura(int id_factura, int id_usuario, Date fecha, String metodo_de_pago) {
        this.id_factura = id_factura;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.metodo_de_pago = metodo_de_pago;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodo_de_pago() {
        return metodo_de_pago;
    }

    public void setMetodo_de_pago(String metodo_de_pago) {
        this.metodo_de_pago = metodo_de_pago;
    }

    @Override
    public String toString() {
        return "Factura{" + "id_factura=" + id_factura + ", id_usuario=" + id_usuario + ", fecha=" + fecha + ", metodo_de_pago=" + metodo_de_pago + '}';
    }
    
    
}
