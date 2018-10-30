
package archivo_texto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Archivo_Texto {

 
    public static void main(String[] args) {
        try {
            PrintWriter salida= new PrintWriter("ARCHIVO.TXT");
            salida.println("Hola Mundo desde un archivo de Texto...");
            salida.close();
            Scanner entrada = new Scanner(new FileReader("ARCHIVO.TXT"));
            //entrada.nextLine();//para la lectura del archivo
            System.out.println("String Leido desde el Archivo -->"+entrada.nextLine());
            entrada.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Problemas con el archivo...."); 
        }
    }
    
}
