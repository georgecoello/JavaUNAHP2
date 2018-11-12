/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacionprograii;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class SerializacionPrograII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try {
            //PREPARANDO ARCHIVO BINARIO Y CONECTANDO AL PROGRAMA JAVA
            ObjectOutputStream objeto_escribir = new ObjectOutputStream(new FileOutputStream("ARCHIVO.BIN"));
            objeto_escribir.writeObject(new Alumno(1234, "Ingenieria en Sistemas", 2018, 99.87f));
            objeto_escribir.writeObject(new Alumno(4351,"Medicina",2016,96.5f));
            objeto_escribir.close();
            //Creando la infraestructura para abrir el archivo binario y leer los datos en el
            ObjectInputStream objeto_leer = new ObjectInputStream(new FileInputStream("ARCHIVO.BIN"));
            Alumno mi_alumno= (Alumno) objeto_leer.readObject();
            objeto_leer.close();
            
            //Imprimir y mostrar en pantalla el archivo desaerializado
            System.out.println(mi_alumno);
        }catch(FileNotFoundException ex){
            System.err.println("Error en la Apertura del Archivo...");
        }catch (IOException ex) {
            System.err.println("Error de Entrada/Salida...");
        }catch (ClassNotFoundException ex){
            System.err.println("La clase alumno no esta definida...");
        }
        
    }

    
}
