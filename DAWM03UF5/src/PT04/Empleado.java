/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PT04;

import java.io.Serializable;

/**
 *
 * @author chronos
 */
public class Empleado implements Serializable{
    private String nombre;
    private int edad;
    private int sueldo;
    private String clave;

    public Empleado(){}
    public Empleado(String nombre, int edad, int sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
        this.clave = "patata";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + ", clave=" + clave + '}';
    }
}

//   (\_(\
// =( °w° )=
//   )   ( //
//  (__ __)/
// balsamiq




