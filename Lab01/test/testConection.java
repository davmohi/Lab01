/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
import AccesoDatos.Servicio;
import java.sql.SQLException;

public class testConection{
    public static void main(String arg[]){
        Servicio s= new Servicio();
        try {
            s.conectar();
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha localizado el driver: "+e);
        } catch (SQLException e) {
            System.out.println("La base de datos no se encuentra disponible: "+e);
        }
    }
}
