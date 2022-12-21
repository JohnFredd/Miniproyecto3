/*
 * MINIPROYECTO #3
 *
 * INTEGRANTES: 
 * John Freddy Belalcázar
 * Hernán David Cisneros
 * Santiago González Gálvez
 *
 * Grupo 01 FPOE 
 *
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Medico extends Persona implements Serializable{
    
    private ArrayList<Servicio> servicios;

    public Medico(ArrayList<Servicio> servicios, String nombre, String sexo, String direccion, String email, long cedula, int edad, long telefono) {
        super(nombre, sexo, direccion, email, cedula, edad, telefono);
        this.servicios = servicios;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    
}
