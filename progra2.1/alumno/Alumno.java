public class Alumno
{
  //propiedades de la clase Alumno

  private int numero_de_cuenta;
  private String nombre_apellido;
  private String carrera;
  private float promedio_actual;
    //Constructores
     
 
  public Alumno()
   {
   numero_de_cuenta();
   nombre_apellido();
   carrera();
   promedio_actual();
   }
  

  public Alumno (int numero_de_cuenta, String nombre_apellido, String carrera, float promedio_actual)
 {
  this.numero_de_cuenta = numero_de_cuenta;
  this.nombre_apellido = nombre_apellido;
  this.carrera = carrera;
  this.promedio_actual = promedio_actual; 
 }
  //metodos Accesores

  public int getNumeroDeCuenta()
  {
    return numero_de_cuenta;
  }
  public String getNombreApellido()
  {
    return nombre_apellido;
  }
  public String getCarrera()
  {
    return carrera;
  }
  public float getPromedioActual()
  {
    return promedio_actual;
  }
  public void setNumeroDeCuenta(int numero_de_cuenta)
  {
    this.numero_de_cuenta = numero_de_cuenta;
  }
 public void setNombreApellido(String nombre_apellido)
{ 
   this.nombre_apellido = nombre_apellido;
}
 public void setCarrera(String carrera)
{
   this.carrera = carrera;
}
 public void setPromedioActual(float promedio_actual)
{
  this.promedio_actual = promedio_actual;
 }
  //sobre escritura del metodo toString()

      public String toString()
{ 
 return numero_de_cuenta+ " "+ nombre_apellido +" "+carrera +" "+ promedio_actual;

}

}
