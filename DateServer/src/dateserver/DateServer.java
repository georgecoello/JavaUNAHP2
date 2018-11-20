
package dateserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class DateServer {

    public static void main(String[] args) throws IOException {
        System.out.println("Inicializando servidor de Tiempo");
        ServerSocket listener = new ServerSocket(9090);
        try{
            while(true){
                System.out.println("Servidor esperando conexion de cliente...");
                Socket socket = listener.accept();
                System.out.println("Conexion Aceptada");
                try{
                    System.out.println("Enviando paquete con Fecha y Hora");
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                    out.println(new Date().toString());
                }finally {
                    socket.close();
                    System.out.println("Conexion con el servidor terminada...");
                }
            }
        }finally{
            listener.close();
        }
    }
    
}
