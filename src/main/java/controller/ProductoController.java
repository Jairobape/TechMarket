/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import beans.Producto;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ProductoController implements IProductoController{

    @Override
    public String listar() {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from producto";

        

        List<String> productos = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id_producto = rs.getInt("id_producto");
                String productoN = rs.getString("producto");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                String descripcion = rs.getString("descripcion");
                String imagenPath = rs.getString("imagen_path");
                        
                System.out.println(id_producto);

                Producto producto = new Producto(id_producto, productoN, categoria, precio, stock, descripcion, imagenPath);
                
                productos.add(gson.toJson(producto));
            

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(productos);
    }



    @Override
    public String comprar(String email, String[] ids, String[] cantidades) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String listarAdmin(boolean ordenar, String orden) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from producto";

        if (ordenar == true) {
            sql += " order by categoria " + orden;
        }

        List<String> productos= new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id_producto = rs.getInt("id_producto");
                String productoN = rs.getString("producto");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                String descripcion = rs.getString("descripcion");
                String imagenPath = rs.getString("imagen_path");
                        

                Producto producto = new Producto(id_producto, productoN, categoria, precio, stock, descripcion, imagenPath);

                productos.add(gson.toJson(producto));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(productos);
    }

    @Override
    public String pedir(String id) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from producto where id_producto = '" + id + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id_producto = rs.getInt("id_producto");
                String productoN = rs.getString("producto");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                String descripcion = rs.getString("descripcion");
                String imagenPath = rs.getString("imagen_path");
       

                Producto producto = new Producto(id_producto, productoN, categoria, precio, stock, descripcion, imagenPath);
                return gson.toJson(producto);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String modificar(int id, String nuevoProductoNombre, String nuevaCategoria, double nuevoPrecio, int nuevoStock, String nuevaDescripcion, String nuevaImagenPath) {
        DBConnection con = new DBConnection();

        String sql = "Update producto set producto = '" + nuevoProductoNombre
                + "', categoria = '" + nuevaCategoria + "', "
                + "precio = " + nuevoPrecio + ", stock = "
                + nuevoStock + ", descripcion = '" + nuevaDescripcion+ "', imagen_path = '"
                + nuevaImagenPath +"'"
                + " where id_producto = '" + id + "'";

        

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String eliminar(int idProducto) {
        DBConnection con = new DBConnection();

        String sql1 = "Delete from producto where id_producto = '" + idProducto + "'";
        //String sql2 = "Delete from factura where id_producto = '" + idProducto + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql1);
            //st.executeUpdate(sql2);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String agregar(String productoN, String categoria, double precio, int stock, String descripcion, String imagenPath) {
        DBConnection con = new DBConnection();

        String sql = " INSERT INTO `producto`(`producto`,`categoria`,`precio`,`stock`,`descripcion`,`imagen_path`) VALUES" +
                    "('"+productoN+"', '"+categoria+"', '"+precio+"', '"+stock+"', '"+descripcion+"', '"+imagenPath+"')";
     

        

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    

   
    
}
