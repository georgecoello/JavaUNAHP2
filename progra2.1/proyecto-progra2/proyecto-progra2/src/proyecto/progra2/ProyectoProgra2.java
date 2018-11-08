/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.progra2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Invitado
 */
public class ProyectoProgra2 {

    /**
     * @param args the command line arguments
     */
    
   public static void main(String[] args) throws IOException {
        
        // TODO code application logic here
        String temporal=null,temporal1=null;
        Scanner datos = new Scanner(System.in);
        Cliente p = new Cliente();
        Banco b = new Banco();
        Cuenta c = new Cuenta();
        Conexion conex = new Conexion();
        int option = 0;
        while(option!=7){
        System.out.println("/////////////////////////////////////////////////////////");   
        System.out.println("---------------------------------------------------------");   
        System.out.println("              Menu Principal                          ");   
        System.out.println("\n1. Impresiones                                           ");   
        System.out.println("2. Ingresar Nuevos datos                                 ");   
        System.out.println("3. Buscar                                                 ");
        System.out.println("4. Eliminar                                                  ");
        System.out.println("5. Modificar                                                  ");
        System.out.println("6. repotes                                                 \n ");
        System.out.println("7.salir                                                  ");
        System.out.println("---------------------------------------------------------");   
        System.out.print("-->>");   
        
        option = datos.nextInt();
        switch(option){
            case 1:
                
                int option2=0;
                while(option2!=4){
                    System.out.println("/////////////////////////////////////////////////////////");   
        System.out.println("---------------------------------------------------------");   
        System.out.println("              Menu de Impresiones                           ");   
        System.out.println("\n1.Para Imprimir un listado de facturas por persona                ");   
        System.out.println("2.Para Imprimir productos por facturas                                 ");    
        System.out.println("3.Para Imprimir total de ventas                               \n");  
        System.out.println("4.Salir al menu principal                                                  ");
        System.out.println("---------------------------------------------------------");
        System.out.print("-->>"); 
                    option2 = datos.nextInt();
                switch(option2){
                    case 1: p.imprimir();
                            break;
                    case 2: b.imprimir();
                            break;
                    case 3: c.imprimir();
                            break;
                    case 4:
                         break;        
                    default:System.out.println("La Opcion no Existe");
                          
                }
                }
                break;
            case 2:
                conex.nueva_conexion();
                break;
            case 3:
                int option3=0;
                while(option3!=5){
                    System.out.println("/////////////////////////////////////////////////////////");   
        System.out.println("---------------------------------------------------------");   
        System.out.println("              Menu de Busqueda                          ");   
        System.out.println("\n1.Para buscar una persona                  ");   
        System.out.println("2.Para buscar un Banco                                 ");    
        System.out.println("3.Para buscar una cuenta                                ");   
        System.out.println("4.Para buscar info bancaria de una persona            \n ");  
        System.out.println("5.Salir                                                  ");
        System.out.println("---------------------------------------------------------");
        System.out.print("-->>"); 
                    option3 = datos.nextInt();
                switch(option3){
                    case 1:
                        System.out.println("id de la persona a buscar");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        p.Buscar(temporal);
                            break;
                    case 2: 
                        System.out.println("id del Banco a buscar");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        b.Buscar(temporal);
                            break;
                    case 3:
                        System.out.println("id de la Cuenta a buscar");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        c.Buscar(temporal);
                            break;
                    case 4:
                         System.out.println("id de la persona a buscar");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        conex.Buscar(temporal);
                         break;   
                    case 5:
                        break;
                    default:System.out.println("La Opcion no Existe");
                           
                }
                }
                
                break;              
            case 4:
                int option4=0;
                while(option4!=4){
                    System.out.println("/////////////////////////////////////////////////////////");   
        System.out.println("---------------------------------------------------------");   
        System.out.println("              Menu de Eliminacion                         ");   
        System.out.println("\n1.Para eliminar una personas                  ");   
        System.out.println("2.Para elimnar un Bancos                                 ");    
        System.out.println("3.Para eliminar una cuentas                             \n ");  
        System.out.println("4.Salir                                                  ");
        System.out.println("---------------------------------------------------------");
        System.out.print("-->>"); 
                    option4 = datos.nextInt();
                switch(option4){
                    case 1:
                        System.out.println("id de la persona a eliminar");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        conex.Eliminar_Persona(temporal);
                            break;
                    case 2: 
                        System.out.println("id del Banco a eliminar");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        conex.Eliminar_Banco(temporal);
                            break;
                    case 3:
                        System.out.println("id de la Cuenta a eliminar");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        c.eliminar(temporal);
                            break;
                    case 4:
                         break;        
                    default:System.out.println("La Opcion no Existe");
                           
                }
                }
                break;
            case 5:
                int option5=0;
                while(option5!=4){
                    System.out.println("/////////////////////////////////////////////////////////");   
        System.out.println("---------------------------------------------------------");   
        System.out.println("              Menu de modificacion                         ");   
        System.out.println("\n1.Para modificar una personas                  ");   
        System.out.println("2.Para modificar un Bancos                                 ");    
        System.out.println("3.Para modificar una cuentas                             \n ");  
        System.out.println("4.Salir                                                  ");
        System.out.println("---------------------------------------------------------");
        System.out.print("-->>"); 
                    option5 = datos.nextInt();
                switch(option5){
                    case 1:
                        System.out.println("id de la persona a modificar");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        conex.Modificar_Persona(temporal);
                            break;
                    case 2: 
                        System.out.println("id del Banco a modificar");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        conex.Modificar_banco(temporal);
                            break;
                    case 3:
                        System.out.println("id de la Cuenta a modificar");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        conex.Modificar_Cuenta(temporal);
                            break;
                    case 4:
                         break;
                    default:System.out.println("La Opcion no Existe");
                           
                }
                }
                break;
            case 6: 
                int option6=0;
                while(option6!=4){
                    System.out.println("/////////////////////////////////////////////////////////");   
        System.out.println("---------------------------------------------------------");   
        System.out.println("              Reportes                         ");   
        System.out.println("\n1.Para Reporte de personas por institucion                  ");   
        System.out.println("2.Para reporte de bancos por persoan                                 ");    
        System.out.println("3.Para reporte de cuentas por persona                             \n ");  
        System.out.println("4.Salir                                                  ");
        System.out.println("---------------------------------------------------------");
        System.out.print("-->>"); 
                    option6 = datos.nextInt();
                switch(option6){
                    case 1:
                        System.out.println("id del Banco");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        conex.RPPI(temporal);
                            break;
                    case 2: 
                        System.out.println("id de la persona");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        conex.RIPP(temporal);
                            break;
                    case 3:
                        System.out.println("id de la persona");
                        datos.nextLine();
                        temporal = datos.nextLine();
                        conex.RIPPA(temporal);
                            break;
                    case 4:
                         break;
                    default:System.out.println("La Opcion no Existe");
                           
                }
                }
                
                break;
            case 7:
                break;
            default: 
                System.out.println("La Opcion no Existe");
           
            }   
        }  
    } 
    
}
