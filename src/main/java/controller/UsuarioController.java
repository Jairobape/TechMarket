package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String email, String contrasena) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuario where email = '" + email
                + "' and contrasena = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String rol = rs.getString("rol");
       

                Usuario usuario
                        = new Usuario(id_usuario, email, contrasena, nombre, apellido, rol);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
    
    

    @Override
    public String register(String email, String contrasena, String nombre, String apellido) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = " INSERT INTO `usuario`(`email`,`contrasena`,`nombre`,`apellido`) VALUES" +
"	('"+email+"', '"+contrasena+"', '"+nombre+"', '"+apellido+"')";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            
       

                Usuario usuario
                        = new Usuario(12 , email, contrasena, nombre, apellido, "cliente");
                st.close();
                return gson.toJson(usuario); 
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String pedir(String email) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where email = '" + email + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String contrasena = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String rol = rs.getString("rol");
       

                Usuario usuario
                        = new Usuario(id_usuario, email, contrasena, nombre, apellido, rol);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    
   
}