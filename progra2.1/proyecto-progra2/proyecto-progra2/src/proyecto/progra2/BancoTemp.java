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
public class BancoTemp {
    private int id;
  private String Nombre_Banco;
  private String Pais;
  private String Ciudad;
 
   

  //metodos accesores

  //metodos get

  public int getId(){return id;} 
  public String getNombre_Banco(){return Nombre_Banco;}
  public String getPais(){return Pais;}
  public String getCiudad(){return Ciudad;}
  
  

  //metodos set

  public void setId(int id){this.id = id;}
  public void setNombre_Banco(String Nombre_Banco){this.Nombre_Banco = Nombre_Banco;} 
  public void setPais(String Pais){this.Pais= Pais;} 
  public void setCiudad(String Ciudad){this.Ciudad = Ciudad;} 
  
  

  //sobrescritura

  public String toString(){
    return id+","+Nombre_Banco+","+Pais+","+Ciudad;
  }
  

}
