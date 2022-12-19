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
import modelos.Afiliado;
import modelos.Almacenamiento;
import vistas.GestionServicioGUI;
import vistas.PlantillaAfiliado;

public class GestorPlantillaAfiliado {
    
    PlantillaAfiliado vistaPlantillaAfiliado;
    Afiliado modeloAfiliado;
    private String opcion;
    
    public GestorPlantillaAfiliado(PlantillaAfiliado vistaPlantillaAfiliado, String opcion, Almacenamiento almacenamiento) {
        this.vistaPlantillaAfiliado = vistaPlantillaAfiliado;
        this.opcion = opcion;
        modificarPlantilla();
        this.vistaPlantillaAfiliado.addBtnRegresarListener(new ManejadoraDeMouse());
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
        //Modificando título y botones
        vistaPlantillaAfiliado.getLblTitulo().setText("Actualizar afiliado");
        vistaPlantillaAfiliado.getBtnAgregar().setText("Actualizar afiliado");
    }
    
    public void plantillaEliminarAfiliado(){
        //Modificando título y botones
        vistaPlantillaAfiliado.getLblTitulo().setText("Eliminar afiliado");
        vistaPlantillaAfiliado.getBtnAgregar().setText("Eliminar afiliado");
        
        //Desabilitando campos de texto
        vistaPlantillaAfiliado.getTxtCedula();
        vistaPlantillaAfiliado.getTxtNombre();
        vistaPlantillaAfiliado.getTxtEdad();
        vistaPlantillaAfiliado.getTxtDireccion();
        vistaPlantillaAfiliado.getTxtCorreo();
        vistaPlantillaAfiliado.getTxtTelefono();
        vistaPlantillaAfiliado.getComboSexo().setEnabled(false);
    }
    
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
                    irGestionServicioGUI();  
                }
            }
        }
    }
    
    private void agregarAfiliado() {
        
        //Obteniendo los datos
        int cedula = Integer.parseInt(vistaPlantillaAfiliado.getTxtCedula().getText());
        String nombre = vistaPlantillaAfiliado.getTxtNombre().getText();
        int edad = Integer.parseInt(vistaPlantillaAfiliado.getTxtEdad().getText());
        String direccion = vistaPlantillaAfiliado.getTxtDireccion().getText();
        String correo = vistaPlantillaAfiliado.getTxtCorreo().getText();
        int telefono = Integer.parseInt(vistaPlantillaAfiliado.getTxtTelefono().getText());
        String sexo = (String)vistaPlantillaAfiliado.getComboSexo().getSelectedItem();
        Afiliado afiliado = new Afiliado(nombre, sexo, direccion, correo, cedula, edad, telefono);
    }

    private void irGestionServicioGUI() {
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios");
        vistaPlantillaAfiliado.dispose();
    }
}

