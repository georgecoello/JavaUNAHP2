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
public class ClienteTemp {
    private int id;
  private String nombre_apellido;
  private char tipo;
   

  //metodos accesores

  //metodos get

  public int getId(){return id;} 
  public String getNombre_Apellido(){return nombre_apellido;}
  public char getTipo(){return tipo;}
  

  //metodos set

  public void setId(int id){this.id = id;}
  public void setNombre_Apellido(String nombre_apellido){this.nombre_apellido = nombre_apellido;} 
  public void setTipo(char tipo){this.tipo = tipo;}
  

  //sobrescritura

  public String toString(){
    return id+","+nombre_apellido+","+tipo;
  }
  


}
