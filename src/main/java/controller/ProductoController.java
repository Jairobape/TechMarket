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

   
    
}
