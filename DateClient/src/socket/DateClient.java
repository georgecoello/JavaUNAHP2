
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class DateClient {

    public static void main(String[] args) throws IOException{
        String serverAddress = JOptionPane.showInputDialog(
                "Ingrese la IP de la maquina en donde \n"
   + "está siendo ejecutado el servidor de frcha y hora en el puerto 9090:  ");
        Socket s =new Socket (serverAddress, 9090);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer =input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
        
    }   
}
