
package controller;


public interface IUsuarioController {
    public String login(String email, String contrasena);
    public String register(String username, String contrasena, 
            String nombre, String apellidos);
    public String pedir(String email);
}
