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
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Invitado
 */
public class Conexion {
             int idpersona;
             int idbanco;
             int idcuenta;
             String x,y,z;
             Cliente p = new Cliente();
             Banco b = new Banco();
             Cuenta c = new Cuenta();
    public void nueva_conexion() throws IOException{
             
        String espacio = "";
        String temporal = null;
        Scanner datos = new Scanner(System.in);
        File archivo = new File("Conexiones.txt");
        Cliente p = new Cliente();
        Banco b = new Banco();
        Cuenta c = new Cuenta();
       
            if(!archivo.exists()){
                archivo.createNewFile();
            }
        
       //Escritura en conexion
       FileWriter datos1 = new FileWriter(archivo,true);
       BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
       BufferedWriter bw_archivo = new BufferedWriter(datos1);
       PrintWriter escritura1 = new PrintWriter(bw_archivo);
       
       if((temporal = br_archivo.readLine()) != null){
             temporal="";
             espacio = "\n";
        }
                idpersona = p.nueva_personas();
                
                idbanco = b.nuevo_Banco();
                
                idcuenta = c.nueva_cuenta();
               
                escritura1.write(espacio+idpersona+","+idbanco+","+idcuenta);
             
             escritura1.close();
             bw_archivo.close();
        }
             
      public void Buscar(String b) throws IOException{
        File archivo = new File("Conexiones.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[0]).equals(b)){
                            System.out.println("Persona:");   
                        p.Buscar(datos_csv[0]);
                            System.out.println("Banco:");
                        this.b.Buscar(datos_csv[1]);
                            System.out.println("Cuenta:");
                        c.Buscar(datos_csv[2]);
                                
                                
                        
                        break;
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                br_archivo.close();
              }
    
    
    }      

    /////////////////////////////////////////Eliminar Conexion por persona////////////////////////////////////
      public void eliminar(String id){
        try {
            File archivo;
            FileReader lectura;
            BufferedReader leer;
            archivo = new File("conexiones.txt");
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
                    if(l[0].equals(id)){
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
                    System.out.println("no se encontro la persona");
                    
                }
                escriba.close();
                escribir.close();
                if(numerolineas==1 && bandera==true){
                    archivo.delete();
                    
                    
                }
            }else{
                System.out.println("No existe la persona que desea eliminar");
                
            }
        } catch (IOException e) {
        }

}
   ////////////////////////////////////////////////////////////////////////////////////////////// 
      ///////////////////////////////////////////Modifica el Archivo de Conexion por persona////////////////////////////////////////
