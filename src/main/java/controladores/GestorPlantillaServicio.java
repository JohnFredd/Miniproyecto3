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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Almacenamiento;
import modelos.Servicio;
import vistas.GestionServicioGUI;
import vistas.PlantillaServicio;

public class GestorPlantillaServicio {
    
    PlantillaServicio vistaPlantillaServicio;
    Almacenamiento almacenamiento;
    String opcion;
    String servicio;
    public GestorPlantillaServicio(PlantillaServicio vistaPlantillaServicio, String opcion, Almacenamiento almacenamiento, String servicio) {
        this.vistaPlantillaServicio = vistaPlantillaServicio;
        this.opcion = opcion;
        this.servicio = servicio;
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
        
        //Agregando los datos del servicio
        ArrayList<Servicio> servicios = almacenamiento.getServicios();
        for(int i = 0; i<servicios.size(); i++){
            if(servicios.get(i).getNombre().equalsIgnoreCase(servicio)){
                vistaPlantillaServicio.getTxtServicio().setText(servicios.get(i).getNombre());
            } 
        }
    }
    
    public void plantillaEliminarServicio(){
        //Modificando título y botones
        vistaPlantillaServicio.getLblTitulo().setText("Eliminar servicio");
        vistaPlantillaServicio.getBtnAgregar().setText("Eliminar servicio");
        
        //Agregando los datos del servicio
        ArrayList<Servicio> servicios = almacenamiento.getServicios();
        for(int i = 0; i<servicios.size(); i++){
            if(servicios.get(i).getNombre().equals(servicio)){
                vistaPlantillaServicio.getTxtServicio().setText(servicios.get(i).getNombre());
            }
        }
        
        //Desabilitando campos de texto
        vistaPlantillaServicio.getTxtServicio().setEditable(false);
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaServicio.getBtnAgregar() && "Agregar".equals(opcion)){
                if (e.getButton() == 1){
                    agregarServicio();
                }
            }
            
            if (e.getSource() == vistaPlantillaServicio.getBtnAgregar()&& "Actualizar".equals(opcion)){
                if (e.getButton() == 1){
                    actualizarServicio();
                }
            }
            if (e.getSource() == vistaPlantillaServicio.getBtnAgregar() && "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    eliminarServicio();
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
        if(!validarCamposVacios()){
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
        } else{
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void actualizarServicio() {
        
        ArrayList<Servicio> servicios = almacenamiento.getServicios();
        if(!validarCamposVacios()) {
            String nombreNuevo = vistaPlantillaServicio.getTxtServicio().getText();
            Servicio miServicio = new Servicio(nombreNuevo);

            //Se recorre el ArrayList de servicios en búsqueda del servicio con el nombre anterior para así actualizarlo
            for(int i = 0; i<servicios.size(); i++){
                if(servicios.get(i).getNombre().equalsIgnoreCase(servicio)){
                    try {
                        //Actualizando el servicio
                        almacenamiento.modificarServicio(i, miServicio);
                        JOptionPane.showMessageDialog(null, "Servicio modificado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                        irGestionServicioGUI();

                    } catch(IOException e){
                        JOptionPane.showMessageDialog(null, "Error al modificar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);   
        }
        
    }
    
    public void eliminarServicio() {
        ArrayList<Servicio> servicios = almacenamiento.getServicios();
        //Se recorre el ArrayList de servicios en búsqueda del servicio con el nombre anterior para así actualizarlo
        for(int i = 0; i<servicios.size(); i++){
            if(servicios.get(i).getNombre().equals(servicio)){
                try {
                    //Eliminando el servicio
                    almacenamiento.eliminarServicio(i);
                    JOptionPane.showMessageDialog(null, "Servicio eliminado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                    irGestionServicioGUI();

                } catch(IOException e){
                    JOptionPane.showMessageDialog(null, "Error al eliminar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
    }
    public void irGestionServicioGUI() {
        
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        vistaPlantillaServicio.dispose();
    }
    public boolean validarCamposVacios(){
        boolean error = false;
        if(vistaPlantillaServicio.getTxtServicio().getText().isBlank())
            error = true;
        return error;
    }
}
