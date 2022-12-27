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
import java.time.LocalDate;
import java.time.LocalTime;

public class Cita implements Serializable {
    
    private int numeroReferencia;
    private LocalDate fecha;
    private LocalTime hora;
    private Servicio servicioRequerido;
    private Afiliado afiliado;
    private Consultorio consultorio;
    private Medico medico;

    public Cita(int numeroReferencia, LocalDate fecha, LocalTime hora, Servicio servicioRequerido, Afiliado afiliado, Consultorio consultorio, Medico medico) {
        this.numeroReferencia = numeroReferencia;
        this.fecha = fecha;
        this.hora = hora;
        this.servicioRequerido = servicioRequerido;
        this.afiliado = afiliado;
        this.consultorio = consultorio;
        this.medico = medico;
    }

    public int getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(int numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Servicio getServicioRequerido() {
        return servicioRequerido;
    }

    public void setServicioRequerido(Servicio servicioRequerido) {
        this.servicioRequerido = servicioRequerido;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedicoDisponible(Medico medico) {
        this.medico = medico;
    }
    
}
