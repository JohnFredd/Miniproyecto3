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

import modelos.Almacenamiento;
import vistas.PlantillaMedico;

public class GestorPlantillaMedico {
    
    PlantillaMedico vistaPlantillaMedico;
    private String opcion;
    private Almacenamiento almacenamiento;
    
    public GestorPlantillaMedico(PlantillaMedico vistaPlantillaMedico, String opcion, Almacenamiento almacenamiento) {
        this.vistaPlantillaMedico = vistaPlantillaMedico;
        this.opcion = opcion;
        this.almacenamiento = almacenamiento;
        modificarPlantilla();
    }
    
    public void modificarPlantilla(){
        
        switch(opcion){
            case "Actualizar" -> {
                plantillaActualizarMedico();
            }
            case "Eliminar" -> {
                plantillaEliminarMedico();
            }
        }
    }
    public void plantillaActualizarMedico(){
        vistaPlantillaMedico.setVisible(true);
        vistaPlantillaMedico.getLblTitulo().setText("Actualizar médico");
        vistaPlantillaMedico.getBtnAgregar().setText("Actualizar médico");
    }
    
    public void plantillaEliminarMedico(){
        //Modificando titulos y botones
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
