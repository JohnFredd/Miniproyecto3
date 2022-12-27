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
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelos.Afiliado;
import modelos.Almacenamiento;
import modelos.Cita;
import modelos.Servicio;
import vistas.CitasDeAfiliado;
import vistas.GestionDeCitas;
import vistas.PpalGUI;
import vistas.PlantillaCita;

public class GestorGestionDeCitas {
    
    private final GestionDeCitas vistaGestionCitas;
    private final Almacenamiento almacenamiento;
   

    public GestorGestionDeCitas(GestionDeCitas vistaGestionCitas, Almacenamiento almacenamiento) {
       
        this.almacenamiento = almacenamiento;
 
        //Vista
        this.vistaGestionCitas = vistaGestionCitas;
        
        //Añadiendo Listeners
        this.vistaGestionCitas.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaGestionCitas.addBtnConsultarListener(new ManejadoraDeMouse());
        this.vistaGestionCitas.addBtnAgendarListener(new ManejadoraDeMouse());
        this.vistaGestionCitas.addBtnEliminarListener(new ManejadoraDeMouse());
        this.vistaGestionCitas.addBtnModificarListener(new ManejadoraDeMouse());
    }
    

    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
          if (e.getSource() == vistaGestionCitas.getBtnRegresar()){
              if (e.getButton() == 1){
                  irPpal();
              }
          }
          if (e.getSource() == vistaGestionCitas.getBtnConsultar()){
              if (e.getButton() == 1){
                  irCitasDeAfiliado();
              }
          }
          if (e.getSource() == vistaGestionCitas.getBtnAgendar()){
              if (e.getButton() == 1){
                  irAgendarCita();
              }
          }
          if (e.getSource() == vistaGestionCitas.getBtnModificar()){
              if (e.getButton() == 1){                  
                  elegirCitaAModificar();
              }
          }
         if (e.getSource() == vistaGestionCitas.getBtnEliminar()){
              if (e.getButton() == 1){  
                  elegirCitaAEliminar();
              }
          }
        }
    }
    
    public void irPpal() {
        PpalGUI ventanaPpal = new PpalGUI("Servicio de salud - Universidad del Valle", almacenamiento);
        vistaGestionCitas.dispose();
    }
    
    public void irCitasDeAfiliado() {
        HashMap<Integer, Cita> misCitas = almacenamiento.getCitas();
        if(!misCitas.isEmpty()){
            String cedulaABuscar;

            try {
                cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Ingrese la cédula del afiliado</p></html>", "Agendar cita", JOptionPane.DEFAULT_OPTION);

                if (cedulaABuscar.isBlank()){
                    JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Por favor ingrese una cédula</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                } else {
                    long cedula = Long.parseLong(cedulaABuscar);

                    if(!almacenamiento.getAfiliados().containsKey(cedula)){   //Verificar también si el afiliado tiene citas
                        JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">No se encontró ningún afiliado registrado con esa cédula</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                    } else {
                        CitasDeAfiliado ventanaConsultarCitasAfiliado = new CitasDeAfiliado("Citas del afiliado", "Consultar", cedula, almacenamiento);
                        vistaGestionCitas.dispose();
                    }
                }
            } catch(NullPointerException np){

            }
        } else {
            JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Agregue una cita primero</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));            
        }
    }
    
    public void irAgendarCita(){
        HashMap<Long, Afiliado> misAfiliados = almacenamiento.getAfiliados();

        if(misAfiliados.isEmpty()){
            JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Agregue un afiiliado primero</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
        
        } else {
            String cedulaABuscar;

            //Convirtiendo los servicios actuales a String[]
            ArrayList<Servicio> servicios = almacenamiento.getServicios();
            String[] misServicios = new String[servicios.size()];

            for (int i= 0; i<servicios.size(); i++){
                String servicio = "";
                servicio += servicios.get(i).getNombre();
                misServicios[i] = servicio;
            }

            try {
                cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Ingrese la cédula del afiliado</p></html>", "Agendar cita", JOptionPane.DEFAULT_OPTION);

                if (cedulaABuscar.isBlank()){
                    JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Por favor ingrese una cédula</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                } else {
                    long cedula = Long.parseLong(cedulaABuscar);

                    if(!almacenamiento.getAfiliados().containsKey(cedula)){
                        JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">No se encontró ningún afiliado registrado con esa cédula</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                    } else {
                        String motivoCita = (String) JOptionPane.showInputDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Escoja el motivo de la cita</p></html>", "Lista de servicios", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), misServicios, misServicios[0]);

                        if (motivoCita != null){
                            for (String miServicio : misServicios) {
                                if (miServicio.equals(motivoCita)) {
                                    PlantillaCita ventanaAgendarCita = new PlantillaCita("Agendar Citas", "Agendar", motivoCita, cedula, almacenamiento);
                                    vistaGestionCitas.dispose();
                                }
                            }
                        }
                    }
                }
            } catch(NullPointerException np){

            }
        }
    }
    
    public void elegirCitaAModificar(){
        HashMap<Integer, Cita> misCitas = almacenamiento.getCitas();
        
        if(!misCitas.isEmpty()) {
            try {
                String refABuscar = (String) JOptionPane.showInputDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Ingrese el numero de referencia de la cita a modificar</p></html>", "Modificar cita", JOptionPane.DEFAULT_OPTION);
                if(refABuscar.isBlank()){
                    JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Por favor ingrese una cédula</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                } else {
                    int numRefABuscar = Integer.parseInt(refABuscar);
                    if(misCitas.containsKey(numRefABuscar)){
                        irModificarCita(numRefABuscar);
                        vistaGestionCitas.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">No se encontró ninguna cita</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                    }
                }
            } catch(NullPointerException np){
                
            }
        } else {
            JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Agregue una cita primero</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
        }
    }
    public void elegirCitaAEliminar(){
        HashMap<Integer, Cita> misCitas = almacenamiento.getCitas();
        
        if(!misCitas.isEmpty()) {
            try {
                String refABuscar = (String) JOptionPane.showInputDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Ingrese el numero de referencia de la cita a eliminar</p></html>", "Modificar cita", JOptionPane.DEFAULT_OPTION);
                if(refABuscar.isBlank()){
                    JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Por favor ingrese una cédula</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                } else {
                    int numRefABuscar = Integer.parseInt(refABuscar);
                    if(misCitas.containsKey(numRefABuscar)){
                        irEliminarCita(numRefABuscar);
                        vistaGestionCitas.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">No se encontró ninguna cita</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                    }
                }
            } catch(NullPointerException np){
                
            }
        } else {
            JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Agregue una cita primero</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
        }
    }
    
    public void irModificarCita(int numRef){
        String motivoCita = almacenamiento.getCitas().get(numRef).getServicioRequerido().getNombre();
        long cedula = almacenamiento.getCitas().get(numRef).getAfiliado().getCedula();
        PlantillaCita ventanaModificarCita = new PlantillaCita("Agendar Citas", "Modificar", motivoCita, cedula, almacenamiento);
        vistaGestionCitas.dispose();
    }
    
    public void irEliminarCita(int numRef){
       String motivoCita = almacenamiento.getCitas().get(numRef).getServicioRequerido().getNombre();
       long cedula = almacenamiento.getCitas().get(numRef).getAfiliado().getCedula();
       PlantillaCita ventanaEliminarCita = new PlantillaCita("Eliminar cita", "Eliminar", motivoCita, cedula, almacenamiento);
       vistaGestionCitas.dispose();
    }
}
