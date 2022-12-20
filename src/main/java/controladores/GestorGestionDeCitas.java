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
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelos.Almacenamiento;
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
                  irPlantillaCitas();
              }
          }
          if (e.getSource() == vistaGestionCitas.getBtnModificar()){
              if (e.getButton() == 1){
                  elegirCitaAModificar();
              }
          }
         /* if (e.getSource() == vistaGestionCitas.getBtnEliminar()){
              if (e.getButton() == 1){
                  irPlantilla();
              }
          }*/
        }
    }
    
    
    public void irPpal() {
        PpalGUI ventanaPpal = new PpalGUI("Servicio de salud - Universidad del Valle", almacenamiento);
        vistaGestionCitas.dispose();
    }
    public void irCitasDeAfiliado() {
        CitasDeAfiliado ventanaCitasAfiliado = new CitasDeAfiliado("Citas del afiliado", almacenamiento);
        vistaGestionCitas.dispose();
    }
    
    public void irPlantillaCitas(){
        PlantillaCita ventanaplantillaCita = new PlantillaCita("Agendar Citas","Plantilla", almacenamiento);
        vistaGestionCitas.dispose();
    }
    public void elegirCitaAModificar(){
        String NumRefABuscar;
                    try {
                        NumRefABuscar = (String) JOptionPane.showInputDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Ingrese el numero de referencia de la cita a modificar</p></html>", "Modificar cita", JOptionPane.DEFAULT_OPTION);
                        if(NumRefABuscar.equals("12345")){
                            irPlantillaCitas();

                        } else if (NumRefABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Por favor ingrese un numero de referencia</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        } else if(!NumRefABuscar.equals("12345")){
                            JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">No se encontró ningúna cita registrada con ese numero de referencia</p></html>", "Cita no encontrada", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        }
                    } catch(NullPointerException np){
                        JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">No se ingresó ningun numero de referencia</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                    }
                }
    }
