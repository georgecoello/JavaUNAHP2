public class Estudiante extends Persona
{
 private int ncuenta;
 private String carrera;
 private float promedio_actual;
 
 public Estudiante(){}
 public Estudiante(String nombre_apellido,float altura,int edad, int ncuenta,String carrera,float promedio_actual)
 {
   super(nombre_apellido,altura,edad);
  this.ncuenta=ncuenta;
  this.carrera=carrera;
  this.promedio_actual=promedio_actual; 

 }



 public int getNcuenta(){ return this.ncuenta; }
 public String getCarrera(){ return this.carrera; }
 public float getPromedioActual(){ return this.promedio_actual; }
 
 public void setNcuenta(int ncuenta){ this.ncuenta=ncuenta; }
 public void setCarrera(String carrera){ this.carrera=carrera; }
 public void setPromedioActual(float promedio_actual){ this.promedio_actual=promedio_actual; }

 public String toString()
  {
    return getNombreApellido()+"|"+getAltura()+"|"+getEdad()+"|"+getNcuenta()+"|"+getCarrera()+"|"+getPromedioActual();


  }
}