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
import vistas.PlantillaConsultorio;


public class GestorPlantillaConsultorio {
    
    PlantillaConsultorio vistaPlantillaConsultorio;
    private String opcion;
    
    public GestorPlantillaConsultorio(PlantillaConsultorio vistaPlantillaConsultorio, String opcion, Almacenamiento almacenamiento) {
        this.vistaPlantillaConsultorio = vistaPlantillaConsultorio;
        this.opcion = opcion;
        modificarPlantilla();
        this.vistaPlantillaConsultorio.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    public void modificarPlantilla(){
        
        switch(opcion){
            case "Actualizar" -> {
                plantillaActualizarConsultorio();
            }
            case "Eliminar" -> {
                plantillaEliminarConsultorio();
            }
        }
    }
    
    public void plantillaActualizarConsultorio(){
        //Modificando título y botones
        vistaPlantillaConsultorio.getLblTitulo().setText("Actualizar consultorio");
        vistaPlantillaConsultorio.getBtnAgregar().setText("Actualizar consultorio");
    }
    
    public void plantillaEliminarConsultorio(){
        //Modificando título y botones
        vistaPlantillaConsultorio.getLblTitulo().setText("Eliminar consultorio");
        vistaPlantillaConsultorio.getBtnAgregar().setText("Eliminar consultorio");
        
        //Desabilitando campos de texto
        vistaPlantillaConsultorio.getTxtIdentificador().setEditable(false);
        vistaPlantillaConsultorio.getComboMedico().setEnabled(false);
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaConsultorio.getBtnAgregar()){
                if (e.getButton() == 1){
                    agregarAfiliado();
                }
            }

            if (e.getSource() == vistaPlantillaConsultorio.getBtnRegresar()){
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
        vistaPlantillaConsultorio.dispose();
    }
}
