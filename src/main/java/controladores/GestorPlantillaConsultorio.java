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

import vistas.PlantillaConsultorio;


public class GestorPlantillaConsultorio {
    
    PlantillaConsultorio vistaPlantillaConsultorio;

    public GestorPlantillaConsultorio(PlantillaConsultorio vistaPlantillaConsultorio) {
        this.vistaPlantillaConsultorio = vistaPlantillaConsultorio;
    }
    
    public void plantillaActualizarConsultorio(){
        vistaPlantillaConsultorio = new PlantillaConsultorio();
        vistaPlantillaConsultorio.setVisible(true);
        vistaPlantillaConsultorio.getLblTitulo().setText("Actualizar consultorio");
        vistaPlantillaConsultorio.getBtnAgregar().setText("Actualizar consultorio");
    }
    
    public void plantillaEliminarConsultorio(){
        
        vistaPlantillaConsultorio = new PlantillaConsultorio();
        vistaPlantillaConsultorio.setVisible(true);
        vistaPlantillaConsultorio.getLblTitulo().setText("Eliminar consultorio");
        vistaPlantillaConsultorio.getBtnAgregar().setText("Eliminar consultorio");
        
        //Desabilitando campos de texto
        vistaPlantillaConsultorio.getTxtIdentificador().setEditable(false);
        vistaPlantillaConsultorio.getComboMedico().setEnabled(false);
    }
}
