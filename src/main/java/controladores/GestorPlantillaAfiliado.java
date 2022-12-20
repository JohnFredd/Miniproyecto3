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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Afiliado;
import modelos.Almacenamiento;
import vistas.GestionServicioGUI;
import vistas.PlantillaAfiliado;

public class GestorPlantillaAfiliado {
    
    PlantillaAfiliado vistaPlantillaAfiliado;
    Almacenamiento almacenamiento;
    Afiliado modeloAfiliado;
    private String opcion;
    
    public GestorPlantillaAfiliado(PlantillaAfiliado vistaPlantillaAfiliado, String opcion, Almacenamiento almacenamiento) {
        this.vistaPlantillaAfiliado = vistaPlantillaAfiliado;
        this.opcion = opcion;
        this.almacenamiento = almacenamiento;
        modificarPlantilla();
        this.vistaPlantillaAfiliado.addBtnAgregarListener(new ManejadoraDeMouse());
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
            /*case "Agregar" -> {
                break;
            }*/
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
        long cedula = Long.parseLong(vistaPlantillaAfiliado.getTxtCedula().getText());
        String nombre = vistaPlantillaAfiliado.getTxtNombre().getText();
        int edad = Integer.parseInt(vistaPlantillaAfiliado.getTxtEdad().getText());
        String direccion = vistaPlantillaAfiliado.getTxtDireccion().getText();
        String correo = vistaPlantillaAfiliado.getTxtCorreo().getText();
        long telefono = Long.parseLong(vistaPlantillaAfiliado.getTxtTelefono().getText());
        String sexo = (String)vistaPlantillaAfiliado.getComboSexo().getSelectedItem();
        
        Afiliado afiliado = new Afiliado(nombre, sexo, direccion, correo, cedula, edad, telefono);
        afiliado.setNombre(nombre);
        afiliado.setSexo(sexo);
        afiliado.setDireccion(direccion);
        afiliado.setEmail(correo);
        afiliado.setCedula(cedula);
        afiliado.setEdad(edad);
        afiliado.setTelefono(telefono);
        try {
            if (almacenamiento.anadirAfiliado(afiliado)){
                JOptionPane.showMessageDialog(null, "Afiliado agregado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                irGestionServicioGUI();
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un afiliado con ese número de cédula", "Resultado de agregar", JOptionPane.ERROR_MESSAGE);
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        /*afiliado.setNombre("");
        afiliado.setSexo("");
        afiliado.setDireccion("");
        afiliado.setEmail("");
        afiliado.setCedula(0);
        afiliado.setEdad(0);
        afiliado.setTelefono(0);
        System.out.println(afiliado.toString());*/
    }

    private void irGestionServicioGUI() {
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        vistaPlantillaAfiliado.dispose();
    }
}

