 public class PruebaAlumno
{
  //metodo principal de la clase 
  public static void main(String [] args)
 {
    Alumno estudiante = new Alumno();
    Alumno estudiante1= new Alumno();

  estudiante1.setNumeroDeCuenta(99999);
  estudiante1.setNombreApellido("peter el crack");
  estudiante1.setCarrera("Ingenieria Sistema");
  estudiante1.setPromedioActual(89.87f);
    
  System.out.println(estudiante1.getNumeroDeCuenta());
  System.out.println(estudiante1.getNombreApellido());
  System.out.println(estudiante1.getCarrera());
  System.out.println(estudiante1.getPromedioActual());

   estudiante.setNumeroDeCuenta(99999);
  estudiante.setNombreApellido("pablo Marmol");
  estudiante.setCarrera("Ingenieria Mecanica");
  estudiante.setPromedioActual(89.87f);
   
   
   System.out.println("--------------------------");
   System.out.println(estudiante.getNumeroDeCuenta());
   System.out.println(estudiante.getNombreApellido());
   System.out.println(estudiante.getCarrera());
   System.out.println(estudiante.getPromedioActual());

 


 } 

}