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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelos.Almacenamiento;
import modelos.Consultorio;
import modelos.Servicio;
import vistas.GestionServicioGUI;
import vistas.PlantillaConsultorio;


public class GestorPlantillaConsultorio {
    
    PlantillaConsultorio vistaPlantillaConsultorio;
    Almacenamiento almacenamiento;
    private String opcion;
    private String id;
    
    public GestorPlantillaConsultorio(PlantillaConsultorio vistaPlantillaConsultorio, String opcion, Almacenamiento almacenamiento, String id) {
        this.vistaPlantillaConsultorio = vistaPlantillaConsultorio;
        this.opcion = opcion;
        this.id = id;
        this.almacenamiento = almacenamiento;
        traerServicios();
        modificarPlantilla();
        verificarSintaxis(vistaPlantillaConsultorio.getTxtIdentificador());
        this.vistaPlantillaConsultorio.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaPlantillaConsultorio.addBtnAgregarListener(new ManejadoraDeMouse());
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
        
        //Ingresando los datos del consultorio
        Consultorio miConsultorio = almacenamiento.getConsultorios().get(id);
        vistaPlantillaConsultorio.getTxtIdentificador().setText(miConsultorio.getIdentificador());
        vistaPlantillaConsultorio.getComboServicio().setSelectedItem(miConsultorio.getServicioAsociado().getNombre());
    }
    
    public void plantillaEliminarConsultorio(){
        //Modificando título y botones
        vistaPlantillaConsultorio.getLblTitulo().setText("Eliminar consultorio");
        vistaPlantillaConsultorio.getBtnAgregar().setText("Eliminar consultorio");
        
        //Ingresando los datos del consultorio
        Consultorio miConsultorio = almacenamiento.getConsultorios().get(id);
        vistaPlantillaConsultorio.getTxtIdentificador().setText(miConsultorio.getIdentificador());
        vistaPlantillaConsultorio.getComboServicio().setSelectedItem(miConsultorio.getServicioAsociado().getNombre());
        
        //Desabilitando campos de texto
        vistaPlantillaConsultorio.getTxtIdentificador().setEditable(false);
        vistaPlantillaConsultorio.getComboServicio().setEnabled(false);
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaConsultorio.getBtnAgregar() && "Agregar".equals(opcion)){
                if (e.getButton() == 1){
                    agregarConsultorio();
                }
            }
            
            if (e.getSource() == vistaPlantillaConsultorio.getBtnAgregar() && "Actualizar".equals(opcion)){
                if (e.getButton() == 1){
                    actualizarConsultorio();
                }
            }
            
            if (e.getSource() == vistaPlantillaConsultorio.getBtnAgregar() && "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    eliminarConsultorio();
                }
            }

            if (e.getSource() == vistaPlantillaConsultorio.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
        }

    }
    public void agregarConsultorio() {
        
        if(!validarCamposVacios()){

            //Obteniendo los datos de la ventana
            String nuevoId = vistaPlantillaConsultorio.getTxtIdentificador().getText();
            String servicio = (String)vistaPlantillaConsultorio.getComboServicio().getSelectedItem();
            Servicio miServicio= new Servicio(servicio);

            //Creando el consultorio
            Consultorio miConsultorio = new Consultorio(nuevoId, miServicio);

            try {
                //Agregando el consultorio
                if (almacenamiento.anadirConsultorio(miConsultorio)){
                    JOptionPane.showMessageDialog(null, "Consultorio agregado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                    irGestionServicioGUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un consultorio con ese identificador", "Resultado de agregar", JOptionPane.ERROR_MESSAGE);
                }
            } catch(IOException e){
                JOptionPane.showMessageDialog(null, "Error al agregar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
             JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarConsultorio() {
        if(!validarCamposVacios()){
            
            //Obteniendo los datos de la ventana
            String nuevoId = vistaPlantillaConsultorio.getTxtIdentificador().getText();
            String servicio = (String)vistaPlantillaConsultorio.getComboServicio().getSelectedItem();
            Servicio miServicio= new Servicio(servicio);
            
            //Verifica si al actualizar el consultorio se ingresa un identificador que ya existía
            if(!almacenamiento.getConsultorios().containsKey(nuevoId) || almacenamiento.getConsultorios().get(id).getIdentificador().equalsIgnoreCase(nuevoId)){
                
                //Creando el consultorio
                Consultorio miConsultorio = new Consultorio(nuevoId, miServicio);

                try {
                    almacenamiento.modificarConsultorio(id, miConsultorio);
                    JOptionPane.showMessageDialog(null, "Consultorio modificado con éxito", "Resultado de actualizar", JOptionPane.INFORMATION_MESSAGE);
                    irGestionServicioGUI();
                } catch(IOException e){
                    JOptionPane.showMessageDialog(null, "Error al actualizar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else
                JOptionPane.showMessageDialog(null, "Ya existe un consultorio con ese identificador", "Error", JOptionPane.ERROR_MESSAGE);
        } else 
             JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
    }
    
    public void eliminarConsultorio() {
        //Eliminando el consultorio
        try{
            almacenamiento.eliminarConsultorio(id);
            JOptionPane.showMessageDialog(null, "Consultorio eliminado con éxito", "Resultado de eliminar", JOptionPane.INFORMATION_MESSAGE);
            irGestionServicioGUI();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void irGestionServicioGUI() {
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        vistaPlantillaConsultorio.dispose();
    }
    
    public void traerServicios() {
        //Lista de todos los servicios
        ArrayList<Servicio> misServicios = almacenamiento.getServicios(); 
        ArrayList<String> allServices = new ArrayList();
        for (int i = 0; i < misServicios.size(); i++) {
            String servicio = "";
            servicio += misServicios.get(i).getNombre();
            allServices.add(servicio);
        }
        vistaPlantillaConsultorio.agregarServicios(allServices);
    }
    
    public void verificarSintaxis(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (Character.isSpaceChar(c)){
                    e.consume();
                }
                if (Character.isLowerCase(c)){
                    String cadenaMayus = (""+c).toUpperCase();
                    c = cadenaMayus.charAt(0);
                    e.setKeyChar(c);
                }
            }
        });
    }
    
    public boolean validarCamposVacios(){
        
        boolean error = false;
        
        if(vistaPlantillaConsultorio.getTxtIdentificador().getText().isBlank())
            error = true;
        
        if(vistaPlantillaConsultorio.getComboServicio().getSelectedItem() == null)
            error = true;
        return error;
    }
}
