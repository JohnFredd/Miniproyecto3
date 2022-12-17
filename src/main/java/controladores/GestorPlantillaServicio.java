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

import vistas.PlantillaServicio;

public class GestorPlantillaServicio {
    
    PlantillaServicio vistaPlantillaServicio;

    public GestorPlantillaServicio(PlantillaServicio vistaPlantillaServicio) {
        this.vistaPlantillaServicio = vistaPlantillaServicio;
    }
    
    public void plantillaActualizarServicio(){
        vistaPlantillaServicio = new PlantillaServicio();
        vistaPlantillaServicio.setVisible(true);
        vistaPlantillaServicio.getLblTitulo().setText("Actualizar servicio");
        vistaPlantillaServicio.getBtnAgregar().setText("Actualizar servicio");
    }
    
    public void plantillaEliminarServicio(){
        
        vistaPlantillaServicio = new PlantillaServicio();
        vistaPlantillaServicio.setVisible(true);
        vistaPlantillaServicio.getLblTitulo().setText("Eliminar servicio");
        vistaPlantillaServicio.getBtnAgregar().setText("Eliminar servicio");
        
        //Desabilitando campos de texto
        vistaPlantillaServicio.getTxtServicio().setEditable(false);
    }
}
