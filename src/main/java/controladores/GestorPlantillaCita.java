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

package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import modelos.Almacenamiento;
import modelos.Cita;
import controladores.GestorGestionDeCitas;
import vistas.CitasDeAfiliado;
import vistas.GestionDeCitas;
import vistas.PlantillaCita;

public class GestorPlantillaCita {
    
    private final PlantillaCita vistaPlantillaCita;
    private final Almacenamiento almacenamiento;
    private final String opcion;
    private final String motivoCita;
    private final long cedula;
    
    public GestorPlantillaCita(PlantillaCita vistaPlantillaCita, String opcion, String motivoCita, long cedula, Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
        this.opcion = opcion;
        this.motivoCita = motivoCita;
        this.cedula = cedula;
        
        //vista
        this.vistaPlantillaCita = vistaPlantillaCita;
        modificarPlantilla();
        //Añadiendo Listeners
        this.vistaPlantillaCita.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addBtnAgendarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addBtnVerificarListener(new ManejadoraDeMouse());
    }
    
    public void modificarPlantilla(){
        switch (opcion) {
        
            case "Agendar" -> {
                plantillaAgendarCita();
            }
            case "Modificar" -> {
                plantillaModificarCita();
            }
            
            case "Eliminar" -> {
                plantillaEliminarCita();
            }
        }
    }
    
    public void plantillaAgendarCita(){
        
        //Ingresando nombre, cédula y motivo de cita en interfaz
        vistaPlantillaCita.getTxtNombre().setText(almacenamiento.getAfiliados().get(cedula).getNombre());
        vistaPlantillaCita.getTxtCedula().setText(String.valueOf(cedula));
        vistaPlantillaCita.getTxtServicio().setText(motivoCita);
    }
    
    public void plantillaModificarCita(){
        
        //Modificando título y botones
        vistaPlantillaCita.getLblTitulo().setText("Modificar Cita");
        vistaPlantillaCita.getBtnAgendar().setText("Modificar Cita");
    }
    
    public void plantillaEliminarCita(){
        
        //Modificando título y botones
        vistaPlantillaCita.getLblTitulo().setText("Eliminar Cita");
        vistaPlantillaCita.getBtnAgendar().setText("Eliminar Cita");
        
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaCita.getBtnAgendar()&& "Agendar".equals(opcion)){
                if (e.getButton() == 1){
                    agendarCita();
                }
            }
            
            if (e.getSource() == vistaPlantillaCita.getBtnAgendar()&& "Modificar".equals(opcion)){
                if (e.getButton() == 1){
                    modificarCita();
                }
            }
            if (e.getSource() == vistaPlantillaCita.getBtnAgendar()&& "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    eliminarCita();
                }
            }

            if (e.getSource() == vistaPlantillaCita.getBtnRegresar() && !"Consultar".equals(opcion)){
                if (e.getButton() == 1){
                    irGestionCitasGUI();  
                }
            }
            
            if (e.getSource() == vistaPlantillaCita.getBtnRegresar() && "Consultar".equals(opcion)){
                if (e.getButton() == 1){
                    irCitasAfiliadoGUI();  
                }
            }
        }
    }
    
    public void agendarCita() {
       
       //Obteniendo los datos
       
    }
    
    public void modificarCita() {
       
       //Obteniendo los datos
       
    }
    
    public void eliminarCita() {
       
       //Obteniendo los datos
       
    }

    public void irGestionCitasGUI() {
        
        GestionDeCitas vistaGestionCitas= new GestionDeCitas("Gestión de Citas", almacenamiento);
        vistaPlantillaCita.dispose();
    }
    
    public void irCitasAfiliadoGUI() {
        
        CitasDeAfiliado vistaCitasAfiliado= new CitasDeAfiliado("Gestión de Citas", "Consultar", cedula, almacenamiento);
        vistaPlantillaCita.dispose();
    }
}

