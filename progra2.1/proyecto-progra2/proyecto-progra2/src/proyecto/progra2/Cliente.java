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
public class Cliente {

    int id;
    String Nombre_Apellido;
    char Tipo;
    ClienteTemp p = new ClienteTemp();

    public int nueva_personas() throws IOException {
        Scanner datos = new Scanner(System.in);
        String espacio = "";
        String temporal = null;
        ClienteTemp p = new ClienteTemp();
        File archivo = new File("personas.txt");

        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        //Escritura en Clientes txt
        FileWriter datos1 = new FileWriter(archivo, true);
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        BufferedWriter bw_archivo = new BufferedWriter(datos1);
        PrintWriter escritura1 = new PrintWriter(bw_archivo);

        if ((temporal = br_archivo.readLine()) != null) {
            espacio = "\n";
        }
/////////////////////////////////Este es la validacion para ingresar un id////////////////

        int option = 1, option1 = 0;
        while (option != 2) {

            if (option != 1) {

                System.out.println("Desea volver a intentar\n1. si\n2. no");
                datos.nextLine();
                option = datos.nextInt();
            }
            switch (option) {
                case 1:
                    try {
                        System.out.println("Ingrese numero de cliente:");
                        id = datos.nextInt();
                        if (!(this.verificar_id(this.idtostring(id)))) {
                            p.setId(id);
                        } else {
                            System.out.println("la Persona con este id ya existe desea Agregarle mas cuentas? \n1. si\n2. no");
                            datos.nextLine();
                            option1 = datos.nextInt();
                            if (option1 == 1) {
                                option = 2;
                            }
                            break;
                        }

                        option = 2;
                    } catch (InputMismatchException e) {
                        System.err.println("El Identificador consta solo de numeros enteros");
                        option = 0;

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

        //////////////////////////////////////Aqui tenemos el Ingreso de la info//////////////   
        if (!(this.verificar_id(this.idtostring(id)))) {
            System.out.println("Ingrese su Nombre y Apellidos:");
            datos.nextLine();
            Nombre_Apellido = datos.nextLine();
            p.setNombre_Apellido(Nombre_Apellido);

        } else {

        }

        escritura1.close();
        bw_archivo.close();

        /////////////////////////////////////Aqui termina el Ingreso de la info     
        return id;
    }

    public void imprimir() throws IOException {
        File archivo = new File("personas.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
        String csv_splitter = ",";
        temporal = ",";
        try {
            br_archivo = new BufferedReader(new FileReader(archivo));
            System.out.println("EN BASE DE CLIENTES SE ALMACENO LO SIGUIENTE");
            System.out.println("");
            while ((temporal = br_archivo.readLine()) != null) {
                String[] datos_csv = temporal.split(csv_splitter);
                System.out.println("numero de cliente: " + datos_csv[0] + "\nNombre y Apellido: " + datos_csv[1] + "\nNumero de cliente:" + datos_csv[2] + "\n");
                System.out.println("<===================================>");
            }
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
        } finally {
            br_archivo.close();
        }
    }

    public void Buscar(String b) throws IOException {
        File archivo = new File("personas.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
        String csv_splitter = ",";
        temporal = ",";
        try {
            br_archivo = new BufferedReader(new FileReader(archivo));

            while ((temporal = br_archivo.readLine()) != null) {
                String[] datos_csv = temporal.split(csv_splitter);
                if ((datos_csv[0]).equals(b)) {
                    System.out.println("");
                    System.out.println("numero de cliente" + datos_csv[0] + "\nNombre y Apellido: " + datos_csv[1] + "\nNumero de flactura:" + datos_csv[2] + "\n");
                    System.out.println("<===================================>");
                    break;
                } else {
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
        } finally {
            br_archivo.close();
        }

    }

    public void eliminar(String idepais) {
        try {
            File archivo;
            FileReader lectura;
            BufferedReader leer;
            archivo = new File("personas.txt");
            if (archivo.exists()) {
                lectura = new FileReader(archivo);
                leer = new BufferedReader(lectura);
                String linea;
                int numerolineas = 0;
                while ((linea = leer.readLine()) != null) {
                    numerolineas++;

                }
                String contacto[] = new String[numerolineas];
                leer = new BufferedReader(new FileReader(archivo));
                int i = 0;
                while ((linea = leer.readLine()) != null) {
                    contacto[i] = linea;
                    i++;

                }
                leer.close();
                lectura.close();
                FileWriter escribir = new FileWriter(archivo);
                BufferedWriter escriba = new BufferedWriter(escribir);
                boolean bandera = false;
                boolean primeral = true;
                for (int j = 0; j < contacto.length; j++) {
                    String l[] = contacto[j].split(",");
                    if (l[0].equals(idepais)) {
                        bandera = true;
                        System.out.println("Elemento eliminado");

                    } else {
                        if (primeral == true) {
                            escriba.write(contacto[j]);
                            primeral = false;

                        } else {
                            escriba.newLine();
                            escriba.write(contacto[j]);
                        }

                    }

                }
                if (bandera == false) {
                    System.out.println("no se encontro la persona");

                }
                escriba.close();
                escribir.close();
                if (numerolineas == 1 && bandera == true) {
                    archivo.delete();

                }
            } else {
                System.out.println("No existe la persona que desea eliminar");

            }
        } catch (IOException e) {
        }

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public int modificar(String x) {
        Scanner datos = new Scanner(System.in);
        BancoTemp b = new BancoTemp();
        String Banco = "";
        String temporal = null;
        try {
            File archivo;
            FileReader lectura;
            BufferedReader leer;
            archivo = new File("personas.txt");
            if (archivo.exists()) {
                lectura = new FileReader(archivo);
                leer = new BufferedReader(lectura);
                String linea;
                int numerolineas = 0;
                while ((linea = leer.readLine()) != null) {
                    numerolineas++;

                }
                String contacto[] = new String[numerolineas];
                leer = new BufferedReader(new FileReader(archivo));
                int i = 0;
                while ((linea = leer.readLine()) != null) {
                    contacto[i] = linea;
                    i++;

                }
                /////////////////////////////////////Aquisetearemos//////////////////////////////
                System.out.println("estos son los datos de la factura a modificar");
                Buscar(x);
                System.out.println("");
                /////////////////////////////////Este es la validacion para ingresar un id////////////////

                int option = 1;
                while (option != 2) {

                    if (option != 1) {

                        System.out.println("Desea volver a intentar\n1. si\n2. no");
                        datos.nextLine();
                        option = datos.nextInt();
                    }
                    switch (option) {
                        case 1:
                            try {
                                System.out.println("Ingrese la ID de la  persona:");
                                id = datos.nextInt();
                                p.setId(id);

                                option = 2;
                            } catch (InputMismatchException e) {
                                System.err.println("El Identificador consta solo de numeros enteros");
                                option = 0;

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

                //////////////////////////////////////Aqui tenemos el Ingreso de la info//////////////   
                System.out.println("Ingrese su Nombre y Apellidos:");
                datos.nextLine();
                Nombre_Apellido = datos.nextLine();
                p.setNombre_Apellido(Nombre_Apellido);

                /////////////////////////////////////////////////////////////////////////////////        
                leer.close();
                lectura.close();
                FileWriter escribir = new FileWriter(archivo);
                BufferedWriter escriba = new BufferedWriter(escribir);
                boolean bandera = false;
                boolean primeral = true;
                for (int j = 0; j < contacto.length; j++) {
                    String l[] = contacto[j].split(",");
                    if (l[0].equals(x)) {
                        bandera = true;
                        if (primeral == true) {
                            escriba.write(p.toString());
                            System.out.println("Elemento modificado");
                            primeral = false;

                        } else {
                            escriba.newLine();
                            escriba.write(p.toString());
                            System.out.println("Elemento modificado");
                        }

                    } else {
                        if (primeral == true) {
                            escriba.write(contacto[j]);
                            primeral = false;

                        } else {
                            escriba.newLine();
                            escriba.write(contacto[j]);
                        }

                    }

                }
                if (bandera == false) {
                    System.out.println("no se encontro la cuenta");

                }
                escriba.close();
                escribir.close();
                if (numerolineas == 1 && bandera == true) {
                    archivo.delete();

                }
            } else {
                System.out.println("No existe la cuenta que desea eliminar");

            }
        } catch (IOException e) {
        }
        return id;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////

    public String reporte(String b) throws IOException {
        File archivo = new File("personas.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal, retorno = "";
        String csv_splitter = ",";
        temporal = " ";
        try {
            br_archivo = new BufferedReader(new FileReader(archivo));

            while ((temporal = br_archivo.readLine()) != null) {
                String[] datos_csv = temporal.split(csv_splitter);
                if ((datos_csv[0]).equals(b)) {
                    retorno = (datos_csv[0] + "           " + datos_csv[1] + "                 " + datos_csv[2] + "\n");

                    break;
                } else {
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
        } finally {
            br_archivo.close();
        }

        return retorno;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////Verificar id/////////////////////////////////////////////////

    public boolean verificar_id(String b) throws IOException {
        File archivo = new File("personas.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal;
        String csv_splitter = ",";
        boolean bandera = false;
        temporal = " ";
        try {
            br_archivo = new BufferedReader(new FileReader(archivo));

            while ((temporal = br_archivo.readLine()) != null) {
                String[] datos_csv = temporal.split(csv_splitter);
                if ((datos_csv[0]).equals(b)) {
                    bandera = true;
                    break;
                } else {
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
        } finally {
            br_archivo.close();
        }

        return bandera;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////

    public String idtostring(int x) {
        return "" + x;
    }
//////////////////////////////////////////////////////Aqui comenzare el codigo q necesito pa el examen
/////////////Mandando los siguientes datos Nombre del Banco y Pais del banco//////////////////

    public String reporte_p(String b) throws IOException {
        File archivo = new File("personas.txt");
        BufferedReader br_archivo = new BufferedReader(new FileReader(archivo));
        String temporal, retorno = "";
        String csv_splitter = ",";
        temporal = ",";
        try {
            br_archivo = new BufferedReader(new FileReader(archivo));

            while ((temporal = br_archivo.readLine()) != null) {
                String[] datos_csv = temporal.split(csv_splitter);
                if ((datos_csv[0]).equals(b)) {
                    retorno = ("Persona: " + datos_csv[1] + "\n");

                    break;
                } else {
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
        } finally {
            br_archivo.close();
        }

        return retorno;
    }
///////////////////////////////////fin de seccion de codigo////////////////////////////////
}
