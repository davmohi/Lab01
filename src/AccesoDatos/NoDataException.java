/*
 * NoDataException.java
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
public class NoDataException extends java.lang.Exception {
    
    /** Creates a new instance of NoDataException */
    public NoDataException() {
    }
    
    public NoDataException(String msg) {
        super(msg);
    }
}
