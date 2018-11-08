/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.progra2;

/**
 *
 * @author Invitado
 */
public class CuentaTemp {
    private int id;
    private String Descripcion;
    private char Moneda;
    private String Tipo_Cuenta;

  //metodos accesores

  //metodos get

  public int getId(){return id;} 
  public String getDescripcion(){return Descripcion;}
  public char getMoneda(){return Moneda;}
  public String getTipo_Cuenta(){return Tipo_Cuenta;}

  //metodos set

  public void setId(int id){this.id = id;}
  public void setDescripcion(String Descripcion){this.Descripcion = Descripcion;} 
  public void setMoneda(char Moneda){this.Moneda = Moneda;}
  public void setTipo_Cuenta(String Tipo_Cuenta){this.Tipo_Cuenta = Tipo_Cuenta;} 

  //sobrescritura

  public String toString(){
    return id+","+Descripcion+","+Moneda+","+Tipo_Cuenta;
  }

    void setPrecio(int Precio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
