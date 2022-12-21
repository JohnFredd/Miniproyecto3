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

public class Afiliado extends Persona implements Serializable{
    
    public Afiliado(String nombre, String sexo, String direccion, String email, long cedula, int edad, long telefono) {
        super(nombre, sexo, direccion, email, cedula, edad, telefono);
    }
    
    public String toString(){
        return nombre +","+sexo+","+direccion+","+email+","+String.valueOf(cedula)+","+String.valueOf(edad)+","+String.valueOf(telefono);
        
    }
}
