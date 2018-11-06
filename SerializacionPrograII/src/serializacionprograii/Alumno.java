/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacionprograii;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Alumno implements Serializable{
    private int numero_cuenta;
    private String carrera; 
    private int año_matriculado; 
    private float promedio; 
    //Constructores
    public Alumno() {
    }

    public Alumno(int numero_cuenta, String carrera, int año_matriculado, float promedio) {
        this.numero_cuenta = numero_cuenta;
        this.carrera = carrera;
        this.año_matriculado = año_matriculado;
        this.promedio = promedio;
    }
    //Metodos Accesores (GETs/SETs)

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getAño_matriculado() {
        return año_matriculado;
    }

    public void setAño_matriculado(int año_matriculado) {
        this.año_matriculado = año_matriculado;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Alumno{" + "numero_cuenta=" + numero_cuenta + ", carrera=" + carrera + ", a\u00f1o_matriculado=" + año_matriculado + ", promedio=" + promedio + '}';
    }
    
    
}
