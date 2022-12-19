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
import vistas.PlantillaAfiliado;
import vistas.PlantillaConsultorio;
import vistas.PlantillaMedico;
import vistas.PlantillaServicio;

public class GestorPlantillaAfiliado {
    
    PlantillaAfiliado vistaPlantillaAfiliado;
    private String opcion;
    
    public GestorPlantillaAfiliado(PlantillaAfiliado vistaPlantillaAfiliado, String opcion, Almacenamiento almacenamiento) {
        this.vistaPlantillaAfiliado = vistaPlantillaAfiliado;
        this.opcion = opcion;
        modificarPlantilla();
    }
    public void modificarPlantilla(){
        
        switch(opcion){
            case "Actualizar" -> {
                plantillaActualizarAfiliado();
            }
            case "Eliminar" -> {
                plantillaEliminarAfiliado();
            }
        }
    }

    public void plantillaActualizarAfiliado(){
        vistaPlantillaAfiliado.setVisible(true);
        vistaPlantillaAfiliado.getLblTitulo().setText("Actualizar afiliado");
        vistaPlantillaAfiliado.getBtnAgregar().setText("Actualizar afiliado");
    }
    
    public void plantillaEliminarAfiliado(){
        //Modificando títulos y botones
        vistaPlantillaAfiliado.setVisible(true);
        vistaPlantillaAfiliado.getLblTitulo().setText("Eliminar afiliado");
        vistaPlantillaAfiliado.getBtnAgregar().setText("Eliminar afiliado");
        
        //Desabilitando campos de texto
        vistaPlantillaAfiliado.getTxtCedula().setEditable(false);
        vistaPlantillaAfiliado.getTxtNombre().setEditable(false);
        vistaPlantillaAfiliado.getTxtEdad().setEditable(false);
        vistaPlantillaAfiliado.getTxtDireccion().setEditable(false);
        vistaPlantillaAfiliado.getTxtCorreo().setEditable(false);
        vistaPlantillaAfiliado.getTxtTelefono().setEditable(false);
        vistaPlantillaAfiliado.getComboSexo().setEnabled(false);
    }
    /*
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaAfiliado.getBtnAgregar()){
                if (e.getButton() == 1){
                    agregarAfiliado();
                }
            }

            if (e.getSource() == vistaPlantillaAfiliado.getBtnRegresar()){
                if (e.getButton() == 1){
                    //irGestionServicioGUI();  
                }
            }
        }
    }
    
    private void agregarAfiliado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
/*
    private void irGestionServicioGUI() {
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI();
        PlantillaAfiliado vistaPlantillaAfiliado = new PlantillaAfiliado();
        PlantillaMedico vistaPlantillaMedico = new PlantillaMedico();
        PlantillaServicio vistaPlantillaServicio = new PlantillaServicio();
        PlantillaConsultorio vistaPlantillaConsultorio = new PlantillaConsultorio();
        
        //Creación de gestores
        
        GestorPlantillaMedico gestorPlantillaMedico = new GestorPlantillaMedico(vistaPlantillaMedico);
        GestorPlantillaConsultorio gestorPlantillaConsultorio = new GestorPlantillaConsultorio(vistaPlantillaConsultorio);
        GestorPlantillaServicio gestorPlantillaServicio = new GestorPlantillaServicio(vistaPlantillaServicio);
        //GestorPlantillaAfiliado gestorPlantillaAfiliado = new GestorPlantillaAfiliado(vistaPlantillaAfiliado);
        
        GestorGestionServicio gestorServicio = new GestorGestionServicio(vistaGestionServicio, gestorPlantillaAfiliado,gestorPlantillaMedico,gestorPlantillaConsultorio, gestorPlantillaServicio);
        vistaGestionServicio.setVisible(true);
    }*/
}

