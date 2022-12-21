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
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelos.Afiliado;
import modelos.Almacenamiento;
import modelos.Medico;
import modelos.Servicio;
import vistas.GestionServicioGUI;
import vistas.PlantillaMedico;

public class GestorPlantillaMedico {
    
    PlantillaMedico vistaPlantillaMedico;
    Almacenamiento almacenamiento;
    private String opcion;
    private long cedula;
    public GestorPlantillaMedico(PlantillaMedico vistaPlantillaMedico, String opcion, Almacenamiento almacenamiento, long cedula) {
        this.vistaPlantillaMedico = vistaPlantillaMedico;
        this.opcion = opcion;
        this.almacenamiento = almacenamiento;
        this.cedula = cedula;
        modificarPlantilla();
        verificarNumero(vistaPlantillaMedico.getTxtCedula());
        verificarNumero(vistaPlantillaMedico.getTxtEdad());
        verificarNumero(vistaPlantillaMedico.getTxtTelefono());
        this.vistaPlantillaMedico.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaPlantillaMedico.addBtnAgregarListener(new ManejadoraDeMouse());
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
        //Ingresando los datos del médico
        Medico miMedico = almacenamiento.getMedicos().get(cedula);
        vistaPlantillaMedico.getTxtCedula().setText(Long.toString(miMedico.getCedula()));
        vistaPlantillaMedico.getTxtEdad().setText(Integer.toString(miMedico.getEdad()));
        vistaPlantillaMedico.getTxtTelefono().setText(Long.toString(miMedico.getTelefono()));
        vistaPlantillaMedico.getTxtNombre().setText(miMedico.getNombre());
        vistaPlantillaMedico.getTxtDireccion().setText(miMedico.getDireccion());
        vistaPlantillaMedico.getTxtCorreo().setText(miMedico.getEmail());
        vistaPlantillaMedico.getComboSexo().setSelectedItem(miMedico.getSexo());
        //vistaPlantillaMedico.getListaEspecialidad().setSelectedIndices(vistaPlantillaMedico.getListaEspecialidad().getSelectedValuesList());
        /*
        for(int i = 0; i<vistaPlantillaMedico.getListaEspecialidad().getModel().getSize(); i++){
            if(miMedico.getServicios().get(i).toString().equals(vistaPlantillaMedico.getListaEspecialidad().getModel().getElementAt(i)));
                vistaPlantillaMedico.getListaEspecialidad().setSelectedValue(miMedico.getServicios().get(i), true);
        }*/
    }
    
    public void plantillaEliminarMedico(){
        //Modificando título y botones
        vistaPlantillaMedico.getLblTitulo().setText("Eliminar médico");
        vistaPlantillaMedico.getBtnAgregar().setText("Eliminar médico");
        
        //Ingresando los datos del médico
        Medico miMedico = almacenamiento.getMedicos().get(cedula);
        vistaPlantillaMedico.getTxtCedula().setText(Long.toString(miMedico.getCedula()));
        vistaPlantillaMedico.getTxtEdad().setText(Integer.toString(miMedico.getEdad()));
        vistaPlantillaMedico.getTxtTelefono().setText(Long.toString(miMedico.getTelefono()));
        vistaPlantillaMedico.getTxtNombre().setText(miMedico.getNombre());
        vistaPlantillaMedico.getTxtDireccion().setText(miMedico.getDireccion());
        vistaPlantillaMedico.getTxtCorreo().setText(miMedico.getEmail());
        vistaPlantillaMedico.getComboSexo().setSelectedItem(miMedico.getSexo());
        
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
            
            if (e.getSource() == vistaPlantillaMedico.getBtnAgregar() && "Agregar".equals(opcion)){
                if (e.getButton() == 1){
                    agregarMedico();
                }
            }
            
            if (e.getSource() == vistaPlantillaMedico.getBtnAgregar() && "Actualizar".equals(opcion)){
                if (e.getButton() == 1){
                    actualizarMedico();
                }
            }
            
            if (e.getSource() == vistaPlantillaMedico.getBtnAgregar() && "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    eliminarMedico();
                }
            }

