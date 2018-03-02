/*
 * Serviciocontacto.java
 *
 * Created on 27 de abril de 2007, 10:41 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package AccesoDatos;

import LogicaNegocio.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author Estudiante
 */
public class ServicioProducto extends Servicio {
     
     private static final String INSERTARproducto = "{call agregarProducto(?,?,?,?,?)}";
     private static final String ALLproductos = "{call getAllProducto()}";
     private static final String BUSCARproducto = "{call getProducto(?)}";
     private static final String Eliminarproducto = "{call eliminarProducto(?)}";
     private static final String ACTUALIZARproducto ="{call editarProducto(?,?,?,?,?)}";  
     
     private static ServicioProducto singleton;
     
     
     public static ServicioProducto getServicioProducto(){
         if(singleton==null)
             singleton=new ServicioProducto();
         return singleton;
     }
    /**
     * Creates a new instance of Servicioproducto
     */
    private ServicioProducto() {
    }
    
   
    public boolean insertarproducto(Producto producto) throws GlobalException, NoDataException  {
        boolean resp=true;
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            resp=false;
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            resp=false;
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
         CallableStatement pstmt=null;  
                                
        try {
            pstmt = conexion.prepareCall(INSERTARproducto);                                    
            pstmt.setInt(1,producto.getCodigo());
            pstmt.setString(2,producto.getNombre());
            pstmt.setBoolean(3,producto.getImportado());
            pstmt.setBigDecimal(4,producto.getPrecio());
            pstmt.setString(5,producto.getTipo());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                resp=false;
                throw new NoDataException ("No se realizo la inserci�n");
            } 
            
        } catch (SQLException e) {
            e.printStackTrace();
            resp=false;
            throw new GlobalException("Llave duplicada");
        } 
         finally {
            try {
                if (pstmt != null) {
                    pstmt.close();                    
                }
                desconectar();
            } catch (SQLException e) {
                resp=false;
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
         return resp;
    }
    
    public void actualizarproducto(Producto producto ) throws GlobalException, NoDataException  {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(ACTUALIZARproducto);
            pstmt.setInt(1,producto.getCodigo());
            pstmt.setString(2,producto.getNombre());
            pstmt.setBoolean(3,producto.getImportado());
            pstmt.setBigDecimal(4,producto.getPrecio());
            pstmt.setString(5,producto.getTipo());

            int resultado = pstmt.executeUpdate();
            
            //si es diferente de 0 es porq si afecto un registro o mas
            if (resultado == 0) {
                throw new NoDataException ("No se realizo la actualizaci�n");
            }
            else{
               System.out.println("\nModificaci�n Satisfactoria!");
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }     
    
    public ArrayList<Producto> allproductos() throws GlobalException, NoDataException  {
     
    try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Producto producto = null;
        CallableStatement pstmt=null;  
        try {            
            pstmt = conexion.prepareCall(ALLproductos);                
            pstmt.execute();
            rs = (ResultSet)pstmt.getResultSet(); 
            while (rs.next()) {
                producto = new Producto(rs.getInt("codigo"),
                                       rs.getString("nombre"),
                                       rs.getBoolean("importado"),
                                       rs.getBigDecimal("precio"),
                                       rs.getString("tipo")
						   );
                coleccion.add(producto);
            }
        } catch (SQLException e) {
          e.printStackTrace();
            
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (coleccion == null || coleccion.size() == 0) {
            throw new NoDataException("No hay datos");
        }
        return coleccion;
 }
 public Producto buscarproducto(int codigo) throws GlobalException, NoDataException  {
     
    try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        Producto producto = null;
        CallableStatement pstmt=null;  
        try {            
            pstmt = conexion.prepareCall(BUSCARproducto); 
            pstmt.setInt(1,codigo);
            pstmt.execute();
            rs = (ResultSet)pstmt.getResultSet(); 
            if (rs.next()) {
                producto = new Producto(rs.getInt("codigo"),
                                       rs.getString("nombre"),
                                       rs.getBoolean("importado"),
                                       rs.getBigDecimal("precio"),
                                       rs.getString("tipo")
						   );
            }
        } catch (SQLException e) {
          e.printStackTrace();
            
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (producto == null) {
            throw new NoDataException("No encontrado");
        }
        return producto;
 }
    
  public void eliminarproducto(int id ) throws GlobalException, NoDataException  {
     
    try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        CallableStatement pstmt=null;  
        try {            
            pstmt = conexion.prepareCall(Eliminarproducto);                
            pstmt.setInt(1,id);            
            pstmt.execute();
            rs = (ResultSet)pstmt.getResultSet(); 
          
        } catch (SQLException e) {
          e.printStackTrace();
            
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
 }

}
