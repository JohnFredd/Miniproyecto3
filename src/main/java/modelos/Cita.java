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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Cita {
    
    private LocalDate fecha;
    private LocalTime hora;
    private Servicio servicioRequerido;
    private Afiliado afiliado;
    private Consultorio consultorio;
    private ArrayList<Medico> medicoDisponible;

    public Cita(LocalDate fecha, LocalTime hora, Servicio servicioRequerido, Afiliado afiliado, Consultorio consultorio, ArrayList<Medico> medicoDisponible) {
        this.fecha = fecha;
        this.hora = hora;
        this.servicioRequerido = servicioRequerido;
        this.afiliado = afiliado;
        this.consultorio = consultorio;
        this.medicoDisponible = medicoDisponible;
    }
    
    
}
