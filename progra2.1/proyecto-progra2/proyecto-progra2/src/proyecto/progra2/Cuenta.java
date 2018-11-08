/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.progra2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Invitado
 */
public class Cuenta {
    int id;
     String Descripcion;
     char Moneda;
     String Tipo_Cuenta;
     CuentaTemp c = new CuentaTemp();
    public int nueva_cuenta() throws IOException{
     
        String r="0";
     Scanner datos = new Scanner(System.in);
     
       String cuenta = "";
       String temporal = null;
       
       File archivo = new File("Cuentas.txt");
       
       
            if(!archivo.exists()){
                archivo.createNewFile();
            }
        
       //Escritura en Clientes txt
       FileWriter datos1 = new FileWriter(archivo,true);
       BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
       BufferedWriter bw_archivo = new BufferedWriter(datos1);
       PrintWriter escritura1 = new PrintWriter(bw_archivo);

    
        
        if((temporal = br_archivo.readLine()) != null){
             cuenta = "\n";
        }
                /////////////////////////////////Este es la validacion para ingresar un id////////////////
        
        int option=1;
        while(option!=2){
            
            if(option!=1){
                
                System.out.println("Desea volver a intentar\n1. si\n2. no");
                datos.nextLine();
                option = datos.nextInt();
            }
                switch(option){
               case 1:
               try{
                System.out.println("id de la cuenta:");
                id = datos.nextInt();
                if(!(this.verificar_id(this.idtostring(id)))){
                   c.setId(id);
                }else{
                    System.out.println("La cuenta con ese identificador ya existe vuelvea intrntar");
                    break;
                }
                
               option=2;
               }catch(InputMismatchException e){
               System.err.println("El Identificador consta solo de numeros enteros");
               option=0;
               
               }
               break;
               case 2:
                   break;
               case 0:
                   break;
               default:
                   System.out.println("la opcion no existe");
        
          }
        }
        //////////////////////////////////Aqui termina la validacion de un id///////////////////
        if(!(this.verificar_id(this.idtostring(id)))){
                   System.out.println("Identificador del producto:");
             datos.nextLine();
             Descripcion = datos.nextLine();
             c.setDescripcion(Descripcion);
             System.out.println("Descripcion del producto:");
             Moneda = datos.next().charAt(0);
             c.setMoneda(Moneda);
             System.out.println("Precio:");
             datos.nextLine();
             Tipo_Cuenta = datos.nextLine();
             c.setTipo_Cuenta(Tipo_Cuenta);
             escritura1.write(cuenta+c.toString());
                }else{
                }
             
             escritura1.close();
             bw_archivo.close();
             
         return id;
     }  
    public void imprimir() throws IOException{
        File archivo = new File("Cuentas.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   System.out.println("\n En las cuentas tenemos");
                   System.out.println("");
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        System.out.println("Indentificacion: "+datos_csv[0]+"\nDescripcion: "+datos_csv[1]+"\nMoneda:"+datos_csv[2]+"\nTipo de cuenta:"+datos_csv[3]+"\n");
                        System.out.println("<===================================>");
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                br_archivo.close();
              }
         }
    public void Buscar(String b) throws IOException{
        File archivo = new File("Cuentas.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[0]).equals(b)){ 
                        System.out.println("");    
                        System.out.println("Indentificacion: "+datos_csv[0]+"\nDescripcion: "+datos_csv[1]+"\nMoneda:"+datos_csv[2]+"\nTipo de cuenta:"+datos_csv[3]+"\n");
                        System.out.println("<===================================>");
                        break;
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                br_archivo.close();
              }
    
    
    }
    public void eliminar(String idepais){
        try {
            File archivo;
            FileReader lectura;
            BufferedReader leer;
            archivo = new File("Cuentas.txt");
            if(archivo.exists()){
                lectura = new FileReader(archivo);
                leer = new BufferedReader(lectura);
                String linea;
                int numerolineas=0;
                while((linea= leer.readLine())!=null){
                    numerolineas++;
                    
                }
                String contacto[] = new String[numerolineas];
                leer = new BufferedReader(new FileReader(archivo));
                int i=0;
                while((linea= leer.readLine())!=null){
                    contacto[i]=linea;
                    i++;
                    
                }
                leer.close();
                lectura.close();
                FileWriter escribir = new FileWriter(archivo);
                BufferedWriter escriba = new BufferedWriter(escribir);
                boolean bandera = false;
                boolean primeral = true;
                for(int j=0; j<contacto.length; j++){
                    String l [] = contacto[j].split(",");
                    if(l[0].equals(idepais)){
                        bandera=true;
                        System.out.println("Elemento eliminado");
                        
                    }else{
                        if(primeral==true){
                            escriba.write(contacto[j]);
                            primeral=false;
                            
                        }else{
                            escriba.newLine();
                            escriba.write(contacto[j]);
                        }
                        
                    }
                            
                }
                if(bandera==false){
                    System.out.println("no se encontro la cuenta");
                    
                }
                escriba.close();
                escribir.close();
                if(numerolineas==1 && bandera==true){
                    archivo.delete();
                    
                    
                }
            }else{
                System.out.println("No existe la cuenta que desea eliminar");
                
            }
        } catch (IOException e) {
        }

}
/////////////////////////////////////////////////////////////////////////////////////////////////////
public int modificar(String x){
    Scanner datos = new Scanner(System.in);
    BancoTemp b = new BancoTemp();
       String Banco = "";
       String temporal = null;
        try {
            File archivo;
            FileReader lectura;
            BufferedReader leer;
            archivo = new File("Cuentas.txt");
            if(archivo.exists()){
                lectura = new FileReader(archivo);
                leer = new BufferedReader(lectura);
                String linea;
                int numerolineas=0;
                while((linea= leer.readLine())!=null){
                    numerolineas++;
                    
                }
                String contacto[] = new String[numerolineas];
                leer = new BufferedReader(new FileReader(archivo));
                int i=0;
                while((linea= leer.readLine())!=null){
                    contacto[i]=linea;
                    i++;
                    
                }
                System.out.println("estos son los datos del banco a modificar");
                        Buscar(x);
                        System.out.println("");
                        /////////////////////////////////Este es la validacion para ingresar un id////////////////
        
        int option=1;
        while(option!=2){
            
            if(option!=1){
                
                System.out.println("Desea volver a intentar\n1. si\n2. no");
                datos.nextLine();
                option = datos.nextInt();
            }
                switch(option){
               case 1:
               try{
                System.out.println("id de la cuenta:");
                id = datos.nextInt();
                   c.setId(id);
                
                
               option=2;
               }catch(InputMismatchException e){
               System.err.println("El Identificador consta solo de numeros enteros");
               option=0;
               
               }
               break;
               case 2:
                   break;
               case 0:
                   break;
               default:
                   System.out.println("la opcion no existe");
        
          }
        }
        //////////////////////////////////Aqui termina la validacion de un id///////////////////
              System.out.println("Descripcion:");
             datos.nextLine();
             Descripcion = datos.nextLine();
             c.setDescripcion(Descripcion);
             System.out.println("Moneda:");
             Moneda = datos.next().charAt(0);
             c.setMoneda(Moneda);
             System.out.println("tipo de cuenta:");
             datos.nextLine();
             Tipo_Cuenta = datos.nextLine();
             c.setTipo_Cuenta(Tipo_Cuenta);
                leer.close();
                lectura.close();
                FileWriter escribir = new FileWriter(archivo);
                BufferedWriter escriba = new BufferedWriter(escribir);
                boolean bandera = false;
                boolean primeral = true;
                for(int j=0; j<contacto.length; j++){
                    String l [] = contacto[j].split(",");
                    if(l[0].equals(x)){
                        bandera=true;
                        if(primeral==true){
                        
                         escriba.write(c.toString());
                        System.out.println("Elemento modificado");
                            primeral=false;
                            
                        }else{
                            escriba.newLine();
                            escriba.write(c.toString());
                        System.out.println("Elemento modificado");
                        }
                       
                        
                    }else{
                        if(primeral==true){
                            escriba.write(contacto[j]);
                            primeral=false;
                            
                        }else{
                            escriba.newLine();
                            escriba.write(contacto[j]);
                        }
                        
                    }
                            
                }
                if(bandera==false){
                    System.out.println("no se encontro la cuenta");
                    
                }
                escriba.close();
                escribir.close();
                if(numerolineas==1 && bandera==true){
                    archivo.delete();
                    
                    
                }
            }else{
                System.out.println("No existe la cuenta que desea eliminar");
                
            }
        } catch (IOException e) {
        }
return id;
}
////////////////////////////////////////////////////////////////////////////////////////////////////7    
////////////////////////////////////////////////////////////////////////////////////////////////////
public String reporte(String b) throws IOException{
    
        Conexion con = new Conexion();
        File archivo = new File("Cuentas.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal,retorno="",nombre_banco;
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[0]).equals(b)){ 
                           nombre_banco= con.Nombre_Banco(b);
                        retorno = (datos_csv[0]+"           "+nombre_banco+"           "+datos_csv[1]+"            "+datos_csv[2]+"            "+datos_csv[3]+"\n");
                        
                        break;
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                br_archivo.close();
              }
    
    return retorno;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////Verificar id/////////////////////////////////////////////////
public boolean verificar_id(String b) throws IOException{
        File archivo = new File("Cuentas.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
         String csv_splitter = ",";
         boolean bandera=false;
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[0]).equals(b)){ 
                        bandera=true;
                        break;
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                br_archivo.close();
              }
    
    return bandera;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String idtostring(int x){ return ""+x;}
}
