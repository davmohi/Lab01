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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class testServicioProducto {
    public static void main(String arg[]){
        Producto p = new Producto(3,"2",false,BigDecimal.valueOf(3),"3");
        ArrayList<Producto> coleccion = new ArrayList();
        
        ServicioProducto s=ServicioProducto.getServicioProducto(); // asi es como se crea un objeto de servicio producto
        
        try {
            s.insertarproducto(p);
            
            //s.actualizarproducto(p);
            
            /*
            coleccion=s.allproductos();
            for(Producto cursor: coleccion) {
                System.out.println(cursor.toStrint()+'\n');
              }
            */
            
            //System.out.println(s.buscarproducto(3).toStrint());
            
            //s.eliminarproducto(3);
        
        } catch (GlobalException ex) {
            Logger.getLogger(testServicioProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoDataException ex) {
            Logger.getLogger(testServicioProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
