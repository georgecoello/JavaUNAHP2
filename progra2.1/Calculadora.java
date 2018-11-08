import java.util.Scanner;
 public class Calculadora{
 public static void main(String [] args){
  Scanner entrada= new Scanner (System.in);
  Scanner entrada1= new Scanner (System.in);
  Float numero1,numero2, suma=0.00f,resta=0.00f,multiplicacion=0.00f, division =0.00f;
  int opcion=0;
  System.out.println("ingrese un numero");
  numero1=entrada.nextFloat();
  System.out.println("ingrese otro numero");
  numero2=entrada.nextFloat();
 
  System.out.println(" 1 : suma");
  System.out.println(" 2 : resta");
  System.out.println(" 3 : multiplicacion");
  System.out.println(" 4 : division");
  opcion=entrada1.nextInt();
   resta=numero1-numero2;

   switch(opcion){
    case 1: 
      suma=numero1+numero2;
     System.out.println("la suma es: "+suma);
    
     
     
    break;
   
    case 2:
       resta=numero1-numero2;
      System.out.println("la resta es: "+resta);

    break;

    case 3:
    
     multiplicacion= numero1*numero2;
     System.out.println("la multiplicacion es: "+multiplicacion);
    break;
  
    case 4:
     
      division= numero1/numero2; 
       System.out.println("la division es: "+division);
    break;
    
   default: System.out.println("el numero no esta dentro de las opcion");
  }
}


}