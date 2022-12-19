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
import vistas.PlantillaMedico;

public class GestorPlantillaMedico {
    
    PlantillaMedico vistaPlantillaMedico;
    private String opcion;
    
    public GestorPlantillaMedico(PlantillaMedico vistaPlantillaMedico, String opcion, Almacenamiento almacenamiento) {
        this.vistaPlantillaMedico = vistaPlantillaMedico;
        this.opcion = opcion;
        modificarPlantilla();
        this.vistaPlantillaMedico.addBtnRegresarListener(new ManejadoraDeMouse());
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
        //Modificando título y botones
        vistaPlantillaMedico.getLblTitulo().setText("Actualizar médico");
        vistaPlantillaMedico.getBtnAgregar().setText("Actualizar médico");
    }
    
    public void plantillaEliminarMedico(){
        //Modificando título y botones
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
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaMedico.getBtnAgregar()){
                if (e.getButton() == 1){
                    agregarAfiliado();
                }
            }

            if (e.getSource() == vistaPlantillaMedico.getBtnRegresar()){
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
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios");
        vistaPlantillaMedico.dispose();
    }
}
