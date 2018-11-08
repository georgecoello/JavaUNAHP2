public class Persona
{
 private String nombre_apellido;  
 private float altura;
 private int edad;
 
  public Persona(){}
  public Persona(String nombre_apellido,float altura,int edad)
  {
   this.nombre_apellido=nombre_apellido;
   this.altura=altura;
   this.edad=edad;


  }

 public String getNombreApellido()
  {return this.nombre_apellido;}
 public float getAltura()
 {return this.altura;}
 public int getEdad()
 {return this.edad;}

 public void setNombreApellido(String nombre_apellido)
 {this.nombre_apellido=nombre_apellido;}
 public void setAltura(float altura)
 {this.altura=altura;}
 public void setEdad(int edad)
 {this.edad=edad;}
 

}