public class PruebaEstudiante
{
 public static void main(String [] args)
 {
   Estudiante estudiante= new Estudiante();
   estudiante.setNombreApellido("Maria Antonieta");
   estudiante.setAltura(1.85f);
   estudiante.setEdad(23);
   estudiante.setNcuenta(123456);
   estudiante.setCarrera("Doctorado Sicologia");
   estudiante.setPromedioActual(96.98f);
   
   System.out.println(estudiante);
   Estudiante colegial= new Estudiante("Karla Alvarenga",1.99f,23,345678,"bachillerato en computacion",85.45f);

   System.out.println(colegial);

 }


}