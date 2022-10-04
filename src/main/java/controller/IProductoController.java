
package controller;

import java.util.List;


public interface IProductoController {
    public String listar();
    public String listarAdmin(boolean ordenar, String orden);
    public String comprar(String email, String[] ids, String[] cantidades);
    public String pedir(String id);
    public String modificar(int id, String nuevoProductoN, String nuevaCategoria,
            double nuevoPrecio, int nuevoStock, String nuevaDescripcion,
            String nuevaImagenPath);
    public String eliminar(int idProducto);
    public String agregar(String productoN, String categoria, double precio, int stock, String descripcion, String imagenPath);
}
