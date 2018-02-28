/*
 * Servicio.java
 *
 * Created on 25 de abril de 2007, 03:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package AccesoDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Servicio {

    protected Connection conexion= null;
    
    public Servicio() {
        
    }
    
    public void conectar() throws SQLException,ClassNotFoundException 
    {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab1BD","root","root" );
    }
    
    protected void desconectar() throws SQLException{
        if(!conexion.isClosed())
        {
            conexion.close();
        }
    }

    private Connection getJdbcMydbsource() throws NamingException {
        Context c = new InitialContext();
        try {
            return ((DataSource) c.lookup("jdbc/Mydbsource")).getConnection();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}