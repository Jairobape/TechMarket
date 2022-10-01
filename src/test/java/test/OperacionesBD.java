package test;

import beans.Producto;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {
    
    public static void main(String[]args){
        listarProducto();
    }
    
   
    
    public static void listarProducto(){
        DBConnection con = new DBConnection();
        String sql = " SELECT * FROM producto ";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id_producto = rs.getInt("id_producto");
                String producto = rs.getString("producto");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                
                Producto productos = new Producto(id_producto, producto, categoria, precio, stock);
                System.out.println(producto.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            con.desconectar();
        }
    }
}