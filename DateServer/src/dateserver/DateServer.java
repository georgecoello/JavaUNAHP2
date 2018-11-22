
package dateserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


public class DateServer {

    public static void main(String[] args) throws IOException {
        System.out.println("Inicializando servidor de Tiempo");
        ServerSocket listener = new ServerSocket(9090);
        try{
            while(true){
                System.out.println("Servidor esperando conexion de cliente...");
                Socket socket = listener.accept();
                System.out.println("Conexion Aceptada");
                Scanner entrada = null;
                try{
                    System.out.println("Enviando paquete con Fecha y Hora");
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                    out.println(new Date().toString());
                    
                    BufferedReader input = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                    entrada = new Scanner(new FileReader(input.readLine()));
                    
                    while(entrada.hasNext()){
                        out.println(entrada.nextLine());
                        System.err.println(input.readLine());
                    }
                }finally {
                    entrada.close();
                    socket.close();
                    System.out.println("Conexion con el servidor terminada...");
                }
            }
        }finally{
            listener.close();
        }
    }
    
}
