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
import modelos.Almacenamiento;
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
                    agregarAfiliado();
                }
            }

            if (e.getSource() == vistaPlantillaServicio.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
        }
    }
    
    private void agregarAfiliado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void irGestionServicioGUI() {
        
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        vistaPlantillaServicio.dispose();
    }
}
