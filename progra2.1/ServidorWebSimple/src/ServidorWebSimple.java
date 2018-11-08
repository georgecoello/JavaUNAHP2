// Se importan los paquetes java.io y java.net
// También se importa el paquete java.util que contiene la clase StringTokenizer que es la utilizada para 
// analizar sintácticamente los mensajes de solicitud HTTP

import java.io.*;
import java.net.*;
import java.util.*;

class ServidorWebSimple {

    public static void main(String argv[]) throws Exception {

        // El objeto lineaDeLaSolicitudHttp es una cadena que contiene
        // la primera linea del mensaje de solicitud HTTP
        // El objeto nombreArchivo contendrá el nombre del archivo solicitado
        String lineaDeLaSolicitudHttp;
        String nombreArchivo;

        // El socket socketdeEscucha atenderá servicios en el puerto 6789 
        ServerSocket socketdeEscucha = new ServerSocket(6789);

        // el método accept() de socketdeEscucha craerá un nuevo objeto: socketdeConexion
        Socket socketdeConexion = socketdeEscucha.accept();

        // ahora se crean dos "streams": mensajeDesdeCliente y mensajeParaCliente
        BufferedReader mensajeDesdeCliente
                = new BufferedReader(new InputStreamReader(
                        socketdeConexion.getInputStream()));
        DataOutputStream mensajeParaCliente
                = new DataOutputStream(
                        socketdeConexion.getOutputStream());

        // se lee la primera linea del mensaje HTTP
        // se supone que esta linea tiene la forma: 
        //      GET nombre_archivo HTTP/1.0
        lineaDeLaSolicitudHttp = mensajeDesdeCliente.readLine();

        // Ahora el servidor debe analizar la línea para extraer el nombre 
        //del archivo solicitado
        // El objeto lineaSeparada puede imaginarse como la linea de la solicitud HTTP
        // separa en tres partes: "GET", "nombre_archivo" y "HTTP/1.0"
        StringTokenizer lineaSeparada
                = new StringTokenizer(lineaDeLaSolicitudHttp);

        // Se comprueba que la primera parte de lineaSeparada sea el método GET
        if (lineaSeparada.nextToken().equals("GET")) {

            // Si el método es GET, entonces la siguiente palabra es el nombre
            // del archivo que el browser está solicitando 
            nombreArchivo = lineaSeparada.nextToken();

            // Si el nombre del archivo trae un slash "/", se quita
            if (nombreArchivo.startsWith("/") == true) {
                nombreArchivo = nombreArchivo.substring(1);
            }

            File archivo = new File(nombreArchivo);

            // La siguiente línea asocia un "stream", archivoDeEntrada, al archivo nombreArchivo
            FileInputStream archivoDeEntrada = new FileInputStream(nombreArchivo);

            // las siguientes dos líneas determinan el tamaño del archivo y construyen 
            // un arreglo de bytes de ese tamaño
            int cantidadDeBytes = (int) archivo.length();
            byte[] archivoEnBytes = new byte[cantidadDeBytes];

            // La siguiente línea lee desde el "stream" archivoDeEntrada y lo
            // coloca en el arreglo archivoEnBytes
            archivoDeEntrada.read(archivoEnBytes);

            // ahora el servidor se dispone a construir el mensaje de respuesta
            // para el browser, colocando la línea de respuesta en el "stream" mensajeParaCliente
            mensajeParaCliente.writeBytes("HTTP/1.0 200 Document Follows\r\n");

            // las siguientes líneas crean los encabezados del mensaje HTTP
            // en caso de enviar una imagen en formato GIF o en formato JPEG
            if (nombreArchivo.endsWith(".jpg")) {
                mensajeParaCliente.writeBytes("Content-Type: image/jpeg\r\n");
            }
            if (nombreArchivo.endsWith(".gif")) {
                mensajeParaCliente.writeBytes("Content-Type: image/gif\r\n");
            }

            // Construye luego el encabezado para indicar la longitud del archivo
            mensajeParaCliente.writeBytes("Content-Length: " + cantidadDeBytes + "\r\n");

            // Ahora envia la linea en blanco que estipula el RFC de HTTP/1.0
            mensajeParaCliente.writeBytes("\r\n");

            // Finalmente envía el archivo solicitado al cliente
            mensajeParaCliente.write(archivoEnBytes, 0, cantidadDeBytes);

            // Después de enviar el archivo, el servidor cierra el socket de conexión
            socketdeConexion.close();

        }
    }
}
