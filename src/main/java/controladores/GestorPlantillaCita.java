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
import java.util.ArrayList;
import java.util.List;
import modelos.Afiliado;
import modelos.Almacenamiento;
import modelos.Cita;
import vistas.GestionServicioGUI;
import vistas.PlantillaAfiliado;
import vistas.PlantillaCita;

public class GestorPlantillaCita {
    
    PlantillaCita vistaPlantillaCita;
    Almacenamiento almacenamiento;
    Cita cita;
    private String opcion;
    
    public GestorPlantillaCita(PlantillaCita vistaPlantillaCita, String opcion, Almacenamiento almacenamiento) {
        this.vistaPlantillaCita = vistaPlantillaCita;
        this.opcion = opcion;
        this.almacenamiento = almacenamiento;
        //modificarPlantilla();
        //this.vistaPlantillaCita.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    /*public void modificarPlantilla(){
        
        switch(opcion){
            case "Actualizar" -> {
                plantillaActualizarCita();
            }
            case "Eliminar" -> {
                plantillaEliminarCita();
            }
        }
    }*/
/*
    public void plantillaActualizarCita(){
        //Modificando título y botones
        vistaPlantillaCita.getLblTitulo().setText("Actualizar afiliado");
        vistaPlantillaCita.getBtnAgregar().setText("Actualizar afiliado");
    }
    
    public void plantillaEliminarCita(){
        //Modificando título y botones
        vistaPlantillaCita.getLblTitulo().setText("Eliminar afiliado");
        vistaPlantillaCita.getBtnAgregar().setText("Eliminar afiliado");
        
        //Desabilitando campos de texto
        vistaPlantillaCita.getTxtCedula();
        vistaPlantillaCita.getTxtNombre();
        vistaPlantillaCita.getTxtEdad();
        vistaPlantillaCita.getTxtDireccion();
        vistaPlantillaCita.getTxtCorreo();
        vistaPlantillaCita.getTxtTelefono();
        vistaPlantillaCita.getComboSexo().setEnabled(false);
    }*/
    /*
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaCita.getBtnAgregar()){
                if (e.getButton() == 1){
                    agregarAfiliado();
                }
            }

            if (e.getSource() == vistaPlantillaCita.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
        }
    }
    */
    private void agregarAfiliado() {
        /*
        //Obteniendo los datos
        int cedula = Integer.parseInt(vistaPlantillaAfiliado.getTxtCedula().getText());
        String nombre = vistaPlantillaAfiliado.getTxtNombre().getText();
        int edad = Integer.parseInt(vistaPlantillaAfiliado.getTxtEdad().getText());
        String direccion = vistaPlantillaAfiliado.getTxtDireccion().getText();
        String correo = vistaPlantillaAfiliado.getTxtCorreo().getText();
        int telefono = Integer.parseInt(vistaPlantillaAfiliado.getTxtTelefono().getText());
        String sexo = (String)vistaPlantillaAfiliado.getComboSexo().getSelectedItem();
        Afiliado afiliado = new Afiliado(nombre, sexo, direccion, correo, cedula, edad, telefono);
        System.out.println(afiliado.toString());
        almacenamiento.anadirAfiliado(afiliado);*/
    }

    private void irGestionServicioGUI() {
        /*
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        vistaPlantillaAfiliado.dispose();*/
    }
}

