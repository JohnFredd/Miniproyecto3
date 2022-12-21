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
import java.io.IOException;
import javax.swing.JOptionPane;
import modelos.Almacenamiento;
import modelos.Servicio;
import vistas.GestionServicioGUI;
import vistas.PlantillaServicio;

public class GestorPlantillaServicio {
    
    PlantillaServicio vistaPlantillaServicio;
    Almacenamiento almacenamiento;
    String opcion;
    public GestorPlantillaServicio(PlantillaServicio vistaPlantillaServicio, String opcion, Almacenamiento almacenamiento) {
        this.vistaPlantillaServicio = vistaPlantillaServicio;
        this.opcion = opcion;
        this.almacenamiento = almacenamiento;
        modificarPlantilla();
        this.vistaPlantillaServicio.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaPlantillaServicio.addBtnAgregarListener(new ManejadoraDeMouse());
    }
    
    public void modificarPlantilla(){
        
        switch(opcion){
            case "Actualizar" -> {
                plantillaActualizarServicio();
            }
            case "Eliminar" -> {
                plantillaEliminarServicio();
            }
        }
    }
    public void plantillaActualizarServicio(){
        //Modificando título y botones
        vistaPlantillaServicio.getLblTitulo().setText("Actualizar servicio");
        vistaPlantillaServicio.getBtnAgregar().setText("Actualizar servicio");
    }
    
    public void plantillaEliminarServicio(){
        //Modificando título y botones
        vistaPlantillaServicio.getLblTitulo().setText("Eliminar servicio");
        vistaPlantillaServicio.getBtnAgregar().setText("Eliminar servicio");
        
        //Desabilitando campos de texto
        vistaPlantillaServicio.getTxtServicio().setEditable(false);
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaServicio.getBtnAgregar()){
                if (e.getButton() == 1){
                    agregarServicio();
                }
            }

            if (e.getSource() == vistaPlantillaServicio.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
        }
    }
    
    public void agregarServicio() {
        String nombre = vistaPlantillaServicio.getTxtServicio().getText();
        Servicio servicio = new Servicio(nombre);
        try {
            //Agregando el servicio
            if (almacenamiento.anadirServicio(servicio)){
                JOptionPane.showMessageDialog(null, "Servicio agregado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                irGestionServicioGUI();
            } else {
                JOptionPane.showMessageDialog(null, "Este servicio ya existe", "Resultado de agregar", JOptionPane.ERROR_MESSAGE);
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void irGestionServicioGUI() {
        
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        vistaPlantillaServicio.dispose();
    }
}