public void modificar_p(int x, String y, String z){
    Scanner datos = new Scanner(System.in);
    BancoTemp b = new BancoTemp();
       String Banco = "";
       String temporal = null;
        try {
            File archivo;
            FileReader lectura;
            BufferedReader leer;
            archivo = new File("conexion.txt");
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
                    if(l[0].equals(x)){
                        bandera=true;
                        if(primeral==true){
                            escriba.write(x+","+y+","+z);
                            System.out.println("Elemento modificado");
                            primeral=false;
                            
                        }else{
                            escriba.newLine();
                           escriba.write(x+","+y+","+z);
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

}
///////////////////////////////////////////Modifica el Archivo de Conexion por banco////////////////////////////////////////
public void modificar_b(String x, int y, String z){
    Scanner datos = new Scanner(System.in);
    BancoTemp b = new BancoTemp();
       String Banco = "";
       String temporal = null;
        try {
            File archivo;
            FileReader lectura;
            BufferedReader leer;
            archivo = new File("conexion.txt");
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
                    if(l[0].equals(y)){
                        bandera=true;
                        if(primeral==true){
                            escriba.write(x+","+y+","+z);
                            System.out.println("Elemento modificado");
                            primeral=false;
                            
                        }else{
                            escriba.newLine();
                           escriba.write(x+","+y+","+z);
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

}
 ///////////////////////////////////////////Modifica el Archivo de  por cuenta////////////////////////////////////////
public void modificar_c(String x, String y, int z){
    Scanner datos = new Scanner(System.in);
    BancoTemp b = new BancoTemp();
       String Banco = "";
       String temporal = null;
        try {
            File archivo;
            FileReader lectura;
            BufferedReader leer;
            archivo = new File("conexion.txt");
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
                    if(l[0].equals(z)){
                        bandera=true;
                        if(primeral==true){
                            escriba.write(x+","+y+","+z);
                            System.out.println("Elemento modificado");
                            primeral=false;
                            
                        }else{
                            escriba.newLine();
                           escriba.write(x+","+y+","+z);
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

}
 
      /////////////////////////////////////////Eliminar Conexion por persona////////////////////////////////////
      public void eliminar_b(String id){
        try {
            File archivo;
            FileReader lectura;
            BufferedReader leer;
            archivo = new File("conexiones.txt");
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
                    if(l[1].equals(id)){
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
                    System.out.println("no se encontro el banco");
                    
                }
                escriba.close();
                escribir.close();
                if(numerolineas==1 && bandera==true){
                    archivo.delete();
                    
                    
                }
            }else{
                System.out.println("No existe la persona que desea eliminar");
                
            }
        } catch (IOException e) {
        }

}
   ////////////////////////////////////////////////////////////////////////////////////////////// 
   /////////////////////////////////////////Eliminar Banco//////////////////////////////////////
      public void Eliminar_Banco(String x) throws IOException{
        File archivo = new File("Conexiones.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
        int bandera=0;
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[1]).equals(x)){
                        b.eliminar(datos_csv[1]);       
                        c.eliminar(datos_csv[2]);
                        bandera=1;
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                  
                        
                        if(bandera==1)
                        this.eliminar_b(x);
                        
                        
                    
                 
                br_archivo.close();
              }
    
    
    }      

   ///////////////////////////////////////////////////////////////////////////////////////////////// 
      /////////////////////////////////////////Eliminar Persona//////////////////////////////////////
      public void Eliminar_Persona(String x) throws IOException{
        File archivo = new File("Conexiones.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
        int bandera=0;
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[0]).equals(x)){
                        p.eliminar(datos_csv[0]);
                        c.eliminar(datos_csv[2]);
                        bandera=1;
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                  
                        if(bandera==1)
                        this.eliminar(x);
                        
                br_archivo.close();
              }
    
    
    }      

   /////////////////////////////////////////////////////////////////////////////////////////////////
      /////////////////////////////////////////modificar Persona//////////////////////////////////////
      public void Modificar_Persona(String x) throws IOException{
        File archivo = new File("Conexiones.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
        int bandera=0;
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[0]).equals(x)){
                        idpersona = p.modificar(datos_csv[0]);
                        y = (datos_csv[1]);
                        z = (datos_csv[2]);
                        break;
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                  
                        this.modificar_p(idpersona,y,z);
                        
                br_archivo.close();
              }
    
    
    }      

   /////////////////////////////////////////////////////////////////////////////////////////////////
      /////////////////////////////////////////modificar Banco//////////////////////////////////////
      public void Modificar_banco(String x) throws IOException{
        File archivo = new File("Conexiones.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
        int bandera=0;
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[1]).equals(x)){
                        idbanco = b.modificar(datos_csv[1]);
                        this.x = (datos_csv[0]);
                        z = (datos_csv[2]);
                        break;
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                  
                        this.modificar_b(this.x,idbanco,z);
                        
                br_archivo.close();
              }
    
    
    }      

   /////////////////////////////////////////////////////////////////////////////////////////////////
      /////////////////////////////////////////modificar Cuenta//////////////////////////////////////
      public void Modificar_Cuenta(String x) throws IOException{
        File archivo = new File("Conexiones.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
        int bandera=0;
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[2]).equals(x)){
                        idcuenta = c.modificar(datos_csv[0]);
                        this.x= (datos_csv[0]);
                        y = (datos_csv[1]);
                        break;
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                  
                        this.modificar_c(this.x,y,idcuenta);
                        
                br_archivo.close();
              }
    
    
    }      

   /////////////////////////////////////////////////////////////////////////////////////////////////
      
   //////////////////////////////////Funcion para saber fecha y hora/////////////////////////////
      public String Fecha(){
        Calendar cal=Calendar.getInstance();
        String fecha = cal.get(cal.DATE)+"-"+cal.get(cal.MONTH)+"-"+cal.get(cal.YEAR);
        String hora = (cal.get(cal.HOUR_OF_DAY)+"."+cal.get(cal.MINUTE)+"."+cal.get(cal.SECOND));
    return ("_"+fecha+"_"+hora);
    }
   ///////////////////////////////////////////////////////////////////////////////////////////////  
   /*   
     Aqui de bajo estaran las funciones nuevas para el examen:
     funciones como crear reportes y guardarlos para sacarlos en un archivo plano de tipo txt
    */
      
    ////////////////////////////////////////Estas son las funciones para el RPPI  
    public void RPPI(String id) throws IOException{
        boolean bandera=false;
        bandera= b.verificar_id(id);
        if(bandera==true){
        String temp=null,fecha;
        fecha=this.Fecha();
        temp = b.reporte_RPPI(id);
        temp = (temp+""+"Personas Relacionadas"+"\n"+"Id           Nombre y apellido            Tipo"+"\n"+this.Personas_RPPI(id));
        System.out.println(temp);
        File archivo = new File("RPPI"+fecha+".txt");
            if(!archivo.exists()){
                archivo.createNewFile();
            }
       //Escritura delarchivo txt
       FileWriter datos1 = new FileWriter(archivo,true);
       BufferedWriter bw_archivo = new BufferedWriter(datos1);
       PrintWriter escritura1 = new PrintWriter(bw_archivo);
       escritura1.write(temp);
       escritura1.close();
       }else{System.out.println("El Banco No existe");}
    
    } 
    ////Esta solo es una divicion pero la siguiente funcion funciona con el codigo anterior
    public String Personas_RPPI(String id)throws IOException{
        File archivo = new File("Conexiones.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal,retorno="";
        
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[1]).equals(id)){
                               
                        retorno = retorno + p.reporte(datos_csv[0]);
                          
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                br_archivo.close();
              }
      return retorno;        
    }
  /////////////////////////////////////////////////Aqui Terminan Las lineas de comano para RPPI/////////////////////////////  
   ////////////////////////////////////////Estas son las funciones para el RIPP  
    public void RIPP(String id) throws IOException{
        boolean bandera=false;
        bandera= p.verificar_id(id);
        if(bandera==true){
        String temp=null,fecha;
        fecha=this.Fecha();
        temp = p.reporte_p(id);
        temp = (temp+""+"Bancos Relacionados"+"\n"+"Id           Banco                 Pais                  Ciudad"+"\n"+this.Bancos_RIPP(id));
        System.out.println(temp);
        File archivo = new File("RIPP"+fecha+".txt");
            if(!archivo.exists()){
                archivo.createNewFile();
            }
       //Escritura delarchivo txt
       FileWriter datos1 = new FileWriter(archivo,true);
       BufferedWriter bw_archivo = new BufferedWriter(datos1);
       PrintWriter escritura1 = new PrintWriter(bw_archivo);
       escritura1.write(temp);
       escritura1.close();
       }else{System.out.println("La Persona No existe");}
    
    } 
    ////Esta solo es una divicion pero la siguiente funcion funciona con el codigo anterior
    public String Bancos_RIPP(String id)throws IOException{
        File archivo = new File("Conexiones.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal,retorno="";
        
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[0]).equals(id)){
                               
                        retorno = retorno + b.reporte(datos_csv[1]);
                          
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                br_archivo.close();
              }
      return retorno;        
    }
  /////////////////////////////////////////////////Aqui Terminan Las lineas de comano para RIPP///////////////////////////// 
    ////////////////////////////////////////Estas son las funciones para el RIPPA  
    public String Nombre_Banco(String n) throws IOException{
    
    File archivo = new File("Conexiones.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal,retorno="";
        
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[2]).equals(n)){
                               
                        retorno = retorno +  b.reporte_RIPPA(datos_csv[1]);
                          
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                br_archivo.close();
              }
    
    return retorno;
    }
    public void RIPPA(String id) throws IOException{
        boolean bandera=false;
        bandera= p.verificar_id(id);
        if(bandera==true){
        String temp=null,fecha;
        fecha=this.Fecha();
        temp = p.reporte_p(id);
        temp = (temp+""+"Cuentas Relacionadas"+"\n"+"Id          Banco               Descripcion         Moneda          Tipo"+"\n"+this.Cuentas_RIPPA(id));
        System.out.println(temp);
        File archivo = new File("RIPPA"+fecha+".txt");
            if(!archivo.exists()){
                archivo.createNewFile();
            }
       //Escritura delarchivo txt
       FileWriter datos1 = new FileWriter(archivo,true);
       BufferedWriter bw_archivo = new BufferedWriter(datos1);
       PrintWriter escritura1 = new PrintWriter(bw_archivo);
       escritura1.write(temp);
       escritura1.close();
       }else{System.out.println("La Persona No existe");}
    
    } 
    ////Esta solo es una divicion pero la siguiente funcion funciona con el codigo anterior
    public String Cuentas_RIPPA(String id)throws IOException{
        File archivo = new File("Conexiones.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal,retorno="";
        
         String csv_splitter = ",";
             temporal = ","; 
              try {
                   br_archivo = new BufferedReader(new FileReader(archivo));
                   
                   while((temporal = br_archivo.readLine())!=null){
                        String[] datos_csv = temporal.split(csv_splitter);
                        if((datos_csv[0]).equals(id)){
                               
                        retorno = retorno + c.reporte(datos_csv[2]);
                          
                        }else{}
                   } 
              } catch (IOException e) {
                System.out.println("ERROR"+e.getMessage());
              } finally {
                br_archivo.close();
              }
      return retorno;        
    }
  /////////////////////////////////////////////////Aqui Terminan Las lineas de comano para RIPP///////////////////////////// 
}
