/*
 * GlobalException.java
 *
 * Created on 27 de abril de 2007, 10:44 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package AccesoDatos;

/**
 *
 * @author Estudiante
 */
public class GlobalException extends java.lang.Exception {
    
    /** Creates a new instance of GlobalException */
    public GlobalException() {
    }
    
    public GlobalException(String msg)
    {
        super(msg);
    }
    
}
