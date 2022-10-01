
package controller;

import java.util.List;


public interface IProductoController {
    public String listar();
    public String comprar(String email, List carrito);
}
