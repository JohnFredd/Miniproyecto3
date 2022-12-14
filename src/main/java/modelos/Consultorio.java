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

public class Consultorio implements Serializable{
    private String identificador;
    private Servicio servicioAsociado;

    public Consultorio(String identificador, Servicio servicioAsociado) {
        this.identificador = identificador;
        this.servicioAsociado = servicioAsociado;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Servicio getServicioAsociado() {
        return servicioAsociado;
    }

    public void setServicioAsociado(Servicio servicioAsociado) {
        this.servicioAsociado = servicioAsociado;
    }
    
}
