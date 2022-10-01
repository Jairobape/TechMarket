
package beans;

import java.sql.Date;

public class Factura {
    private int id_factura;
    private int id_usuario;
    private Date fecha;


    public Factura(int id_factura, int id_usuario, Date fecha) {
        this.id_factura = id_factura;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
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

   

    @Override
    public String toString() {
        return "Factura{" + "id_factura=" + id_factura + ", id_usuario=" + id_usuario + ", fecha=" + fecha +  '}';
    }
    
    
}
