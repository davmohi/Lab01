package LogicaNegocio;


import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Producto {

    int codigo;
    String nombre;
    Boolean importado;
    BigDecimal precio;
    String tipo;

    public Producto(int codigo, String nombre, Boolean importado, BigDecimal precio, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.importado = importado;
        this.precio = precio;
        this.tipo = tipo;
    }

    

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }
     
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
      public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
      public BigDecimal getPrecio(){
        return precio;
    }
    
    public void setPrecio(BigDecimal precio){
        this.precio = precio;
    }
      public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
