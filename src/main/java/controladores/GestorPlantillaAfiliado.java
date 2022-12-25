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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelos.Afiliado;
import modelos.Almacenamiento;
import vistas.GestionServicioGUI;
import vistas.ListarAfiliado;
import vistas.PlantillaAfiliado;

public class GestorPlantillaAfiliado {
    

    private final PlantillaAfiliado vistaPlantillaAfiliado;
    private final Almacenamiento almacenamiento;
    private final String opcion;
    private final long cedula;

    
    public GestorPlantillaAfiliado(PlantillaAfiliado vistaPlantillaAfiliado, String opcion, Almacenamiento almacenamiento, long cedula) {
        this.vistaPlantillaAfiliado = vistaPlantillaAfiliado;
        this.opcion = opcion;
        this.almacenamiento = almacenamiento;
        this.cedula = cedula;
        modificarPlantilla();
        verificarNumero(vistaPlantillaAfiliado.getTxtCedula());
        verificarNumero(vistaPlantillaAfiliado.getTxtEdad());
        verificarNumero(vistaPlantillaAfiliado.getTxtTelefono());
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
            case "Consultar" -> {
                plantillaConsultarAfiliado();
                
            }
        }
    }

    public void plantillaActualizarAfiliado(){
        //Modificando título y botones
        vistaPlantillaAfiliado.getLblTitulo().setText("Actualizar afiliado");
        vistaPlantillaAfiliado.getBtnAgregar().setText("Actualizar afiliado");
        
        //Ingresando los datos del afiliado a eliminar
        Afiliado miAfiliado = almacenamiento.getAfiliados().get(cedula);
        vistaPlantillaAfiliado.getTxtCedula().setText(Long.toString(miAfiliado.getCedula()));
        vistaPlantillaAfiliado.getTxtEdad().setText(Integer.toString(miAfiliado.getEdad()));
        vistaPlantillaAfiliado.getTxtTelefono().setText(Long.toString(miAfiliado.getTelefono()));
        vistaPlantillaAfiliado.getTxtNombre().setText(miAfiliado.getNombre());
        vistaPlantillaAfiliado.getTxtDireccion().setText(miAfiliado.getDireccion());
        vistaPlantillaAfiliado.getTxtCorreo().setText(miAfiliado.getEmail());
        vistaPlantillaAfiliado.getComboSexo().setSelectedItem(miAfiliado.getSexo());
    }
    
    public void plantillaEliminarAfiliado(){
        
        //Modificando título y botones
        vistaPlantillaAfiliado.getLblTitulo().setText("Eliminar afiliado");
        vistaPlantillaAfiliado.getBtnAgregar().setText("Eliminar afiliado");
        
        //Ingresando los datos del afiliado a eliminar
        Afiliado miAfiliado = almacenamiento.getAfiliados().get(cedula);
        vistaPlantillaAfiliado.getTxtCedula().setText(Long.toString(miAfiliado.getCedula()));
        vistaPlantillaAfiliado.getTxtEdad().setText(Integer.toString(miAfiliado.getEdad()));
        vistaPlantillaAfiliado.getTxtTelefono().setText(Long.toString(miAfiliado.getTelefono()));
        vistaPlantillaAfiliado.getTxtNombre().setText(miAfiliado.getNombre());
        vistaPlantillaAfiliado.getTxtDireccion().setText(miAfiliado.getDireccion());
        vistaPlantillaAfiliado.getTxtCorreo().setText(miAfiliado.getEmail());
        vistaPlantillaAfiliado.getComboSexo().setSelectedItem(miAfiliado.getSexo());
        
        //Desabilitando campos de texto
        vistaPlantillaAfiliado.getTxtCedula().setEditable(false);
        vistaPlantillaAfiliado.getTxtEdad().setEditable(false);
        vistaPlantillaAfiliado.getTxtNombre().setEditable(false);
        vistaPlantillaAfiliado.getTxtDireccion().setEditable(false);
        vistaPlantillaAfiliado.getTxtCorreo().setEditable(false);
        vistaPlantillaAfiliado.getTxtTelefono().setEditable(false);
        vistaPlantillaAfiliado.getComboSexo().setEnabled(false);
        
    }
    
    public void plantillaConsultarAfiliado(){
        
        //Modificando título y botones
        vistaPlantillaAfiliado.getLblTitulo().setText("Consultar afiliado");
        vistaPlantillaAfiliado.getBtnAgregar().setVisible(false);
        vistaPlantillaAfiliado.getBtnRegresar().setVisible(true);
        
        //Ingresando los datos del afiliado a eliminar
        Afiliado miAfiliado = almacenamiento.getAfiliados().get(cedula);
        vistaPlantillaAfiliado.getTxtCedula().setText(Long.toString(miAfiliado.getCedula()));
        vistaPlantillaAfiliado.getTxtEdad().setText(Integer.toString(miAfiliado.getEdad()));
        vistaPlantillaAfiliado.getTxtTelefono().setText(Long.toString(miAfiliado.getTelefono()));
        vistaPlantillaAfiliado.getTxtNombre().setText(miAfiliado.getNombre());
        vistaPlantillaAfiliado.getTxtDireccion().setText(miAfiliado.getDireccion());
        vistaPlantillaAfiliado.getTxtCorreo().setText(miAfiliado.getEmail());
        vistaPlantillaAfiliado.getComboSexo().setSelectedItem(miAfiliado.getSexo());
        
        //Desabilitando campos de texto
        vistaPlantillaAfiliado.getTxtCedula().setEditable(false);
        vistaPlantillaAfiliado.getTxtEdad().setEditable(false);
        vistaPlantillaAfiliado.getTxtNombre().setEditable(false);
        vistaPlantillaAfiliado.getTxtDireccion().setEditable(false);
        vistaPlantillaAfiliado.getTxtCorreo().setEditable(false);
        vistaPlantillaAfiliado.getTxtTelefono().setEditable(false);
        vistaPlantillaAfiliado.getComboSexo().setEnabled(false);
        
        //Quitando boton regresar
        
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaAfiliado.getBtnAgregar() && "Agregar".equals(opcion)){
                if (e.getButton() == 1){
                    agregarAfiliado();
                }
            }

            if (e.getSource() == vistaPlantillaAfiliado.getBtnAgregar() && "Actualizar".equals(opcion)){
                if (e.getButton() == 1){
                    actualizarAfiliado();
                }
            }
            
            if (e.getSource() == vistaPlantillaAfiliado.getBtnAgregar() && "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    eliminarAfiliado();
                }
            }
            
            if (e.getSource() == vistaPlantillaAfiliado.getBtnRegresar() && !"Consultar".equals(opcion)){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            } 
            if (e.getSource() == vistaPlantillaAfiliado.getBtnRegresar() && "Consultar".equals(opcion)) {
                if (e.getButton() == 1){
                    irListarAfiliado();
                }
            }
        }
    }
    
    public void agregarAfiliado() {
        if(!validarCamposVacios()){
            
            //Obteniendo los datos de la ventana
            long cedulaNueva = Long.parseLong(vistaPlantillaAfiliado.getTxtCedula().getText());
            String nombre = vistaPlantillaAfiliado.getTxtNombre().getText();
            int edad = Integer.parseInt(vistaPlantillaAfiliado.getTxtEdad().getText());
            String direccion = vistaPlantillaAfiliado.getTxtDireccion().getText();
            String correo = vistaPlantillaAfiliado.getTxtCorreo().getText();
            long telefono = Long.parseLong(vistaPlantillaAfiliado.getTxtTelefono().getText());
            String sexo = (String)vistaPlantillaAfiliado.getComboSexo().getSelectedItem();
            
            //Estableciendo los datos obtenidos al modelo
            Afiliado afiliado = new Afiliado(nombre, sexo, direccion, correo, cedulaNueva, edad, telefono);
            try {
                //Agregando el afiliado
                if (almacenamiento.anadirAfiliado(afiliado)){
                    JOptionPane.showMessageDialog(null, "Afiliado agregado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                    irGestionServicioGUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe una persona con ese número de cédula", "Resultado de agregar", JOptionPane.ERROR_MESSAGE);
                }
            } catch(IOException e){
                JOptionPane.showMessageDialog(null, "Error al agregar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarAfiliado() {
        if(!validarCamposVacios()){
            
            //Obteniendo los datos
            long cedulaNueva = Long.parseLong(vistaPlantillaAfiliado.getTxtCedula().getText());
            String nombre = vistaPlantillaAfiliado.getTxtNombre().getText();
            int edad = Integer.parseInt(vistaPlantillaAfiliado.getTxtEdad().getText());
            String direccion = vistaPlantillaAfiliado.getTxtDireccion().getText();
            String correo = vistaPlantillaAfiliado.getTxtCorreo().getText();
            long telefono = Long.parseLong(vistaPlantillaAfiliado.getTxtTelefono().getText());
            String sexo = (String)vistaPlantillaAfiliado.getComboSexo().getSelectedItem();
            
            //Verifica si al actualizar el afiliado se ingresa una cédula que ya existía
            if(!almacenamiento.getAfiliados().containsKey(cedulaNueva) || almacenamiento.getAfiliados().get(cedula).getCedula() == (cedulaNueva)){
                //Creando el afiliado
                Afiliado afiliado = new Afiliado(nombre, sexo, direccion, correo, cedulaNueva, edad, telefono);
                try {
                    //Actualizando los datos de afiliado
                    almacenamiento.modificarAfiliado(cedula, afiliado);
                    JOptionPane.showMessageDialog(null, "Afiliado actualizado con éxito", "Resultado de actualizar", JOptionPane.INFORMATION_MESSAGE);
                    irGestionServicioGUI();
                } catch(IOException e){
                    JOptionPane.showMessageDialog(null, "Error al actualizar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else{
                JOptionPane.showMessageDialog(null, "Ya existe un afiliado con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        } else{
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);            
        }
    }

    public void eliminarAfiliado(){
        //Eliminando el afiliado
        try{
            almacenamiento.eliminarAfiliado(cedula);
            JOptionPane.showMessageDialog(null, "Afiliado eliminado con éxito", "Resultado de eliminar", JOptionPane.INFORMATION_MESSAGE);
            irGestionServicioGUI();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void irGestionServicioGUI() {
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        vistaPlantillaAfiliado.dispose();
    }
    
    public void irListarAfiliado() {
        
        //Creación de vistas
        ListarAfiliado ventanaListaAfiliado = new ListarAfiliado("Lista de afiliados",almacenamiento);
        vistaPlantillaAfiliado.dispose();
    }
    
    public void verificarNumero(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c) | Character.isSpaceChar(c)){
                    e.consume();
                }
            }
        });
    }
    public boolean validarCamposVacios(){
        boolean error = false;
        if(vistaPlantillaAfiliado.getTxtCedula().getText().isBlank())
            error = true;
        if(vistaPlantillaAfiliado.getTxtNombre().getText().isBlank())
            error = true;
        if(vistaPlantillaAfiliado.getTxtEdad().getText().isBlank())
            error = true;
        if(vistaPlantillaAfiliado.getTxtDireccion().getText().isBlank())
            error = true;
        if(vistaPlantillaAfiliado.getTxtTelefono().getText().isBlank())
            error = true;
        if(vistaPlantillaAfiliado.getTxtCorreo().getText().isBlank())
            error = true;
        String sexo=(String)vistaPlantillaAfiliado.getComboSexo().getSelectedItem();
        if(!"Masculino".equals(sexo) && !"Femenino".equals(sexo))
            error = true;
        return error;
    }
}

