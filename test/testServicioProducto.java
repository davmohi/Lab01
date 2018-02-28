/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import AccesoDatos.ServicioProducto;
import LogicaNegocio.Producto;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
public class testServicioProducto {
    public static void main(String arg[]){
        Producto p = new Producto(3,"3",false,BigDecimal.valueOf(3),"3");
        ServicioProducto s= new ServicioProducto();
        try {
            s.insertarproducto(p);
        } catch (GlobalException ex) {
            Logger.getLogger(testServicioProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoDataException ex) {
            Logger.getLogger(testServicioProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
