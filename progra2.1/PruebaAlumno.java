 public class PruebaAlumno
{
  //metodo principal de la clase 
  public static void main(String [] args)
 {
    Alumno estudiante = new Alumno();

  System.out.println(estudiante.getNumeroDeCuenta());
  System.out.println(estudiante.getNombreApellido());
  System.out.println(estudiante.getCarrera());
  System.out.println(estudiante.getPromedioActual());


  estudiante.setNumeroDeCuenta(99999);
  estudiante.setNombreApellido("pablo Marmol");
  estudiante.setCarrera("Ingenieria Mecanica");
  estudiante.setPromedioActual(89.87f);
   
   System.out.println("--------------------------");
   System.out.println(estudiante.getNumeroDeCuenta());
   System.out.println(estudiante.getNombreApellido());
   System.out.println(estudiante.getCarrera());
   System.out.println(estudiante.getPromedioActual());

    System.out.println("-------------------------------");
   Alumno colegial= new Alumno(9999,"Maria fernanda","ing sistemas",78.00f);

   System.out.println(colegial);

 


 } 

}