            if (e.getSource() == vistaPlantillaMedico.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
        }
    }
    
    public void agregarMedico() {
        if(!validarCamposVacios()){
            
            //Obteniendo los datos
            long cedulaNueva = Long.parseLong(vistaPlantillaMedico.getTxtCedula().getText());
            String nombre = vistaPlantillaMedico.getTxtNombre().getText();
            int edad = Integer.parseInt(vistaPlantillaMedico.getTxtEdad().getText());
            String direccion = vistaPlantillaMedico.getTxtDireccion().getText();
            String correo = vistaPlantillaMedico.getTxtCorreo().getText();
            long telefono = Long.parseLong(vistaPlantillaMedico.getTxtTelefono().getText());
            String sexo = (String)vistaPlantillaMedico.getComboSexo().getSelectedItem();
            
            List<String> listaEspecialidades = vistaPlantillaMedico.getListaEspecialidad().getSelectedValuesList();
            ArrayList<Servicio> misEspecialidades = new ArrayList(listaEspecialidades);
            
            //Creando el médico
            Medico medico = new Medico(misEspecialidades,nombre, sexo, direccion, correo, cedulaNueva, edad, telefono);
            try {
                //Agregando el médico
                if (almacenamiento.anadirMedico(medico)){
                    JOptionPane.showMessageDialog(null, "Médico agregado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                    irGestionServicioGUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un médico con ese número de cédula", "Resultado de agregar", JOptionPane.ERROR_MESSAGE);
                }
            } catch(IOException e){
                JOptionPane.showMessageDialog(null, "Error al agregar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarMedico() {
        if(!validarCamposVacios()){
            
            //Obteniendo los datos
            long cedulaNueva = Long.parseLong(vistaPlantillaMedico.getTxtCedula().getText());
            String nombre = vistaPlantillaMedico.getTxtNombre().getText();
            int edad = Integer.parseInt(vistaPlantillaMedico.getTxtEdad().getText());
            String direccion = vistaPlantillaMedico.getTxtDireccion().getText();
            String correo = vistaPlantillaMedico.getTxtCorreo().getText();
            long telefono = Long.parseLong(vistaPlantillaMedico.getTxtTelefono().getText());
            String sexo = (String)vistaPlantillaMedico.getComboSexo().getSelectedItem();
            
            List<String> listaEspecialidades = vistaPlantillaMedico.getListaEspecialidad().getSelectedValuesList();
            ArrayList<Servicio> misEspecialidades = new ArrayList(listaEspecialidades);
            
            //Creando el médico
            Medico medico = new Medico(misEspecialidades,nombre, sexo, direccion, correo, cedulaNueva, edad, telefono);
            
            try {
                almacenamiento.modificarMedico(cedula, medico);
                JOptionPane.showMessageDialog(null, "Médico modificado con éxito", "Resultado de modificar", JOptionPane.INFORMATION_MESSAGE);
                irGestionServicioGUI();
            } catch(IOException e){
                JOptionPane.showMessageDialog(null, "Error al actualizar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void eliminarMedico() {
        //Eliminando el afiliado
        try{
            almacenamiento.eliminarMedico(cedula);
            JOptionPane.showMessageDialog(null, "Médico eliminado con éxito", "Resultado de eliminar", JOptionPane.INFORMATION_MESSAGE);
            irGestionServicioGUI();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void irGestionServicioGUI() {
        
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        vistaPlantillaMedico.dispose();
    }
    
    private void verificarNumero(JTextField a){
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
    private boolean validarCamposVacios(){
        boolean error = false;
        if(vistaPlantillaMedico.getTxtCedula().getText().isBlank())
            error = true;
        if(vistaPlantillaMedico.getTxtNombre().getText().isBlank())
            error = true;
        if(vistaPlantillaMedico.getTxtEdad().getText().isBlank())
            error = true;
        if(vistaPlantillaMedico.getTxtDireccion().getText().isBlank())
            error = true;
        if(vistaPlantillaMedico.getTxtTelefono().getText().isBlank())
            error = true;
        if(vistaPlantillaMedico.getTxtCorreo().getText().isBlank())
            error = true;
        String sexo=(String)vistaPlantillaMedico.getComboSexo().getSelectedItem();
        if(!"Masculino".equals(sexo) && !"Femenino".equals(sexo))
            error = true;
        List<String> listaEspecialidades = vistaPlantillaMedico.getListaEspecialidad().getSelectedValuesList();
        if(listaEspecialidades.isEmpty())
            error = true;
        return error;
    }
}
