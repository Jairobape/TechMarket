
package beans;


public class Usuario {
    
    private int id_usuario;
    private String email;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String rol;

    public Usuario(int id_usuario, String email, String contrasena, String nombre, String apellido, String rol) {
        this.id_usuario = id_usuario;
        this.email = email;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String password) {
        this.contrasena = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", email=" + email + ", contraseña=" + contrasena + ", nombre=" + nombre + ", apellido=" + apellido + ", rol=" + rol + '}';
    }
    
    
    
}
