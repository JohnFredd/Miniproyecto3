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

import vistas.PlantillaMedico;

public class GestorPlantillaMedico {
    
    PlantillaMedico vistaPlantillaMedico;

    public GestorPlantillaMedico(PlantillaMedico vistaPlantillaMedico) {
        this.vistaPlantillaMedico = vistaPlantillaMedico;
    }
    
    public void plantillaActualizarMedico(){
        vistaPlantillaMedico = new PlantillaMedico();
        vistaPlantillaMedico.setVisible(true);
        vistaPlantillaMedico.getLblTitulo().setText("Actualizar médico");
        vistaPlantillaMedico.getBtnAgregar().setText("Actualizar médico");
    }
    
    public void plantillaEliminarMedico(){
        
        vistaPlantillaMedico = new PlantillaMedico();
        vistaPlantillaMedico.setVisible(true);
        vistaPlantillaMedico.getLblTitulo().setText("Eliminar médico");
        vistaPlantillaMedico.getBtnAgregar().setText("Eliminar médico");
        
        //Desabilitando campos de texto
        vistaPlantillaMedico.getTxtCedula().setEditable(false);
        vistaPlantillaMedico.getTxtNombre().setEditable(false);
        vistaPlantillaMedico.getTxtEdad().setEditable(false);
        vistaPlantillaMedico.getTxtDireccion().setEditable(false);
        vistaPlantillaMedico.getTxtCorreo().setEditable(false);
        vistaPlantillaMedico.getTxtTelefono().setEditable(false);
        vistaPlantillaMedico.getComboSexo().setEnabled(false);
        vistaPlantillaMedico.getListaEspecialidad().setEnabled(false);
    }
    
    
}
