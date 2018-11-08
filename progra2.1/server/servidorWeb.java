/*Ejemplo de Servidor Web en Java
 *
 * Autor: Roberto Canales
 * rcanales@adictosaltrabajo.com
 * rcanales@autentia.com
 *
 **/


import java.io.*;
import java.net.*;
import java.util.*;

public class servidorWeb
{
	int puerto = 90;
	
	final int ERROR = 0;
	final int WARNING = 1;
	final int DEBUG = 2;
	
		
	// funcion para centralizar los mensajes de depuracion

	void depura(String mensaje)
	{
		depura(mensaje,DEBUG);
	}	

	void depura(String mensaje, int gravedad)
	{
		System.out.println("Mensaje: " + mensaje);
	}	
		
	// punto de entrada a nuestro programa
	public static void main(String [] array)	
	{
		servidorWeb instancia = new servidorWeb(array);	
		instancia.arranca();
	}
	
	// constructor que interpreta los parameros pasados
	servidorWeb(String[] param)
	{
		procesaParametros();	
	}
	
	// parsearemos el fichero de entrada y estableceremos las variables de clase
	boolean procesaParametros()
	{
		return true;	
	}
	
	boolean arranca()
	{
		depura("Arrancamos nuestro servidor",DEBUG);
		
		try
		{
		
			
			ServerSocket s = new ServerSocket(90);

			depura("Quedamos a la espera de conexion");
			
			while(true)  // bucle infinito .... ya veremos como hacerlo de otro modo
			{
				Socket entrante = s.accept();
				peticionWeb pCliente = new peticionWeb(entrante);
				pCliente.start();
			}
			
		}
		catch(Exception e)
		{
			depura("Error en servidor\n" + e.toString());
		}
		
		return true;
	}
	
}



class peticionWeb extends Thread
{
	int contador = 0;

	final int ERROR = 0;
	final int WARNING = 1;
	final int DEBUG = 2;

	void depura(String mensaje)
	{
		depura(mensaje,DEBUG);
	}	

	void depura(String mensaje, int gravedad)
	{
		System.out.println(currentThread().toString() + " - " + mensaje);
	}	

	private Socket scliente 	= null;		// representa la petición de nuestro cliente
   	private PrintWriter out 	= null;		// representa el buffer donde escribimos la respuesta

   	peticionWeb(Socket ps)
   	{
		depura("El contador es " + contador);
		
		contador ++;
		
		
		
		scliente = ps;
		setPriority(NORM_PRIORITY - 1); // hacemos que la prioridad sea baja
   	}

	public void run() // emplementamos el metodo run
	{
		depura("Procesamos conexion");

		try
		{
			BufferedReader in = new BufferedReader (new InputStreamReader(scliente.getInputStream()));
  			out = new PrintWriter(new OutputStreamWriter(scliente.getOutputStream(),"8859_1"),true) ;


			String cadena = "";		// cadena donde almacenamos las lineas que leemos
			int i=0;				// lo usaremos para que cierto codigo solo se ejecute una vez
	
			do			
			{
				cadena = in.readLine();

				if (cadena != null )
				{
					// sleep(500);
					depura("--" + cadena + "-");
				}


				if(i == 0) // la primera linea nos dice que fichero hay que descargar
				{
			        i++;
			        
			        StringTokenizer st = new StringTokenizer(cadena);
                    
                    if ((st.countTokens() >= 2) && st.nextToken().equals("GET")) 
                    {
                    	retornaFichero(st.nextToken()) ;
                    }
                    else 
                    {
                    	out.println("400 Petición Incorrecta") ;
                    }
				}
				
			}
			while (cadena != null && cadena.length() != 0);

		}
		catch(Exception e)
		{
			depura("Error en servidor\n" + e.toString());
		}
			
		depura("Hemos terminado");
	}
	
	
	void retornaFichero(String sfichero)
	{
		depura("Recuperamos el fichero " + sfichero);
		
		// comprobamos si tiene una barra al principio
		if (sfichero.startsWith("/"))
		{
			sfichero = sfichero.substring(1) ;
		}
        
        // si acaba en /, le retornamos el index.htm de ese directorio
        // si la cadena esta vacia, no retorna el index.htm principal
        if (sfichero.endsWith("/") || sfichero.equals(""))
        {
        	sfichero = sfichero + "index.htm" ;
        }
        
        try
        {
	        
		    // Ahora leemos el fichero y lo retornamos
		    File mifichero = new File(sfichero) ;
		        
		    if (mifichero.exists()) 
		    {
	      		out.println("HTTP/1.0 200 ok");
				out.println("Server: Roberto Server/1.0");
				out.println("Date: " + new Date());
				out.println("Content-Type: text/html");
				out.println("Content-Length: " + mifichero.length());
				out.println("\n");
			
				BufferedReader ficheroLocal = new BufferedReader(new FileReader(mifichero));
				
				
				String linea = "";
				
				do			
				{
					linea = ficheroLocal.readLine();
	
					if (linea != null )
					{
						// sleep(500);
						out.println(linea);
					}
				}
				while (linea != null);
				
				depura("fin envio fichero");
				
				ficheroLocal.close();
				out.close();
				
			}  // fin de si el fiechero existe 
			else
			{
				depura("No encuentro el fichero " + mifichero.toString());	
	      		out.println("HTTP/1.0 400 ok");
	      		out.close();
			}
			
		}
		catch(Exception e)
		{
			depura("Error al retornar fichero");	
		}

	}
	
}
