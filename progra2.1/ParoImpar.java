import java.util.Scanner;
public class ParoImpar {
   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingresa un numero ");
        int a = sc.nextInt();
        if(a%2==0){
             System.out.println(a+" es par");
        }else{
            System.out.println(a+" es impar");
        }      
     }
}