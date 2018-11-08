package dateserver;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {

    public static void main(String[] args) throws IOException {
        System.out.println("Inicializando Servidor de Tiempo");
        try (ServerSocket listener = new ServerSocket(9090)) {
            while (true) {
                System.out.println("Servidor esperando Conexion de Cliente........");
                Socket socket = listener.accept();
                System.out.println("Connexion Acceptada.....");
                try {
                    System.out.println("Enviado paquete Con Fecha y Hora....");
                    PrintWriter out
                            = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                    System.out.println("Connexion con servidor terminada.....");
                }
            }
        }
    }
}
