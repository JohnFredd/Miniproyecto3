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
import vistas.PlantillaAfiliado;
import vistas.PpalGUI;
import vistas.PlantillaCita;
public class GestorGestionDeCitas {
    
    private final GestionDeCitas vistaGestionCitas;
    PlantillaCita vistaPlantillaCita;

    public GestorGestionDeCitas(GestionDeCitas vistaGestionCitas,PlantillaCita vistaPlantillaCita) {
        
        //Vista
        this.vistaGestionCitas = vistaGestionCitas;
        this.vistaPlantillaCita = vistaPlantillaCita;
        
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
          if (e.getSource() == vistaGestionCitas.getBtnEliminar()){
              if (e.getButton() == 1){
                  elegirCitaAEliminar();
              }
          }
        }
    }
    
    
    public void irPpal() {
        PpalGUI ventanaPpal = new PpalGUI("Servicio de salud - Universidad del Valle");
        vistaGestionCitas.dispose();
    }
    public void irCitasDeAfiliado() {
        Almacenamiento almacenamiento = new Almacenamiento();
        CitasDeAfiliado ventanaCitasAfiliado = new CitasDeAfiliado("Citas del afiliado", almacenamiento);
        vistaGestionCitas.dispose();
    }
    
    /*public void irPlantillaCitas(){
        PlantillaCita ventanaplantillaCita = new PlantillaCita("Agendar Citas");
        vistaGestionCitas.dispose();
    }
    
    public void irPlantillaModificarCitas(){
        PlantillaCita ventanaplantillaCita = new PlantillaCita("Modificar Citas");
        vistaGestionCitas.dispose();
        
        vistaPlantillaCita.getLblTitulo().setText("Modificar Cita");
        vistaPlantillaCita.getBtnAgregar().setText("Modificar Cita");
    }*/
    
    
    public void elegirCitaAModificar(){
        String NumRefABuscar;
                    try {
                        NumRefABuscar = (String) JOptionPane.showInputDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Ingrese el numero de referencia de la cita a modificar</p></html>", "Modificar cita", JOptionPane.DEFAULT_OPTION);
                        if(NumRefABuscar.equals("12345")){
                            irPlantillaModificarCitas();

                        } else if (NumRefABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Por favor ingrese un numero de referencia de cita</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        } else if(!NumRefABuscar.equals("12345")){
                            JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">No se encontró ningúna cita registrada con ese numero de referencia</p></html>", "Cita no encontrada", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        }
                    } catch(NullPointerException np){
                        JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">No se ingresó ningun numero de referencia de cita</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                    }
                }
    public void elegirCitaAEliminar(){
        String NumRefABuscar;
                    try {
                        NumRefABuscar = (String) JOptionPane.showInputDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Ingrese el numero de referencia de la cita a eliminar</p></html>", "Modificar cita", JOptionPane.DEFAULT_OPTION);
                        if(NumRefABuscar.equals("12345")){
                            irPlantillaCitas();

                        } else if (NumRefABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">Por favor ingrese un numero de referencia de cita</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        } else if(!NumRefABuscar.equals("12345")){
                            JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">No se encontró ningúna cita registrada con ese numero de referencia</p></html>", "Cita no encontrada", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        }
                    } catch(NullPointerException np){
                        JOptionPane.showMessageDialog(vistaGestionCitas, "<html><p style = \" font:12px; \">No se ingresó ningun numero de referencia de cita</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                    }
                }
    
    }
    