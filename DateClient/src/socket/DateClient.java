
package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import javax.swing.JOptionPane;

public class DateClient {

    public static void main(String[] args) throws IOException, InterruptedException{
        String serverAddress = JOptionPane.showInputDialog(
                "Ingrese la IP de la maquina en donde \n"
   + "está siendo ejecutado el servidor de frcha y hora en el puerto 9090:  ");
        Socket s =new Socket (serverAddress, 9090);
          PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer =input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        String nombre_archivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo remoto: "); 
        out.println(nombre_archivo); 
        Thread.sleep(100);
        
      while(input.ready())
          System.out.println(input.readLine());
        System.err.println("Jorge Coello");
        System.exit(0);
    }   
}